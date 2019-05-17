package com.capstone.jeju;

import android.app.Application;
import android.content.Context;

import net.daum.mf.map.api.MapView;

public class MapApplication extends Application {
    private MapView mapView = null;
    public MapView mapview(Context context) {
        if(mapView == null) mapView = new MapView(context);
        return mapView;
    }
}
