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
	
	public Rue() {
			super();
			//completer
	}
	
	public Rue (String nom){
		super(nom);
		//completer
	}
	
	public Rue (String nom, PointKm origine, int longueur, DirectionEnum direction) throws Exception {
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
		//completer ici
	}
	
	public int getLongueur() {
		return longueur;
	}
	
	public void setLongueur(int longueur) {
		this.longueur = longueur;
		//completer ici
	}
	
	private void calculCoordonnees () {
		if (DirectionEnum.VERTICAL == direction) {
			
			// On calcule les ordonnees a partir de la longueur et du point d'origine
			// l'origine, l'aval et l'amont ont la même abscisse
			
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
			// l'origine, l'aval et l'amont ont la même ordonnee
			
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
}
