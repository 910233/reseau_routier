package reseau_routier.ihm;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import reseau_routier.Controleur;
import reseau_routier.metier.Ville;

public class FrameNvVille extends FrameNvDonnee<Ville>
{
	public FrameNvVille(Controleur ctrl)
	{
		super(ctrl);
		this.panelSaisie = new PanelSaisirNvVille();
		this.add((JPanel)this.panelSaisie, BorderLayout.CENTER);
	}
}
