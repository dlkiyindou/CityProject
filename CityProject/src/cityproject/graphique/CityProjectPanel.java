package cityproject.graphique;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import cityproject.infrastructures.Quartier;
import cityproject.infrastructures.Rue;
import cityproject.infrastructures.Ville;

public class CityProjectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8719844701019578237L;
	private Ville ville;
	private List<Quartier> listQuartiers;
	private List<Rue> listRues;
	
	private Box bloc1;
	private Box bloc2;
	private Container container;
	
	public CityProjectPanel (Ville _ville, List<Quartier> lq, List<Rue> lr) {
		super();
		listQuartiers =  new ArrayList<Quartier>();
		listQuartiers = lq;
		listRues = new ArrayList<Rue>();
		listRues = lr;
		ville = _ville;
		
		init();
	}

	private void init () {
//		container = new Container();
//		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		
//		bloc1 = new Box(BoxLayout.X_AXIS);
//		bloc2 = new Box(BoxLayout.X_AXIS);
//		
//		bloc1.add(new JButton("Zoom -"));
//		bloc1.add(new JButton("Zoom +"));
//		bloc2.add(container);
//		
//		add(bloc1);
//		add(bloc2);
		
		JButton b1 = new JButton("Zoom -");
	    b1.setVerticalTextPosition(AbstractButton.CENTER);
	    b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
//	    b1.setMnemonic(KeyEvent.VK_D);
//	    b1.setActionCommand("disable");

	    JButton b2 = new JButton("Zoom +");
	    b2.setVerticalTextPosition(AbstractButton.BOTTOM);
	    b2.setHorizontalTextPosition(AbstractButton.CENTER);
//	    b2.setMnemonic(KeyEvent.VK_M);
	    
	    add(b1);
	    add(b2);
	}

	public void paintComponent(Graphics g){ 
		Graphics2D g2 = (Graphics2D) g;

		// resetting the context state
		g2.scale(0.01, 0.01);
	    g2.drawPolygon(ville.getCoordonnees().getPolygon());
	    
	    for (Quartier q : listQuartiers) {
	    	g.drawPolygon(q.getCoordonnees().getPolygon());
	    }
	    
	    for (Rue r : listRues) {
	    	g.drawPolygon(r.getCoordonnees().getPolygon());
	    }
	}
}
