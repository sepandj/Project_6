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





public class Customer {
	
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer customer) {
		this.name = customer.name;
		this.age = customer.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	
	@Override
	public String toString() {
		return name + String.valueOf(age);
	}

}
