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
	
	@Test
	public void testHoursOfSleep() throws InterruptedException {
		s.pushSleepButton();
		Thread.sleep(100);//waits for 0.1 sec
		/*Also checked if worked for longer periods, but
		 *uses 0.1 sec now for not slowing down on gitlab
		 */
		s.pushSleepButton();
		double expected = 0.1/ (double)3600;
		System.out.println(expected);
		assertEquals(expected, s.hoursOfSleep(), 0.001);
				
		
	}
	
	

}
