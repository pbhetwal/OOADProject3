public class CasualCustomer extends Customer{
	/*
    :Description:	Strategy pattern used here. Subclass of customer with
     				casual customer behavior.
    */
	public CasualCustomer(){

	}

	public CasualCustomer(String name){
		super(name);
		setCustomerBehavior(new CasualCustomerBehavior());
	}

	//sets the customer behavior and sets the hardware store
	public CasualCustomer(String name_, HardwareStore s){
		setName(name_);
		store = s;
		setCustomerBehavior(new CasualCustomerBehavior());
	}

	//overrides the class name getter of customer
	@Override
	public String getCustClass(){
		return "CasualCustomer";
	}

	//changes the maximum amount a casual customer can rent if there are less
	//than two tools
	@Override
	public void changeAmount(){
		int num = store.getCasualRentAmt();
		cb.setMaxAmt(num);
	}

}