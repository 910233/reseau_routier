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

	public boolean majNomVille ( int ligne, String nom )
	{
		return this.lstVilles.get(ligne).setNom(nom);
	}

	//etc...
	
	public void ajouterVille (Ville Ville)
	{
		this.lstVilles.add(Ville);
	}

	public void sauvegarder()
	{

	}


	public List<Ville> getVilles()
	{
		return new ArrayList<Ville>( this.lstVilles );
	}


	public String toString()
	{
		String sRet = "";

		for ( Ville clt: this.lstVilles )
			sRet += clt.toString() + "\n";

		return sRet;
	}

}


