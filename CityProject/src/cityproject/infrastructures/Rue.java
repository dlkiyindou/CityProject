package cityproject.infrastructures;

import cityproject.exception.CityProjectException;
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.DirectionEnum;
import cityproject.infrastructures.geographie.PointM;


public class Rue extends Infrastructure {
	private DirectionEnum direction;
	private final int largeur = 5;
	// Milieu de la rue
	private PointM pointOrigine;
	private double longueur;
	private PointM pointDebut;
	private PointM pointFin;
	private PointM pointNordOuest;
	private PointM pointNordEst;
	private PointM pointSudOuest;
	private PointM pointSudEst;
	private Quartier quartier;
	Coordonnees4Points<PointM> coordrue;
	
	public Rue() throws CityProjectException {
		super();
		// completer (créer des paramètres par défault)
		setNom(null);
		setLongueur(0);
		setPointOrigine(null);
		setDirection(DirectionEnum.HORIZONTAL);
		calculCoordonnees();
	}

	public Rue(String nom) {
		super();
		// completer (créer des paramètres par défault)
		setNom(nom);
		setLongueur(0);
		setPointOrigine(null);
		setDirection(DirectionEnum.HORIZONTAL);
		calculCoordonnees();
	}
	
	public Rue(Quartier quartier) {
		super();
		// completer (créer des paramètres par défault)
		setNom(null);
		setLongueur(0);
		setPointOrigine(null);
		setDirection(DirectionEnum.HORIZONTAL);
		calculCoordonnees();
	}

	public Rue(String nom, PointM origine, int longueur, DirectionEnum direction) {
		super();
		// completer (créer des paramètres par défault)
		setNom(nom);
		setLongueur(longueur);
		setPointOrigine(origine);
		setDirection(direction);
		calculCoordonnees();
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}
	
	public PointM getPointOrigine() {
		return pointOrigine;
	}
	
	public void setPointOrigine(PointM pointOrigine) {
		this.pointOrigine = pointOrigine;
		// verifier si la longueur a ete mise et si oui calcule des coordonnees
		// des points debut et fin
		calculCoordonnees();
	}
	
	public double getLongueur() {
		if (direction==DirectionEnum.HORIZONTAL) {
			longueur = quartier.getdistanceHoryzontaleQuartier();
		} else if (direction==DirectionEnum.VERTICAL) {
			longueur = quartier.getdistanceVerticaleQuartier();
		}
		return longueur;
	}
	
	public void setLongueur(int longueur) {
		this.longueur = longueur;
		calculCoordonnees();
		//// verifier si le point d'origine a ete mis et si oui calcule des
		//// coordonnees des points debut et fin
	}
	
	public int getLargeur() {
		return largeur;
	}

	public void setCoordrue(Coordonnees4Points<PointM> coordrue) {
		this.coordrue = coordrue;
	}

	private void calculCoordonnees() {
		if ((pointOrigine != null) & (longueur > 0)) {
			if (DirectionEnum.VERTICAL == direction) {

				// On calcule les ordonnees a partir de la longueur et du point
				// d'origine
				// l'origine, l'aval et l'amont ont la mÃªme abscisse

				double xd = pointOrigine.getX();
				double yd = pointOrigine.getY() - longueur / 2;
				pointDebut = new PointM();
				pointDebut.setLocation(xd, yd);

				double xf = pointOrigine.getX();
				double yf = pointOrigine.getY() + longueur / 2;
				pointFin = new PointM();
				pointFin.setLocation(xf, yf);

			} else if (DirectionEnum.HORIZONTAL == direction) {

				// On calcule les abscisses a partir de la longueur et du point
				// d'origine
				// l'origine, l'aval et l'amont ont la mÃªme ordonnee

				double xd = pointOrigine.getX() - longueur / 2;
				double yd = pointOrigine.getY();
				pointDebut = new PointM();
				pointDebut.setLocation(xd, yd);

				double xf = pointOrigine.getX() + longueur / 2;
				double yf = pointOrigine.getY();
				pointFin = new PointM();
				pointFin.setLocation(xf, yf);
			}
		}
	}

	private void calculCordonnees4Points() {
		// on calcule les extremitées nord-ouest, nord-est, sud-ouest et sud-est
		// de chaque rue
		if ((pointDebut != null) & (pointFin != null)) {
			if (DirectionEnum.VERTICAL == direction) {
				
				double xno = pointDebut.getX() - largeur / 2;
				double yno = pointDebut.getY();
				pointNordOuest = new PointM();
				pointNordOuest.setLocation(xno, yno);

				double xne = pointDebut.getX() + largeur / 2;
				double yne = pointDebut.getY();
				pointNordEst = new PointM();
				pointNordEst.setLocation(xne, yne);

				double xso = pointFin.getX() - largeur / 2;
				double yso = pointFin.getY();
				pointSudOuest = new PointM();
				pointSudOuest.setLocation(xso, yso);

				double xse = pointFin.getX() + largeur / 2;
				double yse = pointFin.getY();
				pointSudEst = new PointM();
				pointSudEst.setLocation(xse, yse);

			} else if (DirectionEnum.HORIZONTAL == direction) {
				double xno = pointDebut.getX();
				double yno = pointDebut.getY() - largeur / 2;
				pointNordOuest = new PointM();
				pointNordOuest.setLocation(xno, yno);

				double xne = pointFin.getX();
				double yne = pointFin.getY() - largeur / 2;
				pointNordEst = new PointM();
				pointNordEst.setLocation(xne, yne);

				double xso = pointDebut.getX();
				double yso = pointDebut.getY() + largeur / 2;
				pointSudOuest = new PointM();
				pointSudOuest.setLocation(xso, yso);

				double xse = pointFin.getX();
				double yse = pointFin.getY() + largeur / 2;
				pointSudEst = new PointM();
				pointSudEst.setLocation(xse, yse);
			}

			Coordonnees4Points<PointM> coord = new Coordonnees4Points<PointM>();
			coord.ajouterElements(pointNordOuest, pointNordEst, pointSudEst, pointSudOuest);
			this.setCoordrue(coord);
		}
	}

	public CoordonneesGeographiques<PointM> getCoordonnees() {

		calculCoordonnees();
		calculCordonnees4Points();

		return coordrue;
	}

}
