public class Route
{
	private int troncons;
	private Ville villeDepart;
	private Ville villeArrivee;

	private Route (int troncons, Ville villeDepart, Ville villeArrivee)
	{
		this.troncons = troncons;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
	}

	public Route nvRoute (int troncons, Ville villeDepart, Ville villeArrivee)
	{
		if (villeDepart != villeArrivee && troncons >= 0 && troncons <= 10)
			return new Route(troncons, villeDepart, villeArrivee);

		return null;
	}

	public int   getTroncons () { return this.troncons    ; }
	public Ville getDepart   () { return this.villeDepart ; }
	public Ville getArVille  () { return this.villeArrivee; }

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
		if (villeDepart != this.villeArrivee)
		{
			this.villeDepart = villeDepart;
			return true;
		}
		return false;
	}

	public boolean setArrivee (Ville villeArrivee)
	{
		if (villeArrivee != this.villeDepart)
		{
			this.villeArrivee = villeArrivee;
			return true;
		}
		return false;
	}
}