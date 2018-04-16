package tdt4140.gr1805.app.core.data;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tdt4140.gr1805.app.core.person.City;
import tdt4140.gr1805.app.core.person.Gender;
import tdt4140.gr1805.app.core.person.Person;

public class TestDatabase
{
	Database db;
	Person p1;
	private HashMap<Integer, Person> people;
	
	@Before
	public void setUp() throws Exception
	{
		db = new Database();
		p1 = new Person(1995, 10, 19, Gender.MALE, City.BERGEN);
		db.addPerson(p1);
		people = new HashMap<>();

	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testAddPerson()
	{
		db.addPerson(p1);
		int excpectedID = p1.getID();
		people.put(excpectedID, p1);
		assertEquals(people.get(excpectedID), p1);
	}

	@Test
	public void testUpdatePerson() {
		Person p2 = new Person(1995, 10, 19, Gender.MALE, City.BERGEN);
		p2.setGatherLocation(false);
		p1.setGatherLocation(false);
		db.updatePerson(p1);
		assertEquals(db.getPerson(p1.getID()), p1);
	}
	
	@Test
	public void testCleanDatabase() throws IOException, URISyntaxException {
		db.addPerson(p1);
		db.cleanDatabase();
		HashMap<Integer, Person> emptyPeople = new HashMap<>();
		assertEquals(db.getAllPeople(), emptyPeople);
	}
	
	@Test
	public void testRemovePerson() throws IOException, URISyntaxException {
		System.out.println(p1);
		db.removePerson(p1.getID());
		assertEquals(db.getPerson(p1.getID()), null);
	}
	
	@Test
	public void testSetPersonGatherLocation() {
		db.setPersonGatherLocation(p1.getID(), false);
		assertEquals(p1.isGatherLocation(), false);
		db.setPersonGatherLocation(p1.getID(), true);
		assertEquals(p1.isGatherLocation(), true);
	}
	@Test (expected = Exception.class)
	public void testAddPoint() throws IOException, URISyntaxException {
		LocalDateTime man16 =LocalDateTime.of(2018, 4, 16, 13, 0);
		DataPoint point = new DataPoint(p1.getID(), man16, 90);
		int before = db.getAllDatapoints().size();
		assertEquals(before, db.getAllDatapoints().size());
		db.addPoint(point);
		assertEquals(before+1, db.getAllDatapoints().size());
		
		DataPoint point2 = new DataPoint(100, man16, 90);
		db.addPoint(point2);
		

		
		
		
		
	}

}
