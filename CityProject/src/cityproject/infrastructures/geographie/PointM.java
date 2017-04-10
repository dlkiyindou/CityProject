package cityproject.infrastructures.geographie;

import java.awt.Point;

public class PointM extends Point {
	private PointKm pointReference;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6363607880806980883L;

	public PointM() {
		super();
	}

	public PointM(Point p) {
		super(p);
	}

	public PointM(int x, int y) {
		super();
		int xKm, yKm;
		if (x > 1000) {
			// xKm = 
		}
		
	}

	public PointKm getPointReference() {
		return pointReference;
	}

	public void setPointReference(PointKm pointReference) {
		this.pointReference = pointReference;
	}

	

}
