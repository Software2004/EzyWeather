package com.example.wheatherappdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wheatherappdesign.R;
import com.example.wheatherappdesign.models.WeatherCardInfo;

import java.util.List;

public class WeatherCardAdapter extends RecyclerView.Adapter<WeatherCardAdapter.WeatherCardViewHolder> {

    private Context context;
    private List<WeatherCardInfo> weatherCardInfoList;

    public WeatherCardAdapter(Context context, List<WeatherCardInfo> weatherCardInfoList) {
        this.context = context;
        this.weatherCardInfoList = weatherCardInfoList;
    }

    @NonNull
    @Override
    public WeatherCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_todays, parent, false);
        return new WeatherCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherCardViewHolder holder, int position) {
        WeatherCardInfo weatherCardInfo = weatherCardInfoList.get(position);
        
        holder.timeTextView.setText(weatherCardInfo.getTime());
        holder.temperatureTextView.setText(weatherCardInfo.getTemperature());
        holder.temperatureTextView.setCompoundDrawablesWithIntrinsicBounds(0, weatherCardInfo.getWeatherDrawable(), 0, 0);
    }

    @Override
    public int getItemCount() {
        return weatherCardInfoList.size();
    }

    public static class WeatherCardViewHolder extends RecyclerView.ViewHolder {

        TextView timeTextView;
        TextView temperatureTextView;

        public WeatherCardViewHolder(@NonNull View itemView) {
            super(itemView);
            timeTextView = itemView.findViewById(R.id.time);
            temperatureTextView = itemView.findViewById(R.id.temp);
        }
    }
}
