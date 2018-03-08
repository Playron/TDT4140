package tdt4140.gr1805.app.core.data;

public class LatLong {

	public final double latitude, longitude;
	
	public LatLong(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public static double distance(double lat1, double lon1, double lat2, double lon2) {
		if (lon1 == lon2 && lat1 == lat2) {
			return 0.0;
		}
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		// convert to degrees
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		// convert to meters 
		dist = dist * 1609.344;
		return dist;
	}
	
	public static double distance(LatLong latLong1, LatLong latLong2) {
		return distance(latLong1.latitude, latLong1.longitude, latLong2.latitude, latLong2.longitude);
	}
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	@Override
	public String toString() {
		return latitude + "," + longitude;
	}
	
	public static void main(String[] args) {
		LatLong latlong1 = new LatLong(60, 20);
		LatLong latlong2 = new LatLong(0, 0);
		System.out.println(distance(latlong1, latlong2));
	}
}
