package de.tudarmstadt.informatik.tk.android.kraken.interfaces;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.08.2015
 */
public interface Sensor extends IDbSensor {

    int getType();

    void setType(int type);

}