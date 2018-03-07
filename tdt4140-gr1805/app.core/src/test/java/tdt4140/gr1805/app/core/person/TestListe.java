package tdt4140.gr1805.app.core.person;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

public class TestListe {
	
	Liste testliste;
	
	@Before
	public void setup() {
		this.testliste = new Liste();
		
	}
	
	@Test							//legger til tre brukere i listen
	public void testleggBrukeIListe1() {
		
		ArrayList<Person> expected = new ArrayList<Person>();
		Person pers1 = new Person(2000, 1, 21, Gender.FEMALE);
		Person pers2 = new Person(2000, 1, 21, Gender.MALE);
		Person pers3 = new Person(2001, 1, 21, Gender.FEMALE);
		expected.add(pers1);
		expected.add(pers2);
		expected.add(pers3);
		testliste.leggBrukerIListe(pers1);
		testliste.leggBrukerIListe(pers2);
		testliste.leggBrukerIListe(pers3);
		assertEquals(expected, testliste.getListe());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testleggBrukerIListe2() {
		Person pers1 = new Person(2000, 1, 21, Gender.FEMALE);
		testliste.leggBrukerIListe(pers1);
		testliste.leggBrukerIListe(pers1);
	}
	
	@Test
	public void testslettBrukerFraListe1() {
		Person pers1 = new Person(2000, 1, 21, Gender.FEMALE);
		Person pers2 = new Person(2000, 1, 21, Gender.MALE);
		Person pers3 = new Person(2001, 1, 21, Gender.FEMALE);
		testliste.leggBrukerIListe(pers1);
		testliste.leggBrukerIListe(pers2);
		testliste.leggBrukerIListe(pers3);
		ArrayList<Person> expected = new ArrayList<Person>();
		expected.add(pers1);
		expected.add(pers3);
		testliste.slettBrukerFraListe(pers2);
		assertEquals(testliste.getListe(), expected);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testslettBrukerFraListe2(){
		Person pers1 = new Person(2000, 1, 21, Gender.FEMALE);
		Person pers2 = new Person(2000, 1, 21, Gender.MALE);
		testliste.leggBrukerIListe(pers1);
		testliste.slettBrukerFraListe(pers2);
	}

}
