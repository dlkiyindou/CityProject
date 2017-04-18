package cityproject.infrastructures;

import cityproject.infrastructures.geographie.DirectionEnum;
import cityproject.infrastructures.geographie.PointKm;

public class Rue extends Infrastructure {
	private DirectionEnum direction;
	private static int largeur = 5;
	// Milieu de la rue
	private PointKm pointOrigine;
	// Longueur de la rue, en Km 
	private int longueur;
	private PointKm pointDebut;
	private PointKm pointFin;
	private PointKm pointNordOuest;
	private PointKm pointNordEst;
	private PointKm pointSudOuest;
	private PointKm pointSudEst;
	
	public Rue() throws Exception {
		new Rue(null, new PointKm(), 0, DirectionEnum.HORIZONTAL);
	}
	
	public Rue (String nom) throws Exception{
		super(nom);
		new Rue (nom, new PointKm(), 0, DirectionEnum.HORIZONTAL);
	}
	
	public Rue (String nom, PointKm origine, int longueur, DirectionEnum direction) throws Exception {
		super();
		//completer (créer des paramètres par défault)
		setNom(nom);
		setLongueur(longueur);
		setPointOrigine(origine);
		setDirection(direction);
		calculCoordonnees ();
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}
	
	public PointKm getPointOrigine() {
		return pointOrigine;
	}
	
	public void setPointOrigine(PointKm pointOrigine) {
		this.pointOrigine = pointOrigine;
		//verifier si la longueur a ete mise et si oui calcule des coordonnees des points debut et fin
	}
	
	public int getLongueur() {
		return longueur;
	}
	
	public void setLongueur(int longueur) {
		this.longueur = longueur;
		////verifier si le point d'origine a ete mis et si oui calcule des coordonnees des points debut et fin
	}
	
	public static int getLargeur() {
		return largeur;
	}

	public static void setLargeur(int largeur) {
		Rue.largeur = largeur;
	}

	private void calculCoordonnees () {
		if (DirectionEnum.VERTICAL == direction) {
			
			// On calcule les ordonnees a partir de la longueur et du point d'origine
			// l'origine, l'aval et l'amont ont la mÃªme abscisse
			
			double xd = pointOrigine.getX();
			double yd= pointOrigine.getY()-longueur/2;
			pointDebut = new PointKm ();
			pointDebut.setLocation (xd,yd);	
			
			double xf = pointOrigine.getX();
			double yf= pointOrigine.getY()+longueur/2;
			pointFin = new PointKm ();
			pointFin.setLocation (xf,yf);		
			
			
			
		} else if (DirectionEnum.HORIZONTAL == direction) {
			
			// On calcule les abscisses a partir de la longueur et du point d'origine
			// l'origine, l'aval et l'amont ont la mÃªme ordonnee
			
			double xd = pointOrigine.getX()-longueur/2;
			double yd= pointOrigine.getY();
			pointDebut = new PointKm ();
			pointDebut.setLocation (xd,yd);	
			
			double xf = pointOrigine.getX()+longueur/2;
			double yf= pointOrigine.getY();
			pointFin = new PointKm ();
			pointFin.setLocation (xf,yf);		
		}
	}
	
	private void calculCordonnees4Points () {
		// on calcule les extremitées nord-ouest, nord-est, sud-ouest et sud-est de chaque rue
		if (DirectionEnum.VERTICAL == direction) {
			double xno = pointDebut.getX()-2.5;
			double yno = pointDebut.getY();
			PointKm pointNordOuest = new PointKm ();
			pointNordOuest.setLocation (xno,yno);
			
			double xne = pointDebut.getX()+2.5;
			double yne = pointDebut.getY();
			PointKm pointNordEst = new PointKm ();
			pointNordEst.setLocation (xne,yne);
			
			double xso = pointFin.getX()-2.5;
			double yso = pointFin.getY();
			PointKm pointSudOuest = new PointKm ();
			pointSudOuest.setLocation (xso,yso);
			
			double xse = pointFin.getX()+2.5;
			double yse = pointFin.getY();
			PointKm pointSudEst = new PointKm ();
			pointSudEst.setLocation (xse,yse);
			
		} else if (DirectionEnum.HORIZONTAL == direction) {
			double xno = pointDebut.getX();
			double yno = pointDebut.getY()-2.5;
			PointKm pointNordOuest = new PointKm ();
			pointNordOuest.setLocation (xno,yno);
			
			double xne = pointFin.getX();
			double yne = pointFin.getY()-2.5;
			PointKm pointNordEst = new PointKm ();
			pointNordEst.setLocation (xne,yne);
			
			double xso = pointDebut.getX();
			double yso = pointDebut.getY()+2.5;
			PointKm pointSudOuest = new PointKm ();
			pointSudOuest.setLocation (xso,yso);
			
			double xse = pointFin.getX();
			double yse = pointFin.getY()+2.5;
			PointKm pointSudEst = new PointKm ();
			pointSudEst.setLocation (xse,yse);
		}
	}
		
}
