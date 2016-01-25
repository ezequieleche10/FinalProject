package Desktop;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Profesor;

public class XTableModelProfesores extends AbstractTableModel {

	ArrayList<Profesor> datasource;
	
	
	public ArrayList<Profesor> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<Profesor> datasource) {
		this.datasource = datasource;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	public void removeRow(int row) {
	    // remove a row from your internal data structure
		//datasource.remove(row);
		this.fireTableDataChanged();
	   // this.fireTableRowsDeleted(row, row);
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
			return datasource.size();
	}
	
	public boolean isCellEditable(int row, int column) {

        if (column < 3) {
            return false;
        } else {
            return true;
        }
	}
	
	 public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }

	 public void setValueAt(Object value, int row, int col) {
			
		 for(int i=0; i<datasource.size();++i){
			 datasource.get(i).setBandera(false);
			// fireTableCellUpdated(row, col);
		 }
		 fireTableRowsUpdated(0, datasource.size());
		 //a ese le pone true.
		 datasource.get(row).setBandera(Boolean.parseBoolean(value.toString()));
		 fireTableCellUpdated(row, col);
		 //ahora a todos los otros ponerle false para que no elija mas de uno
		// ver para validar que no seleccione mas de uno
	 }		
	 
	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		Profesor prof= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=prof.getCod_profesor();
			break;
		case 1:
			o=prof.getApellido();
			break;
		case 2:
			o=prof.getNombre();
			break;
		case 3:
			o= prof.getBandera(); //new Boolean(false);
			break;
		default:
			o=null;
			break;
		}
		return o;
	}
	public String getColumnName( int column)
	{
		String nom="";
		switch (column) {
		case 0:
			nom="Codigo";
			break;
		case 1:
			nom="Apellido";
			break;
		case 2:
			nom="Nombre";
			break;
		case 3:
			nom="Seleccionar";
			break;
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}