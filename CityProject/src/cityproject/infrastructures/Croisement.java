package cityproject.infrastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cityproject.infrastructures.geographie.Coordonnees4Points;
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
	
	public static void main(String[] args){

	
// Pseudo-code (James R)
	
//	ça que je voudrais faire:
//	
//  1) liste des points d'Origine de chaque rue (pointOrigine: 
//	        PointKm cityproject.infrastructures.Rue.pointOrigine))	
//          orig_x_1, orig_y_1, orig_x_2, orig_y_2
//
double orig_x_1 = 2; double orig_y_1 = 2;
//
double orig_x_2 = 4; double orig_y_2 = 4;
//
//  2) liste du direction de chaque rue (direction - 
//	        cityproject.infrastructures.Rue.setDirection(DirectionEnum))	
//          m_1, n_1, m_2, n_2
//
//          IF direction = HORIZONTAL +ve, m=0; n=1
//          IF direction = HORIZONTAL -ve, m=0; n=-1
//
//          IF direction = VERTICAL +ve, m=1; n=0
//          IF direction = VERTICAL -ve, m=-1; n=0
//
double m_1 = 0;
double n_1 = 1;
double m_2 = 1;
double n_2 = 0;
//
//  3) liste du longueur de chaque rue (int longueur - 
//       	cityproject.infrastructures.Rue.setLongueur(int))
//
double longeur_1 = 10;
double longeur_2 = 20;
//
//  4) liste du largeur de chaque rue (largeur - 
//	        cityproject.infrastructures.Rue.largeur))	
//
double largeur_1 = 0.5;
double largeur_2 = 0.5;

System.out.print("largeur_1: " +largeur_1+ ",   ");
System.out.println("largeur_2: " +largeur_2+ ",   ");


//
//  5) créer une équation pour chaque rue
//     e.g. i)  n_1*(y - orig_y_1) = m_1(x - orig_x_1)
//          ii) n_2*(y - orig_y_2) = m_2(x - orig_x_2)
//
//
//  6) reorganiser chaque équation sous la forme:
//     (avec les nouvelles variables A_1, B_1, C_1, A_2, B_2, C_2)	
//     i)  A_1*x + B_1*y = C_1	
//     ii) A_2*x + B_2*y = C_2
//
//     i)  (m_1 * x) - (n_1 * y) = (m_1 * orig_x_1) - (n_1 * orig_y_1)
//     ii) (m_2 * x) - (n_2 * y) = (m_2 * orig_x_2) - (n_2 * orig_y_2)
//
double A_1 = m_1;
double B_1 = -n_1;
double C_1 = (m_1 * orig_x_1) - (n_1 * orig_y_1);
double A_2 = m_2;
double B_2 = -n_2;
double C_2 = (m_2 * orig_x_2) - (m_1 * orig_y_2);


System.out.print("A_1: " +A_1+ ",   ");
System.out.print("B_1: " +B_1+ ",   ");
System.out.println("C_1: " +C_1+ ",   ");
System.out.print("A_2: " +A_2+ ",   ");
System.out.print("B_2: " +B_2+ ",   ");
System.out.println("C_2: " +C_2+ ",   ");

//
//  7) definir:
//     delta = A_1*B_2 - A_2*B_1
//
double delta = ((A_1*B_2) - (A_2*B_1));
//
System.out.println("delta: " +delta+ ",   ");
//
//
//  8) IF: delta = 0
//        aucun intercept
//  
//  9) ELSE: les points d'intercept sont x_cross et y_cross:
//        x_cross = (B_2*C_1 - B_1*C_2)/delta
//        y_cross = (A_1*C_2 - A_2*C_1)/delta
//
double x_cross=((B_2*C_1) - (B_1*C_2))/delta;	
double y_cross=((A_1*C_2) - (A_2*C_1))/delta;
//

//
//
//
//  10) vérifier si ç'est bien un intercept, quand on prend
//        compte du longeur de la rue
//      IF sqrt((x_cross - orig_x_1)^2 + (y_cross - orig_y_1)^2) >=	longeur_1
//      OR sqrt((x_cross - orig_x_2)^2 + (y_cross - orig_y_2)^2) >=	longeur_2
//         aucun intercept
//      ELSE
//         continue	

if ((Math.pow((x_cross - orig_x_1),2) + Math.pow((y_cross - orig_y_1),2)) >= Math.pow(longeur_1,2)) {
	System.out.println("rue 1 trop court");
} else if ((Math.pow((x_cross - orig_x_1),2) + Math.pow((y_cross - orig_y_1),2)) >= Math.pow(longeur_2,2)) {
	System.out.println("rue 2 trop court");
} else if (delta == 0) {
	System.out.println("rue 2 trop court");
} 
  else {
	System.out.println("c'est bien un croisement");
	System.out.println("    ");
	System.out.println("Coordonnés de croisement");
	System.out.println("------------------------");

	System.out.print("x_cross: " +x_cross+ ",   ");
	System.out.println("y_cross: " +y_cross+ ",   ");
}
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
double x1 = x_cross + (largeur_1 / 2);	
double x2 = x_cross - (largeur_1 / 2);
double x3 = x_cross + (largeur_2 / 2);	
double x4 = x_cross - (largeur_2 / 2);
//
double y1 = y_cross + (largeur_1 / 2);	
double y2 = y_cross + (largeur_1 / 2);
double y3 = y_cross + (largeur_2 / 2);	
double y4 = y_cross + (largeur_2 / 2);
//

System.out.println("    ");
System.out.println("les coins de chaque croisement");
System.out.println("------------------------------");


System.out.print("x1: "+x1+ ", ");
System.out.print("x2: "+x2+ ", ");
System.out.print("x3: "+x3+ ", ");
System.out.println("x4: "+x4+ ", ");

System.out.print("y1: "+y1+ ", ");
System.out.print("y2: "+y2+ ", ");
System.out.print("y3: "+y3+ ", ");
System.out.println("y4: "+y4+ ", ");

}

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