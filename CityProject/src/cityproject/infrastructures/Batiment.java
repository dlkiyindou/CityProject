package cityproject.infrastructures;

import java.util.List;

import cityproject.etrevivant.Humain;
import cityproject.etrevivant.role.Proprietaire;
import cityproject.infrastructures.geographie.Adresse;
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointM;

public class Batiment extends Infrastructure implements Proprietaire{
	private String type;
	private PointM taille;
	private Coordonnees4Points<PointM> coordonnees;
	private Adresse adresse;
	private int nbEtages;
	private List<Proprietaire> listeProprietaires;
	private int nbDePersonnesDansBatiment;
	private List<Humain> nomsDesPersonnesDansBatiment;
	
	// constructeur par defaut
	public Batiment(){
		setType(null);
		setTaille(null);
		setCoordonnees(null);
	}
	
	// constructeur avec parametres
	public Batiment (String type, PointM taille, String fonction, Coordonnees4Points<PointM> coordonnees){
		setType(type);
		setTaille(taille);
		setCoordonnees(coordonnees);	
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}

	public PointM getTaille() {
		return taille;
	}

	public void setTaille(PointM taille) {
		this.taille = taille;
	}

	public Coordonnees4Points<PointM> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees4Points<PointM> coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getNbEtages() {
		return nbEtages;
	}

	public void setNbEtages(int nbEtages) {
		this.nbEtages = nbEtages;
	}

	public List<Proprietaire> getListeProprietaires() {
		return listeProprietaires;
	}

	public void setListeProprietaires(List<Proprietaire> listeProprietaires) {
		this.listeProprietaires = listeProprietaires;
	}

	// methode pour entrer dans batiment
	public void entrerDansBatiment(){
		// si pt = coord rue et pf = coord bat, alors j'entre dans un batiment
		
		
	}
	
	//methode pour sortir d'un batiment
	public void sortirDeBatiment(){
		// si po = coord batiment et pt = coord rue, alors je sors du batiment
	}
	
	
	public int nbDePersonnesDansBatiment(){
		return nbDePersonnesDansBatiment;
		
	}
	
	
	public List<Humain> nomsDesPersonnesDansBatiment(){
		return nomsDesPersonnesDansBatiment;
		
	}
}
//just to commit
