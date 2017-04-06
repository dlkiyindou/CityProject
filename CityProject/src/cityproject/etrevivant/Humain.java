package cityproject.etrevivant;

<<<<<<< HEAD
public class Humain extends EtreVivant implements Locataire,Proprietaire {
	

	
	
=======
import java.util.Date;

import cityproject.etrevivant.role.Locataire;
import cityproject.etrevivant.role.Proprietaire;
import cityproject.infrastructures.Quartier;

public class Humain extends EtreVivant implements Locataire, Proprietaire {
	private String nom;
	private Date dateNaissance;
	
	public Humain() {
		// TODO Auto-generated constructor stub
	}
	
	public Humain(String _nom) {
		setNom(_nom);
	}

	@Override
	public Quartier getQuartier() {
		// TODO Auto-generated method stub
		return null;
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
>>>>>>> branch 'YoannF' of https://github.com/dlkiyindou/CityProject/

}
