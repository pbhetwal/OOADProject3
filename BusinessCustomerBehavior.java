//
//  BusinessCustomerBehavior.java
//  OOAD Project 3
//
public class BusinessCustomerBehavior implements CustomerBehavior{
	/*
	:Description:	Strategy pattern used here - implement specific behavior for
					business customer
	*/
	private int maxAmt;
	private int randToolNum, randNumDays;

	public BusinessCustomerBehavior(){

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
		randToolNum = maxAmt;
		return randToolNum;
	}

	public int calcDays(){
		randNumDays = 7;
		return randNumDays;
	}
}