package cityproject.infrastructures;

import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.DirectionEnum;
import cityproject.infrastructures.geographie.PointKm;
import cityproject.infrastructures.geographie.PointM;

public class Rue extends Infrastructure {
	private DirectionEnum direction;
	private static int largeur = 5;
	// Milieu de la rue
	private PointKm pointOrigine;
	// Longueur de la rue, en Km 
	private int longueur;
	
	public Rue() {
		super();
	}

	public Rue(String nom) {
		super(nom);
	}
	
	public Rue(String nom, DirectionEnum direction, PointKm pointOrigine, int longueur) {
		super(nom);
		this.direction = direction;
		this.pointOrigine = pointOrigine;
		this.longueur = longueur;
	
		
	}
	
//		setNom(nom);
//	}

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
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	private Coordonnees4Points<PointM> calculCoordonnees() throws Exception {
		PointM pno= null;
		PointM pne= null;
		PointM pso= null;
		PointM pse= null;
		
		if (DirectionEnum.VERTICAL == direction) {
			pno = new PointM((int)(pointOrigine.toPointM().getX()-(largeur/2)), (int)(pointOrigine.toPointM().getY()+(longueur*1000/2)));
			pne = new PointM((int)(pointOrigine.toPointM().getX()+(largeur/2)), (int)(pointOrigine.toPointM().getY()+(longueur*1000/2)));
			pso = new PointM((int)(pointOrigine.toPointM().getX()-(largeur/2)), (int)(pointOrigine.toPointM().getY()-(longueur*1000/2)));
			pse = new PointM((int)(pointOrigine.toPointM().getX()+(largeur/2)), (int)(pointOrigine.toPointM().getY()-(longueur*1000/2)));

			// On calcule les ordonnees a partir de la longueur et du point d'origine
			// l'origine, l'aval et l'amont ont la m�me abscisse
			
		} else if (DirectionEnum.HORIZONTAL == direction) {
			pno = new PointM((int)(pointOrigine.toPointM().getX()-(longueur*1000/2)), (int)(pointOrigine.toPointM().getY()+(largeur/2)));
			pne = new PointM((int)(pointOrigine.toPointM().getX()+(longueur*1000/2)), (int)(pointOrigine.toPointM().getY()+(largeur/2)));
			pso = new PointM((int)(pointOrigine.toPointM().getX()-(longueur*1000/2)), (int)(pointOrigine.toPointM().getY()-(largeur/2)));
			pse = new PointM((int)(pointOrigine.toPointM().getX()+(longueur*1000/2)), (int)(pointOrigine.toPointM().getY()+(largeur/2)));
			
			// On calcule les abscisses a partir de la longueur et du point d'origine
			// l'origine, l'aval et l'amont ont la m�me ordonnee
		}
		
		Coordonnees4Points<PointM> coordRue = new Coordonnees4Points<PointM>();
		coordRue.ajouterElements(pno, pne, pso, pse);

		
		return coordRue;
	}
}
