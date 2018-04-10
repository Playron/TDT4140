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

	@Override
	public String toString() {
		String ut =  "Workout [#" + id + ", type=" + type + ", datapoints=";// + datapoints + "]";
		for (int i = 0; i < datapoints.size(); i++)
		{
			ut += "\n" + datapoints.get(i).toString();
		}
		return ut;
	}
	
	
	
}
