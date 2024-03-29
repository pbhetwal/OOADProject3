import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.lang.StringBuilder;

class HardwareStore implements Observer{
	/*
    :Description:   Class for the Hardware store - singleton pattern 
    				used here. 
    */
	private static HardwareStore ins = new HardwareStore();
	private int TotalPrice = 0;
	private HashMap<Tools, Customer> hmap = new HashMap<Tools, Customer>();
	private HashMap<String, Integer> priceMap = new HashMap<String, Integer>();
	private int extensionCord = 5;
	private int accessoryKit = 25;
	private int protectiveGear = 30;
	private int toolsRented = 0;
	private int businessRentAmt = 3;
	private int casualRentAmt = 2;
	private int regularRentAmt = 3;
	private int totalSimulationMoney = 0;
	private int updateDayCount = 1;
	private int totalSimRentals = 0;
	private int busCustToolTotal = 0;
	private int regCustToolTotal = 0;
	private int casCustToolTotal = 0;
	private StoreRecord record;
	private int custRentDays;
	private int totalComplete = 0;

	private HardwareStore() {
		System.out.println("Our hardware rental store is now open!");
		record = new StoreRecord();
	}

	public static HardwareStore getInstance(){
		return ins; 
	}

	public void incrementTotalComplete(){
		totalComplete++;
	}

	public void completeRental(){
		record.printRecord(totalComplete);
	}

	public void setCustRentDays(int days){
		custRentDays = days;
	}

	public int getCustRentDays(){
		return this.custRentDays;
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

	// Prints the number of active rentals and the actual rentals 
	public void allActiveRentals(){

		Iterator it = hmap.entrySet().iterator();
		System.out.println("\nNumber of Active Rentals: " + (toolsRented));
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

	//print the tools left in the store
	public void allToolsLeft(){

		Iterator it = hmap.entrySet().iterator();
		System.out.println("\nNumber of Tools left in the store: " + (24-toolsRented));
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

	//sets total price to 0 if day ends, otherwise increment by amount
	public void setTotalPrice(int tp, String s){
		if(s == "end"){
			TotalPrice = 0;
		}
		else{
			TotalPrice = TotalPrice + tp;
		}
	}

	//print sthe totals at the end of the simulation
	public void printDayEarnings(){
		int p = getTotalPrice();
		System.out.println("\nThe Store made "+ p +" dollars today");
		int count = getUpdateDayCount();
		if(count == 36){
			int total = getTotalSimMoney();
			int transaction = getTotalSimRentals();
			int bus = getBusCustToolTotal();
			int cas = getCasCustToolTotal();
			int reg = getRegCustToolTotal();
			System.out.println("\nThe Store made "+ total +" dollars over the course of 35 days");
			System.out.println("The Store issued "+ transaction +" total rentals over the course of 35 days");
			System.out.println("The Store rented "+ bus +" tools  total to business customers over the course of 35 days");
			System.out.println("The Store rented "+ cas +" tools total to casual customers over the course of 35 days");
			System.out.println("The Store rented "+ reg +" tools total to regular customers over the course of 35 days");
		}
	}
	public void calcPrice(Tools t, Customer c){
		int price = priceMap.get(c.getName());
		price += (t.getPrice() * getCustRentDays());
		priceMap.put(c.getName(), price);
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
			System.out.println("\nCustomer "+ custName + " is adding tool "+ toolName +" to their shopping cart");
			String custClassName = customer.getCustClass();
			
			if(custClassName == "BusinessCustomer"){
						setBusCustToolTotal();
					}
					else if(custClassName == "CasualCustomer"){
						setCasCustToolTotal();
					}
					else{
						setRegCustToolTotal();
					}
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
					System.out.println(" Adding option extension cord to their shopping cart before check out");
					price += extensionCord;
				}
				else if(op == "kit"){
					additions.append(" They added option accessory kit\n");
					System.out.println(" Adding option accessory kit to their shopping cart before check out");
					price += accessoryKit;
				}
				else{
					additions.append(" They added option protective gear\n");
					System.out.println(" Adding option protective gear to their shopping cart before check out");
					price += protectiveGear;
				}

				num --;
			}
		}
		return price;
	}

	// Updates amounts each customer type can rent depending on how many tools are left
	public void checkAvailable(){
		if(24 - toolsRented < 3){
			businessRentAmt = 0;
			casualRentAmt = 2;
			regularRentAmt = 2;

		}
		else if(24 - toolsRented == 0){
			businessRentAmt = 0;
			casualRentAmt = 0;
			regularRentAmt = 0;
		}
		else if(24 - toolsRented == 1){
			businessRentAmt = 0;
			casualRentAmt = 1;
			regularRentAmt = 1;
		}
		else{
			businessRentAmt = 3;
			casualRentAmt = 2;
			regularRentAmt = 3;
		}
	}

	public void update(){
		allActiveRentals();
		allToolsLeft();
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