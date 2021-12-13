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





public abstract class Beverage {

	private String bevName;
	private TYPE bevType;
	private SIZE bevSize;
	
	private final double bPrice = 2.0;
	private final double xPrice = 1.0;
	
	public Beverage (String Name, TYPE Type, SIZE Size) {
		
		bevName = Name;
		bevType = Type;
		bevSize = Size;
	}
	
	
	public abstract double calcPrice();
	
	public boolean hasXShot() {
		return false;
	}
	public boolean hasXSyrup() {
		return false;
	}
	
	
	
	
	public int getNumOfFruits() {
		return 0;
	}
	public boolean hasProtein() {
		return false;
	}
	
	
	
	public boolean isWeekend() {
		return false;
	}
	public boolean equals(Beverage beverage) {
		if(beverage.getBevName().equals(bevName) &&
				beverage.getSize()==bevSize &&
				beverage.getType()==bevType)
			return true;
		else
			return false;
			
	}
	
	
	@Override
	public String toString() {
		return "Beverage Name: " + bevName +
				"\nBeverage Size: " + bevSize;
	}
	
	
	
	public void setBevName(String Name) {
		bevName = Name;
	}
	
	public void setBevSize(SIZE Size) {
		bevSize=Size;
	}
	
	public void setBevType(TYPE Type) {
		bevType=Type;
	}
	
	public String getBevName() {
		return bevName;
	}
	
	public SIZE getSize() {
		return bevSize;
	}
	
	public TYPE getType() {
		return bevType;
	}
	
	
	
	
	public double getBPrice() {
		return bPrice;
	}
	
	public double getXPrice() {
		return xPrice;
	}
}
