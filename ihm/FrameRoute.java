package reseau_routier.ihm;

import reseau_routier.Controleur;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameRoute extends JFrame implements ActionListener
{
	private Controleur ctrl;

	private JButton         btnCreerRoute;
	private PanelTableRoute panelTableRoute;

	public FrameRoute(Controleur ctrl)
	{
		this.ctrl = ctrl;

		// Création des composants
		this.panelTableRoute  = new PanelTableRoute (this.ctrl);
		this.btnCreerRoute     = new JButton ( "Créer Route" );
		JPanel panelCreerRoute = new JPanel();

		// Positionnement des composants
		panelCreerRoute.add ( this.btnCreerRoute );
		this.add ( panelCreerRoute,  BorderLayout.NORTH  );
		this.add ( this.panelTableRoute,  BorderLayout.CENTER );

		// Activation des composants
		this.btnCreerRoute.addActionListener ( this );
		this.addComponentListener( new GereFrame() );
	}

	public void majTableau()
	{
		this.panelTableRoute.majTableau();
	}

	public void actionPerformed ( ActionEvent e)
	{
		if ( e.getSource() == this.btnCreerRoute)
			this.ctrl.creerRoute ();
	}


	private class GereFrame extends ComponentAdapter
	{
		public void componentMoved (ComponentEvent e)
		{
			FrameRoute.this.ctrl.deplacerLesFrames('R');
		}
	}
}