package com.capstone.jeju.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.capstone.jeju.Adapter.RecyclerViewAdapter;
import com.capstone.jeju.MiseCategory;
import com.capstone.jeju.R;
import com.capstone.jeju.Task.Task;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class MiseFragment extends Fragment {

    private ViewPager viewPager;
    private View view;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<MiseCategory> miseCategories = new ArrayList<>();
    private SnapHelper snapHelper;
    private Task task;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_mise, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        snapHelper = new LinearSnapHelper();
        recyclerView.setHasFixedSize(true);
        mAdapter = new RecyclerViewAdapter(miseCategories);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        snapHelper.attachToRecyclerView(recyclerView);

        task = new Task(this);
        task.execute();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepareData();
    }

    private void prepareData() {

    }

    public void setMise(String text) {
        String name;
        String dataTime;
        int pm10Value;
        int pm25Value;

        try {
            JSONArray jarray = new JSONObject(text).getJSONArray("list");
            for (int i = 0; i < jarray.length(); i++) {
                JSONObject jObject = jarray.getJSONObject(i);

                name = jObject.optString("stationName");
                dataTime = jObject.optString("dataTime");
                pm10Value = jObject.optInt("pm10Value");
                pm25Value = jObject.optInt("pm25Value");
                miseCategories.add(new MiseCategory(name, dataTime, pm10Value, pm25Value));
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        mAdapter.setMiseArrayList(miseCategories);
        mAdapter.notifyDataSetChanged();
    }
}
