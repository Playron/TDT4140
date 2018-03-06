package tdt4140.gr1805.app.core;

import org.junit.Test;

import junit.framework.TestCase;

public class CreateUserTest extends TestCase {
	
	@Test
	public void testName() throws Exception {
		CoreInput c = new CoreInput("001", 70, "Atle", 21);
		c.setName("Per");
		String excpected = c.getName();
		assertEquals("Per", excpected);
	}
	
	public void testSletteBruker() {
		CoreInput c = new CoreInput("001", 70, "Atle", 21);
		assertEquals(c.brukere.contains(c), c);
	}
	

}
