package com.example.wheatherappdesign.models;

public class WeatherCardInfo {
    private String time;
    private String temperature;
    private int weatherDrawable;

    public WeatherCardInfo(String time, String temperature, int weatherDrawable) {
        this.time = time;
        this.temperature = temperature;
        this.weatherDrawable = weatherDrawable;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getWeatherDrawable() {
        return weatherDrawable;
    }

    public void setWeatherDrawable(int weatherDrawable) {
        this.weatherDrawable = weatherDrawable;
    }
}
