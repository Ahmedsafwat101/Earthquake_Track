package com.example.android.quakereport;

public class EarthquakeData {
    private String countryName;
    private double magnitude;
    private Long timeInMilliseconds;
    private String url;


    public EarthquakeData(String countryName, double magnitude, Long timeInMilliseconds, String url) {
        this.countryName = countryName;
        this.magnitude = magnitude;
        this.timeInMilliseconds = timeInMilliseconds;
        this.url = url;
    }

    public String getCountryName() {
        return countryName;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public Long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }

    public String getUrl() {
        return url;
    }
}
