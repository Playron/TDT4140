package tdt4140.gr1805.app.core.data;

public class DataGathering{
	public boolean GPSbool, PULSEbool;
	public int gpsdata, pulsedata;


	public DataGathering(){
		this.GPSbool=true;
		this.PULSEbool=true;
	}

	public void setGPSGathering(boolean GPSenabled) {
		GPSbool=GPSenabled;
	}

	public void setPulseGathering(boolean PULSEenabled) {
		PULSEbool=PULSEenabled;
	}

	public boolean getGPSbool() {
		return GPSbool;
	}

	public boolean getPULSEbool() {
		return PULSEbool;
	}

	public void addUpdate() {
		if (getPULSEbool()==false){pulsedata=0;}
		if (getGPSbool()==false){gpsdata=0;}
		//TODO
		//addUpdate gathers Z
	}
}