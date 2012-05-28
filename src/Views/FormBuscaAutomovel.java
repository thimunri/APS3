package Views;

import java.awt.*;

import javax.swing.*;

public class FormBuscaAutomovel extends JFrame {

	public FormBuscaAutomovel(){
		super("Busca Automovel");
		this.setSize(600,300);
		inicializaComponentes();
		this.setVisible(true);
	}
	
	
	public void inicializaComponentes(){
		JPanel mainPanel, topoPanel;
		
		mainPanel = new JPanel(new BorderLayout());
		topoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitulo = new JLabel("Busca Automovel");
		lblTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		topoPanel.add(lblTitulo);
		
		mainPanel.add(topoPanel,BorderLayout.NORTH);
		add(mainPanel);
	}
	
}
