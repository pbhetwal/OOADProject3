import java.util.List;
import java.util.LinkedList;

public class Calander<T> implements Subject {
    private List<T> observers;
    private int day;

    public Calander() {
        day = 1;
        observers = new LinkedList<T>();
    }
    public void registerObserver(T observer){
        observers.add(T);
    }
    public void removeObserver(){
        for(T obs: observers){
            observers.remove();
        }

    }
    public void notifyObserver(){
        for(T obs: observers){
            obs.update();
        }
    }

    public String startDay() {
        return "Day " + day.toString() + " is starting!";
    }

    public void endDay() {

    }
}