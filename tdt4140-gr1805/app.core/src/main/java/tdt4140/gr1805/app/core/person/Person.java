package tdt4140.gr1805.app.core.person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Person implements java.io.Serializable{
	
	// The Class takes care of Person-Objects. This is users registered to the application

	//private int ID;
	@JsonProperty("id") private int id;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonProperty("DOB") private LocalDate DOB;
	@JsonProperty("gender") private Gender gender;
	@JsonProperty("gatherLocation") private boolean gatherLocation;
	@JsonProperty("city") private City city;
	//TODO: connect city in person to database
	
	public Person() {
		super();
	}

	public Person(int year, int month, int day, Gender gender, City city) {
		setDOB(year, month, day);
		this.gender = gender;
		this.gatherLocation = true;
		this.city = city;
	}
	
	public Person(int id, int year, int month, int day, Gender gender, City city) {
		this.id = id;
		setDOB(year, month, day);
		this.gender = gender;
		this.gatherLocation = true;
		this.city = city;
	}
	
	
	public static void writePersonToFile(Person person) throws FileNotFoundException, IOException {
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Person.txt", true));
		out.writeObject(person);
		out.close();
	}
	
	public static Person readPersonFromFile(Person person) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Person.txt"));
		person = (Person)in.readObject();
		in.close();
		return person;
		
		
	}

	@JsonIgnore
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
	
	@JsonIgnore
	public LocalDate getDOB() {
		return this.DOB;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id = id;
	}

	@JsonIgnore
	public int getAge() {  //Calculates age
		LocalDate dateNow = LocalDate.now();
		return Period.between(this.DOB, dateNow).getYears(); // Uses between-method from DOB(User-input at registration)
	}														// Until today.
	
	public Gender getGender() { //Returns gender gathered from ENUM Gender
		return this.gender;
	}
	
	public String toString() {
		return "The user is " + this.getAge() +" years old." + "User is from: " + this.getCity() + " and has ID-Number: " + this.getID() + ". Gender: " + this.gender;
	}

	public boolean isGatherLocation() {
		return gatherLocation;
	}

	public void setGatherLocation(boolean gatherLocation) {
		this.gatherLocation = gatherLocation;
	}
	
	public City getCity() {
		return this.city;
	}
	

	
//	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
//	{
//		Person pers1 = new Person(1991, 02, 20, Gender.MALE);
//		System.out.println(pers1.getAge());
//		System.out.println(pers1.getID());
//		System.out.println(pers1.getGender());
//		writePersonToFile(pers1);
//		readPersonFromFile(pers1);
//		Person pers2 = new Person(1993, 02, 20, Gender.FEMALE);
//		writePersonToFile(pers2);
//		readPersonFromFile(pers2);
//		readPersonFromFile(pers1);
//	
//	
//	}
}

