//
//  CustomerBehavior.java
//  OOAD Project 3
//

public interface CustomerBehavior{
	/*
	:Description:	Strategy pattern used here - this is the interface
					for customer behaviors.
	*/
	public void setMaxAmt(int num);
	public int getMaxAmt();
	public int getRand(int min, int max);
	public int getMaxToolAmount();

	public int rentTools();

    public int calcDays();
	
}

