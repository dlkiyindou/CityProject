package cityproject.infrastructures;

import cityproject.habitants.Habitant;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;

public class BienImmobilier {
	private Habitant habitant;
	private CoordonneesGeographiques localisation;

	public Habitant getHabitant() {
		return habitant;
	}

	public void setHabitant(Habitant habitant) {
		this.habitant = habitant;
	}

	public CoordonneesGeographiques getLocalisation() {
		return localisation;
	}

	public void setLocalisation(CoordonneesGeographiques localisation) {
		this.localisation = localisation;
	}
	

}
