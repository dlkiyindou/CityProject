package cityproject.infrastructures.geographie;

import cityproject.infrastructures.*;


public class Adresse {

	
	int numero;
	Rue rue;
	Quartier quartier;
	
	
	String nom_rue = rue.getNom();
	String nom_quartier = quartier.getNom();
	
//	Batiment batiment;
	
	
	public String toString(){
		
		StringBuilder adresse = new StringBuilder();
		
		adresse.append(numero);
		adresse.append(", ");
		adresse.append("Rue " + nom_rue + "/n");	
		adresse.append(nom_quartier);
		
		return adresse.toString();
	}
	
	
	
	
	
	
}
