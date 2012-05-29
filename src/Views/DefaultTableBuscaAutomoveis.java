package Views;

import javax.swing.table.DefaultTableModel;


public class DefaultTableBuscaAutomoveis extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	
	public DefaultTableBuscaAutomoveis(){
		super(null, new String[]{"Cod","Fabricante","Modelo","Ano"});
	}
}
