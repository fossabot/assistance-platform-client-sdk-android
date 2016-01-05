package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.event.calendar;

import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbCalendarReminderSensor;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDao;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.10.2015
 */
public interface CalendarReminderEventDao extends CommonEventDao<DbCalendarReminderSensor> {

    List<DbCalendarReminderSensor> getAllByEventId(long eventId);

}
