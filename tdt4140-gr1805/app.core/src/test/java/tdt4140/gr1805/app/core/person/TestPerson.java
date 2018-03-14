package tdt4140.gr1805.app.core.person;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Period;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TestPerson
{
	
	Person testcase1;			// assigns that testcase1 is instance of Person
	LocalDate dateNow;			// Assigns that dateNow is a LocalDate.
	
	@Before									// Does this before each test
	public void setUp() throws Exception
	{
		dateNow = LocalDate.now();
	}

	@After									// Does this after each test.
	public void tearDown() throws Exception
	{
		dateNow = null;
	}
	
	public ArrayList<Object> createPerson()		// Creates a person with random values for birthday
												// and random gender, and returns a list with the values
												// of DOB, gender and the person-object
	{
		LocalDate currentDate = LocalDate.now();
		Random rand = new Random();
		int years = 16 + rand.nextInt(100);
		int months = 1 + rand.nextInt(12);
		int days = 1 + rand.nextInt(27);
		LocalDate dob = currentDate.minusYears(years).minusMonths(months).minusDays(days);
		Gender gender =  Gender.values()[new Random().nextInt(Gender.values().length)];
		int year = dob.getYear();
		int month = dob.getMonthValue();
		int day = dob.getDayOfMonth();
		Person pers1 = new Person(year, month, day, gender);
		ArrayList<Object> toReturn = new ArrayList<Object>();
		toReturn.add(dob);
		toReturn.add(gender);
		toReturn.add(pers1);
		return toReturn;
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkIfAbovePermittedAgeException()
	{										// should get an exception, as 131 should be outside
											// limits imposed.
		int year = dateNow.getYear() - 131;
		int month = dateNow.getMonthValue();
		int day = dateNow.getDayOfMonth();
		Gender gender = Gender.MALE;
		testcase1 = new Person(year, month, day, gender);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkIfBelowPermittedAgeException()
	{										// Should get an exception as 1 day less than 16 years
											// ago should be outside limits imposed.
		int years = 16;			// How many years we subtract
		int days = 1;			// How many days we add.
		LocalDate dob = LocalDate.now();
		int year = dob.minusYears(years).getYear();
		int month = dob.getMonthValue();
		int day = dob.plusDays(days).getDayOfMonth();
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
	}
	
	@Test
	public void checkIfCorrectInputOK()
	{
		int years = 16;		// The number of years we subtract from the current date.
		int months = 0;		// The number of months we subtract from the current date.
		int days = 1;		// The number of days we subtract from the current date
		LocalDate dob = LocalDate.now().minusYears(years).minusDays(days);
							// dob is now a datepoint 16 years and 1 day ago.
		int year = dob.getYear();
		int month = dob.getMonthValue();
		int day = dob.getDayOfMonth();
//		System.out.println(dob);
//		System.out.println("Year: " + year + "\nMonth: " + month + "\nDay: " + day);
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
		assertEquals(Period.between(dob, LocalDate.now()).getYears(), testcase1.getAge());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkIfWrongMonthException1()		// Checks if we get an exception if we use 0 as an argument for month.
	{
		int year = LocalDate.now().minusYears(30).getYear();
		int month = 0;
		int day = 4;
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkIfWrongMonthException2()		// Checks if we get an exception if we use 13 as an argument for month.
	{
		int year = LocalDate.now().minusYears(30).getYear();
		int month = 13;
		int day = 4;
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkIfWrongDayException1()			// Checks if we get an exception if we use 0 as an argument for day.
	{
		int year = LocalDate.now().minusYears(30).getYear();
		int month = 04;
		int day = 0;
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void checkIfWrongDayException2()			// Checks if we get an exception if we use 32 as an argument for day.
	{
		int year = LocalDate.now().minusYears(30).getYear();
		int month = 04;
		int day = 32;
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
	}
	
	@Test
	public void checkIfIDIncrements()			// Checks if the ID assigned to new Person-instances increments when 
												// we create a new instance.
	{
		ArrayList<Object> listen = createPerson();
		Person pers1 = null;
		long persID1 = 0, persID2 = 0;
		for (int i = 0; i < listen.size(); i++)
		{
			if (listen.get(i) instanceof Person)
			{
				pers1 = (Person) listen.get(i);
			}
		}
		if (pers1 != null)
		{
			persID1 = (long) pers1.getID();
		}
		ArrayList<Object> listen2 = createPerson();
		Person pers2 = null;
		for (int i = 0; i < listen2.size(); i++)
		{
			if (listen2.get(i) instanceof Person)
			{
				pers2 = (Person) listen2.get(i);
			}
		}
		if (pers2 != null)
		{
			persID2 = (long) pers2.getID();
		}
		//System.out.println(persID1 + " " + persID2);
		if (persID1 != 0 && persID2 != 0)
		{	
			assertEquals(persID2, persID1+1);
		}
		else
		{
			fail("Could not assert equals");
		}
	}
	
	@Test
	public void checkIfGenderCorrect()			// Checks if the gender in the Person-object is congruent with
												// The gender supplied by the createPerson().
	{
		ArrayList<Object> listen = createPerson();
		Person pers1 = null;
		Gender pers1Gender = null;
		for (int i = 0; i < listen.size(); i++)
		{
			if (listen.get(i) instanceof Person)
			{
				pers1 = (Person) listen.get(i);
			}
			if (listen.get(i) instanceof Gender)
			{
				pers1Gender = (Gender) listen.get(i);
			}
		}
		if (pers1 != null && pers1Gender != null)
		{
			assertEquals(pers1Gender, pers1.getGender());
		}
		else
		{
			fail("Could not assert equal.");
		}
	}
	
}
