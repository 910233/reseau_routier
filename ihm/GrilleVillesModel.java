package reseau_routier.ihm;

import javax.swing.table.AbstractTableModel;

import reseau_routier.Controleur;
import reseau_routier.metier.Ville;

public class GrilleVillesModel extends AbstractTableModel
{
	private Controleur ctrl;

	private String[]   tabEntetes;
	private Object[][] tabVilles;

	public GrilleVillesModel (Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.majDonnees();
		this.tabEntetes = new String[]{ "Num", "Nom", "X", "Y" };
	}

	public void majDonnees()
	{
		Ville ville;
		int nbVille = this.ctrl.getNbVille();

		tabVilles = new Object[nbVille][4];

		for ( int lig=0; lig<nbVille; lig++)
		{
			ville = this.ctrl.getVille(lig);

			tabVilles[lig][0] = ville.getNum ();
			tabVilles[lig][1] = ville.getNom ();
			tabVilles[lig][2] = ville.getX   ();
			tabVilles[lig][3] = ville.getY   ();
		}

		this.fireTableDataChanged();
	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabVilles.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabVilles[row][col];   }

	public boolean isCellEditable(int row, int col)
	{
		return col == 2 || col == 3;
	}

	public void setValueAt(Object value, int row, int col)
	{
		boolean bRet;

		if ( col == 2 )
		{
			bRet = this.ctrl.majXVille ( row, Integer.parseInt((String) value) );
			if ( bRet )
			{
				this.tabVilles[row][col] = value;
				this.fireTableCellUpdated(row, col);
				this.ctrl.majIHM();
			}
		}
		
		if ( col == 3 )
		{
			bRet = this.ctrl.majYVille ( row, Integer.parseInt((String) value) );
			if ( bRet )
			{
				this.tabVilles[row][col] = value;
				this.fireTableCellUpdated(row, col);
				this.ctrl.majIHM();
			}
		}
 		
	}

}
