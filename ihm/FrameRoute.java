package reseau_routier.ihm;

import reseau_routier.Controleur;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class FrameRoute extends JFrame
{
	private Controleur ctrl;

	public FrameRoute(Controleur ctrl)
	{
		this.ctrl = ctrl;

		// Création des composants
		

		// Positionnement des composants
		

		// Activation des composants
		this.addComponentListener( new GereFrame() );
	}


	private class GereFrame extends ComponentAdapter
	{
		public void componentMoved (ComponentEvent e)
		{
			FrameRoute.this.ctrl.deplacerLesFrames('R');
		}
	}
}