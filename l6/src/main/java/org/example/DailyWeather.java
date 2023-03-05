package org.example;

public class DailyWeather {
    private String date;
    private String tempMin;
    private String tempMax;
    private String description;

    public void setDate(String date) {
        this.date = date;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\tПогода на дату " + date + "\n" +
                "\tминимальная температура " + tempMin + "\n" +
                "\tмаксимальная температура " + tempMax + "\n" +
                "\t" + description + ".\n---\n";
    }
}
