package cityproject.infrastructures;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;

public abstract class Infrastructure {
	private CoordonneesGeographiques coordonnees;
	private String nom;
	
	public Infrastructure() {
		super();
		coordonnees = new CoordonneesGeographiques();
	}
	
	public Infrastructure(String nom) {
		this();
		setNom(nom);
	}
	
	public Infrastructure(String nom, CoordonneesGeographiques coordonnees) {
		super();
		setNom(nom);
		setCoordonnees(coordonnees);
	}

	public CoordonneesGeographiques getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(CoordonneesGeographiques coord) {
		this.coordonnees = coord;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
