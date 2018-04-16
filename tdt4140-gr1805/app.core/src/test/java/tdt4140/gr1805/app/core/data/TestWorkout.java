package tdt4140.gr1805.app.core.data;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestWorkout {

	private Workout w, w2;
	private DataPoint p1, p2, p3, p4, p5, p6 ;
	private LatLong l1, l2, l3, l4, l5 ;

	@Before
	public void setUp() throws Exception {	
	LocalDateTime man16 =LocalDateTime.of(2018, 4, 16, 13, 0);
	w = new Workout(1, Exercise.STRENGTH_TRANING);
	w2 = new Workout(2, Exercise.RUNNING);
	w.setType(Exercise.RUNNING);
	w.setID(0);
	
	p1 = new DataPoint(1, man16, 90);
	p2 = new DataPoint(1, man16.plusMinutes(10), 95);
	p3 = new DataPoint(1, man16.plusMinutes(20), 100);
	p4 = new DataPoint(1, man16.plusMinutes(30), 103);
	p5 = new DataPoint(1, man16.plusMinutes(40), 107);
	p6 = new DataPoint(2, man16.plusMinutes(10), 95);
	
	ArrayList< DataPoint> datapoints = new ArrayList();
	
	l1 =  new LatLong(63.406637, 10.420940); //Njords veg 5a
	l2 =  new LatLong(63.419499, 10.402077); //Gloshaugen
	l3 =  new LatLong(63.422495, 10.395008); //Samfundet
	l4 =  new LatLong(63.430036, 10.393522); //Torget
	l5 =  new LatLong(63.434923, 10.412233); //Solsiden
	
	/*The distance is according to https://www.movable-type.co.uk/scripts/latlong.html
	 * like 1.711 + 0.4844 + 0.8418 + 1.078 = 4.1152 km. 
	 * This is in airline (?), between all this 5 places.
	 */
	
	p1.setLocation(l1);
	p2.setLocation(l2);
	p3.setLocation(l3);
	p4.setLocation(l4);
	p5.setLocation(l5);
	p6.setLocation(l1); //same location as p1
	
	datapoints.add(p1);
	datapoints.add(p2);
	datapoints.add(p3);
	datapoints.add(p4);
	datapoints.add(p5);
	
	w.setDatapoints(datapoints); //adds all datapoints to Workout w
	w2.addDataPoint(p1);

	
	}


	@Test
	public void testCalculateAvgExercisePulse() {
		double excpected = 99;
		assertEquals(excpected, w.calculateAverageExcercisePulse(),0.1);
	}
	
	@Test
	public void testCalculateDistance() {
		double expected0 = 0;
		assertEquals(expected0, w2.calculateWorkoutDistance(), 0.001); 
		
		double expected = 4115.2; //converted km to m
		assertEquals(expected, w.calculateWorkoutDistance(), 1);
		
	}
	
	@Test
	public void testCalculateAvgSpeed() {
		double expected = 4115.2 / (40*60); // distance / time gives avg spedd in m/2
		assertEquals(expected, w.calculateAvgSpeed(), 1);
	}
}
