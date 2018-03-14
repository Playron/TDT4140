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
