public class BusinessCustomer extends Customer{
	public BusinessCustomer(){

	}

	public BusinessCustomer(String name){
		super(name);
		setCustomerBehavior(new BusinessCustomerBehavior());
	}


	public int rentTools() {
		return 0;
	}

	public int calcDays(){
		return 0;
	}




}