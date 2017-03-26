package cityproject.infrastructures;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;

public class Quartier extends Infrastructure{
	private CoordonneesGeographiques coord;
	private Ville ville;
	
	
	public CoordonneesGeographiques getCoord() {
		return coord;
	}
	
	public void setCoord(CoordonneesGeographiques coord) {
		this.coord = coord;
	}
	
	public String toString () {
		return "Quartier : " + getNom() + "\nCoordonnees : " + coord.toString();
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	public boolean estDansVille(Ville ville) {
		return true;
	}
	
}
