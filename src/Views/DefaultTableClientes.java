package Views;

import javax.swing.table.DefaultTableModel;

public class DefaultTableClientes extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;

	public DefaultTableClientes(){
		super(null,new String[]{"COD", "Nome", "Email", "CPF", "Telefone", "Celular", "Telefone Recado", "Endereco", "Bairro", "Cidade", "UF","CEP"});
	}
	
}
