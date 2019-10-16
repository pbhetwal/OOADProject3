public class CasualCustomer extends Customer{
	public CasualCustomer(){

	}

	public CasualCustomer(String name){
		super(name);
		setCustomerBehavior(new CasualCustomerBehavior());
	}

	public CasualCustomer(String name_, HardwareStore s){
		setName(name_);
		store = s;
		setCustomerBehavior(new CasualCustomerBehavior());
	}


	public int rentTools() {
		return 0;
	}

	public int calcDays(){
		return 0;
	}

	@Override
	public String getCustClass(){
		return "CasualCustomer";
	}

	@Override
	public void changeAmount(){
		int num = store.getCasualRentAmt();
		cb.setMaxAmt(num);
	}

}