package de.tudarmstadt.informatik.tk.assistance.sdk.provider.dao.sensing.contact;

import java.util.List;

import de.tudarmstadt.informatik.tk.assistance.sdk.db.DbContactEmailSensor;
import de.tudarmstadt.informatik.tk.assistance.sdk.provider.dao.sensing.common.CommonEventDao;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 24.11.2015
 */
public interface ContactEmailSensorDao extends CommonEventDao<DbContactEmailSensor> {

    List<DbContactEmailSensor> getAll(Long contactId);
}