package tdt4140.gr1805.app.core.analysis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SleepAnalysisTest {
	
	SleepAnalysis s;

	@Before
	public void setUp() throws Exception {
		s = new SleepAnalysis();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPushSleepButton() {
		s.pushSleepButton();
		boolean expected1 = true; //meaning sleeping
		assertEquals(expected1, s.getSleep());
		
		s.pushSleepButton();
		boolean expected2 = false; //meaning awake
		assertEquals(expected2, s.getSleep());
	}
	
	

}
