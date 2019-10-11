import java.util.List;
import java.util.LinkedList;

public class Calander<T> implements Subject {
    private List<T> observers;

    public Calander() {
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
}