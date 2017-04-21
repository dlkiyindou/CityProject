package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.List;

import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointKm;
import cityproject.infrastructures.geographie.PointM;

public class Parcelle {

	private Coordonnees4Points<PointM> coord_parcelle;

	/*
	 * Constructeurs
	 */

	public Parcelle() {
		// TODO Auto-generated constructor stub
	}

	public Parcelle(Coordonnees4Points<PointM> coord) {
		this.coord_parcelle = coord;

	}

	public Coordonnees4Points<PointM> getCoordonneesParcelle() {
		return coord_parcelle;
	}

	/*
	 * Méthode de calcul de la position d'une parcelle
	 */

	public void calculPositionParcelle(PointM p, Croisement c) {


		List<Parcelle> parcelles = new ArrayList<Parcelle>();
		
		// Ville ville = new Ville();
		// List<Croisement> croisements = new ArrayList<Croisement>();
		// List<Rue> rues = new ArrayList<Rue>();

		// 3 méthodes à définir dans la Class Ville ou Quartier peut être pour
		// récupérer les listes de parcelles, rues, et croisements
		// parcelles = ville.getListeDeParcelles();
		// croisements = ville.getListeDeCroisements();
		// rues = ville.getListeDeRues();

		Coordonnees4Points<PointM> coord_croisement = c.getCoordonneesCroisement();

		int i = 0;
		int x1, y1, x2, y2, x3, y3;
		PointM point1 = null; // point de parcours sur axe E-O
		PointM point2 = null; // point de parcours sur axe N-S
		PointM point3 = null; // dernier point pour constituer la parcelle, les
								// coordonnees sont calculées
		
		// Rajouter un appel à méthode pour déterminer la position d'un point en termes cardinaux NO NE SO SE dans la série de point croisement
		// méthode à écrire dans point probablement

		x1 = (int) p.getX();
		y1 = (int) p.getY();
		point1.setLocation(x1, y1);

		x2 = (int) p.getX();
		y2 = (int) p.getY();
		point2.setLocation(x2, y2);

		/*
		 * Premier cas: On part du point NO et on calcule les coordonnées de la
		 * parcelle
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

			coord_parcelle.ajouterElement(point3); // point NO
			coord_parcelle.ajouterElement(point2); // point NE
			coord_parcelle.ajouterElement(point1); // point SO
			coord_parcelle.ajouterElement(p); // point SE

			parcelles.add(this);

			i++;
		}

		/*
		 * Deuxième cas: On part du point NE et on calcule les coordonnées de la
		 * parcelle
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
			coord_parcelle.ajouterElement(point3); // point NE
			coord_parcelle.ajouterElement(p); // point SO
			coord_parcelle.ajouterElement(point1); // point SE

			parcelles.add(this);

			i++;
		}

		/*
		 * Troisième cas: On part du point SO et on calcule les coordonnées de
		 * la parcelle
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

			coord_parcelle.ajouterElement(point1); // Point NO
			coord_parcelle.ajouterElement(p); // Point NE
			coord_parcelle.ajouterElement(point3); // Point SO
			coord_parcelle.ajouterElement(point2); // Point SE

			parcelles.add(this);

			i++;
		}

		/*
		 * Quatrième cas: On part du point SE et on calcule les coordonnées de
		 * la parcelle
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

			coord_parcelle.ajouterElement(p); // Point NO
			coord_parcelle.ajouterElement(point1); // Point NE
			coord_parcelle.ajouterElement(point2); // Point SO
			coord_parcelle.ajouterElement(point3); // Point SE

			parcelles.add(this);

		}

	}

	// Méthode de mise à jour de la liste de parcelle avec élimination des
	// doublons et des parcelles chevauchantes.

	// public void simplifyListeDeParcelle() {
	//
	// Ville ville = new Ville();
	// List<Parcelle> parcelles = new ArrayList<Parcelle>();
	//
	// parcelles = ville.getListeDeParcelles();
	//
	// for (Parcelle p: parcelles){
	// }
	// }

}
