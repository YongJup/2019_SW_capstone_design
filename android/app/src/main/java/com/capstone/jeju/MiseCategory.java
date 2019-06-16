package com.capstone.jeju;

public class MiseCategory {
    private int id;
    private String name;
    private String dataTime;
    private int pm10Value;
    private int pm10Grade;
    private int pm25Value;
    private int pm25Grade;

    public MiseCategory(String name, String dataTime, int pm10Value, int pm25Value) {
        this.name = name;
        this.dataTime = dataTime;
        this.pm10Value = pm10Value;
        this.pm25Value = pm25Value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPm10Grade() {
        return pm10Grade;
    }

    public void setPm10Grade(int pm10Grade) {
        this.pm10Grade = pm10Grade;
    }

    public int getPm25Value() {
        return pm25Value;
    }

    public void setPm25Value(int pm25Value) {
        this.pm25Value = pm25Value;
    }

    public int getPm25Grade() {
        return pm25Grade;
    }

    public void setPm25Grade(int pm25Grade) {
        this.pm25Grade = pm25Grade;
    }
}
