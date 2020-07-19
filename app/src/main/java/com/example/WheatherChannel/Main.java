package com.example.WheatherChannel;

import com.google.gson.Gson;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        helper http = new helper();

        final String urlRootWeather = "http://api.openweathermap.org/data/2.5/weather";
        final String urlRootForecast = "http://api.openweathermap.org/data/2.5/forecast";
        final String apiKey = "eeaa2794e72b5067a7b7da9f2fe49428";
        String city;

        System.out.println("Enter city name: ");

        Scanner userInput = new Scanner(System.in);

        city = userInput.nextLine();
        String result = http.readHTTP(urlRootWeather + "?q=" + city + ",%20US,%20US" + "&units=imperial" + "&apiKey=" + apiKey);

        Gson gson = new Gson();

        WeatherConditions wc = gson.fromJson(result, WeatherConditions.class);

        result = http.readHTTP(urlRootForecast + "?q=" + city + ",%20US,%20US" + "&units=imperial" + "&apiKey=" + apiKey);
        gson = new Gson();

        WeatherForecast wf = gson.fromJson(result, WeatherForecast.class);

        System.out.println(wf);
    }

}
