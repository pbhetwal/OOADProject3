public class CasualCustomer extends Customer{
	public CasualCustomer(){

	}

	public CasualCustomer(String name){
		super(name);
		setCustomerBehavior(new CasualCustomerBehavior());
	}


	public int rentTools() {
		return 0;
	}

	public int calcDays(){
		return 0;
	}

}