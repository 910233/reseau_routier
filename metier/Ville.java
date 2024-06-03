package reseau_routier.metier;

import java.util.ArrayList;
import java.util.List;

public class Ville
{
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

    public Ville nvVille(String nom, int x, int y)
    {
        if (x >= 0 && x <= 1000)
            if (y >= 0 && y <= 800)
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
}