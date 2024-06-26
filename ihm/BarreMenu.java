package reseau_routier.ihm;

import javax.swing.*;
import java.awt.event.*;
import reseau_routier.Controleur;

public class BarreMenu extends JMenuBar implements ActionListener
{
	private Controleur ctrl;
	private String[][] modeleBarre = { { "M", "Fichier",          "F"                 },
	                                   { "I", "Enregistrer",      "E", "CTRL+S"       }  };

	public BarreMenu(Controleur ctrl)
	{
		this.ctrl = ctrl;
		
		JMenu     menu     = null;
		JMenuItem menuItem = null;
		
		for(String[] tabS : this.modeleBarre)
		{
			if(tabS[0].charAt(0) == 'M')
			{
				menu = new JMenu(tabS[1]);
				if(tabS.length == 3) menu.setMnemonic(tabS[2].charAt(0));
				
				this.add(menu);
			}
			if(tabS[0].charAt(0) == 'I')
			{
				menuItem = new JMenuItem(tabS[1]);
				if(tabS.length >= 3) menuItem.setMnemonic(tabS[2].charAt(0));
				if(tabS.length >= 4)
				{ 
					String s = tabS[3].substring(tabS[3].lastIndexOf("+")+1, tabS[3].length());
					int car, mod;
					
					if(!"F4".equals(s)) car = s.charAt(0);
					else                car = KeyEvent.VK_F4;
					
					mod = 0;
					if(tabS[3].indexOf("CTRL")  != -1) mod += InputEvent.CTRL_DOWN_MASK;
					if(tabS[3].indexOf("SHIFT") != -1) mod += InputEvent.SHIFT_DOWN_MASK;
					if(tabS[3].indexOf("ALT")   != -1) mod += InputEvent.ALT_DOWN_MASK;
					
					menuItem.setAccelerator(KeyStroke.getKeyStroke(car, mod));
				}
				
				menu.add(menuItem);
				
				menuItem.addActionListener ( this );
			}
			if(tabS[0].charAt(0) == 'S')
			{
				menu.addSeparator();
			}
		}
	}

	public void actionPerformed ( ActionEvent e )
	{
		if ( "Enregistrer".equals(((JMenuItem)e.getSource()).getText()) )
			this.ctrl.sauvegarder();
	}
}
