package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Automovel;
import Models.AutomoveisModel;
import Views.FormNovaLocacao;

public class BuscarAutomoveisListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		AutomoveisModel model = new AutomoveisModel();
		ArrayList<Automovel> carros = model.getAutomoveis(FormNovaLocacao.getFabricante(), FormNovaLocacao.getModelo());
		FormNovaLocacao.ZeraResult();
		
		for(Automovel carro:carros){
			FormNovaLocacao.insereLinhaResultAutomoveis(carro);
		}
		
		if(carros.size() == 0){
			JOptionPane.showMessageDialog(null, "Nenhum automovel localizado");
		}
	}

}
