package cityproject.graphique;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;

public class CityProjectFenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3208278112962032370L;

	public void initFenetre () {
		JFrame temp =  new JFrame();
		temp.pack();
		Insets insets = temp.getInsets();
		temp = null;
		
		setTitle("Ma première fenêtre Java");
		setSize(new Dimension(insets.left + insets.right + 1200, insets.top + insets.bottom + 800));
		
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    setVisible(true);
	}

}
