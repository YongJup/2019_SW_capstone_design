package com.capstone.jeju.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.capstone.jeju.MiseCategory;
import com.capstone.jeju.R;


import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<MiseCategory> miseArrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView stationName, dataTime, pm10Value, pm25Value, currentCondition;
        public ImageView currentImage, currentImage2, currentImage3;
        public ConstraintLayout itemLayout;
        public MyViewHolder(View view) {
            super(view);
            stationName = (TextView) view.findViewById(R.id.mise_location);
            dataTime = (TextView) view.findViewById(R.id.mise_time);
            pm10Value = (TextView) view.findViewById(R.id.current_mise_concentration);
            pm25Value = (TextView) view.findViewById(R.id.current_chomise_concentration);
            itemLayout = view.findViewById(R.id.item_layout);
            currentCondition = (TextView) view.findViewById(R.id.current_status);
            currentImage = (ImageView) view.findViewById(R.id.imageView);
            currentImage2 = (ImageView) view.findViewById(R.id.imageView2);
            currentImage3 = (ImageView) view.findViewById(R.id.imageView3);
        }
    }

    public RecyclerViewAdapter(ArrayList<MiseCategory> miseArrayList) {
        this.miseArrayList = miseArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mise_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.stationName.setText(miseArrayList.get(position).getStationName());
        holder.dataTime.setText(miseArrayList.get(position).getDataTime());
        holder.pm10Value.setText(String.valueOf(miseArrayList.get(position).getPm10Value()));
        holder.pm25Value.setText(String.valueOf(miseArrayList.get(position).getPm25Value()));
        holder.itemLayout.setBackgroundResource(miseArrayList.get(position).getPm10Value() > 30 ? R.color.colorBad : R.color.colorGood);
        holder.currentCondition.setText(miseArrayList.get(position).getPm10Value() > 30 ? "나쁨" : "좋음");
    }

    @Override
    public int getItemCount() {
        return miseArrayList.size();
    }
}
