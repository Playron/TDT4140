package tdt4140.gr1805.app.core.data;

public class DataGathering{
	private boolean GPS;
	private boolean PULSE;


	public DataGathering(boolean GPS, boolean PULSE){
		this.GPS=GPS;
		this.PULSE=PULSE;
	}

	public void setGPSGathering(boolean GPSinput) {
		GPS=GPSinput;
	}

	public void setPulseGathering(boolean PULSEinput) {
		PULSE=PULSEinput;
	}

	public boolean getGPS() {
		return GPS;
	}
	
	public boolean getPULSE() {
		return PULSE;
	}
	
}