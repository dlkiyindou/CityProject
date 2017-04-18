package cityproject.infrastructures;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointKm;

public class Parcelle {

	private List<Croisement> croisements = new ArrayList<Croisement>();
	private Coordonnees4Points coord_parcelle;

	/*
	 * Constructeurs
	 */

	public Parcelle() {
		// TODO Auto-generated constructor stub
	}

	public Parcelle(Coordonnees4Points coord) {
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

	public void calculCoordonneesParcelle() {

		if (croisements.size() == 4) {

			for (Croisement c : croisements) {

				List<PointKm> listeDePoints = c.getCoordonneesCroisement();

				for (PointKm p : listeDePoints) {
					
					if (c.getPointIntersection.getX 

				}
			}
		}

//		if (croisements.size() == 1) {
//
//		} else if (croisements.size() == 2) {
//
//		} else if (croisements.size() == 3) {
//
//		}
	

		

	}
}
