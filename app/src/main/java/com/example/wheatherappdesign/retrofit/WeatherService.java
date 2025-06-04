package com.example.wheatherappdesign.retrofit;

import com.example.wheatherappdesign.models.WeatherResponse;

import retrofit2.Call;
import retrofit2.Callback;

public class WeatherService {
    private static final String API_KEY = "ff16b2c5be174080b1894435250406"; // Replace!
    private final ApiInterface apiInterface;

    public WeatherService() {
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    }

    public void getWeather(String cityName, Callback<WeatherResponse> callback) {
        Call<WeatherResponse> call = apiInterface.getWeatherData(API_KEY, cityName, "no"); // "no" = disable air quality
        call.enqueue(callback);
    }
}