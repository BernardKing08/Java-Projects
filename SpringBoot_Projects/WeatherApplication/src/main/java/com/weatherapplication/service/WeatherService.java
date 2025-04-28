package com.weatherapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.weatherapplication.model.Weather;
import com.weatherapplication.weatherutils.CountryCodes;

import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;
    
    @Autowired
    CountryCodes cc = new CountryCodes();

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.openweathermap.org/data/2.5")
                .build();
    }

    public Mono<Weather> getCurrentWeather(String countryCode) {
    	
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", cc.getCountry(countryCode) + "," + countryCode)
                        .queryParam("units", "metric") // <-- Converts Kelvin to Celsius on API level
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(Weather.class);
    }
}
