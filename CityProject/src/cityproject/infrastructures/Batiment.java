package cityproject.infrastructures;

import cityproject.infrastructures.geographie.PointM;

public class Batiment extends Infrastructure{
	private String type;
	private PointM taille;
	private String fonction;
	private PointM coordonnees;
	
	public Batiment (String type, PointM taille, String fonction, PointM coordonnees){
		setType(type);
		setTaille(taille);
		setFonction(fonction);
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

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public PointM getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(PointM coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	
	
	
	
}
