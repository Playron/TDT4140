package tdt4140.gr1805.app.core.data;

import java.util.ArrayList;

import tdt4140.gr1805.app.core.person.*;

public class Database {
	
	private Liste personList;
	private ArrayList<DataPoint> dataPoints;
	private ArrayList<Workout> workouts;
	
	public Database(Liste personList, ArrayList<DataPoint> dataPoints, ArrayList<Workout> workouts) {
		super();
		this.personList = personList;
		this.dataPoints = dataPoints;
		this.workouts = workouts;
	}
	
	public Liste getPersonList() {
		return personList;
	}
	public void setPersonList(Liste personList) {
		this.personList = personList;
	}
	public ArrayList<DataPoint> getDataPoints() {
		return dataPoints;
	}
	public void setDataPoints(ArrayList<DataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}
	public ArrayList<Workout> getWorkouts() {
		return workouts;
	}
	public void setWorkouts(ArrayList<Workout> workouts) {
		this.workouts = workouts;
	}

	
	
}
