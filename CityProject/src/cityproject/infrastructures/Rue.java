package cityproject.infrastructures;

<<<<<<< HEAD
public class Rue {
	private String nom;
	private int longueur;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
}

	
=======
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.DirectionEnum;

public class Rue extends Infrastructure {
	private Coordonnees4Points<?> coordonnees;
	private DirectionEnum direction;

	public Rue() {
		super();
	}

	public Rue(String nom) {
		super(nom);
	}

	public Rue(String nom, Coordonnees4Points<?> coordonnees) throws Exception {
		setNom(nom);
		setCoordonnees(coordonnees);

	}

	public Coordonnees4Points<?> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees4Points<?> coordonnees2) throws Exception {
		if (coordonnees2.isValid()) {
			this.coordonnees = coordonnees2;
		} else {
			throw new Exception("Ces coordonnees geographiques ne sont pas valides pour une ville");
		}
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}

}
>>>>>>> branch 'YoannF' of https://github.com/dlkiyindou/CityProject/
