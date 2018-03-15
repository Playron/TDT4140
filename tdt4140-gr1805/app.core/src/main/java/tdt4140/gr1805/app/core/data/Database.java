package tdt4140.gr1805.app.core.data;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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


/* 
 * The Database object reads from its files when initialized, but 
 * writing back to the files is not automatic, so remember to use
 * one of the write-functions after modifying anything.
 */

public class Database {
	
	private HashMap<Integer, Person> people;
	private ArrayList<DataPoint> datapoints;
	private ArrayList<Workout> workouts;
	private File peopleFile;
	private File datapointsFile;
	private File workoutsFile;
	private ObjectMapper mapper = new ObjectMapper();

	public Database() {
		this.people = new HashMap<Integer, Person>();
		this.datapoints = new ArrayList<DataPoint>();
		this.workouts = new ArrayList<Workout>();
		
		this.peopleFile = new File("src/main/resources/tdt4140/gr1805/app/core/people.json");
		this.datapointsFile = new File("src/main/resources/tdt4140/gr1805/app/core/datapoints.json");
		this.workoutsFile = new File("src/main/resources/tdt4140/gr1805/app/core/workouts.json");
		
		try {
			readObjects();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mapper.findAndRegisterModules();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);

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
	
	/**
	 * Saves changes made to the Database object to the files.
	 * Must be used explicitly every time database has been
	 * modified.
	 * 
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void writeObjects() throws JsonGenerationException, JsonMappingException, IOException {
		writePeople();
		writeDataPoints();
		writeWorkouts();
		
	}
	public void writePeople() throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(peopleFile, people);
	}
	
	public void writeDataPoints() throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(datapointsFile, datapoints);
	}
	
	public void writeWorkouts() throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(workoutsFile, workouts);
		
	}
	public void readPeople() throws JsonParseException, JsonMappingException, IOException {
		this.people = mapper.readValue(peopleFile, new TypeReference<HashMap<Integer, Person>>(){});
	}
	
	public void readDatapoints() throws JsonParseException, JsonMappingException, IOException {
		this.datapoints = mapper.readValue(datapointsFile, new TypeReference<ArrayList<DataPoint>>(){});
	}
	
	public void readWorkouts() throws JsonParseException, JsonMappingException, IOException {
		this.workouts = mapper.readValue(workoutsFile, new TypeReference<ArrayList<Workout>>(){});
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
		this.datapoints.add(point);
		
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
	public void populateDatabase() throws JsonGenerationException, JsonMappingException, IOException {
		
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

		Person p1 = new Person(1992, 4, 7, Gender.MALE);
		Person p2 = new Person(1981, 10, 25, Gender.FEMALE);
		this.addPerson(p1);
		this.addPerson(p2);
		
		this.writeObjects();
	}
	
	// Empties the entire database.
	public void cleanDatabase() throws IOException {
		PrintWriter pw = new PrintWriter(datapointsFile);
		pw.close();
		pw = new PrintWriter(peopleFile);
		pw.close();		
		pw = new PrintWriter(workoutsFile);
		pw.close();
	}
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Database db = new Database();
	}
}
