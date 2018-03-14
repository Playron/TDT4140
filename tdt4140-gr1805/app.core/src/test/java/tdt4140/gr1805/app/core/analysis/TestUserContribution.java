package tdt4140.gr1805.app.core.analysis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserContribution
{
	UserContribution testcase;
	
	@Before								// Does this before each test.
	public void setUp() throws Exception
	{
		testcase = new UserContribution();
	}

	@After								// Does this after each test.
	public void tearDown() throws Exception
	{
		testcase = null;
	}

	@Test								// Tests that the default value of usercontribution is true 
	public void checkUserContributionDefault()
	{
		assertTrue(testcase.getContribution());
	}
	
	@Test								// Tests that if we set the value of usercontribution to false 
	public void checkUserContributionOptOut()	// then the value actually is set to false.
	{
		testcase.setContribution(false);
		assertFalse(testcase.getContribution());
	}
	
	
	
	

}
