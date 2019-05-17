package com.capstone.jeju.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.capstone.jeju.Activity.MainActivity;
import com.capstone.jeju.MapApplication;
import com.capstone.jeju.R;

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

public class ToiletFragment extends Fragment {

    private View view;
    private MapView mMapView;
    private MapPOIItem marker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_toilet, container, false);
        ViewGroup mapLayout = (ViewGroup) view.findViewById(R.id.map_view2);
        if(mMapView != null && mMapView.getParent() != null) ((ViewGroup) mMapView.getParent()).removeView(mMapView);
        mMapView = new MapView(getActivity());
        mapLayout.addView(mMapView);
        mapLayout.requestDisallowInterceptTouchEvent(true);
        marker = new MapPOIItem();

        setCenterPoint();
        setMarker();
        setMarker1();
        setMarker2();

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
