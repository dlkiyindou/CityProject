package cityproject.transport;

import cityproject.infrastructures.geographie.CoordonneesGeographiques;
import cityproject.infrastructures.geographie.PointM;
import cityproject.exception.CityProjectException;
import cityproject.infrastructures.Rue;
import cityproject.infrastructures.geographie.DirectionEnum;



public class Trajet {
	
	private CoordonneesGeographiques<PointM> coordTrajet = new CoordonneesGeographiques<PointM>();
	
	//Contructeur par defaut 
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
	
	//Methode de calcul de trajet
	public void calculTrajet (PointM pointOrigin, PointM pointFinal) throws CityProjectException {
	
		//premier point du trajet
		coordTrajet.ajouterElement(pointOrigin);
		
		//po est dans une rue 
		Rue rueO = new Rue ();
		DirectionEnum direction= rueO.getDirection();
		
		
		//Ordonnées et abscises des points origine et final du trajet
		int xo=(int)pointOrigin.getX();
		int yo=(int)pointOrigin.getY();
		
		int xf=(int)pointFinal.getX();
		int yf=(int)pointFinal.getY();
		
		//coordonnees temporaux
		int xt, yt;
		PointM pt= new PointM(0,0);
		
		while((pointOrigin != pointFinal) && (pt != pointFinal)){
			
		
			//Si po est dans une rue vertical
			if (direction==DirectionEnum.VERTICAL) {
			
			
				if (yo>yf) {
					//Balayer sur y jusqu'au croisement plus proche entre po et pf
					yt=yo;
				
					do{ 
						yt--;
						pt.setLocation(xo, yt);
					}while ((pt.isPointCroisement() != null) && (yt != yf));
				
					//Ajouter le point du croisement au trajet
					coordTrajet.ajouterElement(pt);
				}
			
				if (yo<yf) {
					//Balayer sur y jusqu'au croisement plus proche entre po et pf
					yt=yo;
				
					do{ 
						yt++;
						pt.setLocation(xo, yt);
					}while ((pt.isPointCroisement() != null) && (yt != yf));
				
					//Ajouter le point du croisement au trajet
					coordTrajet.ajouterElement(pt);
				
				}
			
			
			
				//Tester encore sur y pour savoir s'il faut continuer
			
			
			}
		
			//Si po est dans une rue vertical
			if (direction==DirectionEnum.HORIZONTAL) {
			
				//Balayer sur x jusqu'au croisement plus proche entre po et pf
				if (xo>xf) {
					
					//Balayer sur x jusqu'au croisement plus proche entre po et pf
					xt=xo;
					
					do{ 
						xt--;
						pt.setLocation(xt, yo);
					}while ((pt.isPointCroisement() != null) && (xt != xf));
					
					//Ajouter le point du croisement au trajet
					coordTrajet.ajouterElement(pt);
				}
				
				if (xo<xf) {
					
					//Balayer sur x jusqu'au croisement plus proche entre po et pf
					xt=xo;
					
					do{ 
						xt++;
						pt.setLocation(xt, yo);
					}while ((pt.isPointCroisement() != null) && (xt != xf));
					
					//Ajouter le point du croisement au trajet
					coordTrajet.ajouterElement(pt);
					
				}
				
			}
			
			//point final du trajet
			coordTrajet.ajouterElement(pointFinal);
			
			
		}
		
		
	}

	
}
