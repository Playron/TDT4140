package tdt4140.gr1805.app.core.data;

public class DataGathering{
	private boolean gps;
	private boolean pulse;

	

	public DataGathering() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataGathering(boolean GPS, boolean PULSE){
		this.gps=GPS;
		this.pulse=PULSE;
	}

	public void setGPSGathering(boolean GPSinput) {
		gps=GPSinput;
	}

	public void setPulseGathering(boolean PULSEinput) {
		pulse=PULSEinput;
	}

	public boolean getGPS() {
		return gps;
	}
	
	public boolean getPULSE() {
		return pulse;
	}
	
}