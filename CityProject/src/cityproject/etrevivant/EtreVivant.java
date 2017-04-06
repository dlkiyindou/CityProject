<<<<<<< HEAD
package cityproject.etrevivant;

import cityproject.etrevivant.role.Habitant;
import cityproject.etrevivant.role.Visiteur;
import cityproject.infrastructures.Habitation;
import cityproject.infrastructures.Quartier;

public class EtreVivant implements Visiteur, Habitant {
	
	@Override
	public Quartier getQuartierCourant() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Quartier getQuartierOrigine() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Habitation getHabitation() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
=======
/**
 * 
 */
package cityproject.etrevivant;

import cityproject.etrevivant.role.Habitant;
import cityproject.etrevivant.role.Visiteur;

/**
 * @author Dixi
 *
 */
public abstract class EtreVivant implements Habitant, Visiteur {

	/**
	 * 
	 */
	public EtreVivant() {
		// TODO Auto-generated constructor stub
	}
>>>>>>> branch 'YoannF' of https://github.com/dlkiyindou/CityProject/

}
