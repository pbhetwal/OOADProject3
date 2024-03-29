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
	private int maxToolAmount = 3;

	public CasualCustomerBehavior(){

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

	//casual customer will rent 2, 1 tools
	public int rentTools() {
		randToolNum = (int)getRand(1,maxAmt);
		return randToolNum;
	}

	//casual customer can rent for 1 or 2 days
	public int calcDays(){
		randNumDays = getRand(1,2);
		return randNumDays;
	}
}