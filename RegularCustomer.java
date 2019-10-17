public class RegularCustomer extends Customer{
	/*
    :Description:	Strategy pattern used here. Subclass of customer with
     				regular customer behavior.
    */
	public RegularCustomer(){

	}

	public RegularCustomer(String name){
		super(name);
		setCustomerBehavior(new RegularCustomerBehavior());
	}

	//sets the customer behavior and sets the hardware store
	public RegularCustomer(String name, HardwareStore s){
		setName(name);
		store = s;
		setCustomerBehavior(new RegularCustomerBehavior());
	}

	//overrides the class name getter of customer
	@Override
	public String getCustClass(){
		return "RegularCustomer";
	}

	//changes the maximum amount a regular customer can rent if there are less
	//than three tools
	@Override
	public void changeAmount(){
		int num = store.getRegularRentAmt();
		cb.setMaxAmt(num);
	}

}