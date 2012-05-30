package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Entidades.Automovel;
import Entidades.Cliente;
import Entidades.Locacao;
import Models.LocacoesModel;
import Views.FormNovaLocacao;

public class FinalizaLocacaoListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		
		Cliente cliente = FormNovaLocacao.getCliente();
		Automovel auto = FormNovaLocacao.getSelectedAutomovel();
		
		if(auto.getCod() != null){
			if(auto.getDisponibilidade().equals("Sim")){
				
			Locacao novaLocacao = new Locacao();
			novaLocacao.setCliente(cliente);
			novaLocacao.setAutomovel(auto);
			
			LocacoesModel model = new LocacoesModel();
			model.salva(novaLocacao);
			
			
				
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Este automovel nao esta disponivel para locacao");
			}
		}
	}

}
