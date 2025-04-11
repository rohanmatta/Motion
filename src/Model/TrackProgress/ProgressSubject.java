package Model.TrackProgress;

import java.util.ArrayList;
import java.util.List;
import Observer.Observer;
import Observer.Subject;

public class ProgressSubject implements Subject {
    private ProgressData progressData;
    private List<Observer> observers = new ArrayList<>();

    public ProgressSubject(ProgressData progressData) {
        this.progressData = progressData;
    }

    public void setProgressData(ProgressData progressData) {
        this.progressData = progressData;
        notifyObservers();
    }

    public ProgressData getProgressData() {
        return this.progressData;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(progressData);
        }
    }
}
