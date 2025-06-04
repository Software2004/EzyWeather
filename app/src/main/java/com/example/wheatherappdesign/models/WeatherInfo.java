package com.example.wheatherappdesign.models;

public class WeatherInfo {
    private String dayName;
    private String temperature;
    private String weatherCondition;
    private int weatherDrawable;

    public WeatherInfo(String dayName, String temperature, String weatherCondition, int weatherDrawable) {
        this.dayName = dayName;
        this.temperature = temperature;
        this.weatherCondition = weatherCondition;
        this.weatherDrawable = weatherDrawable;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public int getWeatherDrawable() {
        return weatherDrawable;
    }

    public void setWeatherDrawable(int weatherDrawable) {
        this.weatherDrawable = weatherDrawable;
    }
}
