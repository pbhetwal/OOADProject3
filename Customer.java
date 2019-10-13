//
//  Customer.java
//  OOAD Project 3
//

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Customer implements Observer, DisplayElement{
	private String name, className;
	private int daysLeft;
	private CustomerBehavior cb;
	private HardwareStore store;
	private HashMap<Tools, Integer> toolTimeMap = new HashMap<Tools, Integer>();

	public Customer(){

	}
	public Customer(String name){
		this.name = name;
	}

	public Customer(String name, HardwareStore s){
		this.name = name;
		store = s;
    }

	public void setCustomerBehavior(CustomerBehavior cb){
		this.cb = cb;
	}

	public void returnTool(Tools t){

		HashMap<Tools, Customer> temp = store.getMap();
		temp.put(t, null);
		
	}

	//to be overridden
	public int rentTools() {
		return 0;
	}
	//to be overridden
	public int calcDays(){
		return 0;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setClassName(String className){
		this.className = className;
	}

	public String getClassName(){
		return this.className;
	}

	public void setDaysLeft(int daysLeft){
		this.daysLeft = daysLeft;
	}

	public int getDaysLeft(){
		return this.daysLeft;
	}


	public int getRand(int min, int max){
		int num = (int)((Math.random()*((max - min) + 1)) + min);
		return num;
	}


	public void update(){

		Iterator it = toolTimeMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry e = (Map.Entry)it.next();
			if (e.getValue() != 0){
				Tools t = e.getKey();
				int i = e.getValue();
				i--;
				toolTimeMap.put(t,i);
			}
		}
		
	}

	public void announce(){
		return;
	}

	public void rent(){
		int numTools = cb.rentTools();
		setDaysLeft(cb.calcDays());
		HashMap<Tools, Customer> temp = store.getMap();
		Iterator it = temp.entrySet().iterator();
		while(numTools != 0){
			Map.Entry elem = (Map.Entry)it.next();
			if(elem.getValue() == null){
				store.addCustomerToHashMap(this, (Tools)elem.getKey());
				toolTimeMap.put((Tools)elem.getKey(), daysLeft);
				System.out.println("They are renting the tool for " + daysLeft + " day(s)");
				numTools--;
			}
			//System.out.println((Tools)elem.getKey().getName());
		}

	}

}