package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.List;

import cityproject.exception.CityProjectException;
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointM;

public class Parcelle {

	private Coordonnees4Points<PointM> coordParcelle;

	/*
	 * Constructeurs
	 */
	public Parcelle() {
		// TODO Auto-generated constructor stub
	}

	public Parcelle(Coordonnees4Points<PointM> coord) {
		this.coordParcelle = coord;

	}

	public Coordonnees4Points<PointM> getCoordonneesParcelle() {
		return coordParcelle;
	}

	/*
	 * M�thode de calcul de la position d'une parcelle
	 */

	public void calculPositionParcelle(PointM p, Croisement c) throws CityProjectException {


		List<Parcelle> parcelles = new ArrayList<Parcelle>();
//		parcelles = ville.getListeDeParcelles();
		
		
		// Ville ville = new Ville();
		// List<Croisement> croisements = new ArrayList<Croisement>();
		// List<Rue> rues = new ArrayList<Rue>();

		// 3 m�thodes � d�finir dans la Class Ville ou Quartier peut �tre pour
		// r�cup�rer les listes de parcelles, rues, et croisements
		
		// croisements = ville.getListeDeCroisements();
		// rues = ville.getListeDeRues();

		Coordonnees4Points<PointM> coord_croisement = c.getCoordonneesCroisement();

		int i = 0;
		int x1, y1, x2, y2, x3, y3;
		PointM point1 = null; // point de parcours sur axe E-O
		PointM point2 = null; // point de parcours sur axe N-S
		PointM point3 = null; // dernier point pour constituer la parcelle, les
								// coordonnees sont calcul�es
		
		// Rajouter un appel � m�thode pour d�terminer la position d'un point en termes cardinaux 
		// NO NE SO SE dans la s�rie de point croisement m�thode � �crire dans point probablement
		x1 = (int) p.getX();
		y1 = (int) p.getY();
		point1.setLocation(x1, y1);

		x2 = (int) p.getX();
		y2 = (int) p.getY();
		point2.setLocation(x2, y2);


		// Premier cas: On part du point NO et on calcule les coordonn�es de la parcelle
		if (i == 0) {

			do {
				x1 -= 1;
				point1.setLocation(x1, y1);
			} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
			// m�thode isPointExtremeRue ou isPointCroissement

			do {
				y2 += 1;
				point2.setLocation(x2, y2);
			} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
			// m�thode � d�crire dans Croisement ou Rue

			x3 = (int) point1.getX();
			y3 = (int) point2.getY();
			point3.setLocation(x3, y3);

			coordParcelle.ajouterElement(point3); // point NO
			coordParcelle.ajouterElement(point2); // point NE
			coordParcelle.ajouterElement(point1); // point SO
			coordParcelle.ajouterElement(p); // point SE

			parcelles.add(this);

			i++;
		}

		// Deuxi�me cas: On part du point NE et on calcule les coordonn�es de la parcelle
		if (i == 1) {

			do {
				x1 += 1;
				point1.setLocation(x1, y1);
			} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
			// m�thode isPointExtremeRue ou isPointCroissement

			do {
				y2 += 1;
				point2.setLocation(x2, y2);
			} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
			// m�thode � d�crire dans Croisement ou Rue

			x3 = (int) point1.getX();
			y3 = (int) point2.getY();
			point3.setLocation(x3, y3);

			coordParcelle.ajouterElement(point2);// point NO
			coordParcelle.ajouterElement(point3); // point NE
			coordParcelle.ajouterElement(p); // point SO
			coordParcelle.ajouterElement(point1); // point SE

			parcelles.add(this);

			i++;
		}

		// Troisi�me cas: On part du point SO et on calcule les coordonn�es de la parcelle
		if (i == 2) {

			do {
				x1 -= 1;
				point1.setLocation(x1, y1);
			} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
			// m�thode isPointExtremeRue ou isPointCroissement

			do {
				y2 -= 1;
				point2.setLocation(x2, y2);
			} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
			// m�thode � d�crire dans Croisement ou Rue

			x3 = (int) point1.getX();
			y3 = (int) point2.getY();
			point3.setLocation(x3, y3);

			coordParcelle.ajouterElement(point1); // Point NO
			coordParcelle.ajouterElement(p); // Point NE
			coordParcelle.ajouterElement(point3); // Point SO
			coordParcelle.ajouterElement(point2); // Point SE

			parcelles.add(this);

			i++;
		}

		// Quatri�me cas: On part du point SE et on calcule les coordonn�es de la parcelle
		if (i == 3) {

			do {
				x1 += 1;
				point1.setLocation(x1, y1);
			} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
			// m�thode isPointExtremeRue ou isPointCroissement

			do {
				y2 -= 1;
				point2.setLocation(x2, y2);
			} while ((point1 != p.isPointExtremeRue() || point1 != p.isPointCroisement));
			// m�thode � d�crire dans Croisement ou Rue

			x3 = (int) point1.getX();
			y3 = (int) point2.getY();
			point3.setLocation(x3, y3);

			coordParcelle.ajouterElement(p); // Point NO
			coordParcelle.ajouterElement(point1); // Point NE
			coordParcelle.ajouterElement(point2); // Point SO
			coordParcelle.ajouterElement(point3); // Point SE

			parcelles.add(this);

		}

	}

	// Methode de mise � jour de la liste de parcelle avec �limination des
	// doublons et des parcelles chevauchantes. A mettre ailleurs je crois
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
