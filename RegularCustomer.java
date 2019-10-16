public class RegularCustomer extends Customer{
	public RegularCustomer(){

	}

	public RegularCustomer(String name){
		super(name);
		setCustomerBehavior(new RegularCustomerBehavior());
	}

	public RegularCustomer(String name, HardwareStore s){
		setName(name);
		store = s;
		setCustomerBehavior(new RegularCustomerBehavior());
	}

	public int rentTools() {
		return 0;
	}

	public int calcDays(){
		return 0;
	}

	@Override
	public String getCustClass(){
		return "RegularCustomer";
	}

	@Override
	public void changeAmount(){
		int num = store.getRegularRentAmt();
		cb.setMaxAmt(num);
	}

}