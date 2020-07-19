package com.example.WheatherChannel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecast {

    @SerializedName("list")
    private List<WeatherForecastItem> items;

    public List<WeatherForecastItem> getItems() {return items;}
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (WeatherForecastItem item : items) {
            result.append(item.toString() + "\n");
        }

        return result.toString();
    }
}
