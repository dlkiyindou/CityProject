package cityproject.infrastructures;

import java.awt.Point;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;

public abstract class Infrastructure {
	private String nom;
	
	public Infrastructure(String nom) {
		super();
		setNom(nom);
	}

	public Infrastructure() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
