import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.ArrayList;

public class Calendar<T extends Observer> implements Subject<T> {
    /*
    :Description:   Observer pattern and singleton used here - concrete
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
    //adds an observer to list of observers
    public void registerObserver(T observer){
        observers.add(observer);
        if(observer instanceof Customer){
            customers.add((Customer)observer);
        }
    }
    //removes observers from list
    public void removeObserver(){
        for(T obs: observers){
            observers.remove(0);
        }

    }

    //updates observers
    public void notifyObserver(){
        for(T obs: observers){
            obs.update();
        }
    }

    //starts day. customers return tools and et notified day has started
    public void startDay() {
        System.out.println("\n\nDay " + Integer.toString(day) + " is starting!");
        for(int i = 1; i < observers.size(); i++){
            Customer tmp = (Customer)observers.get(i);
            tmp.returnTool();
        }
        notifyObserver();
    }

    //ends the day. last customer will have StoreRecord print and store will print
    //day earnings
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

    //run the simulation for 35 days
    public void simulateDays(){
        for(int i = 0; i < numDays; i++){
            int numCust = r.nextInt(customers.size() + 1);
            startDay();
            List<Customer> visitedToday = new ArrayList<Customer>();
            for(int j = 0; j < numCust; j++){
                Customer temp = (Customer)customers.get(r.nextInt(customers.size()));
                if(!visitedToday.contains(temp)){
                    temp.rent();
                }
                visitedToday.add(temp);
            }
            
            endDay();
        }
    }
}