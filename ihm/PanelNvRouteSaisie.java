package reseau_routier.ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import reseau_routier.metier.Route;
import reseau_routier.Controleur;


public class PanelNvRouteSaisie  extends JPanel implements Saisie,AdjustmentListener
{
	private JTextField txtVilleArr;
	private JComboBox txtVilleDep;
	private JScrollBar sbNbTronc;
	private JLabel     lblTronc;
	private Object[] obj;
	
	public PanelNvRouteSaisie()
	{
		this.setLayout(new GridLayout(4, 2));

		// Création des composants
		this.obj = getVilles().toArray();
		this.txtVilleDep = new JComboBox(obj);
		this.txtVilleArr = new JTextField();
		this.sbNbTronc   = new JScrollBar ( JScrollBar.HORIZONTAL, 0, 1, 0, 11 );
		this.lblTronc    = new JLabel("Nb Tronçons : 0");

		// Positionnement des composants
		this.add(new JLabel("Ville Dep   : "));
		this.add(this.txtVilleDep);
		this.add(new JLabel("Ville Arr   : "));
		this.add(this.txtVilleArr);
		this.add(lblTronc);
		this.add(this.sbNbTronc);
		
		// Activation des composants
		this.sbNbTronc.addAdjustmentListener(this);
	}
	
	public Route getNvRoute()
	{
		Route route;
		String villeDep, villeArr;
		int nbTronc;
		
		try {
			villeDep = this.txtVilleDep.getName();
			villeArr = this.txtVilleArr.getText();
			nbTronc  = this.sbNbTronc.getValue() ;
			//route = Route.nvRoute(villeDep, villeArr, nbTronc);
			route = null;
		} 
		catch (Exception e) 
		{
			route = null;
		}

		return route;
	}

	public void reinitSaisie()
	{
		this.txtVilleArr.setText("");
	}

	public void adjustmentValueChanged ( AdjustmentEvent e )
	{
		if ( e.getSource() == this.sbNbTronc )
			this.lblTronc.setText("Nb Tronçons : " + this.sbNbTronc.getValue());
	}
}
