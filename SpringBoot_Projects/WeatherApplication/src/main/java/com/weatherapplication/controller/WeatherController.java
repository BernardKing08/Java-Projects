package com.weatherapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherapplication.model.DailyForecast;
import com.weatherapplication.model.Weather;
import com.weatherapplication.service.FiveDayForecastService;
import com.weatherapplication.service.WeatherService;
import com.weatherapplication.weatherutils.WeatherUtils;


@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private FiveDayForecastService forecastService;

    @GetMapping("/weather")
    public String showWeatherPage(@RequestParam(name = "country") String countryCode, Model model) {

        Weather weather = weatherService.getCurrentWeather(countryCode).block();
        List<DailyForecast> forecast = forecastService.getFiveDayForecast(countryCode);

        if (weather != null) {
            model.addAttribute("cityName", weather.getName());
            model.addAttribute("temperature", weather.getTemperatureInCelsius()); // now in Celsius
            model.addAttribute("humidity", weather.getHumidity());
            model.addAttribute("pressure", weather.getPressure());
            model.addAttribute("feelsLike", weather.getMain().getFeels_like());
            
            if (weather.getWind() != null) {  
            	model.addAttribute("wind", weather.getWind().getSpeed());
            }
            
            
            if (weather.getSys() != null) {
            	model.addAttribute("sunrise", WeatherUtils.formatUnixTime(weather.getSunrise()));
            	model.addAttribute("sunset", WeatherUtils.formatUnixTime(weather.getSunset()));
            }
            
            // Handle nested weather details
            if (weather.getWeather() != null && !weather.getWeather().isEmpty()) {
                Weather.WeatherDetail detail = weather.getWeather().get(0); // usually only one
                model.addAttribute("description", detail.getDescription());
                model.addAttribute("iconUrl", "https://openweathermap.org/img/wn/" + detail.getIcon() + ".png");
            }
        }
        
        model.addAttribute("forecastList", forecast);

        return "index"; // the Thymeleaf view
    }

}