package tdt4140.gr1805.app.core.person;

import java.time.*;
import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	
	// The Class takes care of Person-Objects. This is users registered to the application

	//private int ID;
	private int id;
	private LocalDate DOB;
	private Gender gender;
	private boolean gatherLocation;
	

	@JsonCreator
	public Person(
			@JsonProperty("id") int id,
			@JsonProperty("dob") LocalDate DOB,
			@JsonProperty("gender") Gender gender,
			@JsonProperty("gatherLocation") boolean gatherLocation) {
		this.id = id;
		this.DOB = DOB;
		this.gender = gender;
		this.gatherLocation = gatherLocation;
	}

	public Person(int year, int month, int day, Gender gender) {
		setDOB(year, month, day);
		this.gender = gender;
		this.gatherLocation = true;
	}
	
	public Person(int id, int year, int month, int day, Gender gender) {
		this.id = id;
		setDOB(year, month, day);
		this.gender = gender;
		this.gatherLocation = true;
	}


	private void setDOB(int year, int month, int day) //Validates normal citeria and birthdate.
	{
		if (month <= 0 || month > 12 ) 
		{
			throw new IllegalArgumentException("The month must be between 1 and 12");
		}
		if (day <= 0 || day > 31 ) 
		{
			throw new IllegalArgumentException("The date must be between 1 and 31");
		}
		if (year < (LocalDate.now().minusYears(130).getYear())) 
		{
			throw new IllegalArgumentException("You have to be less than 130"); 
		}
		if (LocalDate.of(year, month, day).isAfter(LocalDate.now().minusYears(16))) 
		{
			throw new IllegalArgumentException("You have to be older than 16 years.");
		}
		try
		{
			this.DOB = LocalDate.of(year, month, day);
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}

	public int getID() {
		return this.id;
	}


	public int getAge() {  //Calculates age
		LocalDate dateNow = LocalDate.now();
		return Period.between(this.DOB, dateNow).getYears(); // Uses between-method from DOB(User-input at registration)
	}														// Until today.
	
	public Gender getGender() { //Returns gender gathered from ENUM Gender
		return this.gender;
	}
	
	public String toString() {
		return "The user is " + this.getAge() +" years old" + " and has ID-Number: " + this.getID() + ". Gender: " + this.gender;
	}

	public boolean isGatherLocation() {
		return gatherLocation;
	}

	public void setGatherLocation(boolean gatherLocation) {
		this.gatherLocation = gatherLocation;
	}
	
}
	
	/*public static void main(String[] args)
	{
		Person pers1 = new Person(1991, 02, 20, Gender.MALE);
		System.out.println(pers1.getAge());
		System.out.println(pers1.getID());
		System.out.println(pers1.getGender());
		Person pers2 = new Person(2000, 12, 20, Gender.FEMALE);
		System.out.println(pers2.getAge());
		System.out.println(pers2.getID());
		System.out.println(pers2.getGender());
	}*/
	

