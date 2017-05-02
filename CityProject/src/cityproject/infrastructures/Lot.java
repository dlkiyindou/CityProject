package cityproject.infrastructures;

import cityproject.infrastructures.geographie.Adresse;
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointM;

public class Lot { //Défintion sous forme d'un rectangle comme Parcelle, Rue etc...
	
	private Coordonnees4Points<PointM> coordLot;
	private Parcelle parcelle; //parcelle dans laquelle se trouve le lot
	private PointM pointNordOuest = new PointM();
	private PointM pointNordEst = new PointM();
	private PointM pointSudOuest = new PointM();
	private PointM pointSudEst = new PointM();
	private Adresse adresse; // adresse du Lot
	
	
	
	public Coordonnees4Points<PointM> getCoordLot() {
		return coordLot;
	}
	public Parcelle getParcelle() {
		return parcelle;
	}
	public PointM getPointNordOuest() {
		return pointNordOuest;
	}
	public PointM getPointNordEst() {
		return pointNordEst;
	}
	public PointM getPointSudOuest() {
		return pointSudOuest;
	}
	public PointM getPointSudEst() {
		return pointSudEst;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	
	

}
