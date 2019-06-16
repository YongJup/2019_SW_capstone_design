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

    public void setMiseArrayList(ArrayList<MiseCategory> miseArrayList) {
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
        holder.stationName.setText(miseArrayList.get(position).getName());
        holder.dataTime.setText(miseArrayList.get(position).getDataTime());
        holder.pm10Value.setText(String.valueOf(miseArrayList.get(position).getPm10Value()));
        holder.pm25Value.setText(String.valueOf(miseArrayList.get(position).getPm25Value()));

        if (miseArrayList.get(position).getPm10Value() <= 30) {
            holder.itemLayout.setBackgroundResource(R.color.colorGood);
            holder.currentCondition.setText("좋음");
            holder.currentImage.setImageResource(R.drawable.good);
            holder.currentImage2.setImageResource(R.drawable.good);
        } else if (miseArrayList.get(position).getPm10Value() <= 80) {
            holder.itemLayout.setBackgroundResource(R.color.colorSoso);
            holder.currentCondition.setText("보통");
            holder.currentImage.setImageResource(R.drawable.soso);
            holder.currentImage2.setImageResource(R.drawable.soso);
        } else if (miseArrayList.get(position).getPm10Value() <= 150) {
            holder.itemLayout.setBackgroundResource(R.color.colorNotBad);
            holder.currentCondition.setText("나쁨");
            holder.currentImage.setImageResource(R.drawable.bad);
            holder.currentImage2.setImageResource(R.drawable.bad);
        } else {
            holder.itemLayout.setBackgroundResource(R.color.colorBad);
            holder.currentCondition.setText("매우나쁨");
            holder.currentImage.setImageResource(R.drawable.verybad);
            holder.currentImage2.setImageResource(R.drawable.verybad);
        }

        if (miseArrayList.get(position).getPm25Value() <= 30) {
            holder.itemLayout.setBackgroundResource(R.color.colorGood);
            holder.currentImage.setImageResource(R.drawable.good);
            holder.currentImage3.setImageResource(R.drawable.good);
            holder.currentCondition.setText("좋음");
        } else if (miseArrayList.get(position).getPm25Value() <= 80) {
            holder.itemLayout.setBackgroundResource(R.color.colorSoso);
            holder.currentImage.setImageResource(R.drawable.soso);
            holder.currentImage3.setImageResource(R.drawable.soso);
            holder.currentCondition.setText("보통");
        } else if (miseArrayList.get(position).getPm25Value() <= 150) {
            holder.itemLayout.setBackgroundResource(R.color.colorNotBad);
            holder.currentImage.setImageResource(R.drawable.bad);
            holder.currentImage3.setImageResource(R.drawable.bad);
            holder.currentCondition.setText("나쁨");
        } else {
            holder.itemLayout.setBackgroundResource(R.color.colorBad);
            holder.currentImage.setImageResource(R.drawable.verybad);
            holder.currentImage3.setImageResource(R.drawable.verybad);
            holder.currentCondition.setText("매우나쁨");
        }
    }

    @Override
    public int getItemCount() {
        return miseArrayList.size();
    }
}
