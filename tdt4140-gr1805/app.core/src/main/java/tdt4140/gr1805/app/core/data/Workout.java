package tdt4140.gr1805.app.core.data;

import java.util.ArrayList;
import java.util.Date;

public class Workout {
	
	private int id;
	private Exercise type;
	private ArrayList<DataPoint> datapoints;
	
	// Nødvendig for å lage et Workout-objekt fra JSON.
	public Workout() {
		super();
	}

	public Workout(int id, Exercise type, ArrayList<DataPoint> datapoints) {
		this.id = id;
		this.type = type;
		this.datapoints = datapoints;

	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
}
