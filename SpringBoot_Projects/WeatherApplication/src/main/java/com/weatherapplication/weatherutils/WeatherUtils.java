package com.weatherapplication.weatherutils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class WeatherUtils {
	
	//initializing constants 
	private static final Double ABSOLUTE_TEMPERATURE_CONSTANT = 273.15;
	private static final Integer CONVERT_SECONDS_TO_HOURS = 3600;
	
	private static final DecimalFormat df;

	static {
        df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.CEILING);
    }
	
	public static DecimalFormat getDecimalFormat() {
        return df;
    }

    public static double convertKelvinToCelsius(double kelvin) {
        return kelvin - ABSOLUTE_TEMPERATURE_CONSTANT;
    }

    public static double convertSecondsToHours(double seconds) {
        return seconds / CONVERT_SECONDS_TO_HOURS;
    }
    
    //getting the current day of the week 
    public static String getDayOfWeek(String date) {
        return LocalDate.parse(date).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    //for getting sunrise/sunset time 
    public static String formatUnixTime(long unixTimestamp) {
        return java.time.Instant.ofEpochSecond(unixTimestamp)
            .atZone(java.time.ZoneId.systemDefault())
            .toLocalTime()
            .toString();
    }

}
