package com.example.wheatherappdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wheatherappdesign.R;
import com.example.wheatherappdesign.models.WeatherInfo;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private Context context;
    private List<WeatherInfo> weatherInfoList;

    public WeatherAdapter(Context context, List<WeatherInfo> weatherInfoList) {
        this.context = context;
        this.weatherInfoList = weatherInfoList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_next, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherInfo weatherInfo = weatherInfoList.get(position);
        
        holder.dayNameTextView.setText(weatherInfo.getDayName());
        holder.temperatureTextView.setText(weatherInfo.getTemperature());
        holder.weatherConditionTextView.setText(weatherInfo.getWeatherCondition());
        holder.weatherConditionTextView.setCompoundDrawablesWithIntrinsicBounds(weatherInfo.getWeatherDrawable(), 0, 0, 0);
    }

    @Override
    public int getItemCount() {
        return weatherInfoList.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {

        TextView dayNameTextView;
        TextView temperatureTextView;
        TextView weatherConditionTextView;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            dayNameTextView = itemView.findViewById(R.id.dayN);
            temperatureTextView = itemView.findViewById(R.id.temp);
            weatherConditionTextView = itemView.findViewById(R.id.dayWea);
        }
    }
}
