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
		//this.initTabVilles();
		//this.initTabRoutes();
	}

	public void initTabVilles()
	{

	}

	public void initTabRoutes()
	{
		Scanner     scFic;
		Decomposeur dec;

		String villeDepart;
		String villeArrivee;
		int nbTroncons;

		try
		{
			scFic = new Scanner ( new FileInputStream ( "constante.data" ), "UTF8" );

			while ( scFic.hasNextLine() )
			{

				dec = new Decomposeur ( scFic.nextLine() );

				

				//                                    nom                prenom         premium     anneeAdh
				this.lstClients.add ( new Client ( dec.getString(1), dec.getString(0), bPremium, dec.getInt(3) ) );
			}

			scFic.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}


	public boolean majXVille ( int ligne, Integer x ) { return this.lstVilles.get(ligne).setX(x); }
	public boolean majYVille ( int ligne, Integer y ) { return this.lstVilles.get(ligne).setY(y); }
	
	public void ajouterVille (Ville Ville) { this.lstVilles.add(Ville); }

	public void sauvegarder()
	{
		try {
			String chemin = System.getProperty("user.dir");
			File fichier = new File(chemin + "constante.data");

			if (fichier.createNewFile())
				System.out.println("Fichier crée");
			else
				System.out.println("Le fichier existe déja");


			try {
				PrintWriter pw = new PrintWriter( new FileOutputStream(fichier.getName()) );

				for (int i = 0; i < lstVilles.size(); i++)
				{
					Ville ville = lstVilles.get(i);
					pw.println(ville.getNom() + "|" + ville.getX() + "|" + ville.getY());
				}

				pw.println();

				for (int i = 0; i < lstRoutes.size(); i++)
				{
					Route route = lstRoutes.get(i);
					pw.println(route.getVilleArrivee().getNom() + "|" + route.getVilleDepart().getNom() + "|" + route.getTroncons());
				}
				pw.close();
			}
			catch (Exception e){ e.printStackTrace(); }
		}
		catch(Exception e) { System.out.println(e); }
	}


	public List<Ville> getVilles() { return new ArrayList<Ville>( this.lstVilles ); }
	public List<Route> getRoutes() { return new ArrayList<Route>( this.lstRoutes ); }

	public String toString()
	{
		String sRet = "";

		for ( Ville clt: this.lstVilles )
			sRet += clt.toString() + "\n";

		return sRet;
	}

}


