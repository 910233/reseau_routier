package reseau_routier.ihm;

import java.awt.event.*;
import javax.swing.*;

import reseau_routier.Controleur;

public class PanelActionVille extends JPanel implements ActionListener
{
	private  Controleur ctrl;
	private  JButton    btnCreerVille;

	public PanelActionVille (Controleur ctrl )
	{
		this.ctrl = ctrl;

		// création des composants
		this.btnCreerVille = new JButton ( "Créer Ville" );

		// Positionnement des composants
		this.add ( this.btnCreerVille );

		// Activation des composants
		this.btnCreerVille.addActionListener ( this );
	}


	public void actionPerformed ( ActionEvent e)
	{
		if ( e.getSource() == this.btnCreerVille)
			this.ctrl.creerVille ();
	}


}

