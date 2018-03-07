package tdt4140.gr1805.app.core.data;

import java.util.ArrayList;
import java.util.Date;

public class Workout {
	
	private int id;
	private String type;
	private Date startTime;
	private Date endTime;
	private ArrayList<DataPoint> dataPoints;
	
	// Nødvendig for å lage et Workout-objekt fra JSON.
	public Workout() {
		super();
	}

	public Workout(int id, String type, Date startTime, Date endTime, ArrayList<DataPoint> dataPoints) {
		super();
		this.id = id;
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dataPoints = dataPoints;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public ArrayList<DataPoint> getDataPoints() {
		return dataPoints;
	}
	
	public void setDataPoints(ArrayList<DataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}
	
}
