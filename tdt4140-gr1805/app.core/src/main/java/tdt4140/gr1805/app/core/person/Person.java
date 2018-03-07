package tdt4140.gr1805.app.core.person;

public class Person {
	
	private int ID;
	private int age;
	private static int id = 1;
	private Gender gender;
	
	
	public Person (int age, Gender gender) {
		
		this.age = age;
		this.gender = gender;
		this.id = id;
		id++;
		System.out.println(gender);
	}


	public int getID() {
		return ID;
	}


	public int getAge() {
		return age;
	}	
	

}
