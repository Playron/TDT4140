package tdt4140.gr1805.app.core.data;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class TestWorkout {

	private Workout w;
	private DataPoint p1, p2, p3, p4, p5 ;

	@Before
	public void setUp() throws Exception {
		
	LocalDateTime man16 =LocalDateTime.of(2018, 4, 16, 13, 0);
	w = new Workout(1, Exercise.RUNNING);
	p1 = new DataPoint(1, man16, 90);
	p2 = new DataPoint(1, man16.plusMinutes(10), 95);
	p3 = new DataPoint(1, man16.plusMinutes(20), 100);
	p4 = new DataPoint(1, man16.plusMinutes(30), 103);
	p5 = new DataPoint(1, man16.plusMinutes(40), 107);
	w.addDataPoint(p1);
	w.addDataPoint(p2);
	w.addDataPoint(p3);
	w.addDataPoint(p4);
	w.addDataPoint(p5);
	}


	@Test
	public void testCalculateAvgExercisePulse() {
		double excpected = 99;
		assertEquals(excpected, w.calculateAverageExcercisePulse(),0.1);
	}
	
	@Test
	public void testCalculateDistance() {
		
		
	}
	
	
	
	

	
}
