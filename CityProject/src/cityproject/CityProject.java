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
		CoordonneesGeographiques<PointM> coordVille = new CoordonneesGeographiques<PointM>();
		coordVille.ajouterElement(new PointM(1000, 30000));
		coordVille.ajouterElement(new PointM(5000, 50000));
		coordVille.ajouterElement(new PointM(10000, 55000));
		coordVille.ajouterElement(new PointM(15000, 70000));
		coordVille.ajouterElement(new PointM(25000, 72000));
		coordVille.ajouterElement(new PointM(35000, 65000)); 
		coordVille.ajouterElement(new PointM(65000, 68000)); 
		coordVille.ajouterElement(new PointM(100000, 65000)); 
		coordVille.ajouterElement(new PointM(110000, 50000));		
		coordVille.ajouterElement(new PointM(115000, 25000));
		coordVille.ajouterElement(new PointM(110000, 3000));
		coordVille.ajouterElement(new PointM(100000, 1000));
		coordVille.ajouterElement(new PointM(90000, 15000));
		coordVille.ajouterElement(new PointM(75000, 20000));
		coordVille.ajouterElement(new PointM(60000, 25000));
		coordVille.ajouterElement(new PointM(45000, 10000));
		coordVille.ajouterElement(new PointM(30000, 5000));
		coordVille.ajouterElements(new PointM(15000, 1000), new PointM(4000, 3000));
		ville.setCoordonnees(coordVille);
		
		return ville;
	}
	
	private static Quartier creerQuartier(Ville ville) throws CityProjectException {
		Quartier quartier = new Quartier("Le quartier centrale");
		CoordonneesGeographiques<PointM> coordQuartier = new CoordonneesGeographiques<PointM>();
		coordQuartier.ajouterElement(new PointM(10000, 30000));
		coordQuartier.ajouterElement(new PointM(10000, 35000));
		coordQuartier.ajouterElement(new PointM(20000, 37000));
		coordQuartier.ajouterElement(new PointM(24000, 29000));
		coordQuartier.ajouterElement(new PointM(25000, 25000));
		coordQuartier.ajouterElement(new PointM(30000, 25000));
		coordQuartier.ajouterElement(new PointM(30000, 20000));
		coordQuartier.ajouterElement(new PointM(35000, 20000));
		coordQuartier.ajouterElement(new PointM(20000, 20000));
				
		quartier.setCoordonnees(coordQuartier);
		quartier.setVille(ville);
		
		return quartier;
	}
	
	private static Rue creerRue1() throws CityProjectException {
		PointM p1 = new PointM(25000,10000);
		Rue rue1 = new Rue("Rue 1", p1, 50000, DirectionEnum.HORIZONTAL);
		return rue1;
	}
	
	private static Rue creerRue2() throws CityProjectException {
		PointM p2= new PointM(26000,10000);
		Rue rue2 = new Rue("Rue 2", p2 , 50000, DirectionEnum.VERTICAL);
		return rue2;
	}

}