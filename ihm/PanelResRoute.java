package reseau_routier.ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
		int x1, y1, x2, y2, nbTronc;
		float segment, espace;
		
		// Dessiner l'ensemble des routes
		g2.setColor(Color.BLACK);
		for (int cpt=this.ctrl.getNbRoute()-1; cpt>=0; cpt--)
		{
			route = this.ctrl.getRoute( cpt );

			x1 = route.getVilleDep().getX();
			y1 = route.getVilleDep().getY();
			x2 = route.getVilleArr().getX();
			y2 = route.getVilleArr().getY();
			nbTronc = route.getNbTronc();

			if(nbTronc == 0)
			{
				g2.setStroke(new BasicStroke(2));
			}
			else
			{
				espace  = ((float) Ville.distance(x1, y1, x2, y2)) * 0.1f / nbTronc;
				segment = ((float) Ville.distance(x1, y1, x2, y2)) * 0.9f / nbTronc + espace / nbTronc;

				
				g2.setStroke(new BasicStroke(
				2, 
				BasicStroke.CAP_BUTT, 
				BasicStroke.JOIN_ROUND, 
				0, 
				new float[]{segment, espace},
				0));
			}
			
			g2.drawLine(x1, y1, x2, y2);
		}

		// Dessiner l'ensemble des villes
		for (int cpt=this.ctrl.getNbVille()-1; cpt>=0; cpt--)
		{
			ville = this.ctrl.getVille( cpt );
			
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

				this.posX = e.getX();
				this.posY = e.getY();
				
				PanelResRoute.this.repaint();
			}
		}
	}
}

