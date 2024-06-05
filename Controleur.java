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
	public int     getNbVille     ()             { return this.metier.getNbVille    ();     }
	public int     getNbRoute     ()             { return this.metier.getNbRoute    ();     }
	public Ville   getVille       (int    num)   { return this.metier.getVille      (num);  }
	public Ville   getVille       (String nom)   { return this.metier.getVille      (nom);  }
	public Route   getRoute       (int    num)   { return this.metier.getRoute      (num);  }
	public Integer getIndiceVille (int x, int y) { return this.metier.getIndiceVille(x, y); }

	public String[] getNomsVilles () { return this.metier.getNomsVilles(); }

	// Modificateurs
	public boolean majXVille ( int ligne, Integer x ) { return this.metier.majXVille(ligne, x); }
	public boolean majYVille ( int ligne, Integer y ) { return this.metier.majYVille(ligne, y); }
	
	// Autres Méthodes	
	public boolean routeExiste(Ville villeDep, Ville villeArr) 
	{
		return this.metier.routeExiste(villeDep, villeArr);
	}

	public void creerVille() { new FrameNvVille(this); }
	public void creerRoute() { new FrameNvRoute(this); }
	
	public void ajouter(Object obj) 
	{
		if(obj instanceof Ville)
			this.metier.ajouterVille((Ville)obj); 
		if(obj instanceof Route)
			this.metier.ajouterRoute((Route)obj); 
		this.majIHM();
	}
	public void deplacerVille(Integer numVilleActive, int x, int y) 
	{
		this.metier.deplacerVille(numVilleActive, x, y);
		this.majIHM();
	}

	public void sauvegarder() { this.metier.sauvegarder(); }
	public void deplacerLesFrames(char orig) { if(this.ihm != null) this.ihm.deplacerLesFrames(orig); }
	public void majIHM           ()          { this.ihm.maj(); } 
	public static void main(String[] a) { new Controleur(); }
}
