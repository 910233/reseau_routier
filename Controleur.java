package reseau_routier;

import reseau_routier.metier.Metier;
import reseau_routier.ihm.IHMGUI;

public class Controleur 
{	
	private IHMGUI ihm;
	private Metier metier;
	
	public Controleur ()
	{
		this.metier = new Metier ();
		this.ihm    = new IHMGUI (this);
	}
}
