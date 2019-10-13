import java.util.List;
import java.util.LinkedList;

public class Calendar<T extends Observer> implements Subject<T> {
    private static Calendar ins = new Calendar();
    private List<T> observers;
    private int day; 
    private Calendar() {
        day = 1;
        observers = new LinkedList<T>();
    }
    public static Calendar getInstance(){
        return ins; 
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
        Customer tmp = (Customer)observers.get(1);
        tmp.returnTool();
        notifyObserver();
    }

    public void endDay() {
        HardwareStore tmp = HardwareStore.getInstance();
        tmp.printDayEarnings();
        day++;

    }
}