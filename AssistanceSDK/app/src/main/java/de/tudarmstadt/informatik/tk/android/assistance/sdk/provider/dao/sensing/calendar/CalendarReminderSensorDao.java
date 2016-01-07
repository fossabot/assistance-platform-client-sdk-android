package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.calendar;

import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbCalendarReminderSensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.common.CommonEventDao;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.10.2015
 */
public interface CalendarReminderSensorDao extends CommonEventDao<DbCalendarReminderSensor> {

    List<DbCalendarReminderSensor> getAllByEventId(long eventId);

}