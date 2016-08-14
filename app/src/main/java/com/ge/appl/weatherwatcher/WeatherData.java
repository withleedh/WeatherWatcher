package com.ge.appl.weatherwatcher;

import android.graphics.drawable.Drawable;

/**
 * Created by SweetLife on 2016-08-14.
 */
public class WeatherData {

    private Drawable mWeatherImage;
    private String mDayOfWeek;
    private String mMonthDay;
    private String mWeather;
    private String mTemperature;

    public Drawable getWeatherImage() {
        return mWeatherImage;
    }

    public void setWeatherImage(Drawable weatherImage) {
        mWeatherImage = weatherImage;
    }

    public String getDayOfWeek() {
        return mDayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        mDayOfWeek = dayOfWeek;
    }

    public String getMonthDay() {
        return mMonthDay;
    }

    public void setMonthDay(String monthDay) {
        mMonthDay = monthDay;
    }

    public String getWeather() {
        return mWeather;
    }

    public void setWeather(String weather) {
        mWeather = weather;
    }

    public String getTemperature() {
        return mTemperature;
    }

    public void setTemperature(String temperature) {
        mTemperature = temperature;
    }
}
