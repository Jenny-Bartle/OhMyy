package com.jenny.ohmyy;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class OhMyyWidgetProvider extends AppWidgetProvider {

        @Override
        public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                             int[] appWidgetIds) {

            // initializing widget layout
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.appwidget_layout);

            // register for button event
            remoteViews.setOnClickPendingIntent(R.id.sync_button,
                    buildButtonPendingIntent(context));

            // request for widget update
            pushWidgetUpdate(context, remoteViews);
        }

        public static PendingIntent buildButtonPendingIntent(Context context) {
            ++OhMyyWidgetIntentReceiver.clickCount;
            // initiate widget update request
            Intent intent = new Intent();
            intent.setAction("com.jenny.intent.action.UPDATE_WIDGET");
            return PendingIntent.getBroadcast(context, 0, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
        }

        public static void pushWidgetUpdate(Context context, RemoteViews remoteViews) {
            ComponentName myWidget = new ComponentName(context,
                    OhMyyWidgetProvider.class);
            AppWidgetManager manager = AppWidgetManager.getInstance(context);
            manager.updateAppWidget(myWidget, remoteViews);
        }
}
