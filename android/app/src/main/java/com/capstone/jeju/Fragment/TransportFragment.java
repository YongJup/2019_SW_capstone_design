package com.capstone.jeju.Fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.capstone.jeju.R;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class TransportFragment extends Fragment {

    private View view;
    MapView mMapView;
    private WebView webView;
    private WebSettings webSettings;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mMapView= ((MapApplication)getActivity().getApplication()).mapview(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_transport, container, false);
//        ViewGroup mapLayout = (ViewGroup) view.findViewById(R.id.map_view);
//        if(mMapView != null && mMapView.getParent() != null) ((ViewGroup) mMapView.getParent()).removeView(mMapView);
//        mMapView = new MapView(getActivity());
//        mapLayout.addView(mMapView);
//        mapLayout.requestDisallowInterceptTouchEvent(true);

        webView = (WebView) view.findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://yongjup.github.io");
//
//        setCenterPoint();

//        addPolyline1();
        return view;
    }

    public void setCenterPoint() {
        mMapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(33.499621, 126.531242), true);
        mMapView.setZoomLevel(5, true);
    }



//    private void addPolyline1() {
//        MapPolyline existingPolyline = mMapView.findPolylineByTag(1000);
//        if (existingPolyline != null) {
//            mMapView.removePolyline(existingPolyline);
//        }
//
//        MapPolyline polyline1 = new MapPolyline();
//        polyline1.setTag(1000);
//        polyline1.setLineColor(Color.argb(128, 255, 51, 0));
//        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.537229, 127.005515));
//        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.545024,127.03923));
//        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.527896,127.036245));
//        polyline1.addPoint(MapPoint.mapPointWithGeoCoord(37.541889,127.095388));
//        mMapView.addPolyline(polyline1);
//
//        MapPointBounds mapPointBounds = new MapPointBounds(polyline1.getMapPoints());
//        int padding = 100; // px
//        mMapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding));
//    }

    public void removeMap() {
        if (mMapView != null) {
            ((ViewGroup) mMapView.getParent()).removeView(mMapView);
            mMapView = null;
        }
    }
}
