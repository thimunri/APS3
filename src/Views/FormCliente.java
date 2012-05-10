package Views;

import javax.swing.JFrame;
import Entidades.Cliente;

public class FormCliente extends JFrame{

	private static final long serialVersionUID = 1L;

	public FormCliente(Cliente cliente){

			super("Fiction Locadora de Veículos  - Visualizar / Editar Cliente");
			this.setSize(800,600);
			this.setVisible(true);
	}
	
}
