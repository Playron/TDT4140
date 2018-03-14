package tdt4140.gr1805.app.core.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class DataPoint {
	int id;
	Date timestamp;
	double pulse;
	LatLong location;
	
	@JsonCreator
	public DataPoint(
			@JsonProperty("id") int id,
			@JsonProperty("timestamp") Date timestamp,
			@JsonProperty("pulse") double pulse,
			@JsonProperty("location") LatLong location) {
		this.id = id;
		this.timestamp = timestamp;
		this.pulse = pulse;
		this.location = location;
	}
	
	// Constructor without location, default null
	public DataPoint(int id, Date timestamp, double pulse) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.pulse = pulse;
		this.location = null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public double getPulse() {
		return pulse;
	}
	public void setPulse(double pulse) {
		this.pulse = pulse;
	}
	public LatLong getLocation() {
		return location;
	}
	public void setLocation(LatLong location) {
		this.location = location;
	}
	
	
}
