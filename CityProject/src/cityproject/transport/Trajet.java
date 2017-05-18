package cityproject.transport;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointM;
import cityproject.exception.CityProjectException;
import cityproject.infrastructures.Rue;
import cityproject.infrastructures.geographie.DirectionEnum;



public class Trajet {
	
	private CoordonneesGeographiques <PointM> coordTrajet = new CoordonneesGeographiques<PointM>();
	PointM point_reference_origine1 = new PointM();
	PointM point_reference_origine2 = new PointM();
	PointM point_reference_fin1 = new PointM();
	PointM point_reference_fin2 = new PointM();
	
	//Constructeur par défaut 
	public Trajet() throws CityProjectException {
		setCoordTrajet(null);
	}
	
	//Constructeur
	public Trajet(PointM pointOrigin, PointM pointFinal) throws CityProjectException {
		calculTrajet(pointOrigin,pointFinal);
	}
	
	//Getter
	public CoordonneesGeographiques<PointM> getCoordTrajet() {
		return coordTrajet;
	}
	
	
	//Setter
	public void setCoordTrajet(CoordonneesGeographiques<PointM> coordTrajet) {
		this.coordTrajet = coordTrajet;
	}
	
	//Méthode de calcul du trajet
	public void calculTrajet (PointM point_debut, PointM point_fin) throws CityProjectException {
	
		
		//ajouter le premier point du trajet, po, à coordTrajet
		coordTrajet.ajouterElement(point_debut);
		
		//Les points origine et final sont dans une rue: il faudra obtenir la rue à partir de chaque point (créer méthode) 
		Rue rue_origine = new Rue (); //à changer en utilisant la méthode à créer
		Rue rue_final = new Rue (); //à changer en utilisant la méthode à créer 
		DirectionEnum direction_origine= rue_origine.getDirection();
		DirectionEnum direction_final = rue_final.getDirection();
		
		
		//Ordonnées et abscisses des points origine et final du trajet
		int x_debut=(int)point_debut.getX();
		int y_debut=(int)point_debut.getY();
		
		int x_fin=(int)point_fin.getX();
		int y_fin=(int)point_fin.getY();
		
		//coordonnees temporaux
		int x_temporal, y_temporal;
		PointM point_parcours= new PointM(0,0);
		
		
	
		
		//Détermination de points de référence pour le point origine
		
		if (direction_origine == DirectionEnum.HORIZONTAL) {
			
			//Point référence origine 1: balayer sur x jusqu'au croisement plus proche à gauche
			
			x_temporal=x_debut;
		
			do{ 
				x_temporal--;
				point_parcours.setLocation(x_temporal, y_debut);
			}while (point_parcours.isPointCentreCroisement() != null);
			
			point_reference_origine1 = point_parcours;
						
			//Point référence origine 2: balayer sur x jusqu'au croisement plus proche à droite
			
			x_temporal=x_debut;
		
			do{ 
				x_temporal++;
				point_parcours.setLocation(x_temporal, y_debut);
			}while (point_parcours.isPointCentreCroisement() != null) ;
			
			point_reference_origine2 = point_parcours;
			
			
		}
		
		
		if (direction_origine == DirectionEnum.VERTICAL) {
			
			//Point référence origine 1: Balayer sur y jusqu'au croisement plus proche au-dessus
			
			y_temporal=y_debut;
		
			do{ 
				y_temporal--;
				point_parcours.setLocation(x_debut, y_temporal);
			}while (point_parcours.isPointCentreCroisement() != null);
			
			point_reference_origine1 = point_parcours;
			
			
			//Point référence origine 2: balayer sur y jusqu'au croisement plus proche en dessous
			
			y_temporal=y_debut;
		
			do{ 
				y_temporal++;
				point_parcours.setLocation(x_debut, y_temporal);
			}while (point_parcours.isPointCentreCroisement() != null);
			
			point_reference_origine2 = point_parcours;
			
			
		}
		
		
		//Détermination de points de référence pour le point final
		
		if (direction_final == DirectionEnum.HORIZONTAL) {
			
			//Point référence fin 1: balayer sur x jusqu'au croisement plus proche à gauche
			
			x_temporal=x_fin;
		
			do{ 
				x_temporal--;
				point_parcours.setLocation(x_temporal, y_fin);
			}while (point_parcours.isPointCentreCroisement() != null);
			
			point_reference_fin1 = point_parcours;
						
			//Point référence fin 2: balayer sur x jusqu'au croisement plus proche à droite
			
			x_temporal=x_fin;
		
			do{ 
				x_temporal++;
				point_parcours.setLocation(x_temporal, y_fin);
			}while (point_parcours.isPointCentreCroisement() != null);
			
			point_reference_fin2 = point_parcours;
			
			
		}
		
		
		if (direction_origine == DirectionEnum.VERTICAL) {
			
			//Point référence fin 1: Balayer sur y jusqu'au croisement plus proche au-dessus
			
			y_temporal=y_fin;
		
			do{ 
				y_temporal--;
				point_parcours.setLocation(x_fin, y_temporal);
			}while (point_parcours.isPointCentreCroisement() != null);
			
			point_reference_fin1 = point_parcours;
			
			
			//Point référence origine 2: balayer sur y jusqu'au croisement plus proche en dessous
			
			y_temporal=y_fin;
		
			do{ 
				y_temporal++;
				point_parcours.setLocation(x_fin, y_temporal);
			}while (point_parcours.isPointCentreCroisement() != null);
			
			point_reference_fin2 = point_parcours;
			
			
		}
		
		
		
	//Calcul de 4 distances entre les points de référence (origine1-fin1, origine1-fin2, origin2-fin1,origin2-fin2)
		
		
	//Ordonnées et abscisses des points de référence
		
		int x_reference_origine1 = (int)point_reference_origine1.getX();
		int y_reference_origine1 = (int)point_reference_origine1.getY();
		
		int x_reference_origine2 = (int)point_reference_origine2.getX();
		int y_reference_origine2 = (int)point_reference_origine2.getY();
		
		int x_reference_fin1 = (int)point_reference_fin1.getX();
		int y_reference_fin1 = (int)point_reference_fin1.getY();
		
		int x_reference_fin2 = (int)point_reference_fin2.getX();
		int y_reference_fin2 = (int)point_reference_fin2.getY();
		
	//Points de mi-parcours:
		
		//entre origine1 et fin1
		
		PointM point_mi_parcours11 = new PointM();
		point_mi_parcours11.setLocation(x_reference_origine1, y_reference_fin1);
		
		//entre origine1 et fin2
		PointM point_mi_parcours12 = new PointM();
		point_mi_parcours12.setLocation(x_reference_origine1, y_reference_fin2);
		
		//entre origine2 et fin1
		PointM point_mi_parcours21 = new PointM();
		point_mi_parcours21.setLocation(x_reference_origine2, y_reference_fin1);
		
		//entre origine2 et fin2
		PointM point_mi_parcours22 = new PointM();
		point_mi_parcours22.setLocation(x_reference_origine2, y_reference_fin2);
		
		
		
	//Calcul de distances
		
		//distance entre origin1 et fin1
		
		int distance_origine1_fin1 = (int) (point_reference_origine1.distance(point_mi_parcours11) +point_mi_parcours11.distance(point_reference_fin1));
		
		//distance entre origin1 et fin2
		
		int distance_origine1_fin2 = (int) (point_reference_origine1.distance(point_mi_parcours12) +point_mi_parcours12.distance(point_reference_fin2));
		
		//distance entre origin2 et fin1
		
		int distance_origine2_fin1 = (int) (point_reference_origine2.distance(point_mi_parcours21) +point_mi_parcours21.distance(point_reference_fin2));
		
		//distance entre origine2 et fin2
		
		int distance_origine2_fin2 = (int) (point_reference_origine2.distance(point_mi_parcours22) +point_mi_parcours22.distance(point_reference_fin2));
		
		
	//Calcul de distance minimale
		
		int distance_minimale1 = Math.min(distance_origine1_fin1, distance_origine1_fin2);
		int distance_minimale2 = Math.min(distance_origine2_fin1, distance_origine2_fin2);
		
		int distance_minimale = Math.min(distance_minimale1, distance_minimale2);
		
		
		
		
		
		

		
	
	}

	
}
