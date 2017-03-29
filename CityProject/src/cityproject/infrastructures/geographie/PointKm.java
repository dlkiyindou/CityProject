package cityproject.infrastructures.geographie;

import java.awt.Point;

/**
 * JavaPoint
 * @author Dixi
 *
 */
public class PointKm extends Point {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5861153812921760925L;

	public PointKm() {
		super();
	}

	public PointKm(Point p) {
		super(p);
	}

	public PointKm(int x, int y) {
		super(x, y);
	}
	
	public PointM toPointM() {
		PointM p = new PointM();
		p.setLocation(getX()*100, getY()*100);
		return p;
	}

}
