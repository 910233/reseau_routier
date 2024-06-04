package reseau_routier.ihm;

import reseau_routier.Controleur;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class FrameResRoute extends JFrame
{
	private Controleur    ctrl;
	private PanelResRoute panelResRoute;

	public FrameResRoute(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.panelResRoute = new PanelResRoute( ctrl );
		this.add ( this.panelResRoute );
		this.addComponentListener( new GereFrame() );
	}


	private class GereFrame extends ComponentAdapter
	{
		public void componentMoved (ComponentEvent e)
		{
			FrameResRoute.this.ctrl.deplacerLesFrames('G');
		}
	}


	public void maj() {
		this.panelResRoute.repaint();
	}
}