package tdt4140.gr1805.app.core.data;

public class DataGathering{

	public boolean GPSbool, PULSEbool, OPTOUT;
	public int gpsdata, pulsedata;

	public DataGathering(){
		this.GPSbool=true;
		this.PULSEbool=true;
		this.OPTOUT=false;
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

	public int getPulseData() {
		return this.pulsedata;
	}

	public int getGpsData() {
		return this.gpsdata;
	}

	public void setOptOut(boolean toggleOO) {
		OPTOUT=toggleOO;
	}

	public boolean getOptOut() { //use this method before calling addUpdate
		return OPTOUT;
	}
}