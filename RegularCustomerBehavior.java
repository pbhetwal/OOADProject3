//
//  RegularCustomerBehavior.java
//  OOAD Project 3
//
public class RegularCustomerBehavior implements CustomerBehavior{
	private double randToolNum, randNumDays;

	public RegularCustomerBehavior(){

	}
	public int getRand(int min, int max){
		int num = (int)((Math.random()*((max - min) + 1)) + min);
		return num;
	}

	public int rentTools() {
		randToolNum = getRand(1,3);
		return randToolNum;
	}

	public int calcDays(){
		randNumDays = getRand(3,5);
		return randNumDays;
	}
}