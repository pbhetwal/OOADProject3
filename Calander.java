import java.util.List;
import java.util.LinkedList;

public class Calander<T extends Observer> implements Subject<T> {
    private List<T> observers;
    private int day;

    public Calander() {
        day = 1;
        observers = new LinkedList<T>();
    }
    public void registerObserver(T observer){
        observers.add(observer);
    }
    public void removeObserver(){
        for(T obs: observers){
            observers.remove(0);
        }

    }
    public void notifyObserver(){
        for(T obs: observers){
            obs.update();
        }
    }

    public void startDay() {
        System.out.println("Day " + Integer.toString(day) + " is starting!");
        notifyObserver();
    }

    public void endDay() {
        day++;
    }
}