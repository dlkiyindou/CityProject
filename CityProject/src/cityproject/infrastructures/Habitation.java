package cityproject.infrastructures;

import cityproject.habitants.Habitant;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;

public class Habitation {
	private Habitant habitant;
	private CoordonneesGeographiques localization;


	public Habitant getHabitant() {
		return habitant;
	}

	public void setHabitant(Habitant habitant) {
		this.habitant = habitant;
	}

	public CoordonneesGeographiques getLocalization() {
		return localization;
	}

	public void setLocalization(CoordonneesGeographiques localization) {
		this.localization = localization;
	}

}
