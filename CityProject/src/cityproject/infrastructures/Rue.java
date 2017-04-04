package cityproject.infrastructures;

import cityproject.infrastructures.geographie.Coordonnes4Points;
import cityproject.infrastructures.geographie.DirectionEnum;

public class Rue extends Infrastructure {
	private Coordonnes4Points<?> coordonnees; 
	private DirectionEnum direction;
	
	public Rue() {
			super();
		
	}
	public Rue (String nom){
		super(nom);
	}
	public Rue (String nom, Coordonnes4Points<?> coordonnees) throws Exception {
		setNom(nom);
		setCoordonnees(coordonnees);
	
	}
	public Coordonnes4Points<?> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnes4Points<?> coordonnees2) throws Exception {
		if (coordonnees2.isValid()) {
			this.coordonnees = coordonnees2;
		} else {
			throw new Exception ("Ces coordonnees geographiques ne sont pas valides pour une ville");
		}
	}

	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}
}
