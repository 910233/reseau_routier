package reseau_routier.ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import reseau_routier.Controleur;
import reseau_routier.metier.Ville;

public class FrameNvVille extends JFrame
{
	private Controleur               ctrl;
	private PanelNvVilleSaisie panelSaisie;
	private PanelNvVilleAction panelAction;

	public FrameNvVille (Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setSize ( 500, 250 );

		// Création des composants
		this.panelSaisie = new PanelNvVilleSaisie ();
		this.panelAction = new PanelNvVilleAction ( this );

		// Positionnement des composants
		this.add ( this.panelSaisie, BorderLayout.CENTER );
		this.add ( this.panelAction, BorderLayout.SOUTH  );

		this.setVisible ( true );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void annuler ()
	{
		this.dispose();
	}
	
	public void valider ()
	{
		Ville ville = this.panelSaisie.getNouvelleVille();
		System.out.println(ville);
		if(ville != null)
		{
			this.ctrl.ajouterVille (ville);
			this.dispose();
		}
		else
		{
			this.panelSaisie.reinitSaisie();
		}
	}
}
