//
//  BusinessCustomerBehavior.java
//  OOAD Project 3
//
public class BusinessCustomerBehavior implements CustomerBehavior{
	private double randToolNum, randNumDays;

	public BusinessCustomerBehavior(){

	}


	public int rentTools() {
		randToolNum = 3;
		return randToolNum;
	}

	public int calcDays(){
		randNumDays = 7;
		return randNumDays;
	}
}