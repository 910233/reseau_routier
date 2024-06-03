package reseau_routier.ihm;

import java.awt.event.*;
import javax.swing.*;

public class PanelNvVilleAction extends JPanel implements ActionListener
{
	private FrameNvVille frame;
	private JButton            btnValider;
	private JButton            btnAnnuler;

	public PanelNvVilleAction (FrameNvVille frame )
	{
		this.frame = frame;

		// création des composants
		this.btnValider = new JButton ( "Valider" );
		this.btnAnnuler     = new JButton ( "Annuler" );

		// Positionnement des composants
		this.add ( this.btnValider );
		this.add ( this.btnAnnuler     );

		// Activation des composants
		this.btnValider.addActionListener ( this );
		this.btnAnnuler.addActionListener(this);
	}


	public void actionPerformed ( ActionEvent e)
	{
		if ( e.getSource() == this.btnValider)
			this.frame.valider ();
		if ( e.getSource() == this.btnAnnuler)
			this.frame.annuler();
	}


}
