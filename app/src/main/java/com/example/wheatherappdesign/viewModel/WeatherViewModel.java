package com.example.wheatherappdesign.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wheatherappdesign.models.WeatherResponse;
import com.example.wheatherappdesign.repository.WeatherRepository;


public class WeatherViewModel extends ViewModel {
    private final MutableLiveData<WeatherResponse> weatherLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    private final WeatherRepository repository = new WeatherRepository();

    public LiveData<WeatherResponse> getWeatherLiveData() {
        return weatherLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void fetchWeather(String cityName) {
        repository.getWeather(cityName, new WeatherRepository.WeatherCallback() {
            @Override
            public void onSuccess(WeatherResponse weatherResponse) {
                weatherLiveData.postValue(weatherResponse);
            }

            @Override
            public void onError(Exception e) {
                errorLiveData.postValue(e.getMessage());
            }
        });
    }
}