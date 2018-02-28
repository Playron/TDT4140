package tdt4140.gr1805.app.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestAverageNumber
{
	
	
	@Test
	public void testZeroes()
	{
		
		AverageNumber gmen = new AverageNumber();
		List<Double> list1 = Arrays.asList(0.0, 0.0, 0.0, 0.0);
		double result = gmen.getResult(list1);
		assertEquals(0, result, 0);
	}
	
	@Test
	public void testOnes()
	{
		AverageNumber gmen = new AverageNumber();
		List<Double> list1 = Arrays.asList(1.0, 1.0, 1.0, 1.0);
		double result = gmen.getResult(list1);
		assertEquals(1, result, 0);
	}
	
	@Test
	public void testNoInput()
	{
		AverageNumber gmen = new AverageNumber();
		List<Double> list1 = Arrays.asList();
		double result = gmen.getResult(list1);
		assertEquals(0, result, 0);
	}
	// TODO: Create package of testcases, which this runs through.
}
