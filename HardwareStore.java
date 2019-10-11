// Singleton pattern used here 
class HardwareStore implements Observer, DisplayElement{
	private static HardwareStore ins = new HardwareStore();
	private Tools tools;
	private Customer customers;
	private Subject Calender;
	private HashMap<Tools, Customer> hmap = new HashMap<Tools, Customer>();

	private HardwareStore(){
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
		hmap.put(tool, NULL);
	}
	
	public void addCustomerToHashMap(Customer customer, Tools tool){
		if(hmap.get(tool) != NULL){
			System.out.println("Tool already rented by a customer");
		}
		else{
			hmap.put(tool, customer);
		}
	}

	public void update(){
		return;
	}

	public void announce(){
		return;
	}


}