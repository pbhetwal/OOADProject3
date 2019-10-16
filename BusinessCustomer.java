public class BusinessCustomer extends Customer{
	public BusinessCustomer(){

	}

	public BusinessCustomer(String name){
		super(name);
		setCustomerBehavior(new BusinessCustomerBehavior());
	}

	public BusinessCustomer(String name, HardwareStore s){
		setName(name);
		store = s;
		setCustomerBehavior(new BusinessCustomerBehavior());
	}

	@Override
	public String getCustClass(){
		return "BusinessCustomer";
	}

	@Override
	public void changeAmount(){
		int num = store.getBusinessRentAmt();
		cb.setMaxAmt(num);
	}
	

}