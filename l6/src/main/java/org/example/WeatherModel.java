package org.example;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    List getWeather(String selectedCity, Period period) throws IOException;
}
