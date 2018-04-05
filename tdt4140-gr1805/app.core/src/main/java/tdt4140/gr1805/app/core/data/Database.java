package tdt4140.gr1805.app.core.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.NoSuchElementException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import tdt4140.gr1805.app.core.person.*;

import java.text.*;//delete

/* 
 * The Database object reads from its files when initialized, but 
 * writing back to the files is not automatic, so remember to use
 * one of the write-functions after modifying anything.
 */

public class Database {

	private HashMap<Integer, Person> people;
	private ArrayList<DataPoint> datapoints;
	private ArrayList<Workout> workouts;
	private ObjectMapper mapper = new ObjectMapper();


	public Database() {
		this.people = new HashMap<Integer, Person>();
		this.datapoints = new ArrayList<DataPoint>();
		this.workouts = new ArrayList<Workout>();

		mapper.findAndRegisterModules();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

		//		this.peopleFile = new File("src/main/resources/tdt4140/gr1805/app/core/people.json");
		//		this.datapointsFile = new File("src/main/resources/tdt4140/gr1805/app/core/datapoints.json");
		//		this.workoutsFile = new File("src/main/resources/tdt4140/gr1805/app/core/workouts.json");


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
	public void readPeople() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = getClass().getResourceAsStream("/tdt4140/gr1805/app/core/people.json");
		this.people = mapper.readValue(input, new TypeReference<HashMap<Integer, Person>>(){});
		input.close();

	}

	// TODO: Add documentation to readDatapoints() in Database.java
	public void readDatapoints() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = getClass().getResourceAsStream("/tdt4140/gr1805/app/core/datapoints.json");
		this.datapoints = mapper.readValue(input, new TypeReference<ArrayList<DataPoint>>(){});
		input.close();
	}

	// TODO: Add documentation to readWorkouts() in Database.java
	public void readWorkouts() throws JsonParseException, JsonMappingException, IOException {
		InputStream input = getClass().getResourceAsStream("/tdt4140/gr1805/app/core/workouts.json");
		this.workouts = mapper.readValue(input, new TypeReference<ArrayList<Workout>>(){});
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
	public void writePeople(HashMap<Integer, Person> people) throws JsonGenerationException, JsonMappingException, IOException, URISyntaxException {
		URL url = getClass().getResource("/tdt4140/gr1805/app/core/people.json");
		OutputStream output = new FileOutputStream(new File(url.toURI()));
		mapper.writeValue(output, people);
		output.close();
	}

	// TODO: Add documentation to writeDataPoints() in Database.java
	public void writeDataPoints(ArrayList<DataPoint> datapoints) throws JsonGenerationException, JsonMappingException, IOException, URISyntaxException {
		URL url = getClass().getResource("/tdt4140/gr1805/app/core/datapoints.json");
		OutputStream output = new FileOutputStream(new File(url.toURI()));
		mapper.writeValue(output, datapoints);
		output.close();
	}

	// TODO: Add documentation to writeWorkouts() in Database.java
	public void writeWorkouts(ArrayList<Workout> workouts) throws JsonGenerationException, JsonMappingException, IOException, URISyntaxException {
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
	 * If the ID does not exist, null is returned
	 * 
	 * @param id
	 * @return Person or null
	 */
	public Person getPerson(int id) {		
		if (this.people.containsKey(id)) {
			return this.people.get(id);
		}
		else {
			return null;
		}
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
		}
		else {
			System.out.println("Can't update: no existing Person with that ID");
		}
	}

	/**
	 * Sets the gatherLocation boolean of a Person in the database.
	 * 
	 * @param id	ID of Person
	 * @param state	true or false
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

		ArrayList<Integer> indexes= new ArrayList<Integer>();
		for (int i = 0; i < this.datapoints.size(); i++) {
			if (this.datapoints.get(i).getID() == id)
			{indexes.add(i);}
		}
		for (int i : indexes) {
			this.datapoints.remove(i);
		}

		indexes.clear();
		for (int i = 0; i < this.workouts.size(); i++) {
			if (this.workouts.get(i).getID() == id)
			{indexes.add(i);}
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
		Person p=getPerson(point.getID());
		if (p.isGatherLocation()==false) {
			//If Location data gathering is set to off, create a new object without latlong argument and add it
			DataPoint LoclessPoint = new DataPoint(point.getID(), point.getTimestamp(), point.getPulse());
			this.datapoints.add(LoclessPoint);

		}
		else{
			this.datapoints.add(point);}
	}

	/**
	 * Returns every DataPoint related to the Person by
	 * the provided ID.
	 * 
	 * @param id ID of datapoints to retrieve
	 * @return ArrayList of datapoints
	 */
	public ArrayList<DataPoint> getPointsByID(int id) {
		ArrayList<DataPoint> points = new ArrayList<DataPoint>();
		for (DataPoint point : this.datapoints) {
			if (point.getID() == id)
			{points.add(point);}
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
		ArrayList<DataPoint> points = new ArrayList<DataPoint>();
		for (DataPoint point: this.datapoints) {
			Person person = this.getPerson(point.getID());
			if (person != null && person.getGender() == gender) {
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
		ArrayList<DataPoint> points = new ArrayList<DataPoint>();
		for (DataPoint point : this.datapoints) {
			Person person = this.getPerson(point.getID());
			if (person != null) {
				int age = person.getAge();
				if (minAge <= age && age <= maxAge)
				{points.add(point);}
			}

		}
		return points;
	}

	// WORKOUTS

	/**
	 * Adds a single Workout to the database.
	 * @param workout Workout to be added
	 */
	public void addWorkout(Workout workout) {
		this.workouts.add(workout);
	}

	/**
	 * Returns every Workout related to the Person by
	 * the provided ID.
	 * 
	 * @param id ID of datapoints to retrieve
	 * @return ArrayList of workouts
	 */
	public ArrayList<Workout> getWorkoutsByID(int id) {
		ArrayList<Workout> workouts = new ArrayList<Workout>();
		for (Workout workout : this.workouts) {
			if (workout.getID() == id)
			{workouts.add(workout);}
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
		ArrayList<Workout> workouts = new ArrayList<Workout>();
		for (Workout workout : this.workouts) {
			Person person = this.getPerson(workout.getID());
			if (person != null && person.getGender() == gender) {
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
		ArrayList<Workout> workouts = new ArrayList<Workout>();
		for (Workout workout: this.workouts) {
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


	// Utility functions for generating data or cleaning the database.

	// This gives us something to look at, but is not realistic data.
	public void populateDatabase() throws JsonGenerationException, JsonMappingException, IOException, URISyntaxException {

		for (int i = 1; i < 201; i++) {
			DataPoint p = new DataPoint(i, new Date(), Math.random()*60+40);
			this.addPoint(p);
		}

		for (int i = 1; i < 51; i++) {
			Exercise e;
			if (Math.random() < 0.5)
			{e = Exercise.RUNNING;}
			else
			{e = Exercise.CYCLING;}

			ArrayList<DataPoint> list = new ArrayList<DataPoint>();
			for (int j = 1; j < 31; j++) {
				LatLong l = new LatLong(Math.random()*180-90, Math.random()*360-180);
				DataPoint p = new DataPoint(i, new Date(), Math.random()*60+40, l);
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
	}

	// Empties the entire database.
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


	//	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	//		Database db = new Database();
	//		try {
	//			db.cleanDatabase();
	//		} catch (URISyntaxException e1) {
	//			// TODO Auto-generated catch block
	//			e1.printStackTrace();
	//		}
	//		
	//		System.out.println(db.getAllPeople());
	//		
	//	}

	
	
	//sjekk av location gathering disabling
	/*
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Database db = new Database();
		LatLong ll = new LatLong(66.68843129, 66.22543467);

		db.cleanDatabase();
		
		Person p = new Person(1993, 01, 02, Gender.MALE, City.OSLO);
		db.addPerson(p); 
		
		p.setGatherLocation(true);
		DataPoint dp1 = new DataPoint(1, date, 100, ll);
		System.out.println(dp1.toString());
		db.addPoint(dp1);
		
		p.setGatherLocation(false);
		DataPoint dp2 = new DataPoint(1, date, 100, ll);
		System.out.println(dp2.toString());
		db.addPoint(dp2);
		
//		System.out.println(db.getAllPeople());
		System.out.println(db.getPointsByID(1));

	}
}
*/
