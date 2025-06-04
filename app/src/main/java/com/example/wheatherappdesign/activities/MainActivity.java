package com.example.wheatherappdesign.activities;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.wheatherappdesign.R;
import com.example.wheatherappdesign.adapters.WeatherCardAdapter;
import com.example.wheatherappdesign.databinding.ActivityMainBinding;
import com.example.wheatherappdesign.models.WeatherCardInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.wheatherappdesign.viewModel.WeatherViewModel;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    WeatherCardAdapter weatherCardAdapter;
    private WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        observeViewModel();

        binding.t6.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,MainActivity2.class)));

        List<WeatherCardInfo> weatherCardInfoList = new ArrayList<>();
        weatherCardInfoList.add(new WeatherCardInfo("9 pm", "28°C", R.drawable.cloudy));
        weatherCardInfoList.add(new WeatherCardInfo("10 pm", "27°C", R.drawable.storm));
        weatherCardInfoList.add(new WeatherCardInfo("11 pm", "26°C", R.drawable.windy));
        weatherCardInfoList.add(new WeatherCardInfo("12 am", "25°C", R.drawable.sunny));
        weatherCardInfoList.add(new WeatherCardInfo("1 am", "24°C", R.drawable.sunny));
        weatherCardInfoList.add(new WeatherCardInfo("2 am", "23°C", R.drawable.rainy));

        weatherCardAdapter = new WeatherCardAdapter(this, weatherCardInfoList);
        binding.rcv.setAdapter(weatherCardAdapter);
    }

    private void observeViewModel() {
        // Observe LiveData
        viewModel.getWeatherLiveData().observe(this, weather -> {
            if (weather != null) {
                //binding.tvRainPercentage.setText(weather.ge + "%");
                binding.pbar.setVisibility(GONE);
                binding.dataLayout.setVisibility(VISIBLE);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMMM dd | hh:mm a");
                binding.dateTime.setText(sdf.format(calendar.getTime()));
                binding.tvWindSpeed.setText(weather.getCurrent().getWind_kph() + getString(R.string.wind));
                binding.tvHumidity.setText(weather.getCurrent().getHumidity() + "%\nHumindity");
                binding.tvCityName.setText(weather.getLocation().getName());
                binding.temp.setText(Html.fromHtml(weather.getCurrent().getFeelslike_c() + "<small><small> °C</small></small>",Html.FROM_HTML_MODE_LEGACY));
                binding.weatherDescription.setText(weather.getCurrent().getCondition().getText());
            }
        });

        viewModel.getErrorLiveData().observe(this, error -> {
            Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_SHORT).show();
            binding.pbar.setVisibility(GONE);
            binding.dataLayout.setVisibility(GONE);
        });

        viewModel.fetchWeather("Sargodha");
    }

}