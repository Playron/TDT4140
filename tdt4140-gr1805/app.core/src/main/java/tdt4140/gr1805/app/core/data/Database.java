package tdt4140.gr1805.app.core.data;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import tdt4140.gr1805.app.core.Random;
import tdt4140.gr1805.app.core.person.City;
import tdt4140.gr1805.app.core.person.Gender;
import tdt4140.gr1805.app.core.person.Person;

import javax.swing.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;

/* 
 * The Database object reads from its files when initialized, but 
 * writing back to the files is not automatic, so remember to use
 * one of the write-functions after modifying anything.
 */

@SuppressWarnings("WeakerAccess")
public class Database {

	private HashMap<Integer, Person> people;
	private ArrayList<DataPoint> datapoints;
	private ArrayList<Workout> workouts;
	private ObjectMapper mapper = new ObjectMapper();


	public Database() {
		this.people = new HashMap<>();
		this.datapoints = new ArrayList<>();
		this.workouts = new ArrayList<>();
		
		mapper.findAndRegisterModules();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
		
		try {
			readObjects();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Used by the Database on initialization. Should not normally be used
	 * explicitly otherwise.
	 *
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private void readObjects() throws JsonParseException, JsonMappingException, IOException {
		readPeople();
		readDatapoints();
		readWorkouts();
	}

	// TODO: Add documentation to readPeople() in Database.java.
	public void readPeople() throws IOException {
		InputStream input = getClass().getResourceAsStream("/tdt4140/gr1805/app/core/people.json");
		this.people = mapper.readValue(input, new TypeReference<HashMap<Integer, Person>>() {
		});
		input.close();

	}

	// TODO: Add documentation to readDatapoints() in Database.java
	public void readDatapoints() throws IOException {
		InputStream input = getClass().getResourceAsStream("/tdt4140/gr1805/app/core/datapoints.json");
		this.datapoints = mapper.readValue(input, new TypeReference<ArrayList<DataPoint>>() {
		});
		input.close();
	}

	// TODO: Add documentation to readWorkouts() in Database.java
	public void readWorkouts() throws IOException {
		InputStream input = getClass().getResourceAsStream("/tdt4140/gr1805/app/core/workouts.json");
		this.workouts = mapper.readValue(input, new TypeReference<ArrayList<Workout>>() {
		});
		input.close();
	}

	/**
	 * Saves changes made to the Database object to the files.
	 * Must be used explicitly every time database has been
	 * modified./tdt4140.gr1805.app.core/src/main/resources/tdt4140/gr1805/app/core/people.js
	 *
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void writeObjects() throws JsonGenerationException, JsonMappingException, IOException, URISyntaxException {
		writePeople(this.people);
		writeDataPoints(this.datapoints);
		writeWorkouts(this.workouts);
	}

	// TODO: Add documentation to writePeopl() in Database.java
	public void writePeople(HashMap<Integer, Person> people) throws IOException, URISyntaxException {
		URL url = getClass().getResource("/tdt4140/gr1805/app/core/people.json");
		OutputStream output = new FileOutputStream(new File(url.toURI()));
		mapper.writeValue(output, people);
		output.close();
	}

	// TODO: Add documentation to writeDataPoints() in Database.java
	public void writeDataPoints(ArrayList<DataPoint> datapoints) throws IOException, URISyntaxException {
		URL url = getClass().getResource("/tdt4140/gr1805/app/core/datapoints.json");
		OutputStream output = new FileOutputStream(new File(url.toURI()));
		mapper.writeValue(output, datapoints);
		output.close();
	}

	// TODO: Add documentation to writeWorkouts() in Database.java
	public void writeWorkouts(ArrayList<Workout> workouts) throws IOException, URISyntaxException {
		URL url = getClass().getResource("/tdt4140/gr1805/app/core/workouts.json");
		OutputStream output = new FileOutputStream(new File(url.toURI()));
		mapper.writeValue(output, workouts);
		output.close();
		
	}


	/**
	 * @return HashMap of all people in the database.
	 */
	public HashMap<Integer, Person> getAllPeople() {
		return people;
	}

	/**
	 * @return ArrayList of every DataPoint in the database.
	 */
	public ArrayList<DataPoint> getAllDatapoints() {
		return datapoints;
	}

	/**
	 * @return ArrayList of every Workout in the database.
	 */
	public ArrayList<Workout> getAllWorkouts() {
		return workouts;
	}


	// PERSON

	/**
	 * Adds a Person to the database. Expects a Person
	 * object with no ID. If ID is provided, it will be
	 * ignored and the next available number is chosen.
	 *
	 * @param person Person to be added
	 */
	public void addPerson(Person person) {
		int nextID;
		try {
			nextID = Collections.max(this.people.keySet()) + 1;
		} catch (NoSuchElementException e) {
			nextID = 1;
		}
		person.setID(nextID);
		this.people.put(nextID, person);
	}

	/**
	 * Returns the Person with the provided ID.
	 * If the ID does not exist, returns null
	 *
	 * @param id
	 * @return Person or null
	 */
	public Person getPerson(int id) {
		return this.people.getOrDefault(id, null);
	}

	/**
	 * Updates a Person in the database to correspond to the Person object
	 * passed to the function. Does nothing if the ID of the Person argument
	 * does not already exist in the database.
	 *
	 * @param person
	 */
	public void updatePerson(Person person) {
		int id = person.getID();
		if (this.people.keySet().contains(id)) {
			this.people.put(id, person);
		} else {
			System.err.println("Can't update: no existing Person with that ID.");
		}
	}

	/**
	 * Sets the gatherLocation boolean of a Person in the database.
	 *
	 * @param id    ID of Person
	 * @param state true or false
	 */
	public void setPersonGatherLocation(int id, boolean state) {
		this.people.get(id).setGatherLocation(state);
	}

	/**
	 * Removes a Person entry from the database, and cascades to
	 * remove all related DataPoints and Workouts.
	 *
	 * @param id ID of Person to be removed
	 */
	public void removePerson(int id) {
		this.people.remove(id);

		ArrayList<Integer> indexes = new ArrayList<>();
		for (int i = 0; i < this.datapoints.size(); i++) {
			if (this.datapoints.get(i).getID() == id) {
				indexes.add(i);
			}
		}
		for (int i : indexes) {
			this.datapoints.remove(i);
		}

		indexes.clear();
		for (int i = 0; i < this.workouts.size(); i++) {
			if (this.workouts.get(i).getID() == id) {
				indexes.add(i);
			}
		}
		for (int i : indexes) {
			this.workouts.remove(i);
		}
	}

	// DATAPOINTS

	/**
	 * Adds a single DataPoint to the database.
	 *
	 * @param point DataPoint to be added
	 */


	public void addPoint(DataPoint point) {
		Person p = getPerson(point.getID());
		if (p == null) {
			System.err.println("Cannot add DataPoint. No person exists with that ID.");
		}
		else if (!p.isGatherLocation()) {
			point.setLocation(null);
			this.datapoints.add(point);
		}
		else {
			this.datapoints.add(point);
		}
	}

	/**
	 * Returns every DataPoint related to the Person by
	 * the provided ID.
	 *
	 * @param id ID of datapoints to retrieve
	 * @return ArrayList of datapoints
	 */
	public ArrayList<DataPoint> getPointsByID(int id) {
		ArrayList<DataPoint> points = new ArrayList<>();
		for (DataPoint point : this.datapoints) {
			if (point.getID() == id) {
				points.add(point);
			}
		}
		return points;
	}

	/**
	 * Returns all DataPoints for either men or women.
	 *
	 * @param gender Gender enumeration
	 * @return ArrayList of datapoints
	 */
	public ArrayList<DataPoint> getPointsByGender(Gender gender) {
		ArrayList<DataPoint> points = new ArrayList<>();
		for (DataPoint point : this.datapoints) {
			Person person = this.getPerson(point.getID());
			if (person != null && person.getGender() == gender) {
				points.add(point);
			}
		}
		return points;
	}

	public ArrayList<DataPoint> getPointsByCity(City city) {
		ArrayList<DataPoint> points = new ArrayList<>();
		for (DataPoint point : this.datapoints) {
			Person person = this.getPerson(point.getID());
			if (person != null && person.getCity() == city) {
				points.add(point);
			}
		}
		return points;
	}


	/**
	 * Returns all DataPoints in an inclusive age range.
	 *
	 * @param minAge
	 * @param maxAge
	 * @return
	 */
	public ArrayList<DataPoint> getPointsByAgeRange(int minAge, int maxAge) {
		ArrayList<DataPoint> points = new ArrayList<>();
		for (DataPoint point : this.datapoints) {
			Person person = this.getPerson(point.getID());
			if (person != null) {
				int age = person.getAge();
				if (minAge <= age && age <= maxAge) {
					points.add(point);
				}
			}

		}
		return points;
	}

	public ArrayList<DataPoint> getPointsByTimeInterval(LocalDateTime start, LocalDateTime end) {
		ArrayList<DataPoint> points = new ArrayList<>();
		for (DataPoint point : this.datapoints) {
			if (!point.timestamp.isBefore(start) && !point.timestamp.isAfter(end)) {
				points.add(point);
			}
		}
		return points;
	}


	// WORKOUTS

	/**
	 * Adds a single Workout to the database.
	 *
	 * @param workout Workout to be added
	 */
	public void addWorkout(Workout workout) {
		if (getPerson(workout.getID()) == null) {
			System.err.println("Cannot add Workout. No person exists with that ID.");
		}
		else {
		    for (DataPoint point : workout.getDatapoints()) {
                if (point.getID() != workout.getID()) {
					System.err.println("Cannot add Workout. Not all DataPoints match Workout ID.");
					return;
				}
            }
            // Workout is valid and refers to an existing Person
			this.workouts.add(workout);
		}
	}

	/**
	 * Returns every Workout related to the Person by
	 * the provided ID.
	 *
	 * @param id ID of datapoints to retrieve
	 * @return ArrayList of workouts
	 */
	public ArrayList<Workout> getWorkoutsByID(int id) {
		ArrayList<Workout> workouts = new ArrayList<>();
		for (Workout workout : this.workouts) {
			if (workout.getID() == id) {
				workouts.add(workout);
			}
		}
		return workouts;
	}

	/**
	 * Returns all Workouts for either men or women.
	 *
	 * @param gender Gender enumeration
	 * @return ArrayList of workouts
	 */
	public ArrayList<Workout> getWorkoutsByGender(Gender gender) {
		ArrayList<Workout> workouts = new ArrayList<>();
		for (Workout workout : this.workouts) {
			Person person = this.getPerson(workout.getID());
			if (person != null && person.getGender() == gender) {
				workouts.add(workout);
			}
		}
		return workouts;
	}

	public ArrayList<Workout> getWorkoutsByCity(City city) {
		ArrayList<Workout> workouts = new ArrayList<>();
		for (Workout workout : this.workouts) {
			Person person = this.getPerson(workout.getID());
			if (person != null && person.getCity() == city) {
				workouts.add(workout);
			}
		}
		return workouts;
	}

	/**
	 * Returns all Workouts in an inclusive age range.
	 *
	 * @param minAge
	 * @param maxAge
	 * @return
	 */
	public ArrayList<Workout> getWorkoutsByAgeRange(int minAge, int maxAge) {
		ArrayList<Workout> workouts = new ArrayList<>();
		for (Workout workout : this.workouts) {
			Person person = this.getPerson(workout.getID());
			if (person != null) {
				int age = person.getAge();
				if (minAge <= age && age <= maxAge) {
					workouts.add(workout);
				}
			}

		}
		return workouts;
	}

	/**
	 * Returns all Workouts in an inclusive time interval.
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public ArrayList<Workout> getWorkoutsByTimeInterval(LocalDateTime start, LocalDateTime end) {
		ArrayList<Workout> workouts = new ArrayList<>();
		for (Workout workout : this.workouts) {
			ArrayList<DataPoint> points = workout.getDatapoints();
			if (!points.get(0).getTimestamp().isBefore(start) && !points.get(points.size() - 1).getTimestamp().isAfter(end)) {
				workouts.add(workout);
			}
		}
		return workouts;
	}


	// Utility functions for generating data or cleaning the database.

	// This gives us something to look at, but is not realistic data.

/*	public void populateDatabase() throws IOException, URISyntaxException {
		
		for (int i = 1; i < 201; i++) {
			DataPoint p = new DataPoint(i, LocalDateTime.now(), Math.random() * 60 + 40);
			this.addPoint(p);
		}

		for (int i = 1; i < 51; i++) {
			Exercise e;
			if (Math.random() < 0.5) {
				e = Exercise.RUNNING;
			} else {
				e = Exercise.CYCLING;
			}

			ArrayList<DataPoint> list = new ArrayList<>();
			for (int j = 1; j < 31; j++) {
				LatLong l = new LatLong(Math.random() * 180 - 90, Math.random() * 360 - 180);
				DataPoint p = new DataPoint(i, LocalDateTime.now(), Math.random() * 60 + 40, l);
				list.add(p);
			}

			Workout w = new Workout(i, e, list);
			this.addWorkout(w);
		}

		Person p1 = new Person(1992, 4, 7, Gender.MALE, City.BERGEN);
		Person p2 = new Person(1981, 10, 25, Gender.FEMALE, City.OSLO);
		this.addPerson(p1);
		this.addPerson(p2);

		this.writeObjects();
	}*/

	public void populateDatabase() {
        final LocalDateTime start = LocalDateTime.of(2018, 1, 1, 0, 0);
        final LocalDateTime end = LocalDateTime.of(2018, 2, 1, 1, 0, 0);
        final int restInterval = 60;
        final int exerciseInterval = 10;

		for (int i = 0; i < 20; i++) {
            addPerson(new Person(Random.year(), Random.month(), Random.day(), Random.gender(), Random.city()));
		}

		for (Person p : this.people.values()) {
		    int id = p.getID();

			double pulse = Random.pulse();
			LocalDateTime t = start;

            while (t.isBefore(end)) {
		        addPoint(new DataPoint(id, t, pulse));
				pulse = Random.nearPulse(pulse);
				t = t.plusSeconds(restInterval);
            }

			double fitness = Random.fitness();
			for (int j = 0; j < 2; j++) {
				Workout w = new Workout(id, Random.exercise());
				pulse = Random.pulse();
				LatLong location = Random.location();
				t = Random.timeBetween(start, end);
				LocalDateTime endOfWorkout = t.plusMinutes(10);

				while (t.isBefore(endOfWorkout)) {
					w.addDataPoint(new DataPoint(id, t, pulse, location));
					pulse = Random.nearPulse(pulse);
					location = Random.nearLocation(location, fitness);
					t = t.plusSeconds(exerciseInterval);
				}
				addWorkout(w);
			}
		}
	}

	/* Empties the entire database in memory. Still needs to be followed
	by writeObjects() to write to disk.*/
	public void cleanDatabase() throws IOException, URISyntaxException {
		HashMap<Integer, Person> emptyPeople = new HashMap<>();
		ArrayList<DataPoint> emptyDatapoints = new ArrayList<>();
		ArrayList<Workout> emptyWorkouts = new ArrayList<>();
		this.writePeople(emptyPeople);
		this.writeDataPoints(emptyDatapoints);
		this.writeWorkouts(emptyWorkouts);
		this.people.clear();
		this.datapoints.clear();
		this.workouts.clear();
	}

	public static void main (String[]args) throws IOException {
		//Uncomment to generate data
		
//		Database db = new Database();
//		try {
//			db.cleanDatabase();
//			db.populateDatabase();
//			db.writeObjects();
//		} catch (URISyntaxException e1) {
//			e1.printStackTrace();
//		}
	}
}
