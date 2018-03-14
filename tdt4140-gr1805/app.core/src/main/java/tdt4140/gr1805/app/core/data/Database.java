package tdt4140.gr1805.app.core.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tdt4140.gr1805.app.core.person.*;

public class Database {
	
	protected ArrayList<Person> personList;
	protected ArrayList<DataPoint> dataPoints; // Add empty superclass default constructor to datapoint-class
	protected ArrayList<Workout> workouts;
	protected static File personDB;
	protected static File pointDB;
	protected static File workoutDB;
	protected ObjectMapper mapper = new ObjectMapper();
	
	public Database() {
		this.personList = new ArrayList<Person>();
		this.dataPoints = new ArrayList<DataPoint>();
		this.workouts = new ArrayList<Workout>();
		
		Database.personDB = new File("src/main/resources/tdt4140/gr1805/app/core/people.json");
		Database.pointDB = new File("src/main/resources/tdt4140/gr1805/app/core/datapoints.json");
		Database.workoutDB = new File("src/main/resources/tdt4140/gr1805/app/core/workouts.json");
		// These probably need to be opened in another way, to not overwrite the files
	}

	public void readObjects() throws JsonParseException, JsonMappingException, IOException {
		readPeople();
		readDataPoints();
		readWorkouts();
	}
	
	public void writeObjects() throws JsonGenerationException, JsonMappingException, IOException {
		// Updates JSON files with current state of the lists.
		// The app is however not expected to modify the database in any way,
		// except maybe to add a Person/do something administrative.
		writePeople();
		writeDataPoints();
		writeWorkouts();
		
	}
	
	public void writePeople() throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(personDB, personList);
	}
	
	public void writeDataPoints() throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(pointDB, dataPoints);
	}
	
	public void writeWorkouts() throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(workoutDB, workouts);
		
	}
	
	public void readPeople() throws JsonParseException, JsonMappingException, IOException {
		personList = mapper.readValue(personDB, new TypeReference<ArrayList<Person>>(){});
	}
	
	public void readDataPoints() throws JsonParseException, JsonMappingException, IOException {
		dataPoints = mapper.readValue(pointDB, new TypeReference<ArrayList<DataPoint>>(){});
	}
	
	public void readWorkouts() throws JsonParseException, JsonMappingException, IOException {
		workouts = mapper.readValue(workoutDB, new TypeReference<ArrayList<Workout>>(){});
	}
	
	public ArrayList<Person> getPersonList() {
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
	
//	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		Database db = new Database();
//		
//		ArrayList<DataPoint> points = new ArrayList<DataPoint>();
//		DataPoint a = new DataPoint(1, new Date(), 20);
//		DataPoint b = new DataPoint(2, new Date(), 50);
//		points.add(a);
//		points.add(b);
//		
//		Workout w1 = new Workout(1, "Run", new Date(), new Date(), points);
//		Workout w2 = new Workout(2, "Bike", new Date(), new Date(), points);
//		ArrayList<Workout> wlist = new ArrayList<Workout>();
//		wlist.add(w1);
//		wlist.add(w2);
//		
//		db.setWorkouts(wlist);
//		db.writeWorkouts();
//		db.readWorkouts();
//		System.out.println(db.getWorkouts());
s	}
}
