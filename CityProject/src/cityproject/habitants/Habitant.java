package cityproject.habitants;

import cityproject.infrastructures.Habitation;
import cityproject.infrastructures.geographie.Point;

public abstract class Habitant {
	private Point localisation;
	
	public void rentrer(Habitation hab){
		
	}
	
	public abstract void marcher();

	public Point getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Point localisation) {
		this.localisation = localisation;
	}
}
