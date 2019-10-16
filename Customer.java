//
//  Customer.java
//  OOAD Project 3
//

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.lang.StringBuilder;

public class Customer implements Observer, DisplayElement{
	private String name, className;
	private int daysLeft;
	protected CustomerBehavior cb;
	protected HardwareStore store;
	private int numToolsRented = 0;
	private int totalRental;
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

	public void returnTool(){

		HashMap<Tools, Customer> temp = store.getMap();
		Iterator it = toolTimeMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry e = (Map.Entry)it.next();
			if ((int)e.getValue() == 0){
				Tools t = (Tools)e.getKey();
				if(temp.get(t) == this){
					System.out.println("Customer " + getName() + " is returning tool: " + t.getName());
					int i = (int)e.getValue();
					toolTimeMap.put(t,i);
					store.setHashMap(t,null);
					setNumToolsRented(-1);
				}
			}
		}
		
		
		
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

	public void announce(){
		return;
	}

	public void changeAmount(){

	}

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
					//System.out.println("They are renting the tool for " + daysLeft + " day(s)");
					rentalRecord.append(", they rented it for " + daysLeft + " day(s)\n");
					rentalRecord.append(checkOut());
					numTools--;
					setNumToolsRented(1);
					store.setTotalSimRentals();
					
					
					Character custClassName = getName().charAt(0);
					//System.out.println("CLASSNAME:"+custClassName);
					if(custClassName == 'B'){
						store.setBusCustToolTotal();
					}
					else if(custClassName == 'C'){
						store.setCasCustToolTotal();
					}
					else{
						store.setRegCustToolTotal();
					}
				}
				//System.out.println((Tools)elem.getKey().getName());
				//store.addRecord(totalRental);
			}
			if(totalRental != 0){
				rentalRecord.append(" Their total at checkout was: " + totalRental);
			}
			store.addRecord(rentalRecord);
			//System.out.println("Customer " + name + " is checking out with a total " + totalRental);
		}
	}

}