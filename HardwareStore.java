// Singleton pattern used here 

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

class HardwareStore implements Observer, DisplayElement{
	private static HardwareStore ins = new HardwareStore();
	private int TotalPrice;
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

	private HardwareStore() {
		System.out.println("Our hardware rental store is now open!");

	}

	public static HardwareStore getInstance(){
		return ins; 
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

	public void setTotalPrice(int tp){
		TotalPrice = TotalPrice + tp;
	}

	public void printDayEarnings(){
		int p = getTotalPrice();
		System.out.println("The Store made "+ p +" dollars today");
	}
	public void calcPrice(Tools t, Customer c){
		int price = priceMap.get(c.getName());
		price += t.getPrice();
		priceMap.put(c.getName(), price);
		setTotalPrice(price);
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

	public void addCustomerToHashMap(Customer customer, Tools tool){
		if(hmap.get(tool) != null){
			System.out.println("Tool already rented by a customer");
		}
		else{
			hmap.put(tool, customer);
			calcPrice(tool, customer);
			String custName = customer.getName();
			String toolName = tool.getName();
			System.out.println("Customer "+ custName + " is adding tool "+ toolName +" to their shopping cart");
		}
	}

	public String chooseOption(){
		double rand;
		rand = (Math.random()*((3 - 1) + 1)) + 1;
		if (rand == 1){
			return "cord";
		}
		else if(rand == 2){
			return "kit";
		}
		else{
			return "gear";
		}
	}

	public int additonalOptions(){
		int price = 0;
		double num = (Math.random()*((6 - 0) + 1)) + 0;
		if(num == 0){
			return 0;
		}
		else{
			while (num != 0){
				String op;
				op = chooseOption();
				if(op == "cord"){
					System.out.printf(" and they are adding option extension cord to their shopping cart");
					price += extensionCord;
				}
				else if(op == "kit"){
					System.out.printf(" and they are adding option accessory kit to their shopping cart");
					price += accessoryKit;
				}
				else{
					System.out.printf(" and they are adding option protective gear to their shopping cart");
					price += protectiveGear;
				}
				num -= 1;
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

		allActiveRentals();
		allToolsLeft();

	}

	public void announce(){
		return;
	}

	public HashMap<Tools, Customer> getMap() {
		return hmap;
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

}