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

public class BevShop implements BevShopInterfce {
	
	private final int MIN_AGE_FOR_ALCOHOL = 21;
	private final int MAX_ORDER_FOR_ALCOHOL= 3;
	private final int MIN_TIME= 8;
	private final int MAX_TIME= 23;
	private final int MAX_FRUIT = 5;
	
	private int ALCOHOL_ORDERS = 0;
	private ArrayList<Order> orderList = new ArrayList<Order>();
	private Order currentOrder;
	
	
	public boolean validTime(int time) {
		if(time>=MIN_TIME && time<=MAX_TIME)
			return true;
		else
			return false;
	}
	
	
	public boolean eligibleForMore() {
		if(ALCOHOL_ORDERS<=MAX_ORDER_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	
	
	public  boolean validAge(int age) {
		if(age>MIN_AGE_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	
	
	public void startNewOrder(int time, DAY day,
		 	String customerName, int customerAge) {
		
		currentOrder = new Order(time, day,
				new Customer(customerName, customerAge));
		
		orderList.add(currentOrder);
	}
	
	
	public void processCoffeeOrder( String bevName, SIZE size,
			boolean extraShot, boolean extraSyrup ) {
		
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	
	
	
	public void addAlcoholOrder() {
		ALCOHOL_ORDERS++;
	}
	
	
	
	public void  processAlcoholOrder( String bevName, SIZE size ) {
		
		currentOrder.addNewBeverage(bevName, size);
		addAlcoholOrder();
	}
	
	
	public void processSmoothieOrder( String bevName, SIZE size,
			int numOfFruits, boolean addProtien) {
		
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	
	
	public int findOrder(int orderNo) {
		int orderIndex = 0;
		for(int i=0; i<orderList.size(); i++) {
			if(orderNo==orderList.get(i).getOrderNo())
				orderIndex = i;
		}
		return orderIndex;
	}
	
	
	public double totalOrderPrice(int orderNo) {
		double total=0;
		for(int i=0; i<orderList.size(); i++) {
			if(orderNo==orderList.get(i).getOrderNo())
				total = orderList.get(i).calcOrderTotal();
		}
		return total;
	}
	
	
	public double totalMonthlySale() {
		double total=0;
		for(int i=0; i<orderList.size(); i++) {
			total += orderList.get(i).calcOrderTotal();
		}
		return total;
	}
	
	
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	
	public int getNumOfAlcoholDrink() {
		return ALCOHOL_ORDERS;
	}
	
	
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
	}
	
	
	public boolean isMaxFruit(int fruit) {
		if(fruit>MAX_FRUIT)
			return true;
		else
			return false;
	}
	
	
	public Order getOrderAtIndex(int index) {
		return orderList.get(index);
	}
	
	
	public  void sortOrders() {
		int minOrderNo = orderList.get(0).getOrderNo();
		
		for(int i=0; i<orderList.size(); i++) {
			if(orderList.get(i).getOrderNo()<minOrderNo) {
				minOrderNo = orderList.get(i).getOrderNo();
				Order firstOrder = orderList.get(i);
				orderList.remove(i);
				orderList.add(0, firstOrder);
			}
		}
			
	}
	

	
	@Override
	public String toString() {
		
		String orderInfo = "";
		for(int i=0; i<orderList.size(); i++) {
			orderInfo += orderList.get(i).toString();
		}
		
		return orderInfo + totalMonthlySale();
	}

	
	
	
	

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}


	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
}
