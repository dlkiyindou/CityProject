/**
 * 
 */
package cityproject.etrevivant;

import java.util.Date;
import cityproject.infrastructures.geographie.Coordonnees4Points;

import cityproject.etrevivant.role.Habitant;
import cityproject.etrevivant.role.Visiteur;
import cityproject.infrastructures.Quartier;
import cityproject.infrastructures.geographie.PointM;

/**
 * @author Dixi
 *
 */
public class EtreVivant implements Habitant, Visiteur {
	private String nom;
	private Date dateNaissance;
	private Coordonnees4Points<PointM> coordonnees;
	
	
	public EtreVivant() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



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
	public Quartier getQuartier() {
		// TODO Auto-generated method stub
		return null;
	}




	public Coordonnees4Points<PointM> getCoordonnees() {
		return coordonnees;
	}




	public void setCoordonnees(Coordonnees4Points<PointM> coordonnees) {
		this.coordonnees = coordonnees;
	}
	
}
	
