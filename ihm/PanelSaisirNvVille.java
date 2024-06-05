package reseau_routier.ihm;

import java.awt.*;
import javax.swing.*;

import reseau_routier.metier.Ville;

public class PanelSaisirNvVille extends JPanel implements Saisie<Ville>
{
	private JTextField  txtNom, txtX, txtY;

	public PanelSaisirNvVille()
	{
		this.setLayout(new GridLayout(4, 2));

		// Création des composants
		this.txtNom = new JTextField();
		this.txtX   = new JTextField();
		this.txtY   = new JTextField();

		// Positionnement des composants
		this.add(new JLabel("Nom : "));
		this.add(this.txtNom);
		this.add(new JLabel("X : "));
		this.add(this.txtX);
		this.add(new JLabel("Y : "));
		this.add(this.txtY);
		
		// Activation des composants

	}
	
	public Ville getSaisie() {
		Ville ville;
		String nom;
		int x, y;

		try {
			nom = this.txtNom.getText();
			x   = Integer.parseInt(this.txtX.getText());
			y   = Integer.parseInt(this.txtY.getText());
			ville = Ville.nvVille(nom, x, y);
		} 
		catch (Exception e) { ville = null; }

		return ville;
	}

	public void reinitSaisie()
	{
		this.txtNom.setText("");
		this.txtX.setText("");
		this.txtY.setText("");
	}
}
