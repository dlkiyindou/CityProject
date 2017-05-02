package cityproject.infrastructures.geographie;

import cityproject.infrastructures.*;


public class Adresse {

	
	int numero;
	Rue rue;
	Ville ville;
	
	
	String nom_rue = rue.getNom();
	String codepostale = ville.getCodepostal();
	String nom_ville = ville.getNom();
	
//	Batiment batiment;
	
	
	public String toString(){
		
		StringBuilder adresse = new StringBuilder();
		
		adresse.append(numero);
		adresse.append(", ");
		adresse.append("Rue " + nom_rue + "/n");	
		adresse.append(codepostale + " ");
		adresse.append(nom_ville);
		
		return adresse.toString();
	}
	
	
	
	
	
	
}
