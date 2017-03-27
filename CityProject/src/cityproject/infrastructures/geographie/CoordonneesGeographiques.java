/**
 * 
 */
package cityproject.infrastructures.geographie;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dixi
 *
 */
public class CoordonneesGeographiques <E extends Point> {
	private List<E> listeDePoints; 
	private Polygon polygon;

	public CoordonneesGeographiques () {
		super();
		listeDePoints = new ArrayList<E>();
		setPolygon(new Polygon());
	}
	
	/**
	 * 
	 * @return
	 */
	public E[] getListeDePointsAsArray() {
		return (E[]) listeDePoints.toArray();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<E> getListeDePoints() {
		return listeDePoints;
	}

	/**
	 * 
	 * @param listeDePoints
	 */
	public void setListeDePoints(E[] _listeDePoints) {
		this.listeDePoints = new ArrayList<E>();
		listeDePoints.addAll(Arrays.asList(_listeDePoints));
		updatePolygon();
	}
	
	/**
	 * 
	 * @param p
	 */
	public void ajouterElement(E e) {
		listeDePoints.add(e);
		updatePolygon();
	}
	
	/**
	 * 
	 * @param p Point à supprimer
	 */
	public void supprimerElement(E e) {
		listeDePoints.remove(e);
		updatePolygon();
	}	
	
	public String toString () {
		StringBuilder chaine = new StringBuilder("\t Liste de points : {");
		if (listeDePoints != null) {
			int i = 0;
			for (E e : listeDePoints) {
				chaine.append("\n Point ");
				chaine.append(i++);
				chaine.append(" : ");
				chaine.append(e);
			}
		}
		
		chaine = chaine.append("}");
		return chaine.toString();
	}
	
	private void updatePolygon() {
		int j = listeDePoints.size();
		if (j > 0) {
			int xs[] = new int[j];
			int ys[] = new int[j];
			int i = 0;
			
			for (E e : listeDePoints) {
				xs[i] = (int)e.getX();
				ys[i] = (int)e.getY();
				i++;
			}
			
			setPolygon(new Polygon(xs, ys, i));
		}
	}

	public Polygon getPolygon() {
		return polygon;
	}

	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}
	
	public boolean contient(CoordonneesGeographiques<E> coord) {
		int all = 0;
		int count = 0;
		for (E e : listeDePoints) {
			if (polygon.contains(e)) {
				count++;
			}
			
			all++;
		}
		
		return all > 0 ? 100*count/all > 80 : false;
	}
	
}
