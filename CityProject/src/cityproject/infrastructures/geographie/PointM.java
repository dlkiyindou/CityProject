package cityproject.infrastructures.geographie;

import java.awt.Point;

import cityproject.exception.CoordonneesPointMOutOfRangeException;

public class PointM extends Point {
	private PointKm pointReference;



	/**
	 * 
	 */
	private static final long serialVersionUID = -6363607880806980883L;

	public PointM() {
		super();
	}

	public PointM(int x, int y) {
		super();
		pointReference = new PointKm(x/1000, y/1000);
		setLocation(x%1000, y%1000);
	}
	
	public PointM (PointKm p, int x, int y) throws CoordonneesPointMOutOfRangeException {
		super();
		
		if (x >= 1000 || y >= 1000) {
			throw new CoordonneesPointMOutOfRangeException("L'abscisse et l'ordonnee doivent etre inferieure a 1000");
		}
		
		pointReference = p;
		setLocation(x, y);
	}

	public PointKm getPointReference() {
		return pointReference;
	}

	public void setPointReference(PointKm pointReference) {
		this.pointReference = pointReference;
	}

	public void setLocation(int x, int y) {
		if (x >= 1000 || y >= 1000) {
			pointReference = new PointKm(x/1000, y/1000);
		}
		
		setLocation(x%1000, y%1000);
	}

	public PointM isPointExtremeRue() {
		// TODO Auto-generated method stub
		return null;
	}

	public CardinalityEnum getCardinality(Coordonnees4Points<PointM> coord_croisement) {
		// TODO Auto-generated method stub
		return null;
	}

	public PointM isPointCroisement() {
		// TODO Auto-generated method stub
		return null;
	}

}
