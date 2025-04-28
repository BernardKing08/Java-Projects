package com.weatherapplication.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weatherapplication.weatherutils.WeatherUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	
	private WeatherUtils wu;

    private String name; // city name
    private Main main;
    private List<WeatherDetail> weather;
    private Wind wind;      // <-- new
    private Sys sys;        // <-- new

    public double getTemperatureInCelsius() {
        return main != null ? main.getTemp() : 0.0;
    }

    public double getHumidity() {
        return main != null ? main.getHumidity() : 0.0;
    }

    public double getPressure() {
        return main != null ? main.getPressure() : 0.0;
    }

    // Optional: formatted sunrise/sunset methods
    public long getSunrise() {
        return sys != null ? sys.getSunrise() : 0;
    }

    public long getSunset() {
        return sys != null ? sys.getSunset() : 0;
    }

    @Getter
    @Setter
    public static class WeatherDetail {
        private String main;
        private String description;
        private String icon;
    }

    @Getter
    @Setter
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private double pressure;
        private double humidity;
    }

    @Getter
    @Setter
    public static class Wind {
        private double speed;
        private double deg;
    }

    @Getter
    @Setter
    public static class Sys {
        private String country;
        private long sunrise;  // UNIX timestamp
        private long sunset;   // UNIX timestamp
    }
}

