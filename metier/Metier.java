package reseau_routier.metier;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;


public class Metier
{	
	private List<Ville> lstVilles;
	private List<Route> lstRoutes;

	public Metier()
	{
		this.lstVilles = new ArrayList<Ville>();
		this.lstRoutes = new ArrayList<Route>();
		this.initVillesRoutes();
	}

	public void initVillesRoutes()
	{
		Scanner scFic, scLig;

		String nom, villeDep, villeArr;
		int x, y, nbTronc;

		try
		{
			scFic = new Scanner ( new FileInputStream ( "donnees.data" ), "UTF8" );

			if(scFic.hasNextLine()) scFic.nextLine();
			while ( scFic.hasNextLine() && !scFic.nextLine().equals("Routes"))
			{
				scLig = new Scanner(scFic.nextLine());
				scLig.useDelimiter("\tab");

				nom = scLig.next();
				x   = scLig.nextInt();
				y   = scLig.nextInt();

				lstVilles.add (Ville.nvVille(nom, x, y));
			}

			if(scFic.hasNextLine()) scFic.nextLine();
			while ( scFic.hasNextLine() && !scFic.nextLine().equals(""))
			{
				scLig = new Scanner(scFic.nextLine());
				scLig.useDelimiter("\tab");

				villeDep = scLig.next();
				villeArr = scLig.next();
				nbTronc  = scLig.nextInt();

				lstRoutes.add (Route.nvRoute(nbTronc, this.getVille(villeDep), this.getVille(villeArr)));
			}
			scFic.close();
		}
		catch (Exception e){}
	}

	public boolean majXVille ( int ligne, Integer x ) { return this.lstVilles.get(ligne).setX(x); }
	public boolean majYVille ( int ligne, Integer y ) { return this.lstVilles.get(ligne).setY(y); }
	
	public void ajouterVille (Ville ville) { this.lstVilles.add(ville); }
	public void ajouterRoute (Route route) { this.lstRoutes.add(route); }

	public void sauvegarder()
	{
		try
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("donnees.data"), "UTF8" ));

			pw.println("Villes\n");
			for (Ville v : this.lstVilles )
			{
				pw.println ( v.getNom () + "\t" +
				             v.getX   () + "\t" +
				             v.getY   () + "\n"   );

			}

			pw.println("Routes\n");
			for (Route r : this.lstRoutes )
			{
				pw.println ( r.getVilleDep () + "\t" +
				             r.getVilleArr () + "\t" +
				             r.getNbTronc  () + "\n"   );

			}
			pw.close();
		}
		catch (Exception e){}
	}


	public List<Ville> getVilles  () { return new ArrayList<Ville>( this.lstVilles ); }
	public List<Route> getRoutes  () { return new ArrayList<Route>( this.lstRoutes ); }
	public int         getNbVille () { return this.lstVilles.size();                  }

	public Ville getVille ( int    num ) { return this.lstVilles.get(num); }
	public Ville getVille ( String nom ) 
	{
		for(Ville v : lstVilles)
			if(v.getNom().equals(nom)) return v;
		return null;
	}

	public Integer getIndiceVille ( int x, int y )
	{
		for (int cpt = 0; cpt<this.lstVilles.size(); cpt++ )
			if ( this.lstVilles.get(cpt).possede ( x, y ) )
				return cpt;

		return null;
	}

	public void deplacerVille ( Integer numVille, int x, int y )
	{
		if ( numVille != null && numVille >=0 && numVille < this.lstVilles.size() )
		{
			this.lstVilles.get(numVille).deplacerX(x);
			this.lstVilles.get(numVille).deplacerY(y);
		}
		
	}	

	public String toString()
	{
		String sRet = "";

		for ( Ville clt: this.lstVilles )
			sRet += clt.toString() + "\n";

		return sRet;
	}


}


