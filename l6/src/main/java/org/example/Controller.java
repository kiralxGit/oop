package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherNodel();
    private Map<Integer, Period> variants = new HashMap<>();
    public Controller() {
        variants.put(1, Period.ONE_DAY);
        variants.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String command, String city) throws IOException {
        Integer userOptions = Integer.parseInt(command);
        switch (variants.get(userOptions)){
            case ONE_DAY:
                System.out.println(weatherModel.getWeather(city, Period.ONE_DAY));
                break;
            case FIVE_DAYS:
                System.out.println(weatherModel.getWeather(city, Period.FIVE_DAYS));
                break;
        }

    }
}
