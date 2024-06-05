package reseau_routier.ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import reseau_routier.metier.Route;
import reseau_routier.metier.Ville;
import reseau_routier.Controleur;


public class PanelSaisirNvRoute  extends JPanel implements Saisie<Route>, AdjustmentListener
{
	private Controleur ctrl;
	
	private JComboBox<String> ddlstVillesDep;
	private JComboBox<String> ddlstVillesArr;
	private JScrollBar sbNbTronc;
	private JLabel     lblTronc;
	
	public PanelSaisirNvRoute(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setLayout(new GridLayout(4, 2));

		// Création des composants
		this.ddlstVillesDep = new JComboBox<String>(this.ctrl.getNomsVilles());
		this.ddlstVillesDep.setSelectedIndex(0);
		this.ddlstVillesArr = new JComboBox<String>(this.ctrl.getNomsVilles());
		this.ddlstVillesDep.setSelectedIndex(0);
		this.sbNbTronc   = new JScrollBar ( JScrollBar.HORIZONTAL, 0, 1, 0, 11 );
		this.lblTronc    = new JLabel("Nb Tronçons : 0");

		// Positionnement des composants
		this.add(new JLabel("Ville Dep   : "));
		this.add(this.ddlstVillesDep);
		this.add(new JLabel("Ville Arr   : "));
		this.add(this.ddlstVillesArr);
		this.add(lblTronc);
		this.add(this.sbNbTronc);
		
		// Activation des composants
		this.sbNbTronc.addAdjustmentListener(this);
	}
	
	public Route getSaisie()
	{
		Route route;
		Ville villeDep, villeArr;
		int nbTronc;
		
		try {
			villeDep = this.ctrl.getVille((String)this.ddlstVillesDep.getSelectedItem());
			villeArr = this.ctrl.getVille((String)this.ddlstVillesArr.getSelectedItem());
			nbTronc  = this.sbNbTronc.getValue() ;
			route = Route.nvRoute(villeDep, villeArr, nbTronc);
		} 
		catch (Exception e) { route = null; }

		return route;
	}

	public void reinitSaisie()
	{
		this.sbNbTronc.setValue(0);
		this.ddlstVillesDep.setSelectedIndex(0);
		this.ddlstVillesArr.setSelectedIndex(0);
	}

	public void adjustmentValueChanged ( AdjustmentEvent e )
	{
		if ( e.getSource() == this.sbNbTronc )
			this.lblTronc.setText("Nb Tronçons : " + this.sbNbTronc.getValue());
	}
}
