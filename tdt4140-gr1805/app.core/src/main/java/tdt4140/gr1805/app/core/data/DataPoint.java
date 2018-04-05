
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
	
	
	// TODO: explain all the parameters below in the Javadoc
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
	// TODO: explain all the parameters below in the Javadoc
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
	
	// TODO: explain what it returns in the Javadoc
	/**
	 * @return
	 */
	public int getID()
	{
		return id;
	}

	// TODO: explain what it returns in the Javadoc
	/**
	 * @param id
	 */
	public void setID(int id)
	{
		this.id = id;
	}

	// TODO: explain what it returns in the Javadoc
	/**
	 * @return
	 */
	public Date getTimestamp()
	{
		return timestamp;
	}

	// TODO: explain parameter in the Javadoc
	/**
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}

	// TODO: explain what it returns in the Javadoc
	/**
	 * @return
	 */
	public double getPulse()
	{
		return pulse;
	}

	// TODO: explain parameter in the Javadoc
	/**
	 * @param pulse
	 */
	public void setPulse(double pulse)
	{
		this.pulse = pulse;
	}

	// TODO: explain what it returns in the Javadoc
	/**
	 * @return
	 */
	public LatLong getLocation()
	{
		return location;
	}

	// TODO: explain parameter in the Javadoc
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
