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
public class Statistics {
	
	
	/**
	 * @param array {@link ArrayList<>} with {@link Double}s
	 * @return {@link Double} which is the median number OR the mean of the two median numbers.
	 */
	public static Double computeMedian(ArrayList<Double> array) {
		Collections.sort(array);
		Double median;
		int length = array.size();
		if (length%2 ==0) {
			int median_number = array.size()/2;
			median = (array.get(median_number) + array.get(median_number-1))/2;
		}
		else {
			median = (array.get(length/2));
		}
		return median;
	}
	/*			//didn't see why we needed this and therefore didn't finish creating the method//
	public static int computeMode(ArrayList<Double> array) {
		Collections.sort(array);
		ArrayList<Integer> intarray = new ArrayList<Integer>();
		for (Double d: array) {
			intarray.add(d.intValue());
		}
		ArrayList<Pair> count = new ArrayList<Pair>();
		for(int d: intarray) {
			
		}
	}
	*/
	
	/**
	 * @param array {@link ArrayList} of {@link app.core.data#Workout}
	 * @return {@link app.core.data.Exercise} which is the most used in the input array
	 */
	public static Exercise mostUsedExercise(ArrayList<Workout> array) {
		//workout.getType() == Exersice.RUNNING;
		ArrayList<Exercise> liste = new ArrayList<Exercise>(); 
		ArrayList<Integer> count = new ArrayList<Integer>();
		for (Exercise e : Exercise.values()) { //goes through the different instances of exercise and adds it to the ArrayList, liste, of exercises
			liste.add(e);
			count.add(0);
		}
		//System.out.println(liste);
		
		for (Workout w:array) { //goes through the different workouts in the array given.
			int ex = 0;
			while(w.getType()!=liste.get(ex)) {
				ex++;
			}
			count.set(ex, count.get(ex)+1); //counts the kind of exercise the workout uses
		}
		int max = Collections.max(count);  
		int index = count.indexOf(max);
		return liste.get(index); //returns the type of exersice that occurs the most in the array given in this method
		
	}
	
	
	public static void main(String[] args) 
	{
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.add(2.9);
		liste.add(2.1);
		liste.add(2.3);
		Double median = computeMedian(liste);
		System.out.println(median);
		
		ArrayList<Workout> liste1 = new ArrayList<Workout>();
		double tall = 70;
		
		
	}
}
