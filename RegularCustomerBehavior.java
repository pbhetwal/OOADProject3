//
//  RegularCustomerBehavior.java
//  OOAD Project 3
//
public class RegularCustomerBehavior implements CustomerBehavior{
	private double randToolNum, randNumDays;

	public static rentTools() {
		randToolNum = getRand(1,3);
		return randToolNum;
	}

	public static calcDays(){
		randNumDays = getRand(3,5);
		return randNumDays;
	}
}