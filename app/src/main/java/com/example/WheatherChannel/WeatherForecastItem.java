package com.example.WheatherChannel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecastItem {

    @SerializedName("dt_txt")
    private String time;

    @SerializedName("main")
    private Temperature temperature;

    private WeatherWind wind;

    @SerializedName("weather")
    private List<WeatherDescription> description;

    @Override
    public String toString() {
        return " - Time: " + time + ',' +
                " - Temperature: " + temperature.getTemp() + ',' +
                " - Weather Conditions: " + description.get(0).getDescription() + ',' +
                " - Wind Speed: " + wind.getSpeed() + '\n';
    }
}
