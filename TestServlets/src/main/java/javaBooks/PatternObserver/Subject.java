package javaBooks.PatternObserver;

/**
 * Created by Home on 31.01.2017.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

