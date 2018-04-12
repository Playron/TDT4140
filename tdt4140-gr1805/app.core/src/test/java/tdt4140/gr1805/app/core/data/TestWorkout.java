package tdt4140.gr1805.app.core.data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

public class TestWorkout {
	
	private Database db;
	private ArrayList<Workout> workouts;
	Workout w0, w1, w2, w3, w4, w5;

	@Before
	public void setUp() throws Exception {
		db = new Database();
		workouts = db.getAllWorkouts();
		w0 = workouts.get(0);
		w1 = workouts.get(1);
		w2 = workouts.get(2);
		w3 = workouts.get(3);
		w4 = workouts.get(4);
		w5 = workouts.get(5);
	}

	@Test
	public void test()
	{
		assertTrue(true);
	}
	
	@Test
	public void testCalculateAvgExercisePulse() {
		
		assertEquals(100.19, w1.calculateAverageExcercisePulse(),0.1);
	}
	

	
}
