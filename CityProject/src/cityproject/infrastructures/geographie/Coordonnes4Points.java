package cityproject.infrastructures.geographie;

import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

public class Coordonnes4Points <E extends Point> extends CoordonneesGeographiques<E> {
	
	public void ajouterElement(E e) throws Exception {
		List<E> listeDePoint = getListeDePoints();
		if (listeDePoint.size() < 4){
			super.ajouterElement(e);
		}else{
			throw new Exception("Coordonnees4Points ne peut contenir que 4 points");
		}
	}

	public boolean isValid () {
		Polygon polygon = getPolygon();
		
		return true;
	}
	
}
