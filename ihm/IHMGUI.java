package reseau_routier.ihm;

import java.awt.Point;
import javax.swing.JFrame;

import reseau_routier.Controleur;
import reseau_routier.metier.Ville;

public class IHMGUI
{
	private static final int HAUTEUR_RR    = 820 + Ville.RAYON; // + 20 pour la barre de menu
	private static final int HAUTEUR_ROUTE = 400;
	private static final int HAUTEUR_VILLE = 400;
	private static final int LARGEUR_RR    = 1000 + Ville.RAYON;
	private static final int LARGEUR_ROUTE = 250;
	private static final int LARGEUR_VILLE = 250;

	private FrameResRoute frameResRoute;
	private FrameRoute    frameRoute;
	private FrameVille    frameVille;

	public IHMGUI(Controleur ctrl)
	{
		this.frameResRoute = new FrameResRoute (ctrl);
		this.frameRoute    = new FrameRoute  (ctrl);
		this.frameVille    = new FrameVille(ctrl);

		this.frameVille.setTitle       ("Villes");
		this.frameVille.setSize        ( IHMGUI.LARGEUR_VILLE, IHMGUI.HAUTEUR_VILLE );
		this.frameVille.setLocation    ( 0, 0 );
		this.frameVille.setResizable   (false);
		this.frameVille.setVisible     ( true );
		this.frameVille.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frameResRoute.setTitle    ("Réseau routier");
		this.frameResRoute.setSize     ( IHMGUI.LARGEUR_RR, IHMGUI.HAUTEUR_RR );
		this.frameResRoute.setLocation ( IHMGUI.LARGEUR_VILLE + 20, 0 );
		this.frameResRoute.setResizable(false);
		this.frameResRoute.setVisible  ( true );
		this.frameResRoute.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frameRoute.setTitle       ("Routes");
		this.frameRoute.setSize        ( IHMGUI.LARGEUR_ROUTE, IHMGUI.HAUTEUR_ROUTE );
		this.frameRoute.setLocation    ( IHMGUI.LARGEUR_VILLE + IHMGUI.LARGEUR_RR + 20, 0);
		this.frameRoute.setResizable   (false);
		this.frameRoute.setVisible     ( true );
		this.frameRoute.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void deplacerLesFrames ( char orig )
	{
		if(    this.frameResRoute != null 
		    && this.frameRoute    != null 
			&& this.frameVille    != null)
		{
			Point p;
			// Représentation Graphique (G)
			if ( orig == 'G')
			{
				p = this.frameResRoute.getLocation();
				this.frameRoute.setLocation(p.x + IHMGUI.LARGEUR_RR, p.y);
				this.frameVille.setLocation(p.x - IHMGUI.LARGEUR_VILLE, p.y);
			}
			// Routes (R)
			if ( orig == 'R')
			{
				p = this.frameRoute.getLocation ();
				this.frameResRoute.setLocation    (p.x - IHMGUI.LARGEUR_RR, p.y);
				this.frameVille.setLocation (p.x - IHMGUI.LARGEUR_RR - IHMGUI.LARGEUR_ROUTE, p.y);
			}
			// Villes (V)
			if ( orig == 'V')
			{
				p = this.frameVille.getLocation();
				this.frameResRoute.setLocation (p.x + IHMGUI.LARGEUR_ROUTE, p.y);
				this.frameRoute.setLocation  (p.x + IHMGUI.LARGEUR_ROUTE + IHMGUI.LARGEUR_RR, p.y);
				
			}
		}
	}

	public void maj() 
	{
		this.frameVille.majTableau();
		this.frameRoute.majTableau();
		this.frameResRoute.maj();
	}
}
