
package tdt4140.gr1805.app.core.analysis;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

import javafx.util.Pair;

import tdt4140.gr1805.app.core.data.Exercise;
import tdt4140.gr1805.app.core.data.Workout;
import java.util.Date;

import tdt4140.gr1805.app.core.data.DataPoint;
import tdt4140.gr1805.app.core.data.Database;


// Used for testing with Main method
//import tdt4140.gr1805.app.core.data.DataPoint;
//import java.util.Date;
//import java.util.Random;
//import java.time.LocalDateTime;
//import java.time.ZoneId;

/**
 * @author Anna, Torleif
 * 
 *
 */
public class Statistics
{

	/**
	 * @param array
	 *            {@link ArrayList<>} with {@link Double}s
	 * @return {@link Double} which is the median number OR the mean of the two
	 *         median numbers.
	 */
	public static final Double computeMedian(ArrayList<Double> array)
	{
		Collections.sort(array); // Sorts the input Array
		Double median; // Assigns median to be a Double
		int length = array.size(); // Finds the length of the input Array
		if (length % 2 == 0) // If the length of the array is an even number
		{
			int median_number = array.size() / 2; // We find the index right above the middle
			median = (array.get(median_number) + array.get(median_number - 1)) / 2;
			// ^ We take the mean of the two middle values of the sorted array and assigns
			// that as the median.
		}
		else
		{
			median = (array.get(length / 2)); // We find the middle value of the array, this is the median
		}
		return median;
	}

	/*
	 * //didn't see why we needed this and therefore didn't finish creating the
	 * method// public static int computeMode(ArrayList<Double> array) {
	 * Collections.sort(array); ArrayList<Integer> intarray = new
	 * ArrayList<Integer>(); for (Double d: array) { intarray.add(d.intValue()); }
	 * ArrayList<Pair> count = new ArrayList<Pair>(); for(int d: intarray) {
	 * 
	 * } }
	 */

	/**
	 * @param array
	 *            {@link ArrayList} of {@link app.core.data#Workout}
	 * @return {@link app.core.data.Exercise} which is the most used in the input
	 *         array
	 */
	
	public static final Exercise mostUsedExercise(ArrayList<Workout> array)
	{
		ArrayList<Exercise> liste = new ArrayList<Exercise>(); // Create new ArrayList of Exercises
		ArrayList<Integer> count = new ArrayList<Integer>(); // Create new ArrayList of counts of each Exercise
		for (Exercise e : Exercise.values()) // Setup for counting
		{
			liste.add(e); // Adds the Exercise to the list of them
			count.add(0); // Adds the count of 0 to the list of counts of each Exercise
		}

		for (Workout w : array) // Goes through all the Workouts in the input ArrayList
		{
			int ex = 0; // Starts at index 0 for the list of Exercises
			while (w.getType() != liste.get(ex)) // While the Exercise of the Workout is not at the current index
			{
				ex++; // we increment the index
			}
			count.set(ex, count.get(ex) + 1); // counts the kind of exercise the workout uses (adds 1 to the count)
		}
		int max = Collections.max(count); // Finds the maximum count
		int index = count.indexOf(max); // Finds the index of the maximum count
		return liste.get(index); // returns the type of exercise that occurs the most in the array given in this
									// method

	}
	
	/**
	 * @param array
	 *            An {@link ArrayList} of {@link Workout}s
	 * @return an {@link ArrayList} of {@link Pair} of {@link Exercise} and
	 *         {@link Integer}. The list is sorted such that the most common
	 *         Exercise is first, and the number of times it was counted is
	 *         connected to it in the Pair. The list then extends in descending
	 *         order such that the exercise
	 */
	
	public static final ArrayList<Pair<Exercise, Integer>> exerciseCounts(ArrayList<Workout> array,
			boolean useAllExercises)
	{
		ArrayList<Exercise> liste = new ArrayList<Exercise>(); // Create new ArrayList of Exercises
		ArrayList<Integer> count = new ArrayList<Integer>(); // Create new ArrayList of counts of each Exercise
		for (Exercise e : Exercise.values()) // Setup for counting
		{
			liste.add(e); // Adds the Exercise to the list of them
			count.add(0); // Adds the count of 0 to the list of counts of each Exercise
		}

		for (Workout w : array) // For each Workout in input array
		{
			int index = liste.indexOf(w.getType()); // Find the index of the specified Exercise in the Workout
			int element = count.get(index) + 1; // Add 1 to the current count of that Exercise
			count.set(index, element); // Update the ArrayList with the new count.
		}

		if (!useAllExercises)
		{
			while (count.contains(0))
			{
				int index = count.lastIndexOf(0);
				count.remove(index);
				liste.remove(index);
			}
		}

		ArrayList<Pair<Exercise, Integer>> utputt = new ArrayList<>();
		while (count.size() > 0)
		{
			int max = Collections.max(count); // Finds the maximum count.
			int index = count.indexOf(max); // Finds the index of the maximum count.
			Exercise ex = liste.get(index); // Extracts the Exercise with maximum count
			Pair<Exercise, Integer> e = new Pair<Exercise, Integer>(ex, max); // Creates new Pair with Exercise and
																				// count
			utputt.add(e); // Adds the Pair to the output
			liste.remove(index); // Removes the Exercise at index from liste
			count.remove(index); // Removes the count at index from liste
		}

		return utputt; // Returns the ArrayList of Pairs, in descending order.
	}
	
	private static ArrayList<DataPoint> PointsByTime(ArrayList<DataPoint> dp, LocalDateTime timeStart, LocalDateTime timeEnd){
		ArrayList<DataPoint> points= new ArrayList<DataPoint>(); //make an arraylist with the datapoints within our timeframe
		for (DataPoint point:dp) {
			
			//System.out.println("runs through");
			//System.out.println(timeStart + " \n" + point.getTimestamp() + " \n" +timeEnd );
			if (point.getTimestamp().isAfter(timeStart)) {
				//System.out.println("is after timeStart");

				if(point.getTimestamp().isBefore(timeEnd)) {
					//System.out.println("is before timeEnd");
					points.add(point);
				}
				
			}
		}
		return points;
	}
	
	private static Double averageBPMhelper(ArrayList<DataPoint>dp){
		//System.out.println(dp);
		Double result = 0.0;
		int count = 0;
		for(DataPoint point:dp) {
			count ++;
			result = result + point.getPulse();
		}
		result = result/count;
		return result;
	}
	public static ArrayList<Pair<LocalDateTime, Double>> averageBPM(ArrayList<DataPoint> dp, LocalDateTime timeStart, LocalDateTime timeEnd, int deler) throws Exception{
		if (timeEnd.isBefore(timeStart)) {
			//System.out.println("hey");
			throw new IllegalArgumentException("The starttime needs to be before the endtime");
		}
		ArrayList<DataPoint> points= new ArrayList<DataPoint>(); //make an arraylist with the datapoints within our timeframe
		for (DataPoint point:dp) {
			if (point.getTimestamp().isAfter(timeStart)) {
				if(point.getTimestamp().isBefore(timeEnd)) {
					points.add(point);
				}
				
			}
		}
		Duration intervall = Duration.between(timeStart,timeEnd);
		long intervallsekund = intervall.getSeconds();
		
		/*ArrayList<Integer> intervall = new ArrayList<Integer>();
		int year = timeEnd.getYear() - timeStart.getYear();
		intervall.add(year);
		int month = timeEnd.getMonthValue() - timeStart.getMonthValue();
		intervall.add(month);
		int day = timeEnd.getDayOfMonth() - timeStart.getDayOfMonth();
		intervall.add(day);
		*/
		//System.out.println(intervall);
		long intervallDeler = intervallsekund/deler;
		ArrayList<Pair<LocalDateTime, Double>> result = new ArrayList<Pair<LocalDateTime, Double>>();
		for(int i = 0; i< deler;i++) {
			LocalDateTime intervallStart = timeStart.plusSeconds(intervallDeler*i);
			
			LocalDateTime intervallEnd = timeStart.plusSeconds(intervallDeler*(i+1));
			//System.out.println(intervallStart + " " + intervallEnd + intervallDeler + " "+ (intervallDeler*i) +" ");
			//System.out.println("hey");
			//System.out.println(intervallStart + " " + intervallEnd);
			ArrayList<DataPoint> intervalldp = PointsByTime(dp, intervallStart, intervallEnd);
			LocalDateTime intervallDisplay = intervallStart.plusSeconds(intervallDeler/2);
			Pair<LocalDateTime,Double> intervallArray= new Pair<LocalDateTime,Double>(intervallDisplay, averageBPMhelper(intervalldp));
			//System.out.println(intervallArray);
			result.add(intervallArray);
		}
		//System.out.println(result);
		return result;
		
	}
	


	
	

	//
	// private static ArrayList<Workout> exerciseCountGenerateWL()
	// {
	// ArrayList<Workout> wl = new ArrayList<>();
	// for (int i = 0; i < 3; i++)
	// {
	// int id = i+1;
	// Workout wk = new Workout(id, Exercise.RUNNING, createDataPoints(id));
	// wl.add(wk);
	// }
	// for (int i = 0; i < 5; i++)
	// {
	// int id = i + 4;
	// Workout wk = new Workout(id, Exercise.CYCLING, createDataPoints(id));
	// wl.add(wk);
	// }
	// //workoutSysOut(wl);
	// for (int i = 0; i < 10; i++)
	// {
	// int id = i + 9;
	// Workout wk = new Workout(id, Exercise.WALKING, createDataPoints(id));
	// wl.add(wk);
	// }
	// for (int i = 0; i < 4; i++)
	// {
	// int id = i + 19;
	// Workout wk = new Workout(id, Exercise.STRENGTH_TRANING,
	// createDataPoints(id));
	// wl.add(wk);
	// }
	// return wl;
	// }
	//
	// private static ArrayList<DataPoint> createDataPoints(int id)
	// {
	// Random rand = new Random();
	// ArrayList<DataPoint> dpa = new ArrayList<>();
	// double pulseBase = 60+(rand.nextDouble()*20); // Sets the baseline for the
	// persons pulse
	// int interval = 5; // Sets the interval between DataPoints in seconds
	// LocalDateTime dateTime = LocalDateTime.now().minusDays(1); // Sets the
	// dateTime 1 day ago
	// for (int i = 0; i < 20; i++)
	// {
	// // The following creates a Date which is 5 seconds after the previous
	// dateTime.
	// Date date =
	// Date.from(dateTime.plusSeconds(interval*i).atZone(ZoneId.systemDefault()).toInstant());
	// DataPoint dp = new DataPoint(id, date, pulseBase+(rand.nextDouble()*i));
	// dpa.add(dp);
	// }
	// return dpa;
	// }
	//
	// public static void main(String[] args)
	// {
	// ArrayList<Double> liste = new ArrayList<Double>();
	// liste.add(2.9);
	// liste.add(2.1);
	// liste.add(2.3);
	// Double median = computeMedian(liste);
	// System.out.println(median);
	// ArrayList<Workout> wl = exerciseCountGenerateWL();
	// ArrayList<Pair<Exercise, Integer>> arl = exerciseCounts(wl, true);
	// System.out.println(arl);
	//
	// }
}
