package tdt4140.gr1805.app.core;

import java.util.*;

public class AverageNumber {

	double getResult(List<Double> listOfDoubles) {
		double sum = 0;
		for (double number : listOfDoubles) {
			sum += number;
		}
		return Math.round(100*sum / (listOfDoubles.size())/100);
	}
}






//public static void main(String[] args) {
//AverageNumber avg = new AverageNumber();
//List<Double> alist = new ArrayList<>(Arrays.asList(1.38, 2.56, 4.3));
//System.out.println(avg.getResult(alist));}