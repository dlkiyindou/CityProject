package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cityproject.infrastructures.Rue;
import cityproject.infrastructures.Croisement;

import cityproject.exception.QuartierHorsDeVilleException;
import cityproject.exception.QuartierPasDeCoordonnees;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointKm;

public class Quartier extends Infrastructure{
	private CoordonneesGeographiques<PointKm> coordonnees = null;
	double distanceHoryzontaleQuartier = 0;
	double distanceVerticaleQuartier = 0;
	
	
	private List<Parcelle> listeparcelles;
	private List<Rue> listerues;
	private List<Croisement> listcroisements;
	
	
	
	public List<Parcelle> getListeDeParcelles() {
		return listeparcelles;
	}

	public void updateListDeParcelles() {
		
		//Suppression des doublons
		List<Parcelle> parcelles = new ArrayList<Parcelle>();
		parcelles = this.getListeDeParcelles();
        Set<Parcelle> set = new HashSet<Parcelle>() ;
        set.addAll(parcelles) ;
        ArrayList<Parcelle> updateparcelles = new ArrayList<Parcelle>(set) ;
        parcelles.addAll(updateparcelles);
	}
	
	
	
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
	
	public String getNomQuartier() {
		return nom_quartier;
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
	

	public void calculDistanceHoryzontaleQuartier () throws QuartierPasDeCoordonnees {
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
		distanceHoryzontaleQuartier = xMax-xMin;
	}
	public double getdistanceHoryzontaleQuartier() {
		return distanceHoryzontaleQuartier;
	}
	
	public void calculDistanceVerticaleQuartier () throws QuartierPasDeCoordonnees {
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
		distanceVerticaleQuartier = yMax-yMin;
	}
	public double getdistanceVerticaleQuartier() {
		return distanceVerticaleQuartier;
	}
	
	
}
