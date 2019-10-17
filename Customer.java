//
//  Customer.java
//  OOAD Project 3
//

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.lang.StringBuilder;
import java.util.List;
import java.util.LinkedList;

public abstract class Customer implements Observer{
	/*
	:Description:	Abstract class for customer with methods for renting
					implemented
	*/
	private String name, className;
	private int daysLeft;
	protected CustomerBehavior cb;
	protected HardwareStore store;
	private int numToolsRented = 0;
	private int totalRental;
	private HashMap<Tools, Integer> toolTimeMap = new HashMap<Tools, Integer>();
	private List<StringBuilder> records = new LinkedList<StringBuilder>();
	public Customer(){

	}
	public Customer(String name){
		this.name = name;
	}

	public Customer(String name, HardwareStore s){
		this.name = name;
		store = s;
    }

	//sets customer behaviore
	public void setCustomerBehavior(CustomerBehavior cb){
		this.cb = cb;
	}

	//adds a record to customers own rental record
	public void addCustRecord(StringBuilder rec){
		records.add(rec);
	}

	//check if a customer returned a tool and adds record to StoreRecord
	public void checkReturns(String toolName, String custName, boolean done){
		for(StringBuilder s: records){
			String temp = s.toString();
			if (temp.contains(toolName) && temp.contains(custName)) {
				store.addRecord(s);
				records.remove(s);
				return;
			}
		}
	}

	//tells store to print the completed rentals
	public void finishReturns(){
		store.completeRental();
	}

	//customer returns tools rented if days are up
	public void returnTool(){
		HashMap<Tools, Customer> temp = store.getMap();
		Iterator it = toolTimeMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry e = (Map.Entry)it.next();
			if ((int)e.getValue() == 0){
				Tools t = (Tools)e.getKey();
				if(temp.get(t) == this){
					int i = (int)e.getValue();
					toolTimeMap.put(t,i);
					store.setHashMap(t,null);
					setNumToolsRented(-1);
					int n = store.getToolsRented();
					n--;
					store.setToolsRented(n);
					checkReturns(t.getName(), getName(), false);
					store.incrementTotalComplete();
				}
			}
		}
		
	}

	public String getCustClass(){
		return "";
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

	public void setNumToolsRented(int num){
		numToolsRented = numToolsRented + num;
	}	

	public int getNumToolsRented(){
		return this.numToolsRented;
	}

	//decrements the days the customer has the tool for
	public void update(){
		totalRental = 0;
		Iterator it = toolTimeMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry e = (Map.Entry)it.next();
			if ((int)e.getValue() != 0){
				Tools t = (Tools)e.getKey();
				int i = (int)e.getValue();
				i--;
				toolTimeMap.put(t,i);
			}
		}
		
	}

	//last customer to return will have store print the record
	public void announce(){
		finishReturns();
		return;
	}

	public void changeAmount(){

	}

	//customer will add options and pay for their tool
	public StringBuilder checkOut(){
		StringBuilder additions = new StringBuilder();
		int custPrice = store.additonalOptions(additions);
		HashMap<String, Integer> priceMap = store.getPriceMap();
		custPrice += priceMap.get(getName());
		totalRental += custPrice;
		store.setTotalPrice(custPrice,"");
		store.setTotalSimMoney(custPrice);
		String custName = getName();
		store.setPriceMap(custName, custPrice);
		//System.out.println("Customer "+ custName + " is checking out and paying "+ custPrice);
		store.setPriceMap(custName,0);
		//System.out.println("additions = "+ additions);
		return additions;
	}

	//customer will rent a tool
	public void rent(){
		if(cb.getMaxAmt() > store.getToolsRented()){
			return;
		}
		StringBuilder rentalRecord = new StringBuilder();
		store.checkAvailable();
		changeAmount();
		int numTools = cb.rentTools();
		setDaysLeft(cb.calcDays());
		store.setCustRentDays(daysLeft);
		HashMap<Tools, Customer> temp = store.getMap();
		Iterator it = temp.entrySet().iterator();
		int n = getNumToolsRented();
		if(n < numTools){
			while(numTools != 0 && it.hasNext()){
				Map.Entry elem = (Map.Entry)it.next();
				if(elem.getValue() == null){
					store.addCustomerToHashMap(this, (Tools)elem.getKey(), rentalRecord);
					toolTimeMap.put((Tools)elem.getKey(), daysLeft);
					int z = store.getToolsRented();
					z++;
					store.setToolsRented(z);
					System.out.println("They are renting the tool for " + daysLeft + " day(s)");
					rentalRecord.append(", they rented it for " + daysLeft + " day(s)\n");
					rentalRecord.append(checkOut());
					numTools--;
					setNumToolsRented(1);
					store.setTotalSimRentals();
				}
				//System.out.println((Tools)elem.getKey().getName());
				//store.addRecord(totalRental);
			}
			//customer tried to get tool that has been rented
			if(totalRental != 0){
				rentalRecord.append(" Their total at checkout was: " + totalRental);
			}
			addCustRecord(rentalRecord);
			System.out.println("Customer " + name + " is checking out with a total " + totalRental);
		}
	}

}