/**
 * 
 */
package de.tudarmstadt.informatik.tk.android.assistance.generators;

import java.io.File;
import java.io.IOException;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

import de.tudarmstadt.informatik.tk.android.assistance.Config;

/**
 * @author Wladimir Schmidt
 * @date 01.02.2016
 *
 */
public class BatteryWatcherDatabaseGenerator {

  public static void main(String[] args) throws Exception {
    new File(Config.BATTERY_WATCHER_OUTPUT).mkdirs();
    generateSchemas();
  }

  private static void generateSchemas() throws Exception, IOException {

    Schema schema =
        new Schema(Config.BATTERY_WATCHER_DB_SCHEMA_VERSION, Config.BATTERY_WATCHER_PACKAGE);

    // ----- Measurements -----
    Entity measurements = schema.addEntity("Measurement");
    measurements.setTableName("measurement");
    measurements.addIdProperty().autoincrement().index();
    measurements.addFloatProperty("power");
    measurements.addLongProperty("memory");
    measurements.addFloatProperty("cpuLoad");
    measurements.addLongProperty("timestamp").notNull();

    // **************************
    // **** GENERATE DAOs ****
    // **************************
    new DaoGenerator().generateAll(schema, Config.BATTERY_WATCHER_OUTPUT);
  }
}
