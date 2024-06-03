package reseau_routier.ihm;

import java.util.List;

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

		Ville clt;
		List<Ville> lstVilles = this.ctrl.getVilles();

		tabVilles = new Object[lstVilles.size()][4];

		for ( int lig=0; lig<lstVilles.size(); lig++)
		{
			clt = lstVilles.get(lig);

			/*
			tabVilles[lig][0] = clt.getPrenom  ();
			tabVilles[lig][1] = clt.getNom     ();
			tabVilles[lig][2] = clt.getPremium ();
			tabVilles[lig][3] = clt.getAnneeAdh();
			*/
		}

		this.tabEntetes = new String[]   {   "Prénom"  , "Nom"     , "Premium", "Année Adhésion"  };

	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabVilles.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabVilles[row][col];   }
	public Class  getColumnClass(int c)            { return getValueAt(0, c).getClass(); }

	public boolean isCellEditable(int row, int col)
	{
		return col == 2 || col == 3;
	}

	/*
	public void setValueAt(Object value, int row, int col)
	{
		boolean bRet;

		if ( col == 2 )
		{
			bRet = this.ctrl.majPremiumVille ( row, (Boolean) value );
			if ( bRet )
			{
				this.tabVilles[row][col] = value;
				this.fireTableCellUpdated(row, col);
			}
		}
		
		if ( col == 3 )
		{
			bRet = this.ctrl.majAnneeAdhesion ( row, (Integer) value );
			if ( bRet )
			{
				this.tabVilles[row][col] = value;
				this.fireTableCellUpdated(row, col);
			}
		}
 		
	}
	*/

}
