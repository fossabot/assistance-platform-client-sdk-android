package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.event;

import java.util.Collections;
import java.util.List;

import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DaoSession;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbWifiConnectionEvent;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.db.DbWifiConnectionEventDao;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.DtoType;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.model.api.dto.sensing.event.WifiConnectionEventDto;
import de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao.sensing.CommonEventDaoImpl;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 30.10.2015
 */
public class WifiConnectionEventDaoImpl extends
        CommonEventDaoImpl<DbWifiConnectionEvent> implements
        WifiConnectionEventDao {

    private static final String TAG = WifiConnectionEventDaoImpl.class.getSimpleName();

    private static WifiConnectionEventDao INSTANCE;

    private WifiConnectionEventDaoImpl(DaoSession daoSession) {
        super(daoSession.getDbWifiConnectionEventDao());
    }

    public static WifiConnectionEventDao getInstance(DaoSession mDaoSession) {

        if (INSTANCE == null) {
            INSTANCE = new WifiConnectionEventDaoImpl(mDaoSession);
        }

        return INSTANCE;
    }

    @Override
    public WifiConnectionEventDto convertObject(DbWifiConnectionEvent sensor) {

        if (sensor == null) {
            return null;
        }

        WifiConnectionEventDto result = new WifiConnectionEventDto();

        result.setId(sensor.getId());
        result.setSsid(sensor.getSsid());
        result.setBssid(sensor.getBssid());
        result.setChannel(sensor.getChannel());
        result.setFrequency(sensor.getFrequency());
        result.setLinkSpeed(sensor.getLinkSpeed());
        result.setSignalStrength(sensor.getSignalStrength());
        result.setNetworkId(sensor.getNetworkId());
        result.setType(DtoType.WIFI_CONNECTION);
        result.setTypeStr(DtoType.getApiName(DtoType.WIFI_CONNECTION));
        result.setCreated(sensor.getCreated());

        return result;
    }

    @Override
    public List<DbWifiConnectionEvent> getLastN(int amount) {

        if (amount <= 0) {
            return Collections.emptyList();
        }

        return dao
                .queryBuilder()
                .orderDesc(DbWifiConnectionEventDao.Properties.Id)
                .limit(amount)
                .build()
                .list();
    }
}