package cityproject.infrastructures;

import java.awt.Polygon;

import cityproject.exception.QuartierHorsDeVilleException;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointKm;

public class Quartier extends Infrastructure{
	private CoordonneesGeographiques<PointKm> coordonnees;
	public CoordonneesGeographiques<PointKm> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(CoordonneesGeographiques<PointKm> coordonnees) {
		this.coordonnees = coordonnees;
	}

	private Ville ville;
	
	
	public Quartier() {
		super();
	}
	
	public Quartier(String nom) {
		super(nom);
	}
	
	public Quartier(String nom, CoordonneesGeographiques<PointKm> coordonnees) {
		this(nom);
		this.coordonnees = coordonnees;
	}
	
	public String toString () {
		return "Quartier : " + getNom() + "\nCoordonnees : " + coordonnees.toString();
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) throws QuartierHorsDeVilleException {
		if (!estDansVille(ville)) {
			StringBuilder s = new StringBuilder("Le quartier ");
			s.append(getNom());
			s.append(" n'est pas dans la ville ");
			s.append(ville.getNom());
			
			throw new QuartierHorsDeVilleException(s.toString());
		}
		
		this.ville = ville;
	}
	
	public boolean estDansVille(Ville ville) {
		return ville.getCoordonnees().contient(coordonnees);
	}
	
	
}
