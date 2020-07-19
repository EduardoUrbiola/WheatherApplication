package com.example.WheatherChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class helper {


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
        }
        catch (IOException ioe) {
            System.out.println("Error reading HTTP: "+ioe);
        }
        return data.toString();
    }
}