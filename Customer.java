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

	public Customer(){

	}
	public Customer(String name){
		this.name = name;
	}

	public Customer(HardwareStore s){
		store = s;
    }

	public void setCustomerBehavior(CustomerBehavior cb){
		this.cb = cb;
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
		daysLeft--;
		if(daysLeft == 0){
			//returnTools();
			return;
		}
	}

	public void announce(){
		return;
	}

	public void rent(){
		int numTools = cb.rentTools();
		setDaysLeft(cb.calcDays());
		HashMap temp = store.getMap();
		Iterator it;

	}

}