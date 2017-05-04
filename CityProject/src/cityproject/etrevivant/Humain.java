package cityproject.etrevivant;

import java.util.Date;
import cityproject.etrevivant.role.Locataire;
import cityproject.etrevivant.role.Proprietaire;
import cityproject.infrastructures.Quartier;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.BienImmobilier;

public class Humain extends EtreVivant implements Locataire, Proprietaire {
	private String nom;
	private Date dateNaissance;
	private Boolean aunBienImmobilier;
	private Boolean aunFoyer;
	private Foyer localisation;
	
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

	public Boolean getAunBienImmobilier() {
		return aunBienImmobilier;
	}

	public void setAunBienImmobilier(Boolean aunBienImmobilier) {
		this.aunBienImmobilier = aunBienImmobilier;
	}

	public Boolean getAunFoyer() {
		return aunFoyer;
	}

	public void setAunFoyer(Boolean aunFoyer) {
		this.aunFoyer = aunFoyer;
	}


}
