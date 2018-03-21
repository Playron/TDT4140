package tdt4140.gr1805.app.core.analysis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tdt4140.gr1805.app.core.data.DataPoint;
import tdt4140.gr1805.app.core.person.Person;
import tdt4140.gr1805.app.core.data.Database;

public class SleepAnalysis {
	
	private List<DataPoint> data;
	
	//computes hours of sleep for a person with the specified id between the two specified dates
	public int hoursOfSleep(int id, Date from, Date to) {
		Database db = new Database();
		//creates list with all pulse data related to id
		data = db.getPointsByID(id);
		
		List<Double> pulse = new ArrayList<>();
		for (DataPoint d : data) {
		pulse.add(d.getPulse());
		}
		return 1;
	}
	
}
