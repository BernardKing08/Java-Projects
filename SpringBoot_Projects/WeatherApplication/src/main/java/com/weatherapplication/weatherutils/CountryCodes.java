package com.weatherapplication.weatherutils;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CountryCodes {
    private final Map<String, String> countries;

    public CountryCodes() {
        this.countries = new LinkedHashMap<>();
      //gets each country by their 2digit iso and puts them in a list
        for (String iso : Locale.getISOCountries()) { 
            Locale locale = new Locale("", iso);
            countries.put(locale.getDisplayCountry(), iso);
        }
    }

    public Map<String, String> getCountries() {
        return countries;
    }
    
    //gets the country code from the country
    public String getCountryCode(String country) {
		return this.countries.get(country);
	}
    
    //gets the country from the country code 
    public String getCountry(String countryCode) {
		String country = "";
		
		for(String get : this.countries.keySet()) {
			if(this.countries.get(get).equals(countryCode)) 
				country = get;
		}
		return country;
	}
	
	public Map<String, String> getAllCountryCodes(){
		return this.countries;
	}
}

