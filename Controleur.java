package reseau_routier;

import reseau_routier.metier.Metier;

import java.util.List;

import reseau_routier.ihm.FrameNvRoute;
import reseau_routier.ihm.FrameNvVille;
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

	// Modificateurs
	public boolean majXVille ( int ligne, Integer x ) { return this.metier.majXVille(ligne, x); }
	public boolean majYVille ( int ligne, Integer y ) { return this.metier.majYVille(ligne, y); }
	
	// Autres Méthodes
	public void sauvegarder() { this.metier.sauvegarder(); }
	
	public void creerVille() { new FrameNvVille(this); }
	public void creerRoute() { new FrameNvRoute(this); }
	
	public void ajouterVille(Ville ville) 
	{ 
		this.metier.ajouterVille(ville); 
		this.ihm.maj();
	}
	public void ajouterRoute(Route route) 
	{
		this.metier.ajouterRoute(route); 
		this.ihm.maj();
	}

	public void deplacerLesFrames(char orig) { if(this.ihm != null) this.ihm.deplacerLesFrames(orig); }

	public int     getNbVille     ()             { return this.metier.getNbVille();         }
	public Ville   getVille       (int num)      { return this.metier.getVille  (num);      }
	public Integer getIndiceVille (int x, int y) { return this.metier.getIndiceVille(x, y); }
	
	public void deplacerVille(Integer numVilleActive, int x, int y) 
	{
		this.metier.deplacerVille(numVilleActive, x, y);
		this.ihm.maj();
	}

	public static void main(String[] a) { new Controleur(); }
}
