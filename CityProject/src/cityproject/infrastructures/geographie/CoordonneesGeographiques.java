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
	 * @param p Point � supprimer
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
	
	
	public String toString () {
		StringBuilder chaine = new StringBuilder("\t Liste de points : {");
		if (listeDePoints != null) {
			for (int i = 0; i < listeDePoints.length; i++) {
				chaine.append("\n Point ");
				chaine.append(i+1);
				chaine.append(" : ");
				chaine.append(listeDePoints[i]);
			}
		}
		
		chaine = chaine.append("}");
		
		return chaine.toString();
	}

}
