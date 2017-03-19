/**
 * 
 */
package cityproject.infrastructures.geographie;

/**
 * @author Dixi
 *
 */
public class CoordonneesGeographiques {
	private Point[] listeDePoints; 

	/**
	 * 
	 */
	public CoordonneesGeographiques() {
		// TODO Auto-generated constructor stub
	}

	public Point[] getListeDePoints() {
		return listeDePoints;
	}

	public void setListeDePoints(Point[] listeDePoints) {
		this.listeDePoints = listeDePoints;
	}
	
	/**
	 * 
	 * @param p
	 */
	public void ajouterPoint(Point p) {
		if (listeDePoints == null) {
			listeDePoints = new Point[]{p};
		} else {
			Point[] tmpListeDePoints = new Point[listeDePoints.length + 1];
			
			int i = 0;
			for (Point tmp : listeDePoints) {
				tmpListeDePoints[i++] = tmp;
			}
			
			tmpListeDePoints[i] = p;
			listeDePoints = tmpListeDePoints;
		}
	}
	
	/**
	 * 
	 * @param p Point à supprimer
	 */
	public void supprimerPoint(Point p) {
		if (listeDePoints != null) {
			Point[] tmpListeDePoints = new Point[listeDePoints.length - 1];
			
			for (int i = 0; i < listeDePoints.length; i++) {
				if (!p.equals(listeDePoints[i]))
					tmpListeDePoints[i] = listeDePoints[i];
			}
			
			listeDePoints = tmpListeDePoints;
		}
	}

}
