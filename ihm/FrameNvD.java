package reseau_routier.ihm;

import java.awt.*;
import javax.swing.*;

import reseau_routier.Controleur;

public abstract class FrameNvD extends JFrame
{
	protected Controleur         ctrl;
	protected Saisie panelSaisie;
	protected PanelNvDAction panelAction;

	public FrameNvD(Controleur ctrl)
	{
		this.ctrl = ctrl;

		// Création des composants
		this.panelAction = new PanelNvDAction ( this );

		// Positionnement des composants
		this.add ( this.panelAction, BorderLayout.SOUTH  );

		this.setSize ( 500, 250 );
		this.setVisible ( true );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void annuler () { this.dispose(); }

	public abstract void valider();
}
