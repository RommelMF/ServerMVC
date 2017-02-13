package javaBooks.PatternObserver;

/**
 * Created by Home on 31.01.2017.
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
