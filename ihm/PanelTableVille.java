package reseau_routier.ihm;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

import reseau_routier.Controleur;


public class PanelTableVille extends JPanel
{
	private Controleur ctrl;
	private JTable     tblGrilleDonnees;

	public PanelTableVille (Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.setLayout ( new BorderLayout() );

		JScrollPane spGrilleDonnees;
		
		// Création des composants
		this.tblGrilleDonnees = new JTable ( new GrilleRoutesModel(ctrl) );
		this.tblGrilleDonnees.setFillsViewportHeight(true);

 		spGrilleDonnees   = new JScrollPane( this.tblGrilleDonnees );

		// positionnement des composants
		this.add ( spGrilleDonnees, BorderLayout.CENTER );
	}

}