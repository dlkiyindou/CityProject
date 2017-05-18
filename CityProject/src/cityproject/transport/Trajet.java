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
		
		// Cas dans lequel le point debut et fin sont dans le même "morceau" de rue (entre le deux même croisement)!!
		
		
		//Détermination de points de référence pour le point origine
		
		if (direction_origine == DirectionEnum.HORIZONTAL) {
			
			//Point référence origine 1: balayer sur x jusqu'au croisement plus proche à gauche
			
			x_temporal=x_debut;
		
			do{ 
				x_temporal--;
				point_parcours.setLocation(x_temporal, y_debut);
			}while (point_parcours.isPointCroisement() != null);
			
			point_reference_origine1 = point_parcours;
						
			//Point référence origine 2: balayer sur x jusqu'au croisement plus proche à droite
			
			x_temporal=x_debut;
		
			do{ 
				x_temporal++;
				point_parcours.setLocation(x_temporal, y_debut);
			}while (point_parcours.isPointCroisement() != null) ;
			
			point_reference_origine2 = point_parcours;
			
			
		}
		
		
		if (direction_origine == DirectionEnum.VERTICAL) {
			
			//Point référence origine 1: Balayer sur y jusqu'au croisement plus proche au-dessus
			
			y_temporal=y_debut;
		
			do{ 
				y_temporal--;
				point_parcours.setLocation(x_debut, y_temporal);
			}while (point_parcours.isPointCroisement() != null);
			
			point_reference_origine1 = point_parcours;
			
			
			//Point référence origine 2: balayer sur y jusqu'au croisement plus proche en dessous
			
			y_temporal=y_debut;
		
			do{ 
				y_temporal++;
				point_parcours.setLocation(x_debut, y_temporal);
			}while (point_parcours.isPointCroisement() != null);
			
			point_reference_origine2 = point_parcours;
			
			
		}
		
		
		//Détermination de points de référence pour le point final
		
		if (direction_final == DirectionEnum.HORIZONTAL) {
			
			//Point référence fin 1: balayer sur x jusqu'au croisement plus proche à gauche
			
			x_temporal=x_fin;
		
			do{ 
				x_temporal--;
				point_parcours.setLocation(x_temporal, y_fin);
			}while (point_parcours.isPointCroisement() != null);
			
			point_reference_fin1 = point_parcours;
						
			//Point référence fin 2: balayer sur x jusqu'au croisement plus proche à droite
			
			x_temporal=x_fin;
		
			do{ 
				x_temporal++;
				point_parcours.setLocation(x_temporal, y_fin);
			}while (point_parcours.isPointCroisement() != null);
			
			point_reference_fin2 = point_parcours;
			
			
		}
		
		
		if (direction_origine == DirectionEnum.VERTICAL) {
			
			//Point référence fin 1: Balayer sur y jusqu'au croisement plus proche au-dessus
			
			y_temporal=y_fin;
		
			do{ 
				y_temporal--;
				point_parcours.setLocation(x_fin, y_temporal);
			}while (point_parcours.isPointCroisement() != null);
			
			point_reference_fin1 = point_parcours;
			
			
			//Point référence origine 2: balayer sur y jusqu'au croisement plus proche en dessous
			
			y_temporal=y_fin;
		
			do{ 
				y_temporal++;
				point_parcours.setLocation(x_fin, y_temporal);
			}while (point_parcours.isPointCroisement() != null);
			
			point_reference_fin2 = point_parcours;
			
			
		}
		
	
	}

	
}