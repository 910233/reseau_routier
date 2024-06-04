package reseau_routier.ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import reseau_routier.Controleur;
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
		Ville ville;
		
		super.paintComponent(g);

		g2 = (Graphics2D) g;
		
		
		// Dessiner l'ensemble des figures
		for (int cpt=ctrl.getNbVille()-1; cpt>=0; cpt--)
		{
			ville = this.ctrl.getVille ( cpt );
			
			g2.drawOval ( ville.getX()-Ville.TAILLE/2, ville.getY()-Ville.TAILLE/2, Ville.TAILLE, Ville.TAILLE );

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

