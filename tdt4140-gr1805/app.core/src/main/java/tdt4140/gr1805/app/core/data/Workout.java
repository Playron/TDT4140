package tdt4140.gr1805.app.core.data;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Workout {
	
	private int id;
	private Exercise type;
	private ArrayList<DataPoint> datapoints;

	@JsonCreator
	public Workout(
			@JsonProperty("id") int id,
			@JsonProperty("type") Exercise type,
			@JsonProperty("datapoints") ArrayList<DataPoint> datapoints) {
		this.id = id;
		this.type = type;
		this.datapoints = datapoints;
	}

	/*
	Constructor for creating a workout with an empty list of datapoints.
	Intended to be used with addDataPoint() and then added to the database
	with db.addWorkout() when complete.
	*/
	public Workout(int id, Exercise type) {
		this.id = id;
		this.type = type;
		this.datapoints = new ArrayList<>();
	}

	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public Exercise getType() {
		return type;
	}
	
	public void setType(Exercise type) {
		this.type = type;
	}
	
	public ArrayList<DataPoint> getDatapoints() {
		return datapoints;
	}
	
	public void setDatapoints(ArrayList<DataPoint> datapoints) {
		this.datapoints = datapoints;
	}

	public void addDataPoint(DataPoint point) {
		// DataPoint ID is set to match Workout ID
		point.setID(this.getID());
		this.datapoints.add(point);
		
		
	}
		
	public double calculateWorkoutDistance() {
		double distance = 0;
		for(int i = 0; i<datapoints.size()-1; i++) {
			double long1 = datapoints.get(i).location.longitude;
			double lat1 = datapoints.get(i).location.latitude;
			double long2 = datapoints.get(i+1).location.longitude;
			double lat2 = datapoints.get(i+1).location.latitude;
			distance = LatLong.distance(lat1, long1, lat2, long2);
		}
		System.out.println("The distance is: " + distance + " meters");
		return distance;
	}
		

	@Override
	public String toString() {
		String ut =  "Workout [#" + id + ", type=" + type + ", datapoints=";// + datapoints + "]";
		for (int i = 0; i < datapoints.size(); i++)
		{
			ut += "\n" + datapoints.get(i).toString();
		}
		return ut;
	}
	
	public static void main(String[] args) {
		Database db = new Database();
		ArrayList<Workout> w = db.getWorkoutsByID(2);
		Workout w2 = w.get(0);
		System.out.println(w2.calculateWorkoutDistance());
		
		
	}
	
}
