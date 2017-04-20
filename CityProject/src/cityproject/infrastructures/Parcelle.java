package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.List;

import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointKm;

public class Parcelle {

	private List<Croisement> croisements = new ArrayList<Croisement>();
	private List<Rue> rues = new ArrayList<Rue>();
	private Coordonnees4Points<PointKm> coord_parcelle, coord_croisement;

	/*
	 * Constructeurs
	 */

	public Parcelle() {
		// TODO Auto-generated constructor stub
	}

	public Parcelle(Coordonnees4Points<PointKm> coord) {
		this.coord_parcelle = coord;

	}

	// méthode de mise en place des parcelles en fonction des cas

	// public void setParcelle(List<Croisement> croisements) throws Exception {
	// if (croisements.size() == 1) {
	//
	// this.croisements = croisements;
	// } else if (croisements.size() == 2) {
	//
	// } else if (croisements.size() == 3) {
	//
	// } else if (croisements.size() == 4) {
	//
	// }
	// throw new Exception("A définir");
	// }

	/*
	 * Méthode pour vérifier qu'un croisement est contenu dans la liste de
	 * croisements
	 */

	public boolean asCroisement(Croisement _croisement) {
		return croisements.contains(_croisement);
	}

	/*
	 * Méthode de calcul des coordonnees de parcelle
	 */

	public void calculCoordonneesParcelle() {

		for (Croisement c : croisements) {

			List<PointKm> coord_croisement = c.getCoordonneesCroisement();

			int i = 0;
			PointKm point1 = new PointKm(0, 0); // point de parcours sur axe E-O
			PointKm point2 = new PointKm(0, 0); // point de parcours sur axe N-S
			PointKm point3 = new PointKm(0, 0); // dernier point pour constituer la parcelle, les coordonnees sont calculées

			for (PointKm p : coord_croisement) {

				int x1, y1, x2, y2, x3, y3;

				x1 = (int) p.getX();
				y1 = (int) p.getY();
				point1.setLocation(x1, y1);

				x2 = (int) p.getX();
				y2 = (int) p.getY();
				point2.setLocation(x2, y2);
				
				/*
				 * Premier cas: On part du point NO et on calcul les coordonnées
				 * de la parcelle
				 */

				if (i == 0) {

					do {
						x1 -= 1;
						point1.setLocation(x1, y1);
					} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
					// méthode isPointExtremeRue ou isPointCroissement

					do {
						y2 += 1;
						point2.setLocation(x2, y2);
					} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
					// méthode à décrire dans Croisement ou Rue
					
					x3 = (int) point1.getX();
					y3 = (int) point2.getY();
					point3.setLocation(x3, y3);
					
					coord_parcelle.ajouterElement(point3); //point NO
					coord_parcelle.ajouterElement(point2); //point NE
					coord_parcelle.ajouterElement(point1); //point SO
					coord_parcelle.ajouterElement(p);	//point SE
					
					i++;
				}
				
				/*
				 * Deuxième cas: On part du point NE et on calcul les coordonnées
				 * de la parcelle
				 */

				if (i == 1) {

					do {
						x1 += 1;
						point1.setLocation(x1, y1);
					} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
					// méthode isPointExtremeRue ou isPointCroissement

					do {
						y2 += 1;
						point2.setLocation(x2, y2);
					} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
					// méthode à décrire dans Croisement ou Rue
					
					x3 = (int) point1.getX();
					y3 = (int) point2.getY();
					point3.setLocation(x3, y3);
					
					coord_parcelle.ajouterElement(point2);// point NO
					coord_parcelle.ajouterElement(point3); //point NE
					coord_parcelle.ajouterElement(p); //point SO
					coord_parcelle.ajouterElement(point1); //point SE
					
					
					i++;
				}
				
				/*
				 * Troisième cas: On part du point SO et on calcule les coordonnées
				 * de la parcelle
				 */

				if (i == 2) {

					do {
						x1 -= 1;
						point1.setLocation(x1, y1);
					} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
					// méthode isPointExtremeRue ou isPointCroissement

					do {
						y2 -= 1;
						point2.setLocation(x2, y2);
					} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
					// méthode à décrire dans Croisement ou Rue
					
					x3 = (int) point1.getX();
					y3 = (int) point2.getY();
					point3.setLocation(x3, y3);
					
					coord_parcelle.ajouterElement(point1); //Point NO
					coord_parcelle.ajouterElement(p); // Point NE
					coord_parcelle.ajouterElement(point3); // Point SO
					coord_parcelle.ajouterElement(point2); // Point SE
					
					
					i++;
				}
				
				/*
				 * Quatrième cas: On part du point SE et on calcule les coordonnées
				 * de la parcelle
				 */

				if (i == 3) {

					do {
						x1 += 1;
						point1.setLocation(x1, y1);
					} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
					// méthode isPointExtremeRue ou isPointCroissement

					do {
						y2 -= 1;
						point2.setLocation(x2, y2);
					} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
					// méthode à décrire dans Croisement ou Rue
					
					x3 = (int) point1.getX();
					y3 = (int) point2.getY();
					point3.setLocation(x3, y3);
					
					coord_parcelle.ajouterElement(p); //Point NO
					coord_parcelle.ajouterElement(point1); // Point NE
					coord_parcelle.ajouterElement(point2); // Point SO
					coord_parcelle.ajouterElement(point3); // Point SE
				}
			}

		}

		// if (croisements.size() == 4) {
		//
		// for (Croisement c : croisements) {
		//
		// List<PointKm> listeDePoints = c.getCoordonneesCroisement();
		//
		// for (PointKm p : listeDePoints) {
		//
		// if (c.getPointIntersection().getX() > pointNordOuest.getX()){
		//
		// }
		//
		// }
		// }
		// }

		// if (croisements.size() == 1) {
		//
		// } else if (croisements.size() == 2) {
		//
		// } else if (croisements.size() == 3) {
		//
		// }

	}
}
