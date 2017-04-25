package cityproject.graphique;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import cityproject.infrastructures.Quartier;
import cityproject.infrastructures.Ville;

public class CityProjectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8719844701019578237L;
	private Ville ville;
	private List<Quartier> listQuartiers;
	
	public CityProjectPanel (Ville _ville, Quartier ... q) {
		super();
		listQuartiers =  new ArrayList<Quartier>();
		ville = _ville;
		listQuartiers = Arrays.asList(q);
		
		init();
	}
	
	private void init () {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		Box box1 = new Box(BoxLayout.Y_AXIS);
		box1.add(new JButton("Bouton 1"));
		box1.add(new JButton("Bouton 2"));
		add(box1);
	}

	public void paintComponent(Graphics g){ 
		Graphics2D g2 = (Graphics2D) g;

		// resetting the context state
		g2.scale(10, 10);
	    g2.drawPolygon(ville.getCoordonnees().getPolygon());
	    
	    for (Quartier q : listQuartiers) {
	    	g.drawPolygon(q.getCoordonnees().getPolygon());
	    }
	}
}
