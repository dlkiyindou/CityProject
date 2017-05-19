package cityproject.transport;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointM;
import java.util.HashMap;
import java.util.Map;

import cityproject.exception.CityProjectException;
import cityproject.infrastructures.Rue;
import cityproject.infrastructures.geographie.DirectionEnum;



public class Trajet {
	
	/**
	 * classe interne à utiliser dans le HashMap mapDistancePairPointsReference
	 * @author Cecilia
	 *
	 */
	public class PairPointsReference {

		private PointM point1 = new PointM();
		private PointM point2 = new PointM();
		
		/**
		 * Constructeur
		 * @param point1
		 * @param point2
		 */
		public PairPointsReference (PointM point1,PointM point2) {
		
			this.setPoint1(point1);
			this.setPoint2(point2);
			
		}

		/**
		 * Getter
		 * @return
		 */
		public PointM getPoint1() {
			return point1;
		}
		
		/**
		 * Setter
		 * @param point1
		 */
		public void setPoint1(PointM point1) {
			this.point1 = point1;
		}
		
		/**
		 * Getter
		 * @return
		 */
		public PointM getPoint2() {
			return point2;
		}

		/**
		 * Setter
		 * @return
		 */
		public void setPoint2(PointM point2) {
			this.point2 = point2;
		}
		
		
		
	}


	private CoordonneesGeographiques <PointM> coordTrajet = new CoordonneesGeographiques<PointM>();
	private PointM pointReferenceOrigine1 = new PointM();
	private PointM pointReferenceOrigine2 = new PointM();
	private PointM pointReferenceFin1 = new PointM();
	private PointM pointReferenceFin2 = new PointM();
	
	

	/**
	 * Constructeur
	 * @param pointOrigin
	 * @param pointFinal
	 * @throws CityProjectException
	 */
	public Trajet(PointM pointOrigin, PointM pointFinal) throws CityProjectException {
		calculTrajet(pointOrigin,pointFinal);
	}
	
	/**
	 * Getter
	 * @return
	 */
	public CoordonneesGeographiques<PointM> getCoordTrajet() {
		return coordTrajet;
	}
	
	
	
	/**
	 * Setter
	 * @param coordTrajet
	 */
	public void setCoordTrajet(CoordonneesGeographiques<PointM> coordTrajet) {
		this.coordTrajet = coordTrajet;
	}
	

	/**
	 * Méthode de calcul du trajet
	 * @param pointDebut
	 * @param pointFin
	 * @throws CityProjectException
	 */
	public void calculTrajet (PointM pointDebut, PointM pointFin) throws CityProjectException {
	
		
		
		coordTrajet.ajouterElement(pointDebut); //ajouter le premier point du trajet à coordTrajet
		
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
		
	
	
		if((pointReferenceOrigine1.equals(pointReferenceFin1))&&((pointReferenceOrigine1.equals(pointReferenceFin1)))){
			
			coordTrajet.ajouterElement(pointFin); //ajouter le dernier point du trajet à coordTrajet
		}
		else{
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
			
			//entre referenceOrigine1 et referenceFin1
			
			PointM pointMiParcours11 = new PointM();
			pointMiParcours11.setLocation(xReferenceOrigine1, yReferenceFin1);
			
			//entre referenceOrigine1 et referenceFin2
			PointM pointMiParcours12 = new PointM();
			pointMiParcours12.setLocation(xReferenceOrigine1, yReferenceFin2);
			
			//entre referenceOrigine2 et referenceFin1
			PointM pointMiParcours21 = new PointM();
			pointMiParcours21.setLocation(xReferenceOrigine2, yReferenceFin1);
			
			//entre referenceOrigine2 et referenceFin2
			PointM pointMiParcours22 = new PointM();
			pointMiParcours22.setLocation(xReferenceOrigine2, yReferenceFin2);
			
			
			
			//Calcul de distances:
			
			//distance entre referenceOrigine1 et referenceFin1
			
			int distanceOrigine1Fin1 = (int) (pointReferenceOrigine1.distance(pointMiParcours11) +pointMiParcours11.distance(pointReferenceFin1));
			
			//distance entre referenceOrigine1 et referenceFin2
			
			int distanceOrigine1Fin2 = (int) (pointReferenceOrigine1.distance(pointMiParcours12) +pointMiParcours12.distance(pointReferenceFin2));
			
			//distance entre referenceOrigine2 et referenceFin1
			
			int distanceOrigine2Fin1 = (int) (pointReferenceOrigine2.distance(pointMiParcours21) +pointMiParcours21.distance(pointReferenceFin2));
			
			//distance entre referenceOrigine2 et referenceFin2
			
			int distanceOrigine2Fin2 = (int) (pointReferenceOrigine2.distance(pointMiParcours22) +pointMiParcours22.distance(pointReferenceFin2));
		
			//Creation d'un Map qui lie chaque distance à ses points de reference origine et fin 
			
			Map<Integer, PairPointsReference> mapPairPointsReferenceDistance= new HashMap<Integer, PairPointsReference>();
			
			PairPointsReference pairPointsReference11 = new PairPointsReference(pointReferenceOrigine1,pointReferenceOrigine1);
			PairPointsReference pairPointsReference12 = new PairPointsReference(pointReferenceOrigine1,pointReferenceOrigine2);
			PairPointsReference pairPointsReference21 = new PairPointsReference(pointReferenceOrigine2,pointReferenceOrigine1);
			PairPointsReference pairPointsReference22 = new PairPointsReference(pointReferenceOrigine2,pointReferenceOrigine2);
			
			
			mapPairPointsReferenceDistance.put(distanceOrigine1Fin1, pairPointsReference11);
			mapPairPointsReferenceDistance.put(distanceOrigine1Fin2, pairPointsReference12);
			mapPairPointsReferenceDistance.put(distanceOrigine2Fin1, pairPointsReference21);
			mapPairPointsReferenceDistance.put(distanceOrigine2Fin2, pairPointsReference22);
			
			
			
			
			//Calcul de distance minimale
			
			int distanceMinimale = Math.min(Math.min(distanceOrigine1Fin1, distanceOrigine1Fin2), Math.min(distanceOrigine2Fin1, distanceOrigine2Fin2));
			
	//		int distanceMinimale1 = Math.min(distanceOrigine1Fin1, distanceOrigine1Fin2);
	//		int distanceMinimale2 = Math.min(distanceOrigine2Fin1, distanceOrigine2Fin2);
	//		
	//		int distanceMinimale = Math.min(distanceMinimale1, distanceMinimale2);
			
			
			//Points de référence correspondants à la distance minimale
			
			PairPointsReference pairPointsReferenceMinimales = new PairPointsReference(null,null);
			pairPointsReferenceMinimales = mapPairPointsReferenceDistance.get(distanceMinimale);
			
			PointM pointReferenceOrigineMinimale = new PointM();
			pointReferenceOrigineMinimale = pairPointsReferenceMinimales.getPoint1();
			
			PointM pointReferenceFinMinimale = new PointM();
			pointReferenceFinMinimale = pairPointsReferenceMinimales.getPoint2();
			
			coordTrajet.ajouterElement(pointReferenceOrigineMinimale); //ajouter le point de référence origine à coordTrajet
			coordTrajet.ajouterElement(pointReferenceFinMinimale); //ajouter le point de référence fin à coordTrajet
			coordTrajet.ajouterElement(pointFin); //ajouter le point fin du trajet à coordTrajet
		}
		
		
		
	}

	
}
