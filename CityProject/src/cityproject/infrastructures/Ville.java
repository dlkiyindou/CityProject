package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointM;

public class Ville extends Infrastructure {
	private CoordonneesGeographiques<PointM> coordonnees;
	private ArrayList<Quartier> listequartiers;

	public ArrayList<Quartier> getListequartiers() {
		return listequartiers;
	}

	public void setListequartiers(ArrayList<Quartier> listequartiers) {
		this.listequartiers = listequartiers;
	}

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


	public int getId() {
		return 0;
	}

}
