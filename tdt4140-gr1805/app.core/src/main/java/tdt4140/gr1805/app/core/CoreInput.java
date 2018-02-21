package tdt4140.gr1805.app.core;

import java.util.ArrayList;

public class CoreInput {
	
	String id; int[][] lokasjon; int puls; String name; int alder;
	ArrayList<CoreInput> brukere = new ArrayList<CoreInput>();
	
	
	public CoreInput(String id, int[][] lokasjon, int puls, String name, int alder) {
		this.id = id;
		this.lokasjon = lokasjon;
		this.puls = puls;
		this.name = name;
		this.alder = alder;
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
