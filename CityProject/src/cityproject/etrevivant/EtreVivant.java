/**
 * 
 */
package cityproject.etrevivant;

import java.util.Date;

import cityproject.etrevivant.role.Habitant;
import cityproject.etrevivant.role.Visiteur;
import cityproject.infrastructures.Quartier;

/**
 * @author Dixi
 *
 */
public class EtreVivant implements Habitant, Visiteur {
	private String nom;
	private Date dateNaissance;
	private int coordonnees;
	
	
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
	public int getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(int coordonnees) {
		this.coordonnees = coordonnees;
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
	
}
	
