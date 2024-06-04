package reseau_routier.ihm;

import reseau_routier.Controleur;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class FrameVille extends JFrame
{
	private Controleur ctrl;

	private PanelTableVille  panelTableVille;
	private PanelActionVille panelActionVille;

	public FrameVille(Controleur ctrl)
	{
		this.ctrl = ctrl;

		// Création des composants
		this.panelActionVille = new PanelActionVille (this.ctrl);
		this.panelTableVille  = new PanelTableVille  (this.ctrl);

		// Positionnement des composants
		this.add ( this.panelActionVille, BorderLayout.NORTH  );
		this.add ( this.panelTableVille,  BorderLayout.CENTER );

		// Activation des composants
		this.addComponentListener( new GereFrame() );
	}
	
	public void majTableau()
	{
		this.panelTableVille.majTableau();
	}


	private class GereFrame extends ComponentAdapter
	{
		public void componentMoved (ComponentEvent e)
		{
			FrameVille.this.ctrl.deplacerLesFrames('V');
		}
	}
}