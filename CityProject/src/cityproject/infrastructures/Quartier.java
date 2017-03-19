package cityproject.infrastructures;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;

public class Quartier {
	private String nom;
	private CoordonneesGeographiques coord;
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public CoordonneesGeographiques getCoord() {
		return coord;
	}
	
	public void setCoord(CoordonneesGeographiques coord) {
		this.coord = coord;
	}
	

	
}
