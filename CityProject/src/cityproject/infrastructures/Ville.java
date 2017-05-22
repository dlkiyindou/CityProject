package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointM;

public class Ville extends Infrastructure {
	private CoordonneesGeographiques<PointM> coordonnees;
	private List<Parcelle> listeparcelles;

	public Ville() {
		super();
	}

	public Ville(String nom) {
		super(nom);
	}

	public Ville(String nom, CoordonneesGeographiques<PointM> coordonnees) {
		this(nom);
		this.setCoordonnees(coordonnees);
	}

	public CoordonneesGeographiques<PointM> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(CoordonneesGeographiques<PointM> coordonnees) {
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

	public int getId() {
		return 0;
	}

}
