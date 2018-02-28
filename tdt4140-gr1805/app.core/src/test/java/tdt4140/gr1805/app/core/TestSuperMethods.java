package tdt4140.gr1805.app.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSuperMethods {
	
	SuperMethods tester;
	
	@Before  						//gjør dette før hver av testene
	public void setup() {
		tester = new SuperMethods();
	}
	@Test 							//Sjekker om "aadas" er en string
	public void checkIfStringTest1() {
		boolean result = tester.checkIfString("aadas");
		assertEquals(true, result);
		
	}
	
	@Test							//Sjekker at tallet 2 ikke er en string
	public void checkIfStringTest2() {
		int tall = 2;
		boolean result = tester.checkIfString(tall);
		assertEquals(false, result);
	}
	
	@Test							// sjekker at tallet 1 er heltall/integer
	public void checkIfIntTest1() {
		int tall = 1;
		boolean result = tester.checkIfInt(tall);
		assertEquals(true,result);
	}
	
	@Test							//sjekker at ordet "heyhey" ikke er integer
	public void checkIfIntTest2() {
		String ord = "heyhey";
		boolean result = tester.checkIfInt(ord);
		assertEquals(false,result);
	}
	
	@Test							//sjekker at 1.23 er double
	public void checkIfDoubleTest1() {
		double tall = 1.23;
		boolean result = tester.checkIfDouble(tall);
		assertEquals(true,result);
	}
	
	@Test								//Tester 
	public void checkIfDoubleTest2() {
		String ord = "heyhey";
		boolean result = tester.checkIfDouble(ord);
		assertEquals(false,result);
	}
	
	@Test
	public void checkIfFloatTest1() {
		float tall = 10987690;
		boolean result = tester.checkIfFloat(tall);
		assertEquals(true,result);
	}
	
	@Test
	public void checkIfFloatTest2() {
		int tall = 12;
		boolean result = tester.checkIfFloat(tall);
		assertEquals(false,result);
	}
	@Test
	public void checkIfFloatTest3() {
		String ord = "heyhey";
		boolean result = tester.checkIfFloat(ord);
		assertEquals(false,result);
	}
	
	@Test
	public void stringToIntTest1() {
		String ord = "123";
		int result = tester.stringToInt(ord);
		int tall = 123; 
		assertEquals(tall,result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void stringToIntTest2() {
		String ord = "ten";
		tester.stringToInt(ord);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void stringToIntTest3() {
		float tall = 215672;
		tester.stringToInt(tall);
	}
	
	
	

}
