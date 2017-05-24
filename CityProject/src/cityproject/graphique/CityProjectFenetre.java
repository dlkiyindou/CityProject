package cityproject.graphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cityproject.infrastructures.Ville;

public class CityProjectFenetre extends JFrame {

	/**
	 * 
	 */
	Ville ville;
	CityProjectPanel villeGraphe;
	JPanel container;

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	private static final long serialVersionUID = 3208278112962032370L;

	public void initFenetre() {
		JFrame temp = new JFrame();
		temp.pack();
		Insets insets = temp.getInsets();
		temp = null;

		setTitle("City Project");
		setSize(new Dimension(insets.left + insets.right + 1200, insets.top + insets.bottom + 800));

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initPanel();

		setVisible(true);
	}

	private void initPanel() {

		/* Contenaire general */
		container = new JPanel();
		container.setLayout(new BorderLayout());

		/* Panneau Ville */

		Ville ville = new Ville();
		ville = this.getVille();

		villeGraphe = new CityProjectPanel(ville);

		container.add(villeGraphe, BorderLayout.CENTER);

		/* Panneau bouton */

		JPanel bouton_panel = new JPanel();

		bouton_panel.setLayout(new BoxLayout(bouton_panel, BoxLayout.LINE_AXIS));

		JButton b1 = new JButton("Zoom +");
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.LEADING);
		b1.addActionListener(new ZoomListener());
		bouton_panel.add(b1);

		JButton b2 = new JButton("Zoom -");
		b2.setVerticalTextPosition(AbstractButton.CENTER);
		b2.setHorizontalTextPosition(AbstractButton.LEADING);
		b2.addActionListener(new ZoomListener());
		bouton_panel.add(b2);

		JButton b3 = new JButton("Haut");
		b3.setVerticalTextPosition(AbstractButton.CENTER);
		b3.setHorizontalTextPosition(AbstractButton.LEADING);
		b3.addActionListener(new TranslationListener());
		bouton_panel.add(b3);

		JButton b4 = new JButton("Bas");
		b4.setVerticalTextPosition(AbstractButton.CENTER);
		b4.setHorizontalTextPosition(AbstractButton.LEADING);
		b4.addActionListener(new TranslationListener());
		bouton_panel.add(b4);

		JButton b5 = new JButton("Gauche");
		b5.setVerticalTextPosition(AbstractButton.CENTER);
		b5.setHorizontalTextPosition(AbstractButton.LEADING);
		b5.addActionListener(new TranslationListener());
		bouton_panel.add(b5);

		JButton b6 = new JButton("Droite");
		b6.setVerticalTextPosition(AbstractButton.CENTER);
		b6.setHorizontalTextPosition(AbstractButton.LEADING);
		b6.addActionListener(new TranslationListener());
		bouton_panel.add(b6);

		villeGraphe.addMouseWheelListener(new MouseAdapter() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				double delta = 0.0005 * e.getPreciseWheelRotation();
				double _scale = villeGraphe.getScale();
				_scale -= delta;
				villeGraphe.setScale(_scale);
				container.revalidate();
				container.repaint();
			}

		});
		
		villeGraphe.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
//				Point delta = e.;
//				double _scale = villeGraphe;
//				_scale -= delta;
//				villeGraphe.setScale(_scale);
//				container.revalidate();
//				container.repaint();
			}

		});

		container.add(bouton_panel, BorderLayout.NORTH);

		this.setContentPane(container);

	}

	class ZoomListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			String str = ((JButton) ae.getSource()).getText();
			double _scale = villeGraphe.getScale();

			if (str == "Zoom +") {
				villeGraphe.setScale(_scale * 2);
				container.repaint();
				// System.out.println("scale + : " + _scale);
			} else if (str == "Zoom -") {
				villeGraphe.setScale(_scale / 2);
				container.repaint();
				// System.out.println("scale - : " + _scale);
			}

		}
	}
	
	class TranslationListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {

			String str = ((JButton) ae.getSource()).getText();
			double _tx = villeGraphe.getTx();
			double _ty = villeGraphe.getTy();

			if (str == "Haut"){
				villeGraphe.setTx(_tx);
				villeGraphe.setTy(_ty - 10000);
			}
			else if (str == "Bas"){
				villeGraphe.setTx(_tx);
				villeGraphe.setTy(_ty + 10000);
			}
			else if (str == "Gauche"){
				villeGraphe.setTx(_tx - 10000);
				villeGraphe.setTy(_ty);
			}
			else if (str == "Droite"){
				villeGraphe.setTx(_tx + 10000);
				villeGraphe.setTy(_ty);
			}
			container.repaint();
		}
	}

}
