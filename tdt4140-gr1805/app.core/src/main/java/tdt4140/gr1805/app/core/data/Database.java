package tdt4140.gr1805.app.core.data;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tdt4140.gr1805.app.core.person.*;

public class Database {
	
	private ArrayList<Person> personList;
	private ArrayList<DataPoint> dataPoints;
	private ArrayList<Workout> workouts;
	private static File personDB;
	private static File pointDB;
	private static File workoutDB;
	private ObjectMapper mapper;
	
	public Database() {
		this.personList = new ArrayList<Person>();
		this.dataPoints = new ArrayList<DataPoint>();
		this.workouts = new ArrayList<Workout>();
		
		Database.personDB = new File("src/main/resources/tdt4140/gr1805/app/core/people.json");
		Database.pointDB = new File("src/main/resources/tdt4140/gr1805/app/core/datapoints.json");
		Database.workoutDB = new File("src/main/resources/tdt4140/gr1805/app/core/workouts.json");
	}

	public void readObjects() {
		ObjectMapper mapper = new ObjectMapper();
		personList = mapper.readValue(personDB, new TypeReference<ArrayList<Person>>(){});
		dataPoints = mapper.readValue(pointDB, new TypeReference<ArrayList<DataPoint>>(){});
		workouts = mapper.readValue(workoutDB, new TypeReference<ArrayList<Workout>>(){});
		
		
	}
	
	public void writeObjects() {
		// Updates JSON files with current state of the lists.
		// The app is however not expected to modify the database in any way,
		// except maybe to add a Person/do something administrative.
	}
	
	public ArrayList<Person> getPersonList()
		return personList;
	}
	
	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}
	
	public ArrayList<DataPoint> getDataPoints() {
		return dataPoints;
	}
	
	public void setDataPoints(ArrayList<DataPoint> dataPoints) {
		this.dataPoints = dataPoints;
	}
	
	public ArrayList<Workout> getWorkouts() {
		return workouts;
	}
	
	public void setWorkouts(ArrayList<Workout> workouts) {
		this.workouts = workouts;
	}
	
}
