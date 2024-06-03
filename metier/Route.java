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
		this.troncons = troncons;
		return true;
	}

	public boolean setDepart (Ville villeDepart)
	{
		this.villeDepart = villeDepart;
		return true;
	}

	public boolean setArrivee (Ville villeArrivee)
	{
		this.villeArrivee = villeArrivee;
		return true;
	}
}