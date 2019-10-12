//
//  BusinessCustomerBehavior.java
//  OOAD Project 3
//
public class BusinessCustomerBehavior implements CustomerBehavior{
	private int randToolNum, randNumDays;

	public BusinessCustomerBehavior(){

	}


	public int getRand(int min, int max){
		int num = (int)((Math.random()*((max - min) + 1)) + min);
		return num;
	}

	public int rentTools() {
		randToolNum = 3;
		return randToolNum;
	}

	public int calcDays(){
		randNumDays = 7;
		return randNumDays;
	}
}