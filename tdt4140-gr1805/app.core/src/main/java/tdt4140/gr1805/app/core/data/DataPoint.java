package tdt4140.gr1805.app.core.data;

import java.util.Date;

public class DataPoint {
	int id;
	Date timestamp;
	int pulse;
	LatLong location = null;
	
	// Necessary to load from JSON
	public DataPoint() {
		super();
	}
	
	public DataPoint(int id, Date timestamp, int pulse, LatLong location) {
		this.id = id;
		this.timestamp = timestamp;
		this.pulse = pulse;
		this.location = location;
	}
	
	// Use if location not applicable to set it to null.
	public DataPoint(int id, Date timestamp, int pulse) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.pulse = pulse;
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
	public int getPulse() {
		return pulse;
	}
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	public LatLong getLocation() {
		return location;
	}
	public void setLocation(LatLong location) {
		this.location = location;
	}
	
	
}
