package tdt4140.gr1805.app.core.data;

public class DataGatheringLimits {

	public void gatherGPS(boolean input) {
		UpdateDataPoint.includeGPS(input);

	}

	public void gatherPulse(boolean input) {
		UpdateDataPoint.includePulse(input);
	}
}