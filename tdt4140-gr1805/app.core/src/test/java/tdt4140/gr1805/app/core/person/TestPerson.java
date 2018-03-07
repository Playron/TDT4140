package tdt4140.gr1805.app.core.person;

import static org.junit.Assert.*;

import java.time.LocalDate;

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
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkIfAbovePermittedAge()
	{										// should get an exception, as 131 should be outside
											// limits imposed.
		int year = dateNow.getYear() - 131;
		int month = dateNow.getMonthValue();
		int day = dateNow.getDayOfMonth();
		Gender gender = Gender.MALE;
		testcase1 = new Person(year, month, day, gender);		
	}

}
