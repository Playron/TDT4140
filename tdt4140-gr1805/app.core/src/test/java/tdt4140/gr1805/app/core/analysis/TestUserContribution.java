package tdt4140.gr1805.app.core.analysis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserContribution
{
	UserContribution testcase;
	
	@Before
	public void setUp() throws Exception
	{
		testcase = new UserContribution();
	}

	@After
	public void tearDown() throws Exception
	{
		testcase = null;
	}

	@Test
	public void checkUserContributionDefault()
	{
		assertTrue(testcase.getContribution());
	}
	
	@Test
	public void checkUserContributionOptOut()
	{
		testcase.setContribution(false);
		assertFalse(testcase.getContribution());
	}
	
	
	
	

}
