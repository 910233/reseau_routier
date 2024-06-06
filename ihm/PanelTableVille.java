package reseau_routier.ihm;
import java.awt.*;
import javax.swing.*;

import reseau_routier.Controleur;


public class PanelTableVille extends JPanel
{
	private Controleur ctrl;

	private GrilleVillesModel grilleDonnees;
	private JTable            tblGrilleDonnees;

	public PanelTableVille (Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.setLayout ( new BorderLayout() );

		JScrollPane spGrilleDonnees;
		
		// Création des composants
		this.grilleDonnees    = new GrilleVillesModel( this.ctrl );
		this.tblGrilleDonnees = new JTable ( this.grilleDonnees );
		this.tblGrilleDonnees.setFillsViewportHeight(true);

 		spGrilleDonnees = new JScrollPane( this.tblGrilleDonnees );

		// positionnement des composants
		this.add ( spGrilleDonnees, BorderLayout.CENTER );
	}

	public void majTableau() { this.grilleDonnees.majDonnees(); }
}