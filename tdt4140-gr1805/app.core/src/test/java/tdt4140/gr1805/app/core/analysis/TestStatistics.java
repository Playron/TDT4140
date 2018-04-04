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
	public void testAverageBPM1() {
		
		ArrayList<DataPoint> dpa = new ArrayList<DataPoint>();
		LocalDateTime date = LocalDateTime.of(2017, 8, 22, 3, 54);
		Date dato = localDateTimeToDate(date);
		System.out.println(dato.getTime());
		
	}
	
	

}
