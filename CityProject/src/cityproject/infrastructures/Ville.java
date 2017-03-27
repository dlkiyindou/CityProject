package cityproject.infrastructures;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;

public class Ville extends Infrastructure {
	public Ville() {
		super();
	}
	
	public Ville(String nom) {
		super(nom);
	}
	
	public Ville(String nom, CoordonneesGeographiques coordonnees) {
		super(nom, coordonnees);
	}
}
