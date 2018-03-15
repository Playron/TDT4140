package tdt4140.gr1805.app.core.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLatLong {

	private LatLong latlong1;
	private LatLong latlong2;

	@Before
	public void setUp() throws Exception
	{
		latlong1 = new LatLong(60, 20);
		latlong2 = new LatLong(0, 0);
	}

	@After
	public void tearDown() throws Exception
	{
		latlong1 = null;
		latlong2 = null;
	}

	@Test
	public void testDistanceLatLongLatLong() {
		assertEquals(6891049.56611051, LatLong.distance(latlong1, latlong2), 0.001);
	}

	@Test
	public void testToString() {
		assertEquals("60.0,20.0", latlong1.toString());
	}

}
