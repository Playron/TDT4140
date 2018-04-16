
package tdt4140.gr1805.app.core.analysis;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;


import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.util.Pair;

import tdt4140.gr1805.app.core.data.Exercise;
import tdt4140.gr1805.app.core.data.Workout;
import java.util.List;

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
			if (point.getTimestamp().isAfter(timeStart)) {
				if(point.getTimestamp().isBefore(timeEnd)) {
					points.add(point);
				}
				
			}
		}
		return points;
	}
	

	private static Double averageBPMhelper(ArrayList<DataPoint>dp){ //computes the average beats per minute from a list of datapoints
		Double result = 0.0; 					//creates a variable that will be the average BPM
		int count = 0; 							// Variable to count how many datapoints/BPM we've gone through
		for(DataPoint point:dp) {
			count ++;							//counts +1 for every datapoint we go through
			result = result + point.getPulse();	// adds up every datapoint
		}
		result = result/count;					//computes the average BPM by adding all the BPM and devides it on the amount of datapoints used
		return result;							// returns averageBPM
	}
	
	
	// TODO: finish documentation of averageBPM
	/**
	 * @param dp
	 * @param timeStart
	 * @param timeEnd
	 * @param deler
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Pair<LocalDateTime, Double>> averageBPM(ArrayList<DataPoint> dp, LocalDateTime timeStart, 
			LocalDateTime timeEnd, int deler) throws Exception{
		if (timeEnd.isBefore(timeStart)) { 									//Checks that endtime is before starttime
			//System.out.println("hey");
			throw new IllegalArgumentException("The starttime needs to be before the endtime");
		}
		ArrayList<DataPoint> points= new ArrayList<DataPoint>(); 				// Make an arraylist with the datapoints
																				// within our timeframe
		for (DataPoint point:dp) {												// goes through all the datapoints and 
																				// adds the ones within the timeframe
			if (point.getTimestamp().isAfter(timeStart)) {
				if(point.getTimestamp().isBefore(timeEnd)) {
					points.add(point);
				}
				
			}
		}
		Duration intervall = Duration.between(timeStart,timeEnd);					// Gets the timeframe between the 
																					// starttime and endtime
		long intervallsekund = intervall.getSeconds();								// Creates a long with the seconds 
																					// of the timeframe
		
		long intervallDeler = intervallsekund/deler;							// Divides the timeframe into how 
																				// many parts they want it devided into
		ArrayList<Pair<LocalDateTime, Double>> result = new ArrayList<Pair<LocalDateTime, Double>>();
		for(int i = 0; i< deler;i++) {														// creates a pair with time and averageBPM for all the parts they want it devided into
			LocalDateTime intervallStart = timeStart.plusSeconds(intervallDeler*i); 			// creates variable for the intervall start
			
			LocalDateTime intervallEnd = timeStart.plusSeconds(intervallDeler*(i+1)); 		// creates variable for intervall end
			ArrayList<DataPoint> intervalldp = PointsByTime(dp, intervallStart, intervallEnd); // gets the datapoints within the intervall
			LocalDateTime intervallDisplay = intervallStart.plusSeconds(intervallDeler/2);	// creates a LocalTimeDate that will be connected with the average BPM within the time frame. 
			Pair<LocalDateTime,Double> intervallArray= new Pair<LocalDateTime,Double>(intervallDisplay, averageBPMhelper(intervalldp)); //create a pair of the intervallDisplay and average BPM within the time frame
			result.add(intervallArray);														// adds the pair of time and ABPM
		}
		return result;																		//returns the list of pairs of LocalDateTime and ABPM
		
	}
	
	/**
	 * @param start The {@link LocalDateTime} for the startpoint used in calculations.
	 * @param end The {@link LocalDateTime} for the endpoint used in calculations.
	 * @return A list of datapoints within the interval.
	 */
	public static final List<DataPoint> getDataPointList(LocalDateTime start, LocalDateTime end)
	{
		Database db = new Database();
		List<DataPoint> points = db.getAllDatapoints();
		points = Statistics.getDataPointsInInterval(start, end, points, false);
		
		return points;
	}
	
	/**
	 * @param start	The {@link LocalDateTime} for the startpoint used in calculations.
	 * @param end	The {@link LocalDateTime} for the endpoint used in calculations.
	 * @param userID The ID of the user whose Datapoints we calculate on
	 * @return	A list of datapoints within the interval belonging to the user.
	 */
	public static final List<DataPoint> getDataPointListByID(LocalDateTime start, LocalDateTime end, int userID)
	{
		Database db = new Database();
		List<DataPoint> userPoints = db.getPointsByID(userID);
		userPoints = Statistics.getDataPointsInInterval(start, end, userPoints, false);
		
		return userPoints; 
	}
	
	/**
	 * @param start	The {@link LocalDateTime} for the startpoint used in calculations.
	 * @param end The {@link LocalDateTime} for the endpoint used in calculations.
	 * @param p	The List of Datapoints used for creating the resturned list.
	 * @param pruneOrgList A boolean on whether we should remove the objects added to the returned list.
	 * @return A List of datapoints within the interval.
	 */
	public static final List<DataPoint> getDataPointsInInterval(LocalDateTime start, LocalDateTime end, List<DataPoint> p, boolean pruneOrgList)
	{
		List<DataPoint> output = new ArrayList<>();
		for (int i = 0; i < p.size(); i++)
		{				// Culls the list such that we only get the dataPoints in the interval specified.
			if (start.isBefore(p.get(i).getTimestamp()) && end.isAfter(p.get(i).getTimestamp()))
			{
				output.add(p.get(i));
			}
		}
		if (pruneOrgList)
		{
			for (int i = 0; i < output.size(); i++)
			{
				p.remove(output.get(i));
			}
		}
		
		return output; 
	}
	
	public static final Series<Number, Number> averagePulseSeries(LocalDateTime start, LocalDateTime end, 
			int parts)
	{
		List<DataPoint> input = Statistics.getDataPointList(start, end);	
		List<LocalDateTime> beforeDates = Statistics.getIntervalDateTimes(start, end, parts);
		
		List<Number> pulse = Statistics.getPulse(beforeDates, input);
		// Now we have a list of Numbers which is the pulse in an interval, which has the index 0 for the first interval
		// and the index n for the n+1'th interval
		
		Series<Number, Number> output = Statistics.getSeriesFromIntervalPulses(pulse);
		
		return output; 
	}
	
	/**
	 * @param beforeDates A list of ending dates for the intervals, where the first 0th date is the startdate.
	 * @param input A list of Datapoints we need for making the list
	 * @return A list of pulses mapped to the interval, with the 0th index being the first interval from the startpoint
	 */
	public static final List<Number> getPulse(List<LocalDateTime> beforeDates, List<DataPoint> input)
	{
		List<Number> pulse = new ArrayList<>();
		
		for (int i = 0; i+1 < beforeDates.size(); i++)
		{
			List<DataPoint> intervalPoints = new ArrayList<>();
			intervalPoints = Statistics.getDataPointsInInterval(beforeDates.get(i), beforeDates.get(i+1), input, true);
			
		
			List<Double> intervalPulses = new ArrayList<>();
			for (int j = 0; j < intervalPoints.size(); j++)	
			{
				intervalPulses.add(new Double(intervalPoints.get(j).getPulse()));
			}
			
			pulse.add(meanDouble(intervalPulses));
		}
		
		return pulse;
	}
	
	/**
	 * @param pulse A list of mean pulses according to intervals
	 * @return A Series mapping the pulses to the intervals
	 */
	public static final Series<Number, Number> getSeriesFromIntervalPulses(List<Number> pulse)
	{
		Series<Number, Number> output = new Series<>();
		output.setName("haha");
		for (int i = 0; i < pulse.size(); i++)
		{
			if (pulse.get(i) instanceof Double && !Double.isNaN(pulse.get(i).doubleValue()))
			{
				output.getData().add(new Data<Number, Number>(-pulse.size()+i, pulse.get(i).doubleValue()));

			}
		}
		return output;
	}
	
	
	
	/**
	 * @param start The {@link LocalDateTime} for the startpoint used in calculations.
	 * @param end The {@link LocalDateTime} for the endpoint used in calculations.
	 * @param parts The number of parts we should divide into
	 * @return	A list of LocalDateTimes where the 0'th index is the date we should be starting at, and the 
	 * parts'th index is the date we should stop at.
	 */
	public static final List<LocalDateTime> getIntervalDateTimes(LocalDateTime start, LocalDateTime end, int parts)
	{
		Duration interval = Duration.between(start, end) ;
		long intervalSeconds = interval.getSeconds();
		long intervalParts = intervalSeconds/parts;
		List<LocalDateTime> beforeDates = new ArrayList<>();
		beforeDates.add(start);
		for (int i = 0; i < parts; i++)			// Creates an arrayList of LocalDateTimes which bookends the intervals.
		{
			beforeDates.add(start.plusSeconds(intervalParts*(i+1)));
		}
		
		return beforeDates; 
	}
		
	
	/**
	 * @param start The {@link LocalDateTime} for the startpoint used in calculations.
	 * @param end The {@link LocalDateTime} for the endpoint used in calculations.
	 * @param userID The userID we're interested in.
	 * @param parts	The number of intervals we want.
	 * @return	A Series that can be used by JavaFX natively.
	 */
	public static final Series<Number, Number> averagePulseSeriesByID(LocalDateTime start, LocalDateTime end, int userID, 
			int parts)
	{
		List<DataPoint> input = Statistics.getDataPointListByID(start, end, userID);
			
		List<LocalDateTime> beforeDates = Statistics.getIntervalDateTimes(start, end, parts);
		
		List<Number> pulse = Statistics.getPulse(beforeDates, input);
		// Now we have a list of Numbers which is the pulse in an interval, which has the index 0 for the first interval
		// and the index n for the n+1'th interval
		
		Series<Number, Number> output = Statistics.getSeriesFromIntervalPulses(pulse);
		
		return output;
	}

	public static final Double meanDouble(List<Double> p) 
	{
		if (p == null)
		{
			return null;
		}
	    double sum = 0;  // sum of all the elements
	    for (int i = 0; i < p.size(); i++) 
	    {
	        sum += p.get(i);
	    }
	    return new Double(sum / p.size());
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
//	 public static void main(String[] args)
//	 {
//	 ArrayList<Double> liste = new ArrayList<Double>();
//	 liste.add(2.9);
//	 liste.add(2.1);
//	 liste.add(2.3);
//	 Double median = computeMedian(liste);
//	 System.out.println(median);
//	 ArrayList<Workout> wl = exerciseCountGenerateWL();
//	 ArrayList<Pair<Exercise, Integer>> arl = exerciseCounts(wl, true);
//	 System.out.println(arl);
//	
//	 }
	
	public static void main(String[] args)
	{
		System.out.println(averagePulseSeriesByID(LocalDateTime.now().minusMonths(4), LocalDateTime.now(), 1, 120));
		
	}
}
