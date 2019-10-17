public class BusinessCustomer extends Customer{
	/*
    :Description:	Strategy pattern used here. Subclass of customer with
     				business customer behavior.
    */
	public BusinessCustomer(){

	}

	public BusinessCustomer(String name){
		super(name);
		setCustomerBehavior(new BusinessCustomerBehavior());
	}

	//sets the customer behavior and sets the hardware store
	public BusinessCustomer(String name, HardwareStore s){
		setName(name);
		store = s;
		setCustomerBehavior(new BusinessCustomerBehavior());
	}

	//overrides the class name getter of customer
	@Override
	public String getCustClass(){
		return "BusinessCustomer";
	}

	//changes the maximum amount a busness customer can rent if there are less
	//than three tools
	@Override
	public void changeAmount(){
		int num = store.getBusinessRentAmt();
		cb.setMaxAmt(num);
	}
	

}