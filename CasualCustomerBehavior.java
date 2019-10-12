//
//  CasualCustomerBehavior.java
//  OOAD Project 3
//
public class CasualCustomerBehavior implements CustomerBehavior{
	private int randToolNum, randNumDays;

	public CasualCustomerBehavior(){

	}
	
	public int getRand(int min, int max){
		int num = (int)((Math.random()*((max - min) + 1)) + min);
		return num;
	}

	public int rentTools() {
		randToolNum = (int)getRand(1,2);
		return randToolNum;
	}

	public int calcDays(){
		randNumDays = getRand(1,2);
		return randNumDays;
	}
}