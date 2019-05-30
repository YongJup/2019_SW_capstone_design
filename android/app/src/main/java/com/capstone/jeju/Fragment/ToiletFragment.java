package com.capstone.jeju.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.capstone.jeju.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class ToiletFragment extends Fragment {

    private View view;
    private MapView mMapView;
    private MapPOIItem marker;
    private WebView webView;
    private WebSettings webSettings;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_toilet, container, false);
//        ViewGroup mapLayout = (ViewGroup) view.findViewById(R.id.map_view2);
//        if(mMapView != null && mMapView.getParent() != null) ((ViewGroup) mMapView.getParent()).removeView(mMapView);
//        mMapView = new MapView(getActivity());
//        mapLayout.addView(mMapView);
//        mapLayout.requestDisallowInterceptTouchEvent(true);
//        marker = new MapPOIItem();
//
//        setCenterPoint();
//        setMarker();
//        setMarker1();
//        setMarker2();

        webView = (WebView) view.findViewById(R.id.webview2);
        webView.setWebViewClient(new WebViewClient());
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://www.google.com/maps/d/viewer?mid=1hbbyr37e" +
                "Mm376UR1MgGyBBgoV4pOVNIh&ll=33.38206286220829%2C126.49410612107022&z=10");

        return view;
    }

    public void setCenterPoint() {
        mMapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(33.499621, 126.531242), true);
        mMapView.setZoomLevel(5, true);
    }

    public void setMarker() {
        marker.setItemName("용재네 집");
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(33.454646, 126.565210));
        marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);

        mMapView.addPOIItem(marker);
    }

    public void setMarker1() {
        marker.setItemName("제주시청");
        marker.setTag(1);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(33.499621, 126.531242));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.BluePin);

        mMapView.addPOIItem(marker);
    }

    public void setMarker2() {
        marker.setItemName("제주공항");
        marker.setTag(2);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(33.507032, 126.492984));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.BluePin);

        mMapView.addPOIItem(marker);
    }

    public void removeMap() {
        if (mMapView != null) {
            ((ViewGroup) mMapView.getParent()).removeView(mMapView);
            mMapView = null;
        }
    }
}
