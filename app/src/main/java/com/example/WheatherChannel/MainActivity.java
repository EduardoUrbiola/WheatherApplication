package com.example.WheatherChannel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private EditText city_name;
    private ListView forcast_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city_name = findViewById(R.id.city_name);
        forcast_list = findViewById(R.id.forcast_list);
    }

    public void getTemp(View view) {
        TempTask task = new TempTask(city_name.getText().toString());
        task.start();
    }

    public void getForecast(View view) {
        ForecastTask task = new ForecastTask(city_name.getText().toString());
        task.start();
    }

    public void displayTemp(float temp) {
        Toast.makeText(this, "Temp is " + temp, Toast.LENGTH_SHORT).show();
    }

    public void displayForcast(WeatherForecast forecast) {
        ArrayAdapter adapter = new ArrayAdapter<WeatherForecastItem>(this, android.R.layout.simple_list_item_1, forecast.getItems());
        forcast_list.setAdapter(adapter);
    }
    private class TempTask extends Thread {
        private String city;
        public TempTask(String city) {
            this.city = city;
        }
        @Override
        public void run(){
            Main main = new Main();
            final WeatherConditions conditions = main.loadCurrentWeather(city);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    displayTemp(conditions.getMeasurements().get("temp"));
                }
            });

        }
    }
    private class ForecastTask extends Thread {
        private String city;
        public ForecastTask(String city) {
            this.city = city;
        }
        @Override
        public void run(){
            Main main = new Main();
            final WeatherForecast forecast = main.loadWeatherForecast(city);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    displayForcast(forecast);
                }
            });
        }


    }
}