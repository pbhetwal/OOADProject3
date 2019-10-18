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
	private int maxToolAmount = 3;

	public RegularCustomerBehavior(){

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

	//regular customer will rent 3, 2, 1 or 0 tools
	public int rentTools() {
		randToolNum = getRand(1,maxAmt);
		return randToolNum;
	}

	//regular customer can rent for 3 to 5 days
	public int calcDays(){
		randNumDays = getRand(3,5);
		return randNumDays;
	}
}