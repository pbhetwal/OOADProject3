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
	private int maxToolAmount = 3;

	public BusinessCustomerBehavior(){

	}

	public int getMaxToolAmount(){
		return maxToolAmount;
	}

	//setter for max amount to rent
	public void setMaxAmt(int num){
		maxAmt = num;
	}

	public int getMaxAmt(){
		return maxAmt;
	}

	//gets random number
	public int getRand(int min, int max){
		int num = (int)((Math.random()*((max - min) + 1)) + min);
		return num;
	}

	//business customer will rent 3 or 0 tools
	public int rentTools() {
		randToolNum = maxAmt;
		return randToolNum;
	}

	//business customer will rent for 3 days
	public int calcDays(){
		randNumDays = 7;
		return randNumDays;
	}
}