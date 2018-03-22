package tdt4140.gr1805.app.core.analysis;

import tdt4140.gr1805.app.core.data.Database;

import java.util.ArrayList;
import java.util.Date;

import tdt4140.gr1805.app.core.data.DataPoint;
import tdt4140.gr1805.app.core.data.Exercise;
import tdt4140.gr1805.app.core.data.LatLong;
import tdt4140.gr1805.app.core.data.Workout;

public class ComputeSpeed {

	
	
	
	
	public void computeAverageSpeed(Workout workout) {
		Database db = new Database();
		ArrayList<DataPoint> speedCompute = workout.getDatapoints();
		Date end_time = speedCompute.get(speedCompute.size()).getTimestamp(); 
		Date start_time = speedCompute.get(0).getTimestamp();
		for(DataPoint i : speedCompute) {
		}
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
