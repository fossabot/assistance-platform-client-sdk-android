package de.tudarmstadt.informatik.tk.android.kraken.model.sensor.impl.triggered;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.Date;
import java.util.Locale;

import de.tudarmstadt.informatik.tk.android.kraken.db.DbLightSensor;
import de.tudarmstadt.informatik.tk.android.kraken.model.api.sensors.SensorType;
import de.tudarmstadt.informatik.tk.android.kraken.model.sensor.AbstractTriggeredEvent;
import de.tudarmstadt.informatik.tk.android.kraken.provider.DbProvider;
import de.tudarmstadt.informatik.tk.android.kraken.util.DateUtils;


public class LightSensor
        extends AbstractTriggeredEvent
        implements SensorEventListener {

    // ------------------- Configuration -------------------
    private int SENSOR_DELAY_BETWEEN_TWO_EVENTS = SensorManager.SENSOR_DELAY_NORMAL;
    private int SENSOR_MIN_DIFFERENCE = 5;
    // -----------------------------------------------------

    private DbProvider dbProvider;

    private SensorManager mSensorManager;
    private Sensor mAccelerometerSensor;

    private int accuracy;
    private float mLastValue;

    public LightSensor(Context context) {
        super(context);

        if (dbProvider == null) {
            dbProvider = DbProvider.getInstance(context);
        }

        mSensorManager = (SensorManager) this.context.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    @Override
    public void dumpData() {

        DbLightSensor sensorLight = new DbLightSensor();

        sensorLight.setValue(mLastValue);
        sensorLight.setAccuracy(accuracy);
        sensorLight.setCreated(DateUtils.dateToISO8601String(new Date(), Locale.getDefault()));

        dbProvider.insertEventEntry(sensorLight, getType());
    }

    @Override
    public void startSensor() {

        if (mSensorManager != null) {

            mSensorManager.registerListener(this,
                    mAccelerometerSensor,
                    SENSOR_DELAY_BETWEEN_TWO_EVENTS);

            setRunning(true);
        }
    }

    @Override
    public void stopSensor() {

        try {
            if (mSensorManager != null) {
                mSensorManager.unregisterListener(this, mAccelerometerSensor);
            }
        } finally {
            setRunning(false);
            mSensorManager = null;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

        this.accuracy = accuracy;
    }

    @Override
    public int getType() {
        return SensorType.LIGHT;
    }

    @Override
    public void reset() {
        mLastValue = 0;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float currentValue = event.values[0];

        if (currentValue < mLastValue - SENSOR_MIN_DIFFERENCE ||
                (currentValue > (mLastValue + SENSOR_MIN_DIFFERENCE))) {

            mLastValue = currentValue;

            dumpData();
        }
    }
}
