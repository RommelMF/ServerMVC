package javaBooks.PatternObserver;

/**
 * Test class
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherDara weatherDara = new WeatherDara();

        CurrentConditionsDisplay currentConditionDisplay = new CurrentConditionsDisplay(weatherDara);


        weatherDara.setMeasurements(80, 65, 30.4f);
        weatherDara.setMeasurements(82, 70, 29.4f);
        weatherDara.setMeasurements(78, 90, 29.2f);
    }
}
