package reseau_routier.ihm;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import reseau_routier.Controleur;
import reseau_routier.metier.Route;
import reseau_routier.metier.Ville;

public class GrilleRoutesModel extends AbstractTableModel
{
	private Controleur ctrl;

	private String[]   tabEntetes;
	private Object[][] tabRoutes;

	public GrilleRoutesModel (Controleur ctrl)
	{
		this.ctrl = ctrl;
		
		this.majDonnees();

		this.tabEntetes = new String[]{ "Ville Dep", "Ville Arr", "Nb Tronçons" };

	}

	public void majDonnees()
	{
		Route route;
		List<Route> lstRoutes = this.ctrl.getRoutes();

		tabRoutes = new Object[lstRoutes.size()][3];

		for ( int lig=0; lig<lstRoutes.size(); lig++)
		{
			route = lstRoutes.get(lig);

			tabRoutes[lig][0] = route.getVilleDep ();
			tabRoutes[lig][1] = route.getVilleArr ();
			tabRoutes[lig][2] = route.getNbTronc  ();
		}

		this.fireTableDataChanged();
	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabRoutes.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabRoutes[row][col];   }
	//public Class  getColumnClass(int c)            { return getValueAt(0, c).getClass(); }

	/*
	public boolean isCellEditable(int row, int col)
	{
		return false;
	}
	*/

}
