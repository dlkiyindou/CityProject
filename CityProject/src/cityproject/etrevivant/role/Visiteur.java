package cityproject.etrevivant.role;

import cityproject.infrastructures.Quartier;

public interface Visiteur {
	Quartier getQuartierCourant();
	Quartier getQuartierOrigine();
}
