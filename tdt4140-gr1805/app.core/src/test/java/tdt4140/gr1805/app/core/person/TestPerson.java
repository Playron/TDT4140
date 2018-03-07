package tdt4140.gr1805.app.core.person;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Period;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class TestPerson
{
	
	Person testcase1;
	LocalDate dateNow;
	
	@Before
	public void setUp() throws Exception
	{
		dateNow = LocalDate.now();
	}

	@After
	public void tearDown() throws Exception
	{
		dateNow = null;
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
	public void checkIfWrongMonthException()
	{
		int year = LocalDate.now().minusYears(30).getYear();
		int month = 0;
		int day = 4;
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
	}
	
}
