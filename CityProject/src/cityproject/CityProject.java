/**
 * 
 */
package cityproject;

import cityproject.infrastructures.Rue;
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.DirectionEnum;
import cityproject.infrastructures.geographie.PointM;

/**
 * @author Dixi
 *
 */
public class CityProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Creation de la ville
//		Ville ville = new Ville("CityProject ville");
//		CoordonneesGeographiques<PointKm> coordVille = new CoordonneesGeographiques<PointKm>();
//		coordVille.ajouterElement(new PointKm(1, 30));
//		coordVille.ajouterElement(new PointKm(5, 50));
//		coordVille.ajouterElement(new PointKm(10, 55));
//		coordVille.ajouterElement(new PointKm(15, 70));
//		coordVille.ajouterElement(new PointKm(25, 72));
//		coordVille.ajouterElement(new PointKm(35, 65));
//		coordVille.ajouterElement(new PointKm(65, 68));
//		coordVille.ajouterElement(new PointKm(100, 65));
//		coordVille.ajouterElement(new PointKm(110, 50));
//		coordVille.ajouterElement(new PointKm(115, 25));
//		coordVille.ajouterElement(new PointKm(110, 3));
//		coordVille.ajouterElement(new PointKm(100, 1));
//		coordVille.ajouterElement(new PointKm(90, 15));
//		coordVille.ajouterElement(new PointKm(75, 20));
//		coordVille.ajouterElement(new PointKm(60, 25));
//		coordVille.ajouterElement(new PointKm(45, 10));
//		coordVille.ajouterElement(new PointKm(30, 5));
//		coordVille.ajouterElement(new PointKm(15, 1));
//		coordVille.ajouterElement(new PointKm(4, 3));
//		ville.setCoordonnees(coordVille);
//		
//		
//		Quartier quartier = new Quartier("Le quartier centrale");
//		CoordonneesGeographiques<PointKm> coordQuartier = new CoordonneesGeographiques<PointKm>();
//		coordQuartier.ajouterElement(new PointKm(10, 30));
//		coordQuartier.ajouterElement(new PointKm(10, 35));
//		coordQuartier.ajouterElement(new PointKm(20, 37));
//		coordQuartier.ajouterElement(new PointKm(24, 29));
//		coordQuartier.ajouterElement(new PointKm(25, 25));
//		coordQuartier.ajouterElement(new PointKm(30, 25));
//		coordQuartier.ajouterElement(new PointKm(30, 20));
//		coordQuartier.ajouterElement(new PointKm(35, 20));
//		coordQuartier.ajouterElement(new PointKm(30, 25));
//		coordQuartier.ajouterElement(new PointKm(20, 20));
//				
//		quartier.setCoordonnees(coordQuartier);
//		quartier.setVille(ville);
//		System.out.println(quartier);
		
		System.out.println(DirectionEnum.HORIZONTAL);
		
<<<<<<< HEAD
		CoordonneesGeographiques coord = new CoordonneesGeographiques();
		coord.ajouterPoint(new Point(1, 1));
		coord.ajouterPoint(new Point(1, 4));
		coord.ajouterPoint(new Point(2, 7));
		coord.ajouterPoint(new Point(4, 9));
		coord.ajouterPoint(new Point(8, 7));
		coord.ajouterPoint(new Point(9, 4));
		coord.ajouterPoint(new Point(8, 1));
		coord.ajouterPoint(new Point(5, 2));
		
=======

>>>>>>> branch 'YoannF' of https://github.com/dlkiyindou/CityProject/
		//System.out.println(coord.listeDePoints);
		quartier.setCoord(coord);

		
<<<<<<< HEAD
		System.out.println(quartier.toString());
=======
		Rue rue = new Rue("Ma belle rue");
		Coordonnees4Points<PointM> coordRue = new Coordonnees4Points<PointM>();
		coordRue.ajouterElement(new PointM(5, 5));
		coordRue.ajouterElement(new PointM(15, 5));
		coordRue.ajouterElement(new PointM(5, 15));
		coordRue.ajouterElement(new PointM(10, 5));

		

		System.out.println(quartier.toString());
		if (coordRue.isValid()) {
			rue.setCoordonnees(coordRue);
		}

>>>>>>> branch 'YoannF' of https://github.com/dlkiyindou/CityProject/
	}

}
