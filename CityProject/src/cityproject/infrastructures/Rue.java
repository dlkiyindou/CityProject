package cityproject.infrastructures;

import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.DirectionEnum;
import cityproject.infrastructures.geographie.PointKm;

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
		setNom(nom);
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
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	private void calculCoordonnees () {
		if (DirectionEnum.VERTICAL == direction) {
			// On calcule les ordonnees a partir de la longueur et du point d'origine
			// l'origine, l'aval et l'amont ont la même abscisse
			
		} else if (DirectionEnum.HORIZONTAL == direction) {
			// On calcule les abscisses a partir de la longueur et du point d'origine
			// l'origine, l'aval et l'amont ont la même ordonnee
		}
	}
}
