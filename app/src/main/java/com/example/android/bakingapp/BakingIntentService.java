package com.example.android.bakingapp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by nazaif on 17/3/18.
 */

public class BakingIntentService extends IntentService {
    public static String FROM_ACTIVITY_INGREDIENTS_LIST ="FROM_ACTIVITY_INGREDIENTS_LIST";

    public BakingIntentService() {
        super("BakingIntentService");
    }

    public static void startBakingService(Context context, ArrayList<String> fromActivityIngrList){
        Intent intent = new Intent(context,BakingIntentService.class);
        intent.putExtra(FROM_ACTIVITY_INGREDIENTS_LIST,fromActivityIngrList);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null){
            ArrayList<String> fromActivityIngrList = intent.getExtras().getStringArrayList(FROM_ACTIVITY_INGREDIENTS_LIST);
            handleActionUpdateBakingWidgets(fromActivityIngrList);
        }
    }

    private void handleActionUpdateBakingWidgets(ArrayList<String> fromActivityIngrList){
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE2");
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE2");
        intent.putExtra(FROM_ACTIVITY_INGREDIENTS_LIST,fromActivityIngrList);
        sendBroadcast(intent);
    }
}
