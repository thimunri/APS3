package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.FormCliente;
import Views.FormClientes;

import Entidades.Cliente;

public class ExibeClienteListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Cliente cliente;
		cliente = FormClientes.getSelectedCliente();
		
		new FormCliente(cliente);
	}

}
