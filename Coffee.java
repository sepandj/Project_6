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





public class Coffee extends Beverage {

	private boolean xShot, xSyrup;
	private final double xAdd = 0.50;
	
	public Coffee(String Name, SIZE Size, boolean xShot, boolean xSyrup) {
		super(Name, TYPE.COFFEE, Size);
		this.xShot = xShot;
		this.xSyrup = xSyrup;
	}
	
	public double getBasePrice() {
		return super.getBPrice();
	}
	
	
	
	public boolean equals(Coffee coffee) {
		if(super.equals(coffee) &&
				coffee.hasXShot()==xShot &&
				coffee.hasXSyrup()==xSyrup)
				return true;
		else
			return false;
	}
	
	@Override
	public boolean hasXShot() {
		return xShot;
	}
	
	@Override
	public boolean hasXSyrup() {
		return xSyrup;
	}

	@Override
	public double calcPrice() {
		
		double price = super.getBPrice();
		
		if(super.getSize()==SIZE.MEDIUM)
			price += super.getXPrice();
		
		else if(super.getSize()==SIZE.LARGE)
			price += (2 * super.getXPrice());
		
		if(xShot)
			price += xAdd;
		
		if(xSyrup)
			price += xAdd;
		
		return price;
	}
	
	public String getBevName() {
		return super.getBevName();
	}

	
	@Override
	public String toString() {
		
		return getBevName() + super.getSize().toString() + xShot + xSyrup + calcPrice();
	}

	public boolean getExtraShot() {
		return xShot;
	}
	public boolean getExtraSyrup() {
		return xSyrup;
	}
}
