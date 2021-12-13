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






public class Smoothie extends Beverage {

	
	private int fruitNum;
	private boolean addProtein;
	private final double xProtein = 1.50;
	private final double xFruit = 0.50;
	
	public Smoothie(String Name, SIZE Size, int fruitNum,
			boolean addProtein) {
		
		super(Name, TYPE.SMOOTHIE, Size);
		this.fruitNum = fruitNum;
		this.addProtein = addProtein;
	}
	
	
	public boolean equals(Smoothie smoothie) {
		if(super.equals(smoothie) &&
				smoothie.getNumOfFruits()==fruitNum &&
				smoothie.hasProtein()==addProtein)
			return true;
		else
			return false;
	}
	
	@Override
	public double calcPrice() {
		double price = super.getBPrice();
		
		if(super.getSize() == SIZE.MEDIUM)
			price += super.getXPrice();
		else if(super.getSize() == SIZE.LARGE)
			price += (2 * super.getXPrice());
		
		if(fruitNum >= 1)
			price += (fruitNum * xFruit);
		
		if(addProtein)
			price += xProtein;
		
		return price;
	}
	
	@Override
	public boolean hasProtein() {
		return addProtein;
	}
	public boolean getAddProtien() {
		return addProtein;
	}
	
	public double getBasePrice() {
		return super.getBPrice();
		}
	
	public String getBevName() {
		return super.getBevName();
	}
	
	@Override
	public int getNumOfFruits() {
		return fruitNum;
	}
	
	@Override
	public String toString() {
		return super.getBevName() + super.getSize() + 
				addProtein + fruitNum + calcPrice();
	}
	
}
