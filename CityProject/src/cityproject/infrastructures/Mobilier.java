package cityproject.infrastructures;

import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointM;

public class Mobilier {
	private Coordonnees4Points<PointM> coordonnees;

	public Mobilier() {
		// TODO Auto-generated constructor stub
	}

	public Coordonnees4Points<PointM> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees4Points<PointM> coordonnees) {
		this.coordonnees = coordonnees;
	}

}
