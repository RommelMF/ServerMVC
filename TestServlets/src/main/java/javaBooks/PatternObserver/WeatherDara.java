package javaBooks.PatternObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 31.01.2017.
 */
public class WeatherDara implements Subject{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDara(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size() ; i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
//        observers.forEach((o)->o.update(temperature, humidity, pressure));
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float tempereture, float humidity, float pressure) {
        this.temperature = tempereture;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
