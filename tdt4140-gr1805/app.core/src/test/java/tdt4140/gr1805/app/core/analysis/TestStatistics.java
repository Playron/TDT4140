package tdt4140.gr1805.app.core.analysis;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import tdt4140.gr1805.app.core.data.DataPoint;
import tdt4140.gr1805.app.core.data.Database;
import tdt4140.gr1805.app.core.data.Exercise;
import tdt4140.gr1805.app.core.data.LatLong;
import tdt4140.gr1805.app.core.data.Workout;

public class TestStatistics {
	private static Date localDateTimeToDate(LocalDateTime date) {
		return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
	}

	@Test
	public void testComputeMedian1() {
		ArrayList<Double> liste = new ArrayList<Double>();
		liste.add(2.9);
		liste.add(2.1);
		liste.add(2.3);
		Double median = Statistics.computeMedian(liste);
		Double actual = 2.3;
		assertEquals(median, actual);
	}
	
	@Test
	public void testComputeMedian2() {
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
	public void testmostUsedExercise1() {
		ArrayList<Workout> liste1 = new ArrayList<Workout>();
		LatLong exempelLat = new LatLong(2.1,2.2);
		Date dato = new Date(0);
		double tall = 70;
		DataPoint point = new DataPoint(2, dato, tall);
		ArrayList<DataPoint> dpa = new ArrayList<DataPoint>();
		dpa.add(point);
		dpa.add(point);
		Workout w = new Workout(2,Exercise.RUNNING, dpa);
		liste1.add(w);
		for (int i = 0; i < 4; i++) {
			Workout a = new Workout(2,Exercise.CYCLING, dpa);
			liste1.add(a);
		}
		Exercise expected = Exercise.CYCLING;
		Exercise mostused = Statistics.mostUsedExercise(liste1);
		assertEquals(expected, mostused);
	}
	
	@Test
	public void testmostUsedExercise2() {
		ArrayList<Workout> liste1 = new ArrayList<Workout>();
		LatLong exempelLat = new LatLong(2.1,2.2);
		Date dato = new Date(0);
		double tall = 70;
		DataPoint point = new DataPoint(2, dato, tall);
		ArrayList<DataPoint> dpa = new ArrayList<DataPoint>();
		dpa.add(point);
		dpa.add(point);
		Workout w = new Workout(2,Exercise.RUNNING, dpa);
		liste1.add(w);
		for (int i = 0; i < 4; i++) {
			Workout a = new Workout(2,Exercise.RUNNING, dpa);
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
		System.out.println(dato.getTime());
		DataPoint dp = new DataPoint(1, dato, 65);
		dpa.add(dp);
		for(int i = 0; i<10; i++) {
			LocalDateTime date1 = LocalDateTime.of(2015, 7, 22, 3, 54, 12, 22);
			Date dato1 = localDateTimeToDate(date1);
			System.out.println(dato1.getTime());
			DataPoint dp1 = new DataPoint(1, dato1, 70);
			dpa.add(dp1);
		}
		System.out.println(dpa);
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
		System.out.println(result);
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
	
	

}
