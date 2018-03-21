package tdt4140.gr1805.app.core.person;

import java.util.ArrayList;
import java.util.List;


import tdt4140.gr1805.app.core.person.*;

public class Liste {

	private List<Person> brukere = new ArrayList<Person>();
	
	public void leggBrukerIListe(Person bruker) {
		if(brukere.contains(bruker)) {
			throw new IllegalArgumentException("User is allredy registered");
		}else {
			brukere.add(bruker);
		}
	}
	
	public void slettBrukerFraListe(Person bruker) {
		if(!brukere.contains(bruker)) {
			throw new IllegalArgumentException("User is not registered");
		}else {
			brukere.remove(bruker);
		}
	}
	public List<Person> getListe(){
		return this.brukere;
	}
	
	
	
	
	/*public static void main(String[] args) {
		Liste liste = new Liste();
		Person Atle = new Person(1996, 1, 20, Gender.MALE);
		liste.leggBrukerIListe(Atle);
		System.out.println(liste.brukere.size());
	}*/

}
