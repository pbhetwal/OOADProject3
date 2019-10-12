public class RegularCustomer extends Customer{
	public RegularCustomer(){

	}

	public RegularCustomer(String name){
		super(name);
		setCustomerBehavior(new RegularCustomerBehavior());
	}

	public RegularCustomer(String name, HardwareStore s){
		super(name, s);
		setCustomerBehavior(new RegularCustomerBehavior());
	}

	public int rentTools() {
		return 0;
	}

	public int calcDays(){
		return 0;
	}




}