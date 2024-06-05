package reseau_routier.metier;

public class Route
{
	private int troncons;
	private Ville villeDepart;
	private Ville villeArrivee;

	private Route (Ville villeDepart, Ville villeArrivee, int troncons)
	{
		this.villeDepart  = villeDepart;
		this.villeArrivee = villeArrivee;
		this.troncons     = troncons;
	}

	public static Route nvRoute (Ville villeDepart, Ville villeArrivee, int troncons)
	{
		Route route;
		
		route = null;
		if (   villeDepart  != null
		    && villeDepart  != villeArrivee 
			&& 0 <= troncons && troncons <= 10)
		{
			route = new Route(villeDepart, villeArrivee, troncons);
			villeDepart.ajouterRoute(route);
			villeArrivee.ajouterRoute(route);
		}

		/*
		for(int i = 0; i < villeDepart.getNbRoute() && bOk; i++)
		{
			route = villeDepart.getRoute(i);
			if(   route.getVilleDep() == villeDepart
			   && route.getVilleArr() == villeArrivee) bOk = false;
		}
		*/
		
		return route;
	}

	// Accesseurs
	public int   getNbTronc  () { return this.troncons    ; }
	public Ville getVilleDep () { return this.villeDepart ; }
	public Ville getVilleArr () { return this.villeArrivee; }

	// Modificateurs
	public boolean setTroncons (int troncons)
	{
		if (troncons >= 0 && troncons <= 10)
		{
			this.troncons = troncons;
			return true;
		}
		return false;
	}

	public boolean setDepart (Ville villeDepart)
	{
		if (villeDepart != null && villeDepart != this.villeArrivee)
		{
			this.villeDepart = villeDepart;
			return true;
		}
		return false;
	}

	public boolean setArrivee (Ville villeArrivee)
	{
		if (villeArrivee != null &&  villeArrivee != this.villeDepart)
		{
			this.villeArrivee = villeArrivee;
			return true;
		}
		return false;
	}

	// Autres Méthodes
	public String toString() {
		return "{" +
			" troncons='" + getNbTronc() + "'" +
			", villeDepart='" + getVilleDep() + "'" +
			", villeArrivee='" + getVilleArr() + "'" +
			"}";
	}

}