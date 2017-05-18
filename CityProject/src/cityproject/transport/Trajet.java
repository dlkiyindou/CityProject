package cityproject.transport;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointM;
import cityproject.exception.CityProjectException;
import cityproject.infrastructures.Rue;
import cityproject.infrastructures.geographie.DirectionEnum;



public class Trajet {
	
	private CoordonneesGeographiques <PointM> coordTrajet = new CoordonneesGeographiques<PointM>();
	PointM pointReferenceOrigine1 = new PointM();
	PointM pointReferenceOrigine2 = new PointM();
	PointM pointReferenceFin1 = new PointM();
	PointM pointReferenceFin2 = new PointM();
	
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
	public void calculTrajet (PointM pointDebut, PointM pointFin) throws CityProjectException {
	
		
		//ajouter le premier point du trajet, po, à coordTrajet
		coordTrajet.ajouterElement(pointDebut);
		
		//Les points origine et final sont dans une rue: il faudra obtenir la rue à partir de chaque point (créer méthode) 
		Rue rueOrigine = new Rue (); //à changer en utilisant la méthode à créer
		Rue rueFinal = new Rue (); //à changer en utilisant la méthode à créer 
		DirectionEnum directionOrigine= rueOrigine.getDirection();
		DirectionEnum directioFinal = rueFinal.getDirection();
		
		
		//Ordonnées et abscisses des points origine et final du trajet
		int xDebut=(int)pointDebut.getX();
		int yDebut=(int)pointDebut.getY();
		
		int xFin=(int)pointFin.getX();
		int yFin=(int)pointFin.getY();
		
		//coordonnees temporaux
		int xTemporal, yTemporal;
		PointM pointParcours= new PointM(0,0);
		
		
	
		
		//Détermination de points de référence pour le point origine
		
		if (directionOrigine == DirectionEnum.HORIZONTAL) {
			
			//Point référence origine 1: balayer sur x jusqu'au croisement plus proche à gauche
			
			xTemporal=xDebut;
		
			do{ 
				xTemporal--;
				pointParcours.setLocation(xTemporal, yDebut);
			}while (pointParcours.isPointCentreCroisement() != null);
			
			pointReferenceOrigine1 = pointParcours;
						
			//Point référence origine 2: balayer sur x jusqu'au croisement plus proche à droite
			
			xTemporal=xDebut;
		
			do{ 
				xTemporal++;
				pointParcours.setLocation(xTemporal, yDebut);
			}while (pointParcours.isPointCentreCroisement() != null) ;
			
			pointReferenceOrigine2 = pointParcours;
			
			
		}
		
		
		if (directionOrigine == DirectionEnum.VERTICAL) {
			
			//Point référence origine 1: Balayer sur y jusqu'au croisement plus proche au-dessus
			
			yTemporal=yDebut;
		
			do{ 
				yTemporal--;
				pointParcours.setLocation(xDebut, yTemporal);
			}while (pointParcours.isPointCentreCroisement() != null);
			
			pointReferenceOrigine1 = pointParcours;
			
			
			//Point référence origine 2: balayer sur y jusqu'au croisement plus proche en dessous
			
			yTemporal=yDebut;
		
			do{ 
				yTemporal++;
				pointParcours.setLocation(xDebut, yTemporal);
			}while (pointParcours.isPointCentreCroisement() != null);
			
			pointReferenceOrigine2 = pointParcours;
			
			
		}
		
		
		//Détermination de points de référence pour le point final
		
		if (directioFinal == DirectionEnum.HORIZONTAL) {
			
			//Point référence fin 1: balayer sur x jusqu'au croisement plus proche à gauche
			
			xTemporal=xFin;
		
			do{ 
				xTemporal--;
				pointParcours.setLocation(xTemporal, yFin);
			}while (pointParcours.isPointCentreCroisement() != null);
			
			pointReferenceFin1 = pointParcours;
						
			//Point référence fin 2: balayer sur x jusqu'au croisement plus proche à droite
			
			xTemporal=xFin;
		
			do{ 
				xTemporal++;
				pointParcours.setLocation(xTemporal, yFin);
			}while (pointParcours.isPointCentreCroisement() != null);
			
			pointReferenceFin2 = pointParcours;
			
			
		}
		
		
		if (directionOrigine == DirectionEnum.VERTICAL) {
			
			//Point référence fin 1: Balayer sur y jusqu'au croisement plus proche au-dessus
			
			yTemporal=yFin;
		
			do{ 
				yTemporal--;
				pointParcours.setLocation(xFin, yTemporal);
			}while (pointParcours.isPointCentreCroisement() != null);
			
			pointReferenceFin1 = pointParcours;
			
			
			//Point référence origine 2: balayer sur y jusqu'au croisement plus proche en dessous
			
			yTemporal=yFin;
		
			do{ 
				yTemporal++;
				pointParcours.setLocation(xFin, yTemporal);
			}while (pointParcours.isPointCentreCroisement() != null);
			
			pointReferenceFin2 = pointParcours;
			
			
		}
		
		
		
	//Calcul de 4 distances entre les points de référence (origine1-fin1, origine1-fin2, origin2-fin1,origin2-fin2)
		
		
	//Ordonnées et abscisses des points de référence
		
		int xReferenceOrigine1 = (int)pointReferenceOrigine1.getX();
		int yReferenceOrigine1 = (int)pointReferenceOrigine1.getY();
		
		int xReferenceOrigine2 = (int)pointReferenceOrigine2.getX();
		int yReferenceOrigine2 = (int)pointReferenceOrigine2.getY();
		
		int xReferenceFin1 = (int)pointReferenceFin1.getX();
		int yReferenceFin1 = (int)pointReferenceFin1.getY();
		
		int xReferenceFin2 = (int)pointReferenceFin2.getX();
		int yReferenceFin2 = (int)pointReferenceFin2.getY();
		
	//Points de mi-parcours:
		
		//entre origine1 et fin1
		
		PointM pointMiParcours11 = new PointM();
		pointMiParcours11.setLocation(xReferenceOrigine1, yReferenceFin1);
		
		//entre origine1 et fin2
		PointM pointMiParcours12 = new PointM();
		pointMiParcours12.setLocation(xReferenceOrigine1, yReferenceFin2);
		
		//entre origine2 et fin1
		PointM pointMiParcours21 = new PointM();
		pointMiParcours21.setLocation(xReferenceOrigine2, yReferenceFin1);
		
		//entre origine2 et fin2
		PointM pointMiParcours22 = new PointM();
		pointMiParcours22.setLocation(xReferenceOrigine2, yReferenceFin2);
		
		
		
	//Calcul de distances
		
		//distance entre origin1 et fin1
		
		int distanceOrigine1Fin1 = (int) (pointReferenceOrigine1.distance(pointMiParcours11) +pointMiParcours11.distance(pointReferenceFin1));
		
		//distance entre origin1 et fin2
		
		int distanceOrigine1Fin2 = (int) (pointReferenceOrigine1.distance(pointMiParcours12) +pointMiParcours12.distance(pointReferenceFin2));
		
		//distance entre origin2 et fin1
		
		int distanceOrigine2Fin1 = (int) (pointReferenceOrigine2.distance(pointMiParcours21) +pointMiParcours21.distance(pointReferenceFin2));
		
		//distance entre origine2 et fin2
		
		int distanceOrigine2Fin2 = (int) (pointReferenceOrigine2.distance(pointMiParcours22) +pointMiParcours22.distance(pointReferenceFin2));
		
		
	//Calcul de distance minimale
		
		Math.min(Math.min(distanceOrigine1Fin1, distanceOrigine1Fin2), Math.min(distanceOrigine2Fin1, distanceOrigine2Fin2));
		
//		int distanceMinimale1 = Math.min(distanceOrigine1Fin1, distanceOrigine1Fin2);
//		int distanceMinimale2 = Math.min(distanceOrigine2Fin1, distanceOrigine2Fin2);
//		
//		int distanceMinimale = Math.min(distanceMinimale1, distanceMinimale2);
		
		
		
		
		
		

		
	
	}

	
}
