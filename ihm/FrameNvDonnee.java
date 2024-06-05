package reseau_routier.ihm;

import java.awt.*;
import javax.swing.*;

import reseau_routier.Controleur;

public abstract class FrameNvDonnee<T> extends JFrame
{
	protected Controleur   ctrl;
	protected Saisie<T>    panelSaisie;
	protected PanelValider<T> panelValider;

	public FrameNvDonnee(Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.setSize ( 500, 250 );
		this.setVisible ( true );
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Création des composants
		this.panelValider = new PanelValider<T> ( this );

		// Positionnement des composants
		this.add ( this.panelValider, BorderLayout.SOUTH  );
	}
	
	public void annuler () { this.dispose(); }

	public void valider ()
	{
		T saisie = this.panelSaisie.getSaisie();
		if(saisie != null)
		{
			this.ctrl.ajouter (saisie);
			this.dispose();
		}
		else
		{
			this.panelSaisie.reinitSaisie();
		}
	}
}
