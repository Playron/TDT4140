package tdt4140.gr1805.app.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestSuperMethods {
	
	SuperMethods tester;
	
	@Before  							//gjør dette før hver av testene
	public void setup() {
		tester = new SuperMethods();
	}
	@Test 								//Sjekker om "aadas" er en string
	public void checkIfStringTest1() {
		boolean result = tester.checkIfString("aadas");
		assertEquals(true, result);
		
	}
	
	@Test								//Sjekker at tallet 2 ikke er en string
	public void checkIfStringTest2() {
		int tall = 2;
		boolean result = tester.checkIfString(tall);
		assertEquals(false, result);
	}
	
	@Test								// sjekker at tallet 1 er heltall/integer
	public void checkIfIntTest1() {
		int tall = 1;
		boolean result = tester.checkIfInt(tall);
		assertEquals(true,result);
	}
	
	@Test								//sjekker at ordet "heyhey" ikke er integer
	public void checkIfIntTest2() {
		String ord = "heyhey";
		boolean result = tester.checkIfInt(ord);
		assertEquals(false,result);
	}
	
	@Test								//sjekker at 1.23 er double
	public void checkIfDoubleTest1() {
		double tall = 1.23;
		boolean result = tester.checkIfDouble(tall);
		assertEquals(true,result);
	}
	
	@Test								//Tester at en string ikke er double
	public void checkIfDoubleTest2() {
		String ord = "heyhey";
		boolean result = tester.checkIfDouble(ord);
		assertEquals(false,result);
	}
	
	@Test								// Tester at float er float
	public void checkIfFloatTest1() {
		float tall = 10987690f;
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
		float tall = 215672f;
		tester.stringToInt(tall);
	}
	
	@Test
	public void doubleToIntTest1() {
		double tall = 2.49;
		int result = tester.doubleToInt(tall);
		int expected = 2;
		assertEquals(result,expected);
	}
	@Test
	public void doubleToIntTest2() {
		double tall = 2.51;
		int result = tester.doubleToInt(tall);
		int expected = 3;
		assertEquals(result,expected); 
	}
	@Test(expected = IllegalArgumentException.class)
	public void doubleToIntTest3() {
		String ord = "juhuu";
		tester.doubleToInt(ord);
	}
	
	@Test								// Tests if calculateAverage gives correct output when given list of int.
	public void calculateAverageTest1()
	{
		int[] input = {1,4,1,51,13,3,123,54123,1,10};
		double result = tester.calculateAverage(input);
		assertEquals(5433, result, 0);
	}
	
	@Test(expected = Exception.class)	// Tests if we get an exception if we pass an empty list to the method.
	public void calculateAverageTest2()
	{
		int[] input = {};
		double result = tester.calculateAverage(input);
		assertEquals(0, result, 0); // This line should never be applicable.
	}
	
	@Test
	public void calculateAverageTest3()	// Tests if we get correct output with a list of 1 integer.
	{
		int[] input = {4};
		double result = tester.calculateAverage(input);
		assertEquals(4, result, 0);
	}

}
