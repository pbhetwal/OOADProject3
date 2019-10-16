//
//  RegularCustomerBehavior.java
//  OOAD Project 3
//
public class RegularCustomerBehavior implements CustomerBehavior{
	/*
	:Description:	Strategy pattern used here - implement specific behavior for
					regular customer
	*/
	private int randToolNum, randNumDays;
	private int maxAmt;

	public RegularCustomerBehavior(){

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
		randToolNum = getRand(1,maxAmt);
		return randToolNum;
	}

	public int calcDays(){
		randNumDays = getRand(3,5);
		return randNumDays;
	}
}