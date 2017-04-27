package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.List;
import cityproject.infrastructures.Rue;
import cityproject.infrastructures.Croisement;

import cityproject.exception.QuartierHorsDeVilleException;
import cityproject.exception.QuartierPasDeCoordonnees;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointKm;

public class Quartier extends Infrastructure{
	private CoordonneesGeographiques<PointKm> coordonnees = null;
	double largeurQuartier = 0;
	double longueurQuartier = 0;
	
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
	public List<Rue> getRue() {
		return getRue();
	}	
	public List<Croisement> getCroisement() {
		return getCroisement();
	}	
	

	public void calculLargeurQuartier () throws QuartierPasDeCoordonnees {
		if (coordonnees == null){
			throw new QuartierPasDeCoordonnees();	
		}
		List<PointKm> listeCoordonnees=coordonnees.getListeDePoints();
		double xMin = Double.MAX_VALUE;
		double xMax = 0;
		for (PointKm e : listeCoordonnees) {
			double x = e.getX();
			if (x<xMin){
				xMin=x;
			}
			if (x>xMax){
				xMax=x;
			}
		}
		largeurQuartier = xMax-xMin;
	}
	public double getlargeurQuartier() {
		return largeurQuartier;
	}
	
	public void calculLongueurQuartier () throws QuartierPasDeCoordonnees {
		if (coordonnees == null){
			throw new QuartierPasDeCoordonnees();	
		}
		List<PointKm> listeCoordonnees=coordonnees.getListeDePoints();
		double yMin = Double.MAX_VALUE;
		double yMax = 0;
		for (PointKm e : listeCoordonnees) {
			double y = e.getY();
			if (y<yMin){
				yMin=y;
			}
			if (y>yMax){
				yMax=y;
			}
		}
		longueurQuartier = yMax-yMin;
	}
	public double getlongueurQuartier() {
		return longueurQuartier;
	}
	
	
}
