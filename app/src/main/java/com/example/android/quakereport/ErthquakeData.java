package com.example.android.quakereport;

class EarthquakeData {
    private String countryName;
    private String magnitude ;
    private Long timeInMilliseconds;

    public EarthquakeData(String countryName, String magnitude, Long timeInMilliseconds) {
        this.countryName = countryName;
        this.magnitude = magnitude;
        this.timeInMilliseconds = timeInMilliseconds;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public Long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }
}
