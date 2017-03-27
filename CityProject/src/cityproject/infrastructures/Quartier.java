package cityproject.infrastructures;

import java.awt.Polygon;

import cityproject.exception.QuartierHorsDeVilleException;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;

public class Quartier extends Infrastructure{
	private CoordonneesGeographiques coordonnees;
	private Ville ville;
	
	
	public Quartier() {
		super();
	}
	
	public Quartier(String nom) {
		super(nom);
	}
	
	public Quartier(String nom, CoordonneesGeographiques coordonnees) {
		super(nom, coordonnees);
	}
	
	public CoordonneesGeographiques getCoordonnees() {
		return coordonnees;
	}
	
	public void setCoordonnees(CoordonneesGeographiques coord) {
		this.coordonnees = coord;
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
