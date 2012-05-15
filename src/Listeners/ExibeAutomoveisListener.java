package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.FormAutomoveis;

public class ExibeAutomoveisListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new FormAutomoveis();
	}

	
	
}
