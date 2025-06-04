package com.example.wheatherappdesign.repository;

import androidx.annotation.NonNull;

import com.example.wheatherappdesign.models.WeatherResponse;
import com.example.wheatherappdesign.retrofit.WeatherService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WeatherRepository {
    private final Map<String, WeatherResponse> cache = new HashMap<>(); // Simple in-memory cache
    private final ExecutorService executorService = Executors.newSingleThreadExecutor(); // For background execution
    WeatherService weatherService;


    public WeatherRepository() {
        weatherService = new WeatherService();
    }

    public void getWeather(String cityName, WeatherCallback callback) {
        executorService.execute(() -> {
            try {
                // Check cache first
                WeatherResponse cachedResponse = cache.get(cityName);
                if (cachedResponse != null) {
                    // Post result back to the main thread if needed (e.g., for UI updates)
                    // For simplicity, directly invoking callback here
                    callback.onSuccess(cachedResponse);
                    return;
                }

                // Fetch fresh data if not in cache or cache is invalid
                // Note: Retrofit calls in Java are typically synchronous by default.
                // If your ApiInterface methods are defined to return Call<WeatherResponse>,
                // you would use response.execute() for a synchronous call.
                // For this direct translation, we'll assume getWeatherData is synchronous
                // or you'd wrap an asynchronous Retrofit call.
                weatherService.getWeather(cityName, new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                        cache.put(cityName, response.body());
                        callback.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                        callback.onError((Exception) t);
                    }
                });

            } catch (Exception e) {
                callback.onError(e);
            }
        });
    }

    // Callback interface for asynchronous operation
    public interface WeatherCallback {
        void onSuccess(WeatherResponse weatherResponse);
        void onError(Exception e);
    }

}