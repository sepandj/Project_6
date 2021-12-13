/*
 * Class: CMSC203 
 * Instructor: Prf. Gary Thai
 * Project 6
 * Description: The Beverage Shop
 * Due: 12/12/21 @11:59PM
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Sepand Jahrominejad
*/





public class Alcohol extends Beverage {

	private boolean onWeekend;
	private final double xWeekendPrice = 0.60;
	
	public Alcohol(String Name, SIZE Size, boolean onWeekend) {
		super(Name, TYPE.ALCOHOL, Size);
		this.onWeekend = onWeekend;
	}
	
	
	public boolean equals(Alcohol alcohol) {
		if(super.equals(alcohol) &&
				alcohol.isWeekend()==onWeekend)
			return true;
		else
			return false;
	}
	
	@Override
	public double calcPrice() {
		double price = super.getBPrice();
		
		if(super.getSize()==SIZE.MEDIUM)
			price += super.getXPrice();
		
		else if(super.getSize() == SIZE.LARGE)
			price += (2 * super.getXPrice());
		
		if(onWeekend)
			price += xWeekendPrice;
		
		return price;
	}
	
	@Override
	public boolean isWeekend() {
		return onWeekend;
	}
	public double getBasePrice() {
		return super.getBPrice();
	}
	
	public String getBevName() {
		return super.getBevName();
	}
	
	@Override
	public String toString() {
		return getBevName() + super.getSize() + onWeekend + calcPrice();
	}
}
