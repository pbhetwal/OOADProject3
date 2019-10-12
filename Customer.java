//
//  Customer.java
//  OOAD Project 3
//
public class Customer implements Observer, DisplayElement{
	private String name, className;
	private int daysLeft;
	private CustomerBehavior cb;

	public Customer(){

    }

	public void setCustomerBehavior( CustomerBehavior cb){
		this.cb = cb;
	}

	//to be overridden
	public int rentTools() {
		return 0;
	}
	//to be overridden
	public int calcDays(){
		return 0;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setClassName(String className){
		this.className = className;
	}

	public String getClassName(){
		return this.className;
	}

	public void setDaysLeft(int daysLeft){
		this.daysLeft = daysLeft;
	}

	public int getDaysLeft(){
		return this.daysLeft;
	}


	public static int getRand(int min, int max){
		int num = (Math.random()*((max - min) + 1)) + min;
		return num;
	}


	public void update(){
		daysLeft--;
		if(daysLeft == 0){
			//returnTools();
			return;
		}
	}

	public void announce(){
		return;
	}

}