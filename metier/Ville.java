package reseau_routier.metier;

import java.util.ArrayList;
import java.util.List;

public class Ville
{	
	public static final int RAYON = 10;

	private static int nbVilles = 0;
	private        int num;

	private String nom;
	private int    x;
	private int    y;

	private List<Route> lstRoutes;

	private Ville(String nom, int x, int y)
	{
		this.nom = nom;
		this.x   = x;
		this.y   = y;
		this.num = Ville.nbVilles++;

		this.lstRoutes = new ArrayList<Route>();
	}

	public static Ville nvVille(String nom, int x, int y)
	{
		if (   0 <= x && x <= 1000 
		    && 0 <= y && y <= 800 
			&& !"".equals(nom))
			return new Ville(nom,x,y);
			
		return null;
	}

	// Accesseurs
	public String getNom () { return this.nom; }
	public int    getX   () { return this.x;   }
	public int    getY   () { return this.y;   }
	public int    getNum () { return this.num; }

	public Route getRoute   (int i) { return this.lstRoutes.get(i); }
	public int   getNbRoute ()      { return this.lstRoutes.size(); }

	// Modificateurs
	public boolean setNom(String nom)
	{
		if (!"".equals(nom))
		{
			this.nom = nom;
			return true;
		}
		return false;
	}

	public boolean setX(int x)
	{
		if (x >= 0 && x <= 1000)
		{
			this.x = x;
			return true;
		}
		return false;
	}

	public boolean setY(int y)
	{
		if (y >= 0 && y <= 800)
		{
			this.y = y;
			return true;
		}
		return false;
	}
	public void ajouterRoute(Route route) { this.lstRoutes.add(route); }

	// Autres méthodes
	
	public String toString() {
		String sRes = "";
		sRes +=  "{" +
			     " nb='" + getNum() + "'" +
			     ", nom='" + getNom() + "'" +
			     ", x='" + getX() + "'" +
			     ", y='" + getY() + "'" +
			     ", lstRoutes='";

		for (int i = 0; i < this.lstRoutes.size(); i++)
		{
			sRes += this.lstRoutes.get(i).getVilleDep().getNom() + "->" + this.lstRoutes.get(i).getVilleArr().getNom() + " / ";
		}

		sRes += "'" + "}";

		return sRes;
	}
	public void deplacerX (int x) { this.x += x; }
	public void deplacerY (int y) { this.y += y; }
	
	public boolean possede ( int x, int y )
	{
		return Ville.distance(this.x, this.y, x, y) <= Ville.RAYON;
	}

	public static double distance(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
	}
}