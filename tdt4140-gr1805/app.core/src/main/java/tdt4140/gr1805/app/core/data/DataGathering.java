package tdt4140.gr1805.app.core.data;

public class DataGathering{

	public boolean gpsbool, pulsebool, optout;
	public int gpsdata, pulsedata;

	public DataGathering(){
		this.gpsbool=true;
		this.pulsebool=true;
		this.optout=false;
	}

	public void setGPSGathering(boolean GPSenabled) {
		gpsbool=GPSenabled;
	}

	public void setPulseGathering(boolean PULSEenabled) {
		pulsebool=PULSEenabled;
	}

	public boolean getGPSbool() {
		return gpsbool;
	}

	public boolean getPULSEbool() {
		return pulsebool;
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
		optout=toggleOO;
	}

	public boolean getOptOut() { //use this method before calling addUpdate
		return optout;
	}
}