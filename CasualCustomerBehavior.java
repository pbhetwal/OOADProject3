//
//  CasualCustomerBehavior.java
//  OOAD Project 3
//
public class CasualCustomerBehavior implements CustomerBehavior{
	private double randToolNum, randNumDays;

	public static rentTools() {
		randToolNum = getRand(1,2);
		return randToolNum;
	}

	public static calcDays(){
		randNumDays = getRand(1,2);
		return randNumDays;
	}
}