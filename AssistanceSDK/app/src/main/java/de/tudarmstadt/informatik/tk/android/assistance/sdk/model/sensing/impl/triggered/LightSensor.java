package de.tudarmstadt.informatik.tk.android.assistance.sdk.model.sensing.impl.triggered;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.Date;
import java.util.Locale;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbLightSensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.DtoType;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.sensing.AbstractTriggeredEvent;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.DaoProvider;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.util.DateUtils;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.util.logger.Log;

/**
 * @author Unknown
 * @edited by Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 26.10.2015
 */
public class LightSensor
        extends AbstractTriggeredEvent
        implements SensorEventListener {

    private static final String TAG = LightSensor.class.getSimpleName();

    // ------------------- Configuration -------------------
    private static final int SENSOR_DELAY_BETWEEN_TWO_EVENTS = SensorManager.SENSOR_DELAY_NORMAL;
    private static final int UPDATE_INTERVAL = 5;    // in seconds
    // -----------------------------------------------------

    private DaoProvider daoProvider;

    private SensorManager mSensorManager;
    private Sensor mSensor;

    private long startTimestamp;
    private float mLastValue;
    private int accuracy;
    private int numValues;

    public LightSensor(Context context) {
        super(context);

        if (daoProvider == null) {
            daoProvider = DaoProvider.getInstance(context);
        }

        mSensorManager = (SensorManager) this.context.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    public void dumpData() {

        if (numValues > 0) {

            DbLightSensor sensorLight = new DbLightSensor();

            sensorLight.setValue(mLastValue / numValues);
            sensorLight.setAccuracy(accuracy);
            sensorLight.setCreated(DateUtils.dateToISO8601String(new Date(), Locale.getDefault()));

            Log.d(TAG, "Insert entry");

            daoProvider.getLightSensorDao().insert(sensorLight);

            Log.d(TAG, "Finished");
        }
    }

    @Override
    public void startSensor() {

        if (mSensorManager != null) {

            if (mSensor != null) {
                mSensorManager.registerListener(this,
                        mSensor,
                        SENSOR_DELAY_BETWEEN_TWO_EVENTS);

                setRunning(true);
            }
        }
    }

    @Override
    public void stopSensor() {

        try {
            if (mSensorManager != null) {

                if (mSensor != null) {
                    mSensorManager.unregisterListener(this, mSensor);
                }
            }
        } finally {
            setRunning(false);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        if (sensor.getType() == Sensor.TYPE_LIGHT) {

            this.accuracy = accuracy;
        }
    }

    @Override
    public int getType() {
        return DtoType.LIGHT;
    }

    @Override
    public void reset() {

        mLastValue = 0;
        accuracy = 0;
        numValues = 0;
        startTimestamp = 0;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

            boolean isValueAdded = addNewValueToAverage(event, false);

            if (!isValueAdded) {

                dumpData();
                addNewValueToAverage(event, true);
            }
        }
    }

    /**
     * Adds new value after summation old ones
     *
     * @param event
     * @param newSeries
     * @return
     */
    private boolean addNewValueToAverage(SensorEvent event, boolean newSeries) {

        if (newSeries) {

            startTimestamp = event.timestamp;
            mLastValue = Math.abs(event.values[0]);
            numValues = 1;

            return true;
        } else {
            if (event.timestamp < (startTimestamp + UPDATE_INTERVAL * 1_000_000_000l)) {

                mLastValue += Math.abs(event.values[0]);
                numValues++;

                return true;
            }
        }

        return false;
    }
}
