package com.weatherapplication.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DailyForecast {
    private String dayOfWeek;
    private String weatherDescription;
    private String weatherIcon;
    private double minTemp;
    private double maxTemp;
}


