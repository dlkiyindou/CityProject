/**
 * 
 */
package cityproject;



import java.util.ArrayList;
import java.util.List;

import cityproject.exception.CityProjectException;
import cityproject.graphique.CityProjectFenetre;
import cityproject.graphique.CityProjectPanel;
import cityproject.infrastructures.Quartier;
import cityproject.infrastructures.Rue;
import cityproject.infrastructures.Ville;
import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.DirectionEnum;
import cityproject.infrastructures.geographie.PointKm;
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
		Ville ville = creerVille();	
		
		// Constitution liste de quartiers
		
		List<Quartier> quartiers = new ArrayList<Quartier>();
		
		Quartier quartier = creerQuartier(ville);
		
		quartiers.add(quartier);
		
		// Constitution liste de rues
		
		List<Rue> rues = new ArrayList<Rue>();
		
		Rue rue1 = creerRue1();
		Rue rue2 = creerRue2();
		
		rues.add(rue1);
		rues.add(rue2);
		
		
		
		CityProjectFenetre fenetre = new CityProjectFenetre();
		CityProjectPanel villeGraphe = new CityProjectPanel(ville, quartiers, rues);
		
		villeGraphe.paintComponents(fenetre.getGraphics());
		fenetre.setContentPane(villeGraphe);
		
		fenetre.initFenetre();
	}
	
	
	private static Ville creerVille() throws CityProjectException {
		Ville ville = new Ville("CityProject ville");
		CoordonneesGeographiques<PointKm> coordVille = new CoordonneesGeographiques<PointKm>();
		coordVille.ajouterElement(new PointKm(1, 30));
		coordVille.ajouterElement(new PointKm(5, 50));
		coordVille.ajouterElement(new PointKm(10, 55));
		coordVille.ajouterElement(new PointKm(15, 70));
		coordVille.ajouterElement(new PointKm(25, 72));
		coordVille.ajouterElement(new PointKm(35, 65)); 
		coordVille.ajouterElement(new PointKm(65, 68)); 
		coordVille.ajouterElement(new PointKm(100, 65)); 
		coordVille.ajouterElement(new PointKm(110, 50));		
		coordVille.ajouterElement(new PointKm(115, 25));
		coordVille.ajouterElement(new PointKm(110, 3));
		coordVille.ajouterElement(new PointKm(100, 1));
		coordVille.ajouterElement(new PointKm(90, 15));
		coordVille.ajouterElement(new PointKm(75, 20));
		coordVille.ajouterElement(new PointKm(60, 25));
		coordVille.ajouterElement(new PointKm(45, 10));
		coordVille.ajouterElement(new PointKm(30, 5));
		coordVille.ajouterElements(new PointKm(15, 1), new PointKm(4, 3));
		ville.setCoordonnees(coordVille);
		
		return ville;
	}
	
	private static Quartier creerQuartier(Ville ville) throws CityProjectException {
		Quartier quartier = new Quartier("Le quartier centrale");
		CoordonneesGeographiques<PointKm> coordQuartier = new CoordonneesGeographiques<PointKm>();
		coordQuartier.ajouterElement(new PointKm(10, 30));
		coordQuartier.ajouterElement(new PointKm(10, 35));
		coordQuartier.ajouterElement(new PointKm(20, 37));
		coordQuartier.ajouterElement(new PointKm(24, 29));
		coordQuartier.ajouterElement(new PointKm(25, 25));
		coordQuartier.ajouterElement(new PointKm(30, 25));
		coordQuartier.ajouterElement(new PointKm(30, 20));
		coordQuartier.ajouterElement(new PointKm(35, 20));
		coordQuartier.ajouterElement(new PointKm(30, 25));
		coordQuartier.ajouterElement(new PointKm(20, 20));
				
		quartier.setCoordonnees(coordQuartier);
		quartier.setVille(ville);
		
		return quartier;
	}
	
	private static Rue creerRue1() throws CityProjectException {
		PointKm p1 = new PointKm(25,10);
		Rue rue1 = new Rue("Rue 1", p1, 50, DirectionEnum.HORIZONTAL);
		return rue1;
	}
	
	private static Rue creerRue2() throws CityProjectException {
		PointKm p2= new PointKm(26,10);
		//PointM p2_1 = new PointM(p2, 100, 200);
		Rue rue2 = new Rue("Rue 2", p2 , 50, DirectionEnum.VERTICAL);
		return rue2;
	}

}