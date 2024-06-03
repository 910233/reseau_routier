package reseau_routier;

import reseau_routier.metier.Metier;

import java.util.List;

import reseau_routier.ihm.IHMGUI;
import reseau_routier.metier.Ville;
import reseau_routier.metier.Route;

public class Controleur 
{	
	private IHMGUI ihm;
	private Metier metier;
	
	public Controleur ()
	{
		this.metier = new Metier ();
		this.ihm    = new IHMGUI (this);
	}

	// Accesseurs
	public List<Route> getRoutes() { return this.metier.getRoutes(); }
	public List<Ville> getVilles() { return this.metier.getVilles(); }

	// Modificateurs (ignorez ça pour le moment)
	//public boolean majPremiumClient ( int ligne, boolean val ) { return this.metier.majPremiumClient ( ligne, val ); }
	//public boolean majAnneeAdhesion ( int ligne, int     val ) { return this.metier.majAnneeAdhesion ( ligne, val ); }

	// Autres Méthodes
	public void sauvegarder()
	{
		//this.metier.sauvegarder();
	}
	
	public void creerVille()
	{
		//new FrameNouvelleVille(this);
	}

	public void creerRoute()
	{
		//new FrameNouvelleRoute(this);
	}
	
	public void ajouterVille(Ville ville)
	{
		//this.metier.ajouterVille(ville);
	}

	public void ajouterRoute(Route route)
	{
		//this.metier.ajouterRoute(route);
	}

	public void deplacerLesFrames(char orig) { if(this.ihm != null) this.ihm.deplacerLesFrames(orig); }
	public static void main(String[] a)
	{
		new Controleur();
	}
}
