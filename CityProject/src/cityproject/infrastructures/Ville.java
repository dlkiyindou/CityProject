package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointKm;

public class Ville extends Infrastructure {
	private CoordonneesGeographiques<PointKm> coordonnees;

	public Ville() {
		super();
	}

	public Ville(String nom) {
		super(nom);
	}

	public Ville(String nom, CoordonneesGeographiques<PointKm> coordonnees) {
		this(nom);
		this.setCoordonnees(coordonnees);
	}

	public CoordonneesGeographiques<PointKm> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(CoordonneesGeographiques<PointKm> coordonnees) {
		this.coordonnees = coordonnees;
	}

	public int getId() {
		return 0;
	}
}
