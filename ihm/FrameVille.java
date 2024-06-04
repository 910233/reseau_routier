package reseau_routier.ihm;

import reseau_routier.Controleur;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameVille extends JFrame implements ActionListener
{
	private Controleur ctrl;

	private  JButton         btnCreerVille;
	private PanelTableVille panelTableVille;

	public FrameVille(Controleur ctrl)
	{
		this.ctrl = ctrl;

		// Création des composants
		this.panelTableVille  = new PanelTableVille (this.ctrl);
		this.btnCreerVille     = new JButton ( "Créer Ville" );
		JPanel panelCreerVille = new JPanel();

		// Positionnement des composants
		panelCreerVille.add ( this.btnCreerVille );
		this.add ( panelCreerVille,  BorderLayout.NORTH  );
		this.add ( this.panelTableVille,  BorderLayout.CENTER );

		// Activation des composants
		this.btnCreerVille.addActionListener ( this );
		this.addComponentListener( new GereFrame() );
	}
	
	public void majTableau()
	{
		this.panelTableVille.majTableau();
	}

	public void actionPerformed ( ActionEvent e)
	{
		if ( e.getSource() == this.btnCreerVille)
			this.ctrl.creerVille ();
	}

	private class GereFrame extends ComponentAdapter
	{
		public void componentMoved (ComponentEvent e)
		{
			FrameVille.this.ctrl.deplacerLesFrames('V');
		}
	}
}