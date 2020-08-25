package com.example.android.quakereport;

class EarthquakeData {
    private String countryName;
    private String magnitude ;
    private String date;

    public EarthquakeData(String countryName, String magnitude, String date) {
        this.countryName = countryName;
        this.magnitude = magnitude;
        this.date = date;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }
}
