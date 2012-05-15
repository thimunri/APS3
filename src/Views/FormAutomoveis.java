package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import Models.AutomoveisModel;
import Entidades.Carro;

public class FormAutomoveis extends JFrame {
 
	private static final long serialVersionUID = 1L;

	private DefaultTableAutomoveis modelAutomoveis;

	public FormAutomoveis(){
		
		super("Fiction Veículos - Cadastro de Automóveis");
		this.setSize(800,600);
		inicializaComponentes();
		this.setVisible(true);
	}
	
	
	
	private void inicializaComponentes(){
			
		JPanel panelTopo 		= new JPanel(new BorderLayout());
		panelTopo.setBackground(new Color(255,255,255));
		JPanel panelBotoes		= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBotoes.setBackground(new Color(255,255,255));
		
		panelBotoes.add(new JButton("Adicionar"));
		panelBotoes.add(new JButton("Remover"));
		panelBotoes.add(new JButton("Editar/Visualizar"));
		
		panelTopo.add(panelBotoes,BorderLayout.EAST);
		
		JLabel labelTitulo = new JLabel("Automóveis");
		labelTitulo.setIcon( new ImageIcon( getClass().getResource("/resources/icons/car_32.png")));
		panelTopo.add(labelTitulo,BorderLayout.WEST);
		labelTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(panelTopo,BorderLayout.NORTH);
		
		modelAutomoveis = new DefaultTableAutomoveis();
		JTable tableAutomoveis = new JTable(modelAutomoveis);
		JScrollPane scroll = new JScrollPane(tableAutomoveis);
		populaTabela();
		
		
		mainPanel.add(scroll,BorderLayout.CENTER);
		
		this.getContentPane().add(mainPanel);
	}
	
	
	public void populaTabela(){
		AutomoveisModel model = new AutomoveisModel();
		ArrayList<Carro> carros = model.getAutomoveis();
		
		for( Carro carro:carros ){
			modelAutomoveis.addRow(new String[]{carro.getCod(),carro.getPlaca(), carro.getNomeFabricante(),carro.getNomeModelo()});
		}
	}
	
	
}
