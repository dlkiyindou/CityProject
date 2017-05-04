package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cityproject.infrastructures.Rue;
import cityproject.infrastructures.Croisement;

import cityproject.exception.QuartierHorsDeVilleException;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointKm;

public class Quartier extends Infrastructure{
	
	
	private String nom_quartier;
	private CoordonneesGeographiques<PointKm> coordonnees;
	
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
	

//	private double calculLongueurQuartier () {
//		while (les abscisse de deux coordville sont = )
//			public static double distance (double x1, double y1, double x2, double y2) {
//				return distance;
//		}
//	Double longueurQuartier = new Double ();
//	
//	}
	
	private void calculLargeurMaxQuartier () {
		
	}
}
