package reseau_routier.ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

import reseau_routier.Controleur;
import reseau_routier.metier.Route;
import reseau_routier.metier.Ville;

public class PanelResRoute extends JPanel
{	
	private Controleur ctrl;
	private Graphics2D g2;

	public PanelResRoute  ( Controleur ctrl )
	{
		this.ctrl = ctrl;

		GereSouris gereSouris = new GereSouris();

		this.addMouseListener      ( gereSouris );
		this.addMouseMotionListener( gereSouris );
	}
	
	public void paintComponent(Graphics g)
	{			
		super.paintComponent(g);
		g2 = (Graphics2D) g;

		Ville ville;
		Route route;
		List<Ville> lstVilles = this.ctrl.getVilles();
		List<Route> lstRoutes = this.ctrl.getRoutes();
		
		// Dessiner l'ensemble des routes
		g2.setColor(Color.BLACK);
		for (int cpt=lstRoutes.size()-1; cpt>=0; cpt--)
		{
			route = lstRoutes.get( cpt );
			
			for(int i = 0; i <= route.getNbTronc(); i++)
			{

			}
		}

		// Dessiner l'ensemble des villes
		for (int cpt=lstVilles.size()-1; cpt>=0; cpt--)
		{
			ville = lstVilles.get( cpt );
			
			g2.setColor(Color.RED);
			g2.fillOval(ville.getX()-Ville.RAYON, 
			            ville.getY()-Ville.RAYON, 
						Ville.RAYON*2, 
						Ville.RAYON*2            );
			
						g2.setColor(Color.BLACK);
			g2.drawString(ville.getNom(), ville.getX(), ville.getY()-Ville.RAYON-5);
		}
	}

	private class GereSouris extends MouseAdapter
	{
		Integer numVilleActive = null;
		int     posX, posY;
		
		public void mousePressed(MouseEvent e)
		{
			this.numVilleActive = PanelResRoute.this.ctrl.getIndiceVille ( e.getX(), e.getY() );
			this.posX = e.getX();
			this.posY = e.getY();
		}

		
		public void mouseDragged(MouseEvent e) 
		{
			if ( this.numVilleActive != null )
			{
				PanelResRoute.this.ctrl.deplacerVille ( this.numVilleActive, e.getX()-this.posX, e.getY()-this.posY );

				// Ne pas oublier de mettre à jour les futures anciennes coordonnées de la souris
				this.posX = e.getX();
				this.posY = e.getY();
				
				PanelResRoute.this.repaint();
			}
		}
	}
}

