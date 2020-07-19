package com.example.WheatherChannel;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {
    helper http = new helper();

    private final String urlRootWeather = "http://api.openweathermap.org/data/2.5/weather";
    private final String urlRootForecast = "http://api.openweathermap.org/data/2.5/forecast";
    private final String apiKey = "eeaa2794e72b5067a7b7da9f2fe49428";
    private Gson gson;
    String city;

    public WeatherConditions loadCurrentWeather(String city) {
        String result = http.readHTTP(urlRootWeather + "?q=" + city + ",%20US,%20US" + "&units=imperial" + "&apiKey=" + apiKey);
        String data = readHTTP(result);
    return gson.fromJson(data, WeatherConditions.class);
    }

    public WeatherForecast loadWeatherForecast(String city) {
        String result = http.readHTTP(urlRootForecast + "?q=" + city + ",%20US,%20US" + "&units=imperial" + "&apiKey=" + apiKey);
        String data = readHTTP(result);
        return gson.fromJson(data, WeatherForecast.class);
    }
    public String readHTTP(String url) {
        StringBuilder data = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    data.append(line);
                }
            }
            while (line != null);
            return data.toString();
        } catch (IOException ioe) {
            System.out.println("Error reading HTTP: " + ioe);
        }
        return data.toString();
    }
}
