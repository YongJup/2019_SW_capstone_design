package com.capstone.jeju;

import java.sql.Time;

public class MiseCategory {
    private String stationName;
    private String dataTime;
    private int pm10Value;
    private int pm25Value;

    public MiseCategory(String stationName, String dataTime, int pm10Value, int pm25Value) {
        this.stationName = stationName;
        this.dataTime = dataTime;
        this.pm10Value = pm10Value;
        this.pm25Value = pm25Value;
    }


    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public int getPm10Value() {
        return pm10Value;
    }

    public void setPm10Value(int pm10Value) {
        this.pm10Value = pm10Value;
    }

    public int getPm25Value() {
        return pm25Value;
    }

    public void setPm25Value(int pm25Value) {
        this.pm25Value = pm25Value;
    }
}
