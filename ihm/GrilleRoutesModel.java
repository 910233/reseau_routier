package reseau_routier.ihm;


import javax.swing.table.AbstractTableModel;

import reseau_routier.Controleur;
import reseau_routier.metier.Route;

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
		int nbRoute = this.ctrl.getNbRoute();

		tabRoutes = new Object[nbRoute][3];

		for ( int lig=0; lig<nbRoute; lig++)
		{
			route = this.ctrl.getRoute(lig);

			tabRoutes[lig][0] = route.getVilleDep().getNom();
			tabRoutes[lig][1] = route.getVilleArr().getNom();
			tabRoutes[lig][2] = route.getNbTronc();
		}

		this.fireTableDataChanged();
	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabRoutes.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabRoutes[row][col];   }

}
