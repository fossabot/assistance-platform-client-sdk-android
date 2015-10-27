package de.tudarmstadt.informatik.tk.android.kraken.model.sensor.impl.triggered;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.Date;
import java.util.Locale;

import de.tudarmstadt.informatik.tk.android.kraken.db.DbGyroscopeSensor;
import de.tudarmstadt.informatik.tk.android.kraken.model.api.sensors.SensorType;
import de.tudarmstadt.informatik.tk.android.kraken.model.sensor.AbstractTriggeredEvent;
import de.tudarmstadt.informatik.tk.android.kraken.util.DateUtils;

/**
 * Provides event for calibrated and uncalibrated gyroscope sensor
 *
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 27.10.2015
 */
public class GyroscopeSensor extends AbstractTriggeredEvent implements SensorEventListener {

    private static final String TAG = GyroscopeSensor.class.getSimpleName();

    // ------------------- Configuration -------------------
    private static final int SENSOR_DELAY_BETWEEN_TWO_EVENTS = SensorManager.SENSOR_DELAY_NORMAL;
    private static final int UPDATE_INTERVAL = 10;    // in seconds
    // -----------------------------------------------------

    private long mLastEventDumpingTimestamp;    // in nanoseconds

    private SensorManager mSensorManager;
    private Sensor mGyroscopeSensor;
    private Sensor mGyroscopeUncalibratedSensor;

    private double x;
    private double y;
    private double z;
    private int accuracy;

    private float xUncalibratedNoDrift;
    private float yUncalibratedNoDrift;
    private float zUncalibratedNoDrift;
    private float xUncalibratedEstimatedDrift;
    private float yUncalibratedEstimatedDrift;
    private float zUncalibratedEstimatedDrift;

    public GyroscopeSensor(Context context) {
        super(context);

        mSensorManager = (SensorManager) context
                .getSystemService(Context.SENSOR_SERVICE);
        mGyroscopeSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        mGyroscopeUncalibratedSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED);
    }

    /**
     * Called when sensor values have changed.
     * <p>See {@link SensorManager SensorManager}
     * for details on possible sensor types.
     * <p>See also {@link SensorEvent SensorEvent}.
     * <p/>
     * <p><b>NOTE:</b> The application doesn't own the
     * {@link SensorEvent event}
     * object passed as a parameter and therefore cannot hold on to it.
     * The object may be part of an internal pool and may be reused by
     * the framework.
     *
     * @param event the {@link SensorEvent SensorEvent}.
     */
    @Override
    public void onSensorChanged(SensorEvent event) {

        // serve only this type
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {

            // updating values
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
        }

        // serve only this type
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE_UNCALIBRATED) {

            // updating values
            xUncalibratedNoDrift = event.values[0];
            yUncalibratedNoDrift = event.values[1];
            zUncalibratedNoDrift = event.values[2];
            xUncalibratedEstimatedDrift = event.values[3];
            yUncalibratedEstimatedDrift = event.values[4];
            zUncalibratedEstimatedDrift = event.values[5];
        }

        // checks for saving new data
        if (isTimeToSaveData(event.timestamp)) {

            mLastEventDumpingTimestamp = event.timestamp;

            // time to dump/save data into db
            dumpData();
        }
    }

    /**
     * Called when the accuracy of the registered sensor has changed.
     * <p/>
     * <p>See the SENSOR_STATUS_* constants in
     * {@link SensorManager SensorManager} for details.
     *
     * @param sensor
     * @param accuracy The new accuracy of this sensor, one of
     *                 {@code SensorManager.SENSOR_STATUS_*}
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        Log.d(TAG, "Accuracy has changed. Old: " + this.accuracy + " new: " + accuracy);

        this.accuracy = accuracy;

        // checks for saving new data
        if (isTimeToSaveData(System.nanoTime())) {

            // accuracy has changed faster than accelerometer itself
            // ignore that accuracy
            if (x == 0 && y == 0 && z == 0) {
                return;
            }

            mLastEventDumpingTimestamp = System.nanoTime();

            dumpData();
        }
    }

    @Override
    public void startSensor() {

        if (mSensorManager != null) {

            mSensorManager.registerListener(this,
                    mGyroscopeSensor,
                    SENSOR_DELAY_BETWEEN_TWO_EVENTS);
            mSensorManager.registerListener(this,
                    mGyroscopeUncalibratedSensor,
                    SENSOR_DELAY_BETWEEN_TWO_EVENTS);

            setRunning(true);
        }
    }

    @Override
    public void stopSensor() {

        try {
            if (mSensorManager != null) {
                mSensorManager.unregisterListener(this, mGyroscopeSensor);
                mSensorManager.unregisterListener(this, mGyroscopeUncalibratedSensor);
            }
        } finally {
            setRunning(false);
            mSensorManager = null;
        }
    }

    @Override
    public int getType() {
        return SensorType.GYROSCOPE;
    }

    @Override
    public void reset() {

        mLastEventDumpingTimestamp = 0;
        x = 0;
        y = 0;
        z = 0;
        accuracy = 0;

        xUncalibratedNoDrift = 0;
        yUncalibratedNoDrift = 0;
        zUncalibratedNoDrift = 0;
        xUncalibratedEstimatedDrift = 0;
        yUncalibratedEstimatedDrift = 0;
        zUncalibratedEstimatedDrift = 0;
    }

    @Override
    public void dumpData() {

        DbGyroscopeSensor gyroscopeSensor = new DbGyroscopeSensor();

        /**
         * Calibrated data
         */

        if (x != 0) {
            gyroscopeSensor.setX(x);
        }

        if (y != 0) {
            gyroscopeSensor.setY(y);
        }

        if (z != 0) {
            gyroscopeSensor.setZ(z);
        }

        /**
         * Uncalibrated data
         */

        if (xUncalibratedNoDrift != 0) {
            gyroscopeSensor.setXUncalibratedNoDrift(xUncalibratedNoDrift);
        }

        if (yUncalibratedNoDrift != 0) {
            gyroscopeSensor.setYUncalibratedNoDrift(yUncalibratedNoDrift);
        }

        if (zUncalibratedNoDrift != 0) {
            gyroscopeSensor.setZUncalibratedNoDrift(zUncalibratedNoDrift);
        }

        if (xUncalibratedEstimatedDrift != 0) {
            gyroscopeSensor.setXUncalibratedEstimatedDrift(xUncalibratedEstimatedDrift);
        }

        if (yUncalibratedEstimatedDrift != 0) {
            gyroscopeSensor.setYUncalibratedEstimatedDrift(yUncalibratedEstimatedDrift);
        }

        if (zUncalibratedEstimatedDrift != 0) {
            gyroscopeSensor.setZUncalibratedEstimatedDrift(zUncalibratedEstimatedDrift);
        }

        gyroscopeSensor.setCreated(DateUtils.dateToISO8601String(new Date(), Locale.getDefault()));

        dbProvider.insertEventEntry(gyroscopeSensor, getType());
    }

    /**
     * Checks for the time to save new sensor reading into db
     *
     * @param timestamp
     * @return
     */
    private boolean isTimeToSaveData(long timestamp) {

        // save the first sensor data
        if (mLastEventDumpingTimestamp == 0) {
            return true;
        } else {

            // the time has come -> save data into db
            if ((timestamp - mLastEventDumpingTimestamp) / 1000000000 > UPDATE_INTERVAL) {
                return true;
            }
        }

        return false;
    }
}
