package tdt4140.gr1805.app.core.analysis;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestStatistics {

	@Test
	public void testComputeMedian1() {
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.add(2.9);
		liste.add(2.1);
		liste.add(2.3);
		Double median = Statistics.computeMedian(liste);
		Double actual = 2.3;
		assertEquals(median, actual);
	}
	
	@Test
	public void testComputeMedian2() {
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.add(2.9);
		liste.add(2.1);
		liste.add(2.3);
		liste.add(1.0);
		Double median = Statistics.computeMedian(liste);
		Double actual = 2.2;
		assertEquals(median, actual);
	}
	
	

}
