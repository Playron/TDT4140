package tdt4140.gr1805.app.core.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDataGathering {
	
	DataGathering tester;
	
	@Before
	public void setup() {
		this.tester = new DataGathering();
	}

	@Test							//tester at en kan sette GPSGathering til false og getGPSbool vil returnere false
	public void testsetGPSGathering1() {
		tester.setGPSGathering(false);
		assertEquals(tester.getGPSbool(), false);
	}
	
	@Test
	public void testsetPulseGathering() {
		tester.setPulseGathering(false);
		assertEquals(false, tester.getPULSEbool());
	}
	
	@Test
	public void testAddUpdate1() {
		tester.setGPSGathering(false);
		tester.addUpdate();
		assertEquals(0, tester.getGpsData());
	}
	
	@Test
	public void testAddUpdate2() {
		tester.setPulseGathering(false);
		tester.addUpdate();
		assertEquals(0, tester.getPulseData());
	}

	@Test			// Tests if OptOut set to false gives correct output.
	public void checkIfSetOptOutCorrect1()
	{
		tester.setOptOut(false);
		assertFalse(tester.getOptOut());
	}
	
	@Test			// Tests if OptOut set to true gives correct output.
	public void checkIfSetOptOutCorrect2()
	{
		tester.setOptOut(true);
		assertTrue(tester.getOptOut());
	}
	
	
}
