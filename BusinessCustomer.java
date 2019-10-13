public class BusinessCustomer extends Customer{
	public BusinessCustomer(){

	}

	public BusinessCustomer(String name){
		super(name);
		setCustomerBehavior(new BusinessCustomerBehavior());
	}

	public BusinessCustomer(String name, HardwareStore s){
		super(name, s);
		setCustomerBehavior(new BusinessCustomerBehavior());
	}


	public int rentTools() {
		return 0;
	}

	public int calcDays(){
		return 0;
	}

	@Override
	public void changeAmount(){
		int num = store.getBusinessRentAmt();
		cb.setMaxAmt(num);
	}
}