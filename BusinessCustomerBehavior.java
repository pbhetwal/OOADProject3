//
//  BusinessCustomerBehavior.java
//  OOAD Project 3
//
public class BusinessCustomerBehavior implements CustomerBehavior{
	private double randToolNum, randNumDays;

	public BusinessCustomerBehavior(){

	}

	public static int rentTools() {
		randToolNum = 3;
		return randToolNum;
	}

	public static int calcDays(){
		randNumDays = 7;
		return randNumDays;
	}
}