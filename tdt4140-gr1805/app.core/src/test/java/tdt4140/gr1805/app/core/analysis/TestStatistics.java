
package tdt4140.gr1805.app.core.analysis;

import static org.junit.Assert.*;


import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


import java.util.Random;


import org.junit.Test;

import javafx.util.Pair;
import tdt4140.gr1805.app.core.data.DataPoint;
import tdt4140.gr1805.app.core.data.Exercise;
import tdt4140.gr1805.app.core.data.Workout;


public class TestStatistics 
	{
	private static Date localDateTimeToDate(LocalDateTime date) {
		return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
	}


	/**
	 * @return an {@link ArrayList} of random {@link DataPoint}s
	 * @param id
	 *            The user ID connected to these DataPoints
	 */

	private ArrayList<DataPoint> createDataPoints(int id)
	{
		Random rand = new Random();
		ArrayList<DataPoint> dpa = new ArrayList<>();
		double pulseBase = 60 + (rand.nextDouble() * 20); // Sets the baseline for the persons pulse
		int interval = 5; // Sets the interval between DataPoints in seconds
		LocalDateTime dateTime = LocalDateTime.now().minusDays(1); // Sets the dateTime 1 day ago
		for (int i = 0; i < 20; i++)
		{
			// The following creates a Date which is 5 seconds after the previous dateTime.
			Date date = Date.from(dateTime.plusSeconds(interval * i).atZone(ZoneId.systemDefault()).toInstant());
			DataPoint dp = new DataPoint(id, date, pulseBase + (rand.nextDouble() * i));
			dpa.add(dp);
		}
		return dpa;

	}

	@Test
	public void testComputeMedian1()
	{
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.add(2.9);
		liste.add(2.1);
		liste.add(2.3);
		Double median = Statistics.computeMedian(liste);
		Double actual = 2.3;
		assertEquals(median, actual);
	}

	@Test
	public void testComputeMedian2()
	{
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.add(2.9);
		liste.add(2.1);
		liste.add(2.3);
		liste.add(1.0);
		Double median = Statistics.computeMedian(liste);
		Double actual = 2.2;
		assertEquals(median, actual);
	}

	@Test
	public void testmostUsedExercise1()
	{
		ArrayList<Workout> liste1 = new ArrayList<Workout>();
		Date dato = new Date(0);
		double tall = 70;
		DataPoint point = new DataPoint(2, dato, tall);
		ArrayList<DataPoint> dpa = new ArrayList<DataPoint>();
		dpa.add(point);
		dpa.add(point);
		Workout w = new Workout(2, Exercise.RUNNING, dpa);
		liste1.add(w);
		for (int i = 0; i < 4; i++)
		{
			Workout a = new Workout(2, Exercise.CYCLING, dpa);
			liste1.add(a);
		}
		Exercise expected = Exercise.CYCLING;
		Exercise mostused = Statistics.mostUsedExercise(liste1);
		assertEquals(expected, mostused);
	}

	@Test
	public void testmostUsedExercise2()
	{
		ArrayList<Workout> liste1 = new ArrayList<Workout>();
		Date dato = new Date(0);
		double tall = 70;
		DataPoint point = new DataPoint(2, dato, tall);
		ArrayList<DataPoint> dpa = new ArrayList<DataPoint>();
		dpa.add(point);
		dpa.add(point);
		Workout w = new Workout(2, Exercise.RUNNING, dpa);
		liste1.add(w);
		for (int i = 0; i < 4; i++)
		{
			Workout a = new Workout(2, Exercise.RUNNING, dpa);
			liste1.add(a);
		}
		Exercise expected = Exercise.RUNNING;
		Exercise mostused = Statistics.mostUsedExercise(liste1);
		assertEquals(expected, mostused);
	}
	
	@Test
	public void testAverageBPM1() throws Exception {
		
		ArrayList<DataPoint> dpa = new ArrayList<DataPoint>();
		LocalDateTime date = LocalDateTime.of(2017, 8, 22, 3, 54, 13, 22);
		Date dato = localDateTimeToDate(date);
		//System.out.println(dato.getTime());
		DataPoint dp = new DataPoint(1, dato, 65);
		dpa.add(dp);
		for(int i = 0; i<10; i++) {
			LocalDateTime date1 = LocalDateTime.of(2015, 7, 22, 3, 54, 12, 22);
			Date dato1 = localDateTimeToDate(date1);
			//System.out.println(dato1.getTime());
			DataPoint dp1 = new DataPoint(1, dato1, 70);
			dpa.add(dp1);
		}
		//System.out.println(dpa);
		for (int i = 0; i<10;i++) {
			LocalDateTime date1 = LocalDateTime.of(2015, 12, 28, 16, 22, 54, 836142);
			Date dato1 = localDateTimeToDate(date1);
			DataPoint dp1 = new DataPoint(2,dato1,69);
			dpa.add(dp1);
		}
		for(int i = 0;i<10;i++) {
			LocalDateTime date1 = LocalDateTime.of(2015, 12, 8, 16, 22, 54, 836142);
			Date dato1 = localDateTimeToDate(date1);
			DataPoint dp1 = new DataPoint(1,dato1,68);
			dpa.add(dp1);
		}
		LocalDateTime start = LocalDateTime.of(2015, 5, 12, 13, 14);
		Date startDate = localDateTimeToDate(start);
		LocalDateTime end = LocalDateTime.of(2018, 4,1,1,1);
		Date endDate = localDateTimeToDate(end);
		ArrayList<ArrayList<Object>> result = Statistics.averageBPM(dpa, startDate, endDate, 2);
		//System.out.println(result);
		ArrayList<ArrayList<Object>> expected = new ArrayList<>();
		LocalDateTime date1 = LocalDateTime.of(2016, 1,31,3,10,45);
		Date dato1 = localDateTimeToDate(date1);
		LocalDateTime date2 = LocalDateTime.of(2017, 7,11,10,4,15);
		Date dato2 = localDateTimeToDate(date2);
		ArrayList<Object> parts = new ArrayList<>();
		parts.add(dato1);
		parts.add(69.0);
		expected.add(parts);
		ArrayList<Object> parts1 = new ArrayList<>();
		parts1.add(dato2);
		parts1.add(65.0);
		expected.add(parts1);
		assertEquals(expected, result);
		
		
	}
	
	

	@Test
	public void testExerciseCountsHighest()
	{
		ArrayList<Workout> wl = exerciseCountGenerateWL(); // Creates a list with Cycling 5, Walking 10, Running 3,
															// Strength 4.
		ArrayList<Pair<Exercise, Integer>> exs = Statistics.exerciseCounts(wl, true);
		Exercise expected = Exercise.WALKING;
		assertEquals(expected, exs.get(0).getKey());
		int expected2 = 10;
		assertEquals(expected2, exs.get(0).getValue().intValue());
	}

	@Test
	public void testExerciseCountsNextHighest()
	{
		ArrayList<Workout> wl = exerciseCountGenerateWL(); // Creates a list with Cycling 5, Walking 10, Running 3,
															// Strength 4.
		ArrayList<Pair<Exercise, Integer>> exs = Statistics.exerciseCounts(wl, false);
		Exercise expected = Exercise.CYCLING;
		assertEquals(expected, exs.get(1).getKey());
		int expected2 = 5;
		assertEquals(expected2, exs.get(1).getValue().intValue());
	}

	@Test
	public void testExerciseCountsLowest()
	{
		ArrayList<Workout> wl = exerciseCountGenerateWL(); // Creates a list with Cycling 5, Walking 10, Running 3,
															// Strength 4.
		ArrayList<Pair<Exercise, Integer>> exs = Statistics.exerciseCounts(wl, false);
		Exercise expected = Exercise.RUNNING;
		assertEquals(expected, exs.get(exs.size() - 1).getKey());
		int expected2 = 3;
		assertEquals(expected2, exs.get(exs.size() - 1).getValue().intValue());
	}

	/**
	 * @return a {@link ArrayList} of {@link Workout}s where RUNNING is 3,
	 *         STRENGTH_TRAINING is 4, CYCLING is 5, and WALKING is 10
	 */
	private ArrayList<Workout> exerciseCountGenerateWL()
	{
		ArrayList<Workout> wl = new ArrayList<>();
		for (int i = 0; i < 3; i++)
		{
			int id = i + 1;
			Workout wk = new Workout(id, Exercise.RUNNING, createDataPoints(id));
			wl.add(wk);
		}
		for (int i = 0; i < 5; i++)
		{
			int id = i + 4;
			Workout wk = new Workout(id, Exercise.CYCLING, createDataPoints(id));
			wl.add(wk);
		}
		// workoutSysOut(wl);
		for (int i = 0; i < 10; i++)
		{
			int id = i + 9;
			Workout wk = new Workout(id, Exercise.WALKING, createDataPoints(id));
			wl.add(wk);
		}
		for (int i = 0; i < 4; i++)
		{
			int id = i + 19;
			Workout wk = new Workout(id, Exercise.STRENGTH_TRANING, createDataPoints(id));
			wl.add(wk);
		}
		return wl;
	}

	// /**
	// * @since To be used for debugging when you need to see all the stuff.
	// * @param wl And {@link ArrayList} with {@link Workout}s which is written out
	// for all the Workouts
	// */
	//
	// private void workoutSysOut(ArrayList<Workout> wl)
	// {
	// for (int i = 0; i < wl.size(); i++)
	// {
	// System.out.println(wl.get(i).toString());
	// }
	// }

}
