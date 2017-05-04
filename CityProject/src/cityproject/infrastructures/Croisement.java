package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointKm;
import cityproject.infrastructures.geographie.PointM;

public class Croisement extends Infrastructure {
	private List<Rue> rues;

	public Croisement() {
		super();
		rues = new ArrayList<Rue>();
	}
	
	public Croisement(Rue ... _rues) {
		this();
		setRues(_rues);
	}
	
	public Croisement(String _nom, Rue ... _rues) {
		this(_rues);
		setNom(_nom);
	}

	public List<Rue> getRues() {
		return rues;
	}

	public void setRues(Rue ... _rues) {
		rues.addAll(Arrays.asList(_rues));
	}

	public void setRues(List<Rue> rues) {
		this.rues = rues;
	}
	
	public boolean addRue(Rue _rue) {
		return rues.add(_rue);
	}
	
	public boolean asRue(Rue _rue) {
		return rues.contains(_rue);
	}

	public Coordonnees4Points<PointM> getCoordonneesCroisement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
// Pseudo-code (James R)
	
//	ça que je voudrais faire:
//	
//  1) liste des points d'Origine de chaque rue (pointOrigine: 
//	        PointKm cityproject.infrastructures.Rue.pointOrigine))	
//          orig_x, orig_y
//
//  2) liste du direction de chaque rue (direction - 
//	        cityproject.infrastructures.Rue.setDirection(DirectionEnum))	
//          m_1, n_1, m_2, n_2
//
//  3) liste du longueur de chaque rue (int longueur - 
//       	cityproject.infrastructures.Rue.setLongueur(int))
//
//  4) liste du largeur de chaque rue (largeur - 
//	        cityproject.infrastructures.Rue.largeur))	
//
//  5) créer une équation pour chaque rue
//     e.g. n_1*y = m_1(x - orig_x_1) + orig_y_1
//          n_2*y = m_2(x - orig_x_2) + orig_y_2
	
//     IF direction = HORIZONTAL, m=0; n=1
//     IF direction = VERTICAL, m=1; n=0
//
//  6) reorganiser chaque équation sous la forme:
//     (avec les nouvelles variables A_1, B_1, C_1, A_2, B_2, C_2)	
//     i) A_1*x + B_1*y = C_1	
//     ii) A_2*x + B_2*y = C_2
//
//  7) definir:
//     delta = A_1*B_2 - A_2*B_1
//
//  8) IF: delta = 0
//        aucun intercept
//  
//  9) ELSE: les points d'intercept sont x_cross et y_cross:
//        X_cross = (B_2*C_1 - B_1*C_2)/delta
//        Y_cross = (A_1*C_2 - A_2*C_1)/delta
//
//  10) vérifier si ç'est bien un intercept, quand on prend
//        compte du longeur de la rue
//      IF sqrt((x_cross - orig_x_1)^2 + (y_cross - orig_y_1)^2) >=	longeur_1
//      OR sqrt((x_cross - orig_x_2)^2 + (y_cross - orig_y_2)^2) >=	longeur_2
//         aucun intercept
//      ELSE
//         continue	
//
//  11) désigner les 'coins' de l'interception
//        x1 = x_cross + (largueur_1 / 2)	
//   	  x2 = x_cross - (largueur_1 / 2)
//        x3 = x_cross + (largueur_2 / 2)	
//        x4 = x_cross - (largueur_2 / 2)
//
//        y1 = y_cross + (largueur_1 / 2)	
//	      y2 = y_cross + (largueur_1 / 2)
//        y3 = y_cross + (largueur_2 / 2)	
//        y4 = y_cross + (largueur_2 / 2)
//	
//	public Coordonnees4Points getCoordonneesCroisement() {
//		
//		return coord;
//		// TODO Auto-generated method stub
//		
//	}
	
//  public PointKm getPointIntersection(){
//		
//		return point;
//	}
	
//	public void setCroisement(){
//		
//		
//	
//	}
}
