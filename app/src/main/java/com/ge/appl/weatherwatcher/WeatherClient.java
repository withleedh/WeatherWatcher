package com.ge.appl.weatherwatcher;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SweetLife on 2016-08-21.
 */
public class WeatherClient {

    final static String openWeatherURL = "http://api.openweathermap.org/data/2.5/weather?q=";
    final static String apiKey = "931ed2a2113552915849cebeb3f0f9a5";

    public Weather getWeather(String city) {
        Weather w = new Weather();

        // url for parsing weather data
        String urlString = openWeatherURL + city + "&APPID=" + apiKey;

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


            //get JSON data from urlConnection.
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JSONObject json = new JSONObject(in.toString());

            // parse JSON
            w = parseJSON(json);
            w.setCity(city);

        } catch (JSONException e) {
            System.err.println("JSON parsing error");
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            System.err.println("URL Connection failed");
            e.printStackTrace();
            return null;
        }

        return w;
    }

    private Weather parseJSON(JSONObject json) throws JSONException {
        Weather weather = new Weather();
        weather.setTemperature(json.getJSONObject("main").getInt("temp"));
        weather.setCity(json.getString("name"));
        weather.setCloudy(json.getString("description"));


        return weather;
    }
}