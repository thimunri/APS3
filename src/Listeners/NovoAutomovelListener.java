package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.FormNovoAutomovel;

public class NovoAutomovelListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new FormNovoAutomovel();
	}

}
