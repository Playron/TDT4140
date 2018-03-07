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
	{
		int years = 16;
		int days = 1;
		dateNow.minusYears(years);
		dateNow.plusDays(days);
		int year = dateNow.getYear();
		int month = dateNow.getMonthValue();
		int day = dateNow.getDayOfMonth();
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
	}
	
/*	@Test
	public void checkIfCorrectInputOK()
	{
		int years = 16;
		int months = 0;
		int days = 1;
		dateNow.minusYears(years);
		dateNow.minusMonths(months);
		dateNow.minusDays(days);
		int year = dateNow.getYear();
		int month = dateNow.getMonthValue();
		int day = dateNow.getDayOfMonth();
		Gender gender = Gender.FEMALE;
		testcase1 = new Person(year, month, day, gender);
		assertEquals(Period.between(dateNow, LocalDate.now()).getYears(), testcase1.getAge());
	}
*/	
}
