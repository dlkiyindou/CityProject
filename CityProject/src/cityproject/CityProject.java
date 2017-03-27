/**
 * 
 */
package cityproject;

import cityproject.infrastructures.Quartier;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.Point;

/**
 * @author Dixi
 *
 */
public class CityProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Quartier quartier = new Quartier();
		quartier.setNom("Le quartier centrale");
		
		CoordonneesGeographiques coord = new CoordonneesGeographiques();
		coord.ajouterPoint(new Point(1, 1));
		coord.ajouterPoint(new Point(1, 4));
		coord.ajouterPoint(new Point(2, 7));
		coord.ajouterPoint(new Point(4, 9));
		coord.ajouterPoint(new Point(8, 7));
		coord.ajouterPoint(new Point(9, 4));
		coord.ajouterPoint(new Point(8, 1));
		coord.ajouterPoint(new Point(5, 2));
		
		//System.out.println(coord.listeDePoints);
		quartier.setCoord(coord);
		
		System.out.println(quartier.toString());
	}

}
