package tdt4140.gr1805.app.core;

import java.util.ArrayList;

import tdt4140.gr1805.app.core.person.Person;

public class CoreInput extends SuperMethods {
	
	private Person bruker;
	private int puls;
	private int[][] lokasjon; 
	ArrayList<CoreInput> brukere = new ArrayList<CoreInput>();
	
	
	public CoreInput(Person bruker, int[][] lokasjon, int puls) {
		this.bruker = bruker;
		this.lokasjon = lokasjon;
		this.puls = puls;
		
	}

	public void leggTilBruker(CoreInput nyBruker) {
		if(!(brukere.contains(nyBruker))){
			brukere.add(nyBruker);
		}else {
			throw new IllegalArgumentException("Brukeren er allerede registrert! ");
		}
	}
	
	public void fjernBruker(CoreInput bruker) {
		if(brukere.contains(bruker)) {
			brukere.remove(bruker);
		} else {
			throw new IllegalArgumentException("Brukeren er ikke registrert! ");
		}
	}
	
	
	
}
