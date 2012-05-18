package Views;

import javax.swing.table.DefaultTableModel;

public class DefaultTableAutomoveis extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	public DefaultTableAutomoveis(){
		super(null,new String[]{"COD", "Placa", "Fabricante", "Modelo","Disponibilidade"});
	}
}
