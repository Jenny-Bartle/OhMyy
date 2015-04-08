package com.jenny.ohmyy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by Jenny on 08/04/2015.
 */
public class OhMyyWidgetIntentReceiver extends BroadcastReceiver {
    public static int clickCount = 0;
    private String msg[] = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.jenny.intent.action.UPDATE_WIDGET")) {
            MediaPlayer mp = MediaPlayer.create(context, R.raw.ohmyy);
            mp.start();
        }
    }
}
