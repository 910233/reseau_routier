package reseau_routier.ihm;
import java.awt.*;
import javax.swing.*;

import reseau_routier.Controleur;


public class PanelTableRoute extends JPanel
{
	private Controleur        ctrl;
	private GrilleRoutesModel grilleDonnees;
	private JTable            tblGrilleDonnees;

	public PanelTableRoute (Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.setLayout ( new BorderLayout() );

		JScrollPane spGrilleDonnees;
		
		// Création des composants
		this.grilleDonnees    = new GrilleRoutesModel( this.ctrl );
		this.tblGrilleDonnees = new JTable ( this.grilleDonnees );
		this.tblGrilleDonnees.setFillsViewportHeight(true);

 		spGrilleDonnees = new JScrollPane( this.tblGrilleDonnees );

		// positionnement des composants
		this.add ( spGrilleDonnees, BorderLayout.CENTER );
	}

	public void majTableau() { this.grilleDonnees.majDonnees(); }


}