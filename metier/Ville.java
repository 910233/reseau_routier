package reseau_routier.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ville
{
	public static final int TAILLE = 50;
	
	private static int nbVilles = 0;
	private        int nb;

	private String nom;
	private int    x;
	private int    y;

	private List<Route> lstRoutes;

	private Ville(String nom, int x, int y)
	{
		this.nom = nom;
		this.x   = x;
		this.y   = y;
		this.nb  = Ville.nbVilles++;

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

	public String      getNom      () { return this.nom       ;}
	public int         getX        () { return this.x         ;}
	public int         getY        () { return this.y         ;}
	public int         getNb       () { return this.nb        ;}
	public List<Route> getLstRoutes() { return this.lstRoutes ;}

	public boolean setNom(String nom)
	{
		this.nom = nom;
		return true;
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

	public boolean ajouterRoute(Route route)
	{
		this.lstRoutes.add(route);
		return true;
	}
	
	public String toString() {
		String sRes = "";
		sRes +=  "{" +
			     " nb='" + getNb() + "'" +
			     ", nom='" + getNom() + "'" +
			     ", x='" + getX() + "'" +
			     ", y='" + getY() + "'" +
			     ", lstRoutes='";

		for (int i = 0; i < getLstRoutes().size(); i++)
		{
			sRes += getLstRoutes().get(i).getVilleDep().getNom() + "->" + getLstRoutes().get(i).getVilleArr().getNom() + " / ";
		}

		sRes += "'" + "}";

		return sRes;
	}
	void deplacerX (int x) { this.x += x;         }
	void deplacerY (int y) { this.y += y;         }
	
	boolean possede ( int x, int y )
	{
		int xA, yA;

		return this.distance(this.x, this.y, x, y) <= Ville.TAILLE/2;

		//return this.distance(this.getCentreX(), this.getCentreY(), x, y) <= this.distance(this.getCentreX(), this.getCentreY(), this.getCentreX(), this.getCentreY())
	}

	private double distance(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
	}
}