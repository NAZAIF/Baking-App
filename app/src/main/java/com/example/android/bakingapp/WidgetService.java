package com.example.android.bakingapp;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.List;

import static com.example.android.bakingapp.WidgetProvider.ingredientsList;

/**
 * Created by nazaif on 17/3/18.
 */

public class WidgetService extends RemoteViewsService {
    List<String> remoteViewingredientsList;


    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        return new GridRemoteViewsFactory(this.getApplicationContext(),intent);
    }

    class GridRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
        Context mContext = null;

        public GridRemoteViewsFactory(Context context,Intent intent){
            mContext = context;
        }
        @Override
        public void onCreate() {

        }

        @Override
        public void onDataSetChanged() {
            remoteViewingredientsList = ingredientsList;
        }

        @Override
        public void onDestroy() {

        }

        @Override
        public int getCount() {
            return remoteViewingredientsList.size();
        }

        @Override
        public RemoteViews getViewAt(int i) {
            RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.widget_grid_view_item);

            views.setTextViewText(R.id.widget_grid_view_item, remoteViewingredientsList.get(i));

            Intent fillInIntent = new Intent();
            views.setOnClickFillInIntent(R.id.widget_grid_view_item, fillInIntent);

            return views;
        }

        @Override
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
