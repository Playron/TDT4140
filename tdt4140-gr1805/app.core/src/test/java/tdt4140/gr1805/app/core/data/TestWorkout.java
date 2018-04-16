package tdt4140.gr1805.app.core.data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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

	}

	@Ignore
	@Test
	public void testCalculateAvgExercisePulse() {
		
		double excpected = w1.calculateAverageExcercisePulse();
		assertEquals(excpected, w1.calculateAverageExcercisePulse(),1);
	}
	
	
	
	

	
}
