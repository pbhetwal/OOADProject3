//
//  BusinessCustomerBehavior.java
//  OOAD Project 3
//
public class BusinessCustomerBehavior implements CustomerBehavior{
	private double randToolNum, randNumDays;

	public static rentTools() {
		randToolNum = 3;
		return randToolNum;
	}

	public static calcDays(){
		randNumDays = 7;
		return randNumDays;
	}
}