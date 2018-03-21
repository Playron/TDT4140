package tdt4140.gr1805.app.core.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Statistics {
	
	
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
	
	public static void main(String[] args) {
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.add(2.9);
		liste.add(2.1);
		liste.add(2.3);
		liste.add(2.0);
		Double median = computeMedian(liste);
		System.out.println(median);
	}
}
