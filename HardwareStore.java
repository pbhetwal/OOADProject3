// Singleton pattern used here 

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.lang.StringBuilder;

class HardwareStore implements Observer, DisplayElement{
	private static HardwareStore ins = new HardwareStore();
	private int TotalPrice = 0;
	private HashMap<Tools, Customer> hmap = new HashMap<Tools, Customer>();
	private HashMap<String, Integer> priceMap = new HashMap<String, Integer>();
	private int extensionCord = 5;
	private int accessoryKit = 25;
	private int protectiveGear = 30;
	private int toolsRented = 0;
	private boolean allowBusinessCustomer = true;
	private boolean allowRegularCustomer = true;
	private boolean allowCasualCustomer = true;
	private int businessRentAmt;
	private int casualRentAmt;
	private int regularRentAmt;
	private int totalSimulationMoney = 0;
	private int updateDayCount = 1;
	private int totalSimRentals = 0;
	private int busCustToolTotal = 0;
	private int regCustToolTotal = 0;
	private int casCustToolTotal = 0;
	private StoreRecord record;

	private HardwareStore() {
		System.out.println("Our hardware rental store is now open!");
		record = new StoreRecord();
	}

	public static HardwareStore getInstance(){
		return ins; 
	}

	public void setBusCustToolTotal(){
		busCustToolTotal++;
	}

	public int getBusCustToolTotal(){
		return this.busCustToolTotal;
	}

	public void setRegCustToolTotal(){
		regCustToolTotal++;
	}

	public int getRegCustToolTotal(){
		return this.regCustToolTotal;
	}

	public void setCasCustToolTotal(){
		casCustToolTotal++;
	}

	public int getCasCustToolTotal(){
		return this.casCustToolTotal;
	}

	public void setTotalSimMoney(int sim){
		totalSimulationMoney = totalSimulationMoney + sim;
	}

	public int getTotalSimMoney(){
		return this.totalSimulationMoney;
	}

	public void setTotalSimRentals(){
		totalSimRentals = totalSimRentals + 1;
	}

	public int getTotalSimRentals(){
		return this.totalSimRentals;
	}

	public void setUpdateDayCount(){
		updateDayCount++;
	}
	public int getUpdateDayCount(){
		return this.updateDayCount;
	}
	public void newCust(Customer c){
		priceMap.put(c.getName(), 0);
	}

	public void allActiveRentals(){

		Iterator it = hmap.entrySet().iterator();
		System.out.println("Active Rentals are as follows: ");
		while(it.hasNext()){
			Map.Entry elem = (Map.Entry)it.next();

			if(elem.getValue() != null){
				Customer c = (Customer)elem.getValue();
				String cName = c.getName();
				Tools t = (Tools)elem.getKey();
				String tName = t.getName();
				System.out.println(cName + " is currently renting "+ tName);
			}
		}
	}

	public void allToolsLeft(){

		Iterator it = hmap.entrySet().iterator();
		System.out.println("Tools left in the store are as follows: ");
		while(it.hasNext()){
			Map.Entry elem = (Map.Entry)it.next();

			if(elem.getValue() == null){
				Tools t = (Tools)elem.getKey();
				String tName = t.getName();
				System.out.println(tName);
			}
		}
	}


	public int getTotalPrice(){
		return this.TotalPrice;
	}

	public void setTotalPrice(int tp, String s){
		if(s == "end"){
			TotalPrice = 0;
		}
		else{
			TotalPrice = TotalPrice + tp;
		}
	}

	public void printDayEarnings(){
		int p = getTotalPrice();
		System.out.println("The Store made "+ p +" dollars today");
		int count = getUpdateDayCount();
		if(count == 36){
			int total = getTotalSimMoney();
			int transaction = getTotalSimRentals();
			int bus = getBusCustToolTotal();
			int cas = getCasCustToolTotal();
			int reg = getRegCustToolTotal();
			System.out.println("The Store made "+ total +" dollars over the course of 35 days");
			System.out.println("The Store issued "+ transaction +" total rentals over the course of 35 days");
			System.out.println("The Store rented to  "+ bus +" business customers total over the course of 35 days");
			System.out.println("The Store rented to  "+ cas +" casual customers total over the course of 35 days");
			System.out.println("The Store rented to  "+ reg +" regular customers total over the course of 35 days");
		}
	}
	public void calcPrice(Tools t, Customer c){
		int price = priceMap.get(c.getName());
		price += t.getPrice();
		priceMap.put(c.getName(), price);
	}

	public void returnTools(Customer customer, Tools tool){
		if(hmap.get(tool) == customer){
			hmap.remove(tool);
		}
		else{
			System.out.println("No known tool for given customer");
		}
	}

	public void addToolToHashMap(Tools tool){
		hmap.put(tool, null);
	}

	public void addCustomerToHashMap(Customer customer, Tools tool, StringBuilder s){
		if(hmap.get(tool) != null){
			System.out.println("Tool already rented by a customer");
		}
		else{
			hmap.put(tool, customer);
			calcPrice(tool, customer);
			String custName = customer.getName();
			String toolName = tool.getName();
			s.append("Customer "+ custName + " rented the tool "+ toolName);
			//System.out.println("Customer "+ custName + " is adding tool "+ toolName +" to their shopping cart");
		}
	}

	public String chooseOption(){
		double rand;
		rand = (Math.random()*((3 - 1) + 1)) + 1;
		if ((int)rand == 1){
			return "cord";
		}
		else if((int)rand == 2){
			return "kit";
		}
		else{
			return "gear";
		}
	}

	public int additonalOptions(StringBuilder additions){
		int price = 0;
		int num = (int)(Math.random()*((6 - 0) + 1)) + 0;
		if(num == 0){
			//additions.append('\n');
			return 0;
		}
		else{
			while (num != 0){
				String op;
				op = chooseOption();
				if(op == "cord"){
					additions.append(" They added option extension cord\n");
					//System.out.println(" Adding option extension cord to their shopping cart before check out");
					price += extensionCord;
				}
				else if(op == "kit"){
					additions.append(" They added option accessory kit\n");
					//System.out.println(" Adding option accessory kit to their shopping cart before check out");
					price += accessoryKit;
				}
				else{
					additions.append(" They added option protective gear\n");
					//System.out.println(" Adding option protective gear to their shopping cart before check out");
					price += protectiveGear;
				}

				num --;
			}
		}
		return price;
	}

	public void checkAvailable(){
		if(24 - toolsRented < 3){
			allowBusinessCustomer = false;
			businessRentAmt = 0;
			casualRentAmt = 2;
			regularRentAmt = 2;

		}
		else if(24 - toolsRented == 0){
			allowBusinessCustomer = false;
			allowCasualCustomer = false;
			allowRegularCustomer = false;
		}
		else if(24 - toolsRented == 1){
			allowBusinessCustomer = false;
			allowCasualCustomer = true;
			allowRegularCustomer = true;
			businessRentAmt = 0;
			casualRentAmt = 1;
			regularRentAmt = 1;
		}
		else{
			allowBusinessCustomer = true;
			allowCasualCustomer = true;
			allowRegularCustomer = true;
			businessRentAmt = 3;
			casualRentAmt = 2;
			regularRentAmt = 3;
		}
	}

	public void update(){
		record.printRecord(getTotalSimRentals());
		//allActiveRentals();
		//allToolsLeft();
		setTotalPrice(0,"end");
		setUpdateDayCount();
	}

	public void announce(){
		return;
	}

	public HashMap<Tools, Customer> getMap() {
		return hmap;
	}

	public HashMap<String, Integer> getPriceMap() {
		return priceMap; 
	}

	public void setPriceMap(String c, int amt){
		priceMap.put(c, amt);
	}

	public void setHashMap(Tools t, Customer c) {
		hmap.put(t,c);
	}

	public int getToolsRented(){
		return toolsRented;
	}

	public void setToolsRented(int num){
		toolsRented = num;
	}

	public int getBusinessRentAmt(){
		return businessRentAmt;
	}

	public int getCasualRentAmt(){
		return casualRentAmt;
	}

	public int getRegularRentAmt(){
		return regularRentAmt;
	}

	public void addRecord(StringBuilder rec){
		record.addRecord(rec);
	}

}