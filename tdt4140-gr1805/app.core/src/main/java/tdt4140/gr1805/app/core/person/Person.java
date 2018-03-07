package tdt4140.gr1805.app.core.person;

import java.time.*;

public class Person {
	

	//private int ID;
	private LocalDate DOB;
	private static int id = 1;
	private Gender gender;
	
	
	public Person (int year, int month, int day, Gender gender) {
		
		setDOB(year, month, day);
		this.gender = gender;
		this.id = id;
		id++;
		//System.out.println(gender);
	}

	private void setDOB(int year, int month, int day)
	{
		if (month <= 0 || month > 12 ) 
		{
			throw new IllegalArgumentException("Måneden må være mellom 1 og 12");
		}
		if (day <= 0 || day > 31 ) 
		{
			throw new IllegalArgumentException("Datoen må være mellom 1 og 31");
		}
		if (year < (LocalDate.now().minusYears(130).getYear())) 
		{
			throw new IllegalArgumentException("Du må være født etter 1900"); //TODO: fikse feilmelding
		}
		if (LocalDate.of(year, month, day).isAfter(LocalDate.now().minusYears(16))) 
		{
			throw new IllegalArgumentException("Du må være eldre enn 16 år");// TODO: Fikse feilmelding.
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


	public int getAge() {
		LocalDate dateNow = LocalDate.now();
		return Period.between(this.DOB, dateNow).getYears();
	}	
	
	public Gender getGender() {
		return this.gender;
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
	

