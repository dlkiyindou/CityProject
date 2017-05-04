package cityproject.infrastructures.geographie;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cityproject.exception.CityProjectException;

public class Coordonnees4Points<E extends Point> extends CoordonneesGeographiques<E> {
	private Map<PointCardinalEnum, E> mapDePoints;
	
	public Coordonnees4Points () {
		super();
		mapDePoints =  new HashMap<PointCardinalEnum, E>();
	}
	
	public void ajouterElement(E e) throws CityProjectException {
		if (super.getListeDePoints().size() < 4) {
			super.ajouterElement(e);
			
			for (E elt : super.getListeDePoints()) {
				mapDePoints.put(getPointCardinal(elt), elt);
			}
		} else {
			throw new CityProjectException("Coordonnees4Points ne peut contenir que 4 points");
		}
	}
	
	
	/**
	 * 
	 * @param listeDePoints
	 */
	public void setListeDePoints(E[] _listeDePoints) {
		setListeDePoints(Arrays.asList(_listeDePoints));
	}
	
	public void setListeDePoints(List<E> _listeDePoints) {
		super.setListeDePoints(_listeDePoints);
		mapDePoints =  new HashMap<PointCardinalEnum, E>();
		for (E elt : _listeDePoints) {
			mapDePoints.put(getPointCardinal(elt), elt);
		}
	}
	
	/**
	 * 
	 * @param p Point à supprimer
	 */
	public void supprimerElement(E e) {
		super.supprimerElement(e);
		mapDePoints =  new HashMap<PointCardinalEnum, E>();
		for (E elt : super.getListeDePoints()) {
			mapDePoints.put(getPointCardinal(elt), elt);
		}
	}
	
	public PointCardinalEnum getPointCardinal(E elt) {
		double maxX = 0, maxY = 0, minX = 0, minY = 0;
		PointCardinalEnum resultat = null;
		
		for (E e : getListeDePoints()) {
			if (e.getX() > maxX)
				maxX = e.getX();
			else minX = e.getX();
			
			if (e.getY() > maxY)
				maxY = e.getY();
			else minY = e.getY();
		}
		
		if (elt.getX() == maxX && elt.getY() == maxY)
			resultat = PointCardinalEnum.SUDEST;
		else if (elt.getX() == maxX && elt.getY() == minY)
			resultat = PointCardinalEnum.NORDEST;
		else if (elt.getX() == minX && elt.getY() == minY)
			resultat = PointCardinalEnum.NORDOUEST;
		else if (elt.getX() == minX && elt.getY() == maxY)
			resultat = PointCardinalEnum.NORDOUEST;
		
		return resultat;
	}
}
