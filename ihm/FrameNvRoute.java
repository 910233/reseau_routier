package reseau_routier.ihm;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import reseau_routier.Controleur;
import reseau_routier.metier.Route;

public class FrameNvRoute extends FrameNvDonnee<Route>
{
	public FrameNvRoute(Controleur ctrl)
	{
		super(ctrl);
		this.panelSaisie = new PanelSaisirNvRoute(this.ctrl);
		this.add((JPanel)this.panelSaisie, BorderLayout.CENTER);
	}
}
