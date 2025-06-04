package com.example.wheatherappdesign.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wheatherappdesign.R;
import com.example.wheatherappdesign.adapters.WeatherAdapter;
import com.example.wheatherappdesign.models.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView weatherRecyclerView;
    private WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_forecast);
        findViewById(R.id.ivback).setOnClickListener(view -> finish());
        weatherRecyclerView = findViewById(R.id.rcv);

        List<WeatherInfo> weatherInfoList = new ArrayList<>();
        weatherInfoList.add(new WeatherInfo("Wed", "32°C", "Windy", R.drawable.windy));
        weatherInfoList.add(new WeatherInfo("Thu", "31°C", "Cloudy-Sunny", R.drawable.cloudy));
        weatherInfoList.add(new WeatherInfo("Fri", "35°C", "Sunny", R.drawable.sunny));
        weatherInfoList.add(new WeatherInfo("Sat", "29°C", "Rainy", R.drawable.rainy));
        weatherInfoList.add(new WeatherInfo("Sun", "30°C", "Storm", R.drawable.storm));
        weatherInfoList.add(new WeatherInfo("Mon", "28°C", "Cloudy", R.drawable.cloudy));

        weatherAdapter = new WeatherAdapter(this, weatherInfoList);
        weatherRecyclerView.setAdapter(weatherAdapter);

    }
}