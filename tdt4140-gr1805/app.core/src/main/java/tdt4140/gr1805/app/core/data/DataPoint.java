package tdt4140.gr1805.app.core.data;

public class DataPoint extends DataGathering{


	public DataPoint(boolean GPS, boolean PULSE, DataGathering DGL) {
		super(GPS, PULSE);
		//Auto-generated constructor stub
	}

	public void includePulse(){
		//TODO
		//if DGL.getPulse returns false, the update() method writes the attribute as NULL 

	}

	public void includeGPS(){
		//TODO
		//if DGL.getGPS returns false, the update() method writes the attribute as NULL 
	}

	public void addUpdate() {
		//checks if GPS and Pulse should be included
		//method makes a datapoint with (time, pulse, GPS)-attributes and adds them to the database/file
	}

}
