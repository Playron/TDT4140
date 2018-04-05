
package tdt4140.gr1805.app.core.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author
 *
 */
public class DataPoint
{
	// TODO: Add comments explaining what id, timestamp, pulse, location is referring to.
	int id;
	Date timestamp;
	double pulse;
	LatLong location;

	/**
	 * @param id
	 * @param timestamp
	 * @param pulse
	 * @param location
	 */
	@JsonCreator
	public DataPoint(@JsonProperty("id") int id, @JsonProperty("timestamp") Date timestamp,
			@JsonProperty("pulse") double pulse, @JsonProperty("location") LatLong location)
	{
		this.id = id;
		this.timestamp = timestamp;
		this.pulse = pulse;
		this.location = location;
	}

	// Constructor without location, default null
	/**
	 * @param id
	 * @param timestamp
	 * @param pulse
	 */
	public DataPoint(int id, Date timestamp, double pulse)
	{
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
	public Date getTimestamp()
	{
		return timestamp;
	}

	/**
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp)
	{
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
