package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Models.ClienteModel;
import Views.FormClientes;

public class DeletaClienteListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cod, nome;
		int linha;

		linha = FormClientes.getLinhaSelecionada();


		if( linha >= 0 ){
			ClienteModel model = new ClienteModel();
			cod		=	FormClientes.getCod(linha);
			nome	=	FormClientes.getNome(linha);

			if (JOptionPane.showConfirmDialog(null, "Deseja realmente remover o cliente '" + nome + " (Cod:"+cod+")'? ") == 0){

				//Remove do banco de dados
				model.removeCliente( cod );

				//Remove da tabela
				FormClientes.removeLinha(linha);

				JOptionPane.showMessageDialog(null, "Cliente removido!");

			}
		}//end if	
		else {
			JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado. ");
		}
	}

	
}
