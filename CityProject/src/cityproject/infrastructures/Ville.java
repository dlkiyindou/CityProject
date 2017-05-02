package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointKm;

public class Ville extends Infrastructure {
	private CoordonneesGeographiques<PointKm> coordonnees;
	private List<Parcelle> listeparcelles;
	private String codepostal;

	public String getCodepostal() {
		return codepostal;
	}

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

}
