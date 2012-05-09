package Views;

import javax.swing.JFrame;
import Entidades.Cliente;

public class FormCliente extends JFrame{

	private static final long serialVersionUID = 1L;

	public FormCliente(Cliente cliente){

			this.setSize(800,600);
			this.setTitle("Cliente");
			this.setVisible(true);
			
			System.out.println(cliente);
	}
	
}
