//
//  CasualCustomerBehavior.java
//  OOAD Project 3
//
public class CasualCustomerBehavior implements CustomerBehavior{
	/*
	:Description:	Strategy pattern used here - implement specific behavior for
					casual customer
	*/
	private int randToolNum, randNumDays;
	private int maxAmt;

	public CasualCustomerBehavior(){

	}
	public void setMaxAmt(int num){
		maxAmt = num;
	}

	public int getMaxAmt(){
		return maxAmt;
	}

	public int getRand(int min, int max){
		int num = (int)((Math.random()*((max - min) + 1)) + min);
		return num;
	}

	public int rentTools() {
		randToolNum = (int)getRand(1,maxAmt);
		return randToolNum;
	}

	public int calcDays(){
		randNumDays = getRand(1,2);
		return randNumDays;
	}
}