package de.tudarmstadt.informatik.tk.kraken.android.sdk.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import de.tudarmstadt.informatik.tk.kraken.android.sdk.preference.PreferenceManager;
import de.tudarmstadt.informatik.tk.kraken.android.sdk.utils.KrakenServiceManager;

/**
 * @author Karsten Planz
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean activated = PreferenceManager.getInstance(context).getActivated();
        Log.d("kraken", "BootReceiver onReceive " + activated);
        if(activated) {
            KrakenServiceManager.getInstance(context).startService();
        }
    }
}
