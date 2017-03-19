/**
 * 
 */
package cityproject.infrastructures.geographie;

/**
 * @author Dixi
 *
 */
public class Point {
	private int x;
	private int y;
	/**
	 * 
	 */
	public Point() {
		setX(0);
		setY(0);
	}
	
	public Point(int _x, int _y) {
		setX(_x);
		setY(_y);
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public String toString() {
		return "(x = "+x+", y = "+y+")";
	}
}
