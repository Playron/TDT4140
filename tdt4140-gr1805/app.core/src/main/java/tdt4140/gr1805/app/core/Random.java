package tdt4140.gr1805.app.core;

import tdt4140.gr1805.app.core.data.Exercise;
import tdt4140.gr1805.app.core.data.LatLong;
import tdt4140.gr1805.app.core.person.City;
import tdt4140.gr1805.app.core.person.Gender;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/*public final class Random {
    private static final java.util.Random R = new java.util.Random();
    private static final List<City> CITIES = Arrays.asList(City.values());
    private static final List<Exercise> EXERCISES = Arrays.asList(Exercise.values());

    public static City city() {
        return CITIES.get(R.nextInt(CITIES.size()));
    }

    public static Exercise exercise() {
        return EXERCISES.get(R.nextInt(EXERCISES.size()));
    }

    public static Gender gender() {
        return R.nextBoolean() ? Gender.MALE : Gender.FEMALE;
    }

    public static int year() {
        return R.nextInt(60) + 1940;
    }

    public static int month() {
        return R.nextInt(12) + 1;
    }

    public static int day() {
        return R.nextInt(28) + 1;
    }

    public static LocalDate date() {
        return LocalDate.of(year(), month(), day());
    }

    public static double pulse(Boolean workoutBool) {
    		if (workoutBool == false) {
    			return Math.random() * 40 + 40;
    		}
    		return Math.random() * 55 + 100;
    }
    
    //A function that randomly generates a pulse based on last recorded pulse
    public static double nearPulse(double pulse, Boolean workoutBool) {
    		double rnd = Math.random() * 5;
    		if ((pulse < 40) || (workoutBool == true && pulse < 80)) {
    			return pulse+rnd;
    		}
    		else if ((pulse > 100) || (workoutBool == true && pulse > 210)){
    			return pulse-rnd;
    		}
    		return pulse + rnd *(R.nextBoolean() ? 1 : -1);
    		
    }

    public static LatLong location() {
        return new LatLong(Math.random() * (71 - 58) + 58, Math.random() * (31 - 5) + 5);
    }

    public static LatLong nearLocation(LatLong location, double fitness) {
        double latDelta = Math.random() * (0.001 - 0.0003) * fitness + 0.0003;
        latDelta = latDelta * (R.nextBoolean() ? 1 : -1);
        double longDelta = Math.random() * (0.0015 - 0.0005) * fitness + 0.0005;
        longDelta = longDelta * (R.nextBoolean() ? 1 : -1);
        return new LatLong(location.latitude + latDelta, location.longitude + longDelta);
    }

    public static double fitness() {
        return Math.random() + 1;
    }

    public static LocalDateTime timeBetween(LocalDateTime start, LocalDateTime end) {
        return start.plusMinutes((long) (Math.random()*Duration.between(start, end).toMinutes()));
    }

}
*/