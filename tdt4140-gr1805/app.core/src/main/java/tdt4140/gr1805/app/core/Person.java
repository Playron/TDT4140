package tdt4140.gr1805.app.core;

public class Person {
	
	private int ID;
	private String name;
	private int age;
	
	
	
	public Person (int ID, String name, int age ) {
		this.ID = ID;
		this.name = name;
		this.age = age;
	}


	public int getID() {
		return ID;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}	

}
