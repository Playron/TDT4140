package tdt4140.gr1805.app.core.person;

import java.time.*;

public class Person {
	
	private int ID;
	private LocalDate DOB;
	private static int id = 1;
	private Gender gender;
	
	
	public Person (int year, int month, int day, Gender gender) {
		
		setDOB(year, month, day);
		this.gender = gender;
		this.id = id;
		id++;
		System.out.println(gender);
	}

	private void setDOB(int year, int month, int day)
	{
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
		return ID;
	}


	public int getAge() {
		LocalDate dateNow = LocalDate.now();
		return Period.between(this.DOB, dateNow).getYears();
	}	
	
/*	public static void main(String[] args)
	{
		Person pers1 = new Person(1991, 02, 20, Gender.MALE);
		System.out.println();
	}
*/
}
