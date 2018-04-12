package tdt4140.gr1805.app.core.data;

import static org.junit.Assert.*;

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

}
