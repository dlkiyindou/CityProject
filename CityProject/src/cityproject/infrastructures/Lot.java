package cityproject.infrastructures;

// import cityproject.infrastructures.geographie.Adresse;
import cityproject.infrastructures.geographie.Coordonnees4Points;
import cityproject.infrastructures.geographie.PointM;
import cityproject.exception.CityProjectException;
import cityproject.infrastructures.geographie.DirectionEnum;
import cityproject.infrastructures.geographie.PointKm;


// import java.awt.Point;
// import java.awt.Polygon;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import cityproject.exception.CityProjectException;


public class Lot { //Definition sous forme d'un rectangle comme Parcelle, Rue etc...
	
	private Coordonnees4Points<PointM> coordLot;
	private Parcelle parcelle; //parcelle dans laquelle se trouve le lot
	private PointM pointNordOuest = new PointM();
	private PointM pointNordEst = new PointM();
	private PointM pointSudOuest = new PointM();
	private PointM pointSudEst = new PointM();
	
	// private Parcelle parcelle_taille; // parcelle size

	
	// private Adresse adresse; // adresse du Lot
	
	
	
	public Coordonnees4Points<PointM> getCoordLot() {
		return coordLot;
	}
	public Parcelle getParcelle() {
		return parcelle;
	}
	public PointM getPointNordOuest() {
		return pointNordOuest;
	}
	public PointM getPointNordEst() {
		return pointNordEst;
	}
	public PointM getPointSudOuest() {
		return pointSudOuest;
	}
	public PointM getPointSudEst() {
		return pointSudEst;
	}
	// public Adresse getAdresse() {
	//	return adresse;
	// }
	
	public static void main(String[] args){

	
	
	// calculate the 'parcel area using the above points'
	// n.b. find out why getX, getY don't work..
		
	// double x1 = pointNordOuest.getX();
	// double x2 = pointNordEst.getX();

	// double x3 = pointNordOuest.getY();
	// double x4 = pointSudOuest.getY();
	
	// dummy numbers for testing, definition of co-ordinates
	double x1 = 0.0; //nordouest x
	double y1 = 0.0; //nordouest y
	double x4 = 2.0; //sudest x
	double y4 = 7.0; //sudest y	
		
	
	double parcelle_taille = Math.abs(x1 - x4) * Math.abs(y1 - y4);

	int nom_batiments_horiz = 10;
	int nom_batiments_vert = 6;
	
	double lot_taille = parcelle_taille / (nom_batiments_horiz * nom_batiments_vert);

	double lot_largeur_horiz = Math.abs(x1 - x4) / (nom_batiments_horiz);
	double lot_largeur_vert = Math.abs(y1 - y4) / (nom_batiments_vert);

	
	
	System.out.println(" parcelle_taille: "+parcelle_taille+ ", ");
	System.out.println(" lot_taille: "+lot_taille+ ", ");
	System.out.println(" nombreux_des_lots par parcelle: "+(nom_batiments_horiz * nom_batiments_vert)+ ", ");

	
	
	// System.out.print("x4: "+x4+ ", ");
	// System.out.println("y4: "+y4+ "; ");
	
	int nom_parcelles=5;
	int kcount=0;

    for(int k=1; k<nom_parcelles+1; k++){
    	int jcount=0;
		System.out.println(" ");    	
		System.out.println("parcelle no.: "+ k);
		System.out.println("-----------------");
		System.out.println(" ");

    	for(int i=1; i<nom_batiments_horiz+1; i++){
    		for(int j=1; j<nom_batiments_vert+1; j++){
    			jcount = jcount + 1;
    			kcount = kcount + 1;

    			System.out.print("no. lot en parcelle: "+ jcount);
    			System.out.println("; no. lot unique: "+ kcount);

    			
    			System.out.print("(coin nordouest) lot x_coord: "+ (x1 + lot_largeur_horiz*(i-1)));
    			System.out.print("; y_coord: "+ (y1 + lot_largeur_vert*(j-1)));

    			System.out.println(" ");
        
        }
    }			
	}
	}
}

