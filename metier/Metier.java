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
		//this.initTabVilles();
		//this.initTabRoutes();
	}

	public void initTabVilles()
	{
		
	}

	public void initTabRoutes()
	{
		
	}


	public boolean majXVille ( int ligne, Integer x ) { return this.lstVilles.get(ligne).setX(x); }
	public boolean majYVille ( int ligne, Integer y ) { return this.lstVilles.get(ligne).setY(y); }
	
	public void ajouterVille (Ville Ville) { this.lstVilles.add(Ville); }

	public void sauvegarder()
	{

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


