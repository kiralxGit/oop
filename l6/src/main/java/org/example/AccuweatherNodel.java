package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AccuweatherNodel implements WeatherModel{
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "rz4F3BmH83Zwol7RDGlDfUfuCRyLAuZM";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String METRIC = "metric";
    private static final String TRUE = "true";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List getWeather(String selectedCity, Period period) throws IOException {
        HttpUrl httpUrl = null;
        switch (period) {
            case ONE_DAY:
                httpUrl = httpUrlBuilder(selectedCity, ONE_DAY);
                break;
            case FIVE_DAYS:
                httpUrl = httpUrlBuilder(selectedCity, FIVE_DAYS);
                break;
        }
        Request request = new Request.Builder().url(httpUrl).build();

        Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = oneDayForecastResponse.body().string();
        String reponseString = objectMapper.readTree(weatherResponse).get("DailyForecasts").toString();
        String[] responseArray = reponseString.replace("[{","")
                .replace("}]","")
                .replace("},{","---")
                .split("---");
        List<DailyWeather> dailyWeatherList = new ArrayList<>();
        for (String item: responseArray) {
            dailyWeatherList.add(makeDailyObject(item));
        }

        return dailyWeatherList;
    }
    private HttpUrl httpUrlBuilder(String selectedCity, String period) throws IOException{
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(period)
                .addPathSegment(detectCityKey(selectedCity))
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(METRIC, TRUE)
                .addQueryParameter("language", "ru-ru")
                .build();
        return httpUrl;
    }
    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
    private DailyWeather makeDailyObject(String weatherResponse) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder(weatherResponse);
        sb.insert(0, '{');
        sb.append('}');
        String string = sb.toString();

        DailyWeather dailyWeather = new DailyWeather();
        dailyWeather.setDate(objectMapper.readTree(string)
                                                 .get("Date")
                                                 .asText()
                                                 .substring(0, 10));
        dailyWeather.setTempMin(objectMapper.readTree(string)
                                                .get("Temperature")
                                                .get("Minimum")
                                                .get("Value")
                                                .asText());
        dailyWeather.setTempMax(objectMapper.readTree(string)
                                                .get("Temperature")
                                                .get("Maximum")
                                                .get("Value")
                                                .asText());
        String day = objectMapper.readTree(string).get("Day").get("IconPhrase").asText();
        String night = objectMapper.readTree(string).get("Night").get("IconPhrase").asText();
        dailyWeather.setDescription(String.format("Днём %s, ночью %s", day, night));

        return dailyWeather;
    }


}
