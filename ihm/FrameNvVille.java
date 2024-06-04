package reseau_routier.ihm;

import java.awt.*;

import reseau_routier.Controleur;
import reseau_routier.metier.Ville;

public class FrameNvVille extends FrameNvD
{
	public FrameNvVille (Controleur ctrl)
	{ 
		super(ctrl);
		this.panelSaisie = new PanelNvVilleSaisie();
		this.add((PanelNvVilleSaisie) this.panelSaisie, BorderLayout.CENTER); 
	}
	
	public void valider ()
	{
		Ville saisie = ((PanelNvVilleSaisie)this.panelSaisie).getNvVille();
		System.out.println(saisie);
		if(saisie != null)
		{
			this.ctrl.ajouterVille (saisie);
			this.dispose();
		}
		else
		{
			this.panelSaisie.reinitSaisie();
		}
	}
}