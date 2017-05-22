package cityproject.infrastructures;

import cityproject.exception.CityProjectException;
import cityproject.infrastructures.geographie.PointInterCardinalEnum;
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointM;

public class Parcelle {

	private Coordonnees4Points<PointM> coordParcelle;
	private PointM pointNordOuest = new PointM();
	private PointM pointNordEst = new PointM();
	private PointM pointSudOuest = new PointM();
	private PointM pointSudEst = new PointM();

	/*
	 * Constructeurs
	 */
	public Parcelle() throws CityProjectException {
		super();
		setPointNordOuest(null);
		setPointNordEst(null);
		setPointSudOuest(null);
		setPointSudEst(null);
		setCoordParcelle(null);
	}
	
	public Parcelle(PointM p, Croisement c) throws CityProjectException {
		super();
		calculPositionParcelle(p,c);
	}
	
	/*
	 * Setters
	 */

	public void setCoordParcelle(Coordonnees4Points<PointM> coordParcelle) {
		this.coordParcelle = coordParcelle;
	}

	public void setPointNordOuest(PointM pointNordOuest) {
		this.pointNordOuest = pointNordOuest;
	}

	public void setPointNordEst(PointM pointNordEst) {
		this.pointNordEst = pointNordEst;
	}

	public void setPointSudOuest(PointM pointSudOuest) {
		this.pointSudOuest = pointSudOuest;
	}

	public void setPointSudEst(PointM pointSudEst) {
		this.pointSudEst = pointSudEst;
	}
	
	/*
	 * Getters
	 */

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

	public Coordonnees4Points<PointM> getCoordonneesParcelle() {
		return coordParcelle;
	}

	/*
	 * M?thode de calcul de la position d'une parcelle
	 */

	public void calculPositionParcelle(PointM p, Croisement c) throws CityProjectException {

		Coordonnees4Points<PointM> coord_croisement = new Coordonnees4Points<PointM>();

		PointInterCardinalEnum cardinality = p.getCardinality(coord_croisement);

		int x1, y1, x2, y2, x3, y3;

		// point de parcours sur axe E-O
		PointM pointParcoursAxeEO = new PointM(0, 0);
		// point de parcours sur axe N-S
		PointM pointParcoursAxeNS = new PointM(0, 0);
		// dernier point pour constituer la parcelle, les coordonnees sont
		// calcul?es
		PointM pointCalcule = new PointM(0, 0);

		// Initialisation de la position des points

		x1 = (int) p.getX();
		y1 = (int) p.getY();

		x2 = (int) p.getX();
		y2 = (int) p.getY();

		// Premier cas: On part du point NO et on calcule les coordonn?es de la
		// parcelle
		if (cardinality == PointInterCardinalEnum.NORDOUEST) {
			do {
				x1 -= 1;
				pointParcoursAxeEO.setLocation(x1, y1);
			} while ((pointParcoursAxeEO != p.isPointExtremeRue() || pointParcoursAxeEO != p.isPointSommetCroisement()));
			do {
				y2 += 1;
				pointParcoursAxeNS.setLocation(x2, y2);
			} while ((pointParcoursAxeEO != p.isPointExtremeRue() || pointParcoursAxeEO != p.isPointSommetCroisement()));

			x3 = (int) pointParcoursAxeEO.getX();
			y3 = (int) pointParcoursAxeNS.getY();
			pointCalcule.setLocation(x3, y3);

			pointNordOuest = pointCalcule;
			pointNordEst = pointParcoursAxeNS;
			pointSudOuest = pointParcoursAxeEO;
			pointSudEst = p;
		}

		// Deuxi?me cas: On part du point NE et on calcule les coordonn?es de la
		// parcelle
		if (cardinality == PointInterCardinalEnum.NORDEST) {
			do {
				x1 += 1;
				pointParcoursAxeEO.setLocation(x1, y1);
			} while ((pointParcoursAxeEO != p.isPointExtremeRue() || pointParcoursAxeEO != p.isPointSommetCroisement()));
			do {
				y2 += 1;
				pointParcoursAxeNS.setLocation(x2, y2);
			} while ((pointParcoursAxeEO != p.isPointExtremeRue() || pointParcoursAxeEO != p.isPointSommetCroisement()));

			x3 = (int) pointParcoursAxeEO.getX();
			y3 = (int) pointParcoursAxeNS.getY();
			pointCalcule.setLocation(x3, y3);

			pointNordOuest = pointCalcule;
			pointNordEst = pointParcoursAxeNS;
			pointSudOuest = pointParcoursAxeEO;
			pointSudEst = p;
		}

		// Troisi?me cas: On part du point SO et on calcule les coordonn?es de
		// la parcelle
		if (cardinality == PointInterCardinalEnum.SUDOUEST) {

			do {
				x1 -= 1;
				pointParcoursAxeEO.setLocation(x1, y1);
			} while ((pointParcoursAxeEO != p.isPointExtremeRue() || pointParcoursAxeEO != p.isPointSommetCroisement()));
			do {
				y2 -= 1;
				pointParcoursAxeNS.setLocation(x2, y2);
			} while ((pointParcoursAxeEO != p.isPointExtremeRue() || pointParcoursAxeEO != p.isPointSommetCroisement()));

			x3 = (int) pointParcoursAxeEO.getX();
			y3 = (int) pointParcoursAxeNS.getY();
			pointCalcule.setLocation(x3, y3);

			pointNordOuest = pointCalcule;
			pointNordEst = pointParcoursAxeNS;
			pointSudOuest = pointParcoursAxeEO;
			pointSudEst = p;

		}

		// Quatri?me cas: On part du point SE et on calcule les coordonn?es de
		// la parcelle
		if (cardinality == PointInterCardinalEnum.SUDEST) {
			do {
				x1 += 1;
				pointParcoursAxeEO.setLocation(x1, y1);
			} while ((pointParcoursAxeEO != p.isPointExtremeRue() || pointParcoursAxeEO != p.isPointSommetCroisement()));
			do {
				y2 -= 1;
				pointParcoursAxeNS.setLocation(x2, y2);
			} while ((pointParcoursAxeEO != p.isPointExtremeRue() || pointParcoursAxeEO != p.isPointSommetCroisement()));

			x3 = (int) pointParcoursAxeEO.getX();
			y3 = (int) pointParcoursAxeNS.getY();
			pointCalcule.setLocation(x3, y3);
		}

		coordParcelle.ajouterElements(pointNordOuest, pointNordEst, pointSudOuest, pointSudEst);

	}

}
