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






import java.util.ArrayList;
import java.util.Random;



public class Order implements OrderInterface{
	
	private int orderNo, orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> bevList = new ArrayList<Beverage>();
	
	public int randomNo() {
		Random random = new Random();
		return random.nextInt(90000 - 10000) + 10000;
	}
	
	
	
	
	
	public Order(int orderTime, DAY orderDay, Customer custmr) {
		
		orderNo = randomNo();
		
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		customer = new Customer(custmr);
	}
	
	
	public boolean isWeekend() {
		if(orderDay==DAY.SATURDAY || orderDay==DAY.SUNDAY)
			return true;
		else
			return false;
	}
	
	
	public void addNewBeverage(String bevName, SIZE size,
								boolean extraShot, boolean extraSyrup) {
		bevList.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	
	public void addNewBeverage(String bevName, SIZE size) {
		bevList.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	
	public void addNewBeverage(String bevName, SIZE size,
								int numOfFruits, boolean addProtein) {
		bevList.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	
	public Beverage getBeverage(int itemNumber) {
		if(bevList.get(itemNumber).getType()==TYPE.COFFEE) {
			Beverage cf = new Coffee(bevList.get(itemNumber).getBevName(),
					bevList.get(itemNumber).getSize(), bevList.get(itemNumber).hasXShot(),
					bevList.get(itemNumber).hasXSyrup());
			return cf;
		}
		else if(bevList.get(itemNumber).getType()==TYPE.SMOOTHIE) {
			Beverage sm = new Smoothie(bevList.get(itemNumber).getBevName(),
					bevList.get(itemNumber).getSize(), bevList.get(itemNumber).getNumOfFruits(),
					bevList.get(itemNumber).hasProtein());
			return sm;
		}
		else {
			Beverage al = new Alcohol(bevList.get(itemNumber).getBevName(),
					bevList.get(itemNumber).getSize(), bevList.get(itemNumber).isWeekend());
			return al;
		}
	}
	
	
	public double calcOrderTotal() {
		double total = 0.0;
		
		for(int i=0; i<bevList.size(); i++) {
			total += bevList.get(i).calcPrice();
		}
		
		return total;
	}
	
	
	
	public int findNumOfBeveType(TYPE type) {
		int counter = 0;
		
		for(int i=0; i<bevList.size(); i++) {
			if(type == bevList.get(i).getType())
				counter += 1;
		}
		
		return counter;
	}
	
	
	
	
	
	public void setOrderTime(int time) {
		orderTime = time;
	}
	
	public void setOrderDay(DAY day) {
		orderDay = day;
	}
	
	
	
	
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public DAY getOrderDay() {
		return orderDay;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	

	public int compareTo(Order order) {
		
		if(orderNo == order.getOrderNo())
			return 0;
		else if(orderNo > order.getOrderNo())
			return 1;
		else
			return -1;
	}
	
	
	
	public int getTotalItems() {
		return bevList.size();
	}
	
	
	@Override
	public String toString() {
		
		String bevInfo = "";
		
		for(int i=0; i<bevList.size(); i++) {
			bevInfo += bevList.get(i).toString();
		}
		return String.valueOf(getOrderNo()) + String.valueOf(getOrderTime())
		+ orderDay + customer.getName() + String.valueOf(customer.getAge())
		+ String.valueOf(calcOrderTotal())+ bevInfo;
	}
	
	
	

}
