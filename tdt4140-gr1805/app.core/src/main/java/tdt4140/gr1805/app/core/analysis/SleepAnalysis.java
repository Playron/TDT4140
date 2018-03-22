package tdt4140.gr1805.app.core.analysis;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tdt4140.gr1805.app.core.data.DataPoint;
import tdt4140.gr1805.app.core.person.Person;
import tdt4140.gr1805.app.core.data.Database;

public class SleepAnalysis {
	
	private Date start;
	private Date end;
	private boolean sleep = false; //true = sleeping, false = awake
	
	
	
		public double hoursOfSleep() {
		double hoursOfSleep =(double) (end.getTime() - start.getTime()) / (1000*60*60); //hoursofsleep in hours
		return hoursOfSleep;
		
		}
		
		public boolean pushSleepButton() {
			if(sleep == false) {
				start = new Date();
				sleep = true;
			}
			else {
				sleep = false;
				end = new Date();
			}
			return sleep;
		}
		
	
}
