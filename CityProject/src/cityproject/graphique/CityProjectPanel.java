package cityproject.graphique;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

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

	// Variables de zoom
	double scale = 0.01;
	double tx = 0.0;
	double ty = 0.0;

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public CityProjectPanel(Ville _ville) {
		super();

		ville = _ville;

		ArrayList<Quartier> listeQuartiers = new ArrayList<Quartier>();
		listeQuartiers = _ville.getListequartiers();
		



		init();
	}

	private void init() {


	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// resetting the context state
		g2.scale(scale, scale);
		g2.translate(tx, ty);
		g2.drawPolygon(ville.getCoordonnees().getPolygon());

		for (Quartier q : ville.getListequartiers()) {
			g.drawPolygon(q.getCoordonnees().getPolygon());

			for (Rue r : q.getListerues()) {
				g.drawPolygon(r.getCoordonnees().getPolygon());
			}
		}
	}

	public double getTx() {
		return tx;
	}

	public void setTx(double tx) {
		this.tx = tx;
	}
	
	public double getTy() {
		return ty;
	}

	public void setTy(double ty) {
		this.ty = ty;
	}



}
