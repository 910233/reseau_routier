package reseau_routier.metier;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

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

		String s, nom, villeDep, villeArr;
		int x, y, nbTronc;

		try
		{
			scFic = new Scanner ( new FileInputStream ( "./reseau_routier/donnees.data" ), "UTF8" );
			s     = "";

			if(scFic.hasNextLine()) s = scFic.nextLine();
			while ( scFic.hasNextLine() && !"".equals(s) )
			{	
				scLig = new Scanner(s);
				scLig.useDelimiter("\t");

				nom = scLig.next();
				x   = scLig.nextInt();
				y   = scLig.nextInt();

				this.lstVilles.add(Ville.nvVille(nom, x, y));
				s = scFic.nextLine();
				System.out.println(s);
			}

			s = scFic.nextLine();
			while ( scFic.hasNextLine() && !"".equals(s) )
			{
				scLig = new Scanner(s);
				System.out.println(s);
				scLig.useDelimiter("\t");

				villeDep = scLig.next();
				villeArr = scLig.next();
				nbTronc  = scLig.nextInt();

				this.lstRoutes.add (Route.nvRoute(this.getVille(villeDep), this.getVille(villeArr), nbTronc));
			
				s = scFic.nextLine();
			}
			scFic.close();
		}
		catch (Exception e){e.printStackTrace(System.out);}
	}

	public void sauvegarder()
	{
		System.out.println("sauvegarder");
		try
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./reseau_routier/donnees.data"), "UTF8" ));

			for (Ville v : this.lstVilles )
			{
				pw.println ( v.getNom() + "\t" +
				             v.getX()   + "\t" +
				             v.getY()          );

			}
			pw.println();

			for (Route r : this.lstRoutes )
			{
				pw.println ( r.getVilleDep().getNom() + "\t" +
				             r.getVilleArr().getNom() + "\t" +
				             r.getNbTronc()                   );

			}
			pw.println();
			
			pw.close();
		}
		catch (Exception e){}
	}

	// Accesseurs
	public int   getNbVille () { return this.lstVilles.size();             }
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

	public int   getNbRoute ()          { return this.lstRoutes.size();   }
	public Route getRoute   ( int num ) { return this.lstRoutes.get(num); }
	
	public String[] getNomsVilles () 
	{ 
		String[] tabNomsVilles = new String[this.lstVilles.size()+1];
		
		tabNomsVilles[0] = "";
		for(int i = 0; i < this.lstVilles.size(); i++) 
			tabNomsVilles[i+1] = this.lstVilles.get(i).getNom();

		return tabNomsVilles;
	}

	// Autres méthodes
	public boolean routeExiste(Ville villeDep, Ville villeArr) 
	{
		boolean retour = false;
		
		for(int i = 0; i < this.lstRoutes.size() && !retour; i++)
		{
			Route r = this.lstRoutes.get(i);
			if((r.getVilleDep() == villeDep && r.getVilleArr() == villeArr)
				||
			   (r.getVilleDep() == villeDep && r.getVilleArr() == villeArr)) 
			   retour = true;
		}

		return retour; 
	}

	public boolean majXVille ( int ligne, Integer x ) { return this.lstVilles.get(ligne).setX(x); }
	public boolean majYVille ( int ligne, Integer y ) { return this.lstVilles.get(ligne).setY(y); }
	
	public void ajouterVille (Ville ville) { this.lstVilles.add(ville); }
	public void ajouterRoute (Route route) { this.lstRoutes.add(route); }

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


