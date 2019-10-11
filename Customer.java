//
//  Customer.java
//  OOAD Project 3
//
public class Customer implements Observer, DisplayElement{
	private String name, className;
	private Int daysLeft;
	private CustomerBehavior cb;

	public Customer(){

    }

	public void setCustomerBehavior( CustomerBehavior cb){
		customerBehavior = cb;
	}

	//to be overridden
	public static rentTools() {
		return 0;
	}
	//to be overridden
	public static calcDays(){
		return 0;
	}

	public void setName(String name){
		this.name = name;
	}

	public static getName(){
		return this.name;
	}

	public void setClassName(String className){
		this.className = className;
	}

	public static getClassName(){
		return this.className;
	}

	public void setDaysLeft(Int daysLeft){
		this.daysLeft = daysLeft;
	}

	public static getDaysLeft(){
		return this.daysLeft;
	}

	public static getRand(double min, double max){
		double num = (Math.random()*((max - min) + 1)) + min;
		return num;
	}


	public void update(){
		daysLeft--;
		if(daysLeft == 0){
			returnTools();
		}
	}

	public void announce(){
		return;
	}

}