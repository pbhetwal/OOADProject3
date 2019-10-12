//
//  CasualCustomerBehavior.java
//  OOAD Project 3
//
public class CasualCustomerBehavior implements CustomerBehavior{
	private double randToolNum, randNumDays;

	public CasualCustomerBehavior(){

	}

	public int rentTools() {
		randToolNum = getRand(1,2);
		return randToolNum;
	}

	public int calcDays(){
		randNumDays = getRand(1,2);
		return randNumDays;
	}
}