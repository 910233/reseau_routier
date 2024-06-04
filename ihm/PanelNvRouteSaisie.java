package reseau_routier.ihm;

import java.awt.*;
import javax.swing.*;

import reseau_routier.metier.Route;

public class PanelNvRouteSaisie  extends JPanel implements Saisie
{
	private JTextField txtVilleDep, txtVilleArr, txtNbTronc;

	public PanelNvRouteSaisie()
	{
		this.setLayout(new GridLayout(4, 2));

		// Création des composants
		this.txtVilleDep = new JTextField();
		this.txtVilleArr = new JTextField();
		this.txtNbTronc  = new JTextField();

		// Positionnement des composants
		this.add(new JLabel("Ville Dep   : "));
		this.add(this.txtVilleDep);
		this.add(new JLabel("Ville Arr   : "));
		this.add(this.txtVilleArr);
		this.add(new JLabel("Nb Tronçons : "));
		this.add(this.txtNbTronc);
		
		// Activation des composants

	}
	
	public Route getNvRoute()
	{
		Route route;
		String villeDep, villeArr;
		int nbTronc;
		
		try {
			villeDep = this.txtVilleDep.getText();
			villeArr = this.txtVilleArr.getText();
			nbTronc  = Integer.parseInt(this.txtNbTronc.getText());
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
		this.txtVilleDep.setText("");
		this.txtVilleArr.setText("");
		this.txtNbTronc.setText("");
	}
}
