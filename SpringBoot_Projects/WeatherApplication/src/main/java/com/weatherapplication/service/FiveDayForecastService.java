package com.weatherapplication.service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.weatherapplication.model.DailyForecast;
import com.weatherapplication.weatherutils.CountryCodes;
import com.weatherapplication.weatherutils.WeatherUtils;

import lombok.Getter;

@Service
public class FiveDayForecastService {

    private final WebClient webClient;
    
    @Autowired
    CountryCodes cc = new CountryCodes();

    @Value("${openweather.api.key}")
    private String apiKey;

    public FiveDayForecastService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public List<DailyForecast> getFiveDayForecast(String countryCode) {
        String url = "/forecast?q=" + cc.getCountry(countryCode) + "," + countryCode + "&appid=" + apiKey;

        // Get the list node from the response JSON
        Map<String, Object> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();

        List<Map<String, Object>> forecastList = (List<Map<String, Object>>) response.get("list");

        // Group by day (ignoring today)
        String today = LocalDate.now().toString();

        return forecastList.stream()
            .map(this::mapToForecastData)
            .filter(entry -> !entry.getDate().equals(today))
            .collect(Collectors.groupingBy(ForecastData::getDate, LinkedHashMap::new, Collectors.toList()))
            .entrySet().stream()
            .limit(5)
            .map(entry -> {
                List<ForecastData> dailyData = entry.getValue();
                return new DailyForecast(
                	    WeatherUtils.getDayOfWeek(entry.getKey()),
                	    dailyData.get(0).getDescription(),
                	    dailyData.get(0).getIcon(),
                	    Math.round(dailyData.stream().mapToDouble(ForecastData::getTemp).min().orElse(0)),
                	    Math.round(dailyData.stream().mapToDouble(ForecastData::getTemp).max().orElse(0))
                	);

            })
            .collect(Collectors.toList());
    }

    // Helper class for internal data processing
    private ForecastData mapToForecastData(Map<String, Object> entry) {
        Map<String, Object> main = (Map<String, Object>) entry.get("main");
        List<Map<String, Object>> weatherList = (List<Map<String, Object>>) entry.get("weather");
        Map<String, Object> weather = weatherList.get(0);

        double kelvinTemp = Double.parseDouble(main.get("temp").toString());
        double tempCelsius = WeatherUtils.convertKelvinToCelsius(kelvinTemp);

        String dateTime = entry.get("dt_txt").toString();
        String dateOnly = dateTime.split(" ")[0];

        return new ForecastData(
            dateOnly,
            tempCelsius,
            weather.get("description").toString(),
            weather.get("icon").toString()
        );
    }

    // Simple POJO to help group forecast data internally
    // uses lombok getters
    @Getter
    private static class ForecastData {
        private final String date;
        private final double temp;
        private final String description;
        private final String icon;

        public ForecastData(String date, double temp, String description, String icon) {
            this.date = date;
            this.temp = temp;
            this.description = description;
            this.icon = icon;
        }

    }
}
