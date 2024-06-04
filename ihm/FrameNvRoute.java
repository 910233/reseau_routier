package reseau_routier.ihm;

import java.awt.*;

import reseau_routier.Controleur;
import reseau_routier.metier.Route;

public class FrameNvRoute extends FrameNvD
{
	public FrameNvRoute (Controleur ctrl)
	{ 
		super(ctrl); 
		this.panelSaisie = new PanelNvRouteSaisie();
		this.add((PanelNvRouteSaisie) this.panelSaisie, BorderLayout.CENTER);
	}
	
	public void valider ()
	{
		Route saisie = ((PanelNvRouteSaisie)this.panelSaisie).getNvRoute();
		System.out.println(saisie);
		if(saisie != null)
		{
			this.ctrl.ajouterRoute (saisie);
			this.dispose();
		}
		else
		{
			this.panelSaisie.reinitSaisie();
		}
	}
}
