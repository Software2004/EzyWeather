package com.example.wheatherappdesign.retrofit;

import com.example.wheatherappdesign.models.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("current.json") // Changed endpoint
    Call<WeatherResponse> getWeatherData(
            @Query("key") String apiKey,  // Changed from "appid" to "key"
            @Query("q") String cityName,
            @Query("aqi") String aqi // Optional (air quality)
    );
}