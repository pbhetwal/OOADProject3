import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Calendar<T extends Observer> implements Subject<T> {
    /*
    :Description:   Observer pattern used here - concrete 
                    observable.  
    */
    private static Calendar ins = new Calendar();
    private List<T> observers;
    private List<Customer> customers;
    private int day;
    private Random r;
    private int numDays;
    private Calendar() {
        day = 1;
        observers = new LinkedList<T>();
        customers = new LinkedList<Customer>();
        r = new Random();
        numDays = 35;
    }
    public static Calendar getInstance(){
        return ins; 
    }
    public void registerObserver(T observer){
        observers.add(observer);
        if(observer instanceof Customer){
            customers.add((Customer)observer);
        }
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
            if(i == index || i == 0){
                observers.get(i).announce();
            }
        }

        HardwareStore tmp = HardwareStore.getInstance();
    
        tmp.printDayEarnings();
        day++;

    }

    public void simulateDays(){
        for(int i = 0; i < numDays; i++){
            int numCust = r.nextInt(customers.size() + 1);
            startDay();
            for(int j = 0; j < numCust; j++){
                Customer temp = (Customer)customers.get(r.nextInt(customers.size()));
                temp.rent();
            }
            
            endDay();
        }
    }
}