
package tdt4140.gr1805.app.core.analysis;

import java.util.ArrayList;
import java.util.Collections;

import tdt4140.gr1805.app.core.data.Exercise;
import tdt4140.gr1805.app.core.data.Workout;

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
	public static Double computeMedian(ArrayList<Double> array)
	{
		Collections.sort(array);	// Sorts the input Array
		Double median;				// Assigns median to be a Double
		int length = array.size();	// Finds the length of the input Array
		if (length % 2 == 0)		// If the length of the array is an even number
		{
			int median_number = array.size() / 2;	// We find the index right above the middle
			median = (array.get(median_number) + array.get(median_number - 1)) / 2;	
			// ^ We take the mean of the two middle values of the sorted array and assigns that as the median.
		}
		else
		{
			median = (array.get(length / 2));	// We find the middle value of the array, this is the median
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
	public static Exercise mostUsedExercise(ArrayList<Workout> array)
	{
		ArrayList<Exercise> liste = new ArrayList<Exercise>();	// Create new ArrayList of Exercises
		ArrayList<Integer> count = new ArrayList<Integer>();	// Create new ArrayList of counts of each Exercise
		for (Exercise e : Exercise.values())	// Setup for counting
		{ 
			liste.add(e);	// Adds the Exercise to the list of them	
			count.add(0);	// Adds the count of 0 to the list of counts of each Exercise
		}
		
		for (Workout w : array)		// Goes through all the Workouts in the input ArrayList
		{
			int ex = 0;				// Starts at index 0 for the list of Exercises
			while (w.getType() != liste.get(ex))	// While the Exercise of the Workout is not at the current index
			{
				ex++;								// we increment the index
			}
			count.set(ex, count.get(ex) + 1); // counts the kind of exercise the workout uses (adds 1 to the count)
		}
		int max = Collections.max(count);	// Finds the maximum count
		int index = count.indexOf(max);		// Finds the index of the maximum count
		return liste.get(index); // returns the type of exercise that occurs the most in the array given in this
									// method

	}

//	public static void main(String[] args)
//	{
//		ArrayList<Double> liste = new ArrayList<Double>();
//		liste.add(2.9);
//		liste.add(2.1);
//		liste.add(2.3);
//		Double median = computeMedian(liste);
//		System.out.println(median);
//
//		ArrayList<Workout> liste1 = new ArrayList<Workout>();
//		double tall = 70;
//
//	}
}
