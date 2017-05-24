
package cityproject.etrevivant;

import java.util.Date;

import cityproject.etrevivant.role.Habitant;
import cityproject.etrevivant.role.Visiteur;
import cityproject.infrastructures.Quartier;
import cityproject.infrastructures.geographie.Coordonnees4Points;

public class EtreVivant implements Habitant, Visiteur {
	private String nom;
	private Date dateNaissance;
	private Coordonnees4Points<?> coordonnees;
	private boolean aunfoyer;
	
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
	
	public Coordonnees4Points<?> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees4Points<?> coordonnees) {
		this.coordonnees = coordonnees;
	}

	public boolean isAunfoyer() {
		return aunfoyer;
	}

	public void setAunfoyer(boolean aunfoyer) {
		this.aunfoyer = aunfoyer;
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




	

}
	