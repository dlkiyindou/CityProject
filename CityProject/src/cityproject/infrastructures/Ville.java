package cityproject.infrastructures;

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
}
