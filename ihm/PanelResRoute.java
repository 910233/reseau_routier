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
		int x1, y1, x2, y2;
		BasicStroke bs;
		
		// Dessiner l'ensemble des routes
		g2.setColor(Color.BLACK);
		for (int cpt=this.ctrl.getNbRoute()-1; cpt>=0; cpt--)
		{
			route = this.ctrl.getRoute( cpt );

			x1 = route.getVilleDep().getX();
			y1 = route.getVilleDep().getY();
			x2 = route.getVilleArr().getX();
			y2 = route.getVilleArr().getY();

			bs = new BasicStroke(
			2,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_BEVEL,
            0,
            new float[]{ 100, 10},
        	0);
			
			g2.setStroke(bs);
			g2.drawLine(x1, y1, x2, y2);

			for(int i = 0; i <= route.getNbTronc(); i++)
			{

			}
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

	private static float distance(int x1, int y1, int x2, int y2)
	{
		return (float)Math.sqrt((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
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

