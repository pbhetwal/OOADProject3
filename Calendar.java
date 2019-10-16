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
        System.out.println("\n\nDay " + Integer.toString(day) + " is starting!");
        for(int i = 1; i < observers.size(); i++){
            Customer tmp = (Customer)observers.get(i);
            tmp.returnTool();
        }
        notifyObserver();
    }

    public void endDay() {
        int index = observers.size()-1;
        for(int i = 0; i < index+1; i++){
            if(i == index){
                observers.get(i).announce();
            }
        }

        HardwareStore tmp = HardwareStore.getInstance();
        tmp.allActiveRentals();
        tmp.allToolsLeft();
        tmp.printDayEarnings();
        day++;

    }
}