
package tdt4140.gr1805.app.core.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

public class DataPoint
{
	int id;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	LocalDateTime timestamp;
	double pulse;
	LatLong location;
	
	
	/**
	 * @param id
	 * @param timestamp
	 * @param pulse
	 * @param location
	 */
	@JsonCreator
	public DataPoint(
			@JsonProperty("id") int id,
			@JsonProperty("timestamp") LocalDateTime timestamp,
			@JsonProperty("pulse") double pulse,
			@JsonProperty("location") LatLong location
			) {
		this.id = id;
		this.timestamp = timestamp;
		this.pulse = pulse;
		this.location = location;
	}

	// Constructor without location, default null
	public DataPoint(int id, LocalDateTime timestamp, double pulse) {
	/**
	 * @param id
	 * @param timestamp
	 * @param pulse
	 */
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.pulse = pulse;
		this.location = null;
	}
	
	/**
	 * @return
	 */
	public int getID()
	{
		return id;
	}

	/**
	 * @param id
	 */
	public void setID(int id)
	{
		this.id = id;
	}

	/**
	 * @return
	 */
	public LocalDateTime getTimestamp()
	{
		return timestamp;
	}

	/**
	 * @param timestamp
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return
	 */
	public double getPulse()
	{
		return pulse;
	}

	/**
	 * @param pulse
	 */
	public void setPulse(double pulse)
	{
		this.pulse = pulse;
	}

	/**
	 * @return
	 */
	public LatLong getLocation()
	{
		return location;
	}

	/**
	 * @param location
	 */
	public void setLocation(LatLong location)
	{
		this.location = location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	
	
	@Override
	public String toString()
	
	{
		return "DataPoint [#" + id + ", " + timestamp + ", pulse=" + pulse + ", location=" + location + "]";
	}

}
