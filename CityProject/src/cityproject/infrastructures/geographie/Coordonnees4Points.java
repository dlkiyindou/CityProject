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
	private Map<PointInterCardinalEnum, E> mapDePoints;
	
	public Coordonnees4Points () {
		super();
		mapDePoints =  new HashMap<PointInterCardinalEnum, E>();
	}
	
	public void ajouterElement(E e) throws CityProjectException {
		if (super.getListeDePoints().size() < 4) {
			super.ajouterElement(e);
			
			for (E elt : super.getListeDePoints()) {
				mapDePoints.put(getPointInterCardinal(elt), elt);
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
		mapDePoints =  new HashMap<PointInterCardinalEnum, E>();
		for (E elt : _listeDePoints) {
			mapDePoints.put(getPointInterCardinal(elt), elt);
		}
	}
	
	/**
	 * 
	 * @param p Point � supprimer
	 */
	public void supprimerElement(E e) {
		super.supprimerElement(e);
		mapDePoints =  new HashMap<PointInterCardinalEnum, E>();
		for (E elt : super.getListeDePoints()) {
			mapDePoints.put(getPointInterCardinal(elt), elt);
		}
	}
	
	public PointInterCardinalEnum getPointInterCardinal(E elt) {
		double maxX = 0, maxY = 0, minX = 0, minY = 0;
		PointInterCardinalEnum resultat = null;
		
		for (E e : getListeDePoints()) {
			if (e.getX() > maxX)
				maxX = e.getX();
			else minX = e.getX();
			
			if (e.getY() > maxY)
				maxY = e.getY();
			else minY = e.getY();
		}
		
		if (elt.getX() == maxX && elt.getY() == maxY)
			resultat = PointInterCardinalEnum.SUDEST;
		else if (elt.getX() == maxX && elt.getY() == minY)
			resultat = PointInterCardinalEnum.NORDEST;
		else if (elt.getX() == minX && elt.getY() == minY)
			resultat = PointInterCardinalEnum.NORDOUEST;
		else if (elt.getX() == minX && elt.getY() == maxY)
			resultat = PointInterCardinalEnum.SUDOUEST;
		
		return resultat;
	}
}
