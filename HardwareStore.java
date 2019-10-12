// Singleton pattern used here 

import java.util.HashMap;
import java.util.Map;

class HardwareStore implements Observer, DisplayElement{
	private static HardwareStore ins = new HardwareStore();
	private Tools tools;
	private Customer customers;
	private Subject Calender;
	private HashMap<Tools, Customer> hmap = new HashMap<Tools, Customer>();
	private int extensionCord = 5;
	private int accessoryKit = 25;
	private int protectiveGear = 30;

	private HardwareStore() {
		System.out.println("Our hardware rental store is now open!");

	}

	public static HardwareStore getInstance(){
		return ins; 
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
		}
	}

public String chooseOption(){

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
		double rand;
		
		double num = (Math.random()*((6 - 0) + 1)) + 0;
		if(num == 0){
			return 0;
		}
		else{
			while (num != 0){
				String op;
				op = chooseOption();
				if(op == "cord"){
					price += extensionCord;
				}
				else if(op == "kit"){
					price += accessoryKit;
				}
				else{
					price += protectiveGear;
				}
				num -= 1;
			}
		}
		return price;
	}

	public void update(){
		return;
	}

	public void announce(){
		return;
	}


}