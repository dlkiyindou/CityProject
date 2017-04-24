package cityproject.infrastructures.geographie;

import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

import cityproject.exception.CityProjectException;

public class Coordonnees4Points<E extends Point> extends CoordonneesGeographiques<E> {
	public void ajouterElement(E e) throws CityProjectException {
		List<E> listeDePoints =  getListeDePoints();
		if (listeDePoints.size() < 4) {
			super.ajouterElement(e);
		} else {
			throw new CityProjectException("Coordonnees4Points ne peut contenir que 4 points");
		}
	}
	
	public boolean isValid () {
		Polygon polygon =  getPolygon();
		
		return true;
	}
}
