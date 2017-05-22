package cityproject.infrastructures;

import cityproject.infrastructures.geographie.Adresse;
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointM;

public class Immobilier {
	private Coordonnees4Points<PointM> coordonnees;
	private Adresse adresse;

	public Immobilier() {
		// TODO Auto-generated constructor stub
	}

	public Coordonnees4Points<PointM> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees4Points<PointM> coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
