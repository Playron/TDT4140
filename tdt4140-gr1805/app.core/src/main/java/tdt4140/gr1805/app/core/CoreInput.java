package tdt4140.gr1805.app.core;

import java.util.ArrayList;

public class CoreInput {
	
	String id; int[][] lokasjon; int puls; String name; int alder;
	public ArrayList<CoreInput> brukere = new ArrayList<CoreInput>();
	
	
	public CoreInput(String id, int puls, String name, int alder) {
		this.id = id;
		this.puls = puls;
		this.name = name;
		this.alder = alder;
		leggTilBruker(this);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<CoreInput> getBrukere() {
		return brukere;
	}

	public void setBrukere(ArrayList<CoreInput> brukere) {
		this.brukere = brukere;
	}
	
	
	
	
	
	
}
