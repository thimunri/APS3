package Views;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import Models.AutomoveisModel;
import Entidades.Fabricante;
import Entidades.ModeloAutomovel;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.util.ArrayList;

public class FormNovoAutomovel extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField ano;
	private static JComboBox comboFabricante, comboModelo;
	
	public FormNovoAutomovel(){
		super("Fiction Locadora de Veículos - Novo Automóvel");
		this.setSize(800,600);
		inicializaComponentes();
		this.setVisible(true);
	}
	
	
	public void inicializaComponentes(){
		
		JPanel mainPanel	= new JPanel(new BorderLayout());
		JPanel topoPanel	= new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblTitulo	=	new JLabel("Adicionar Automóvel");
		lblTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		topoPanel.add(lblTitulo,BorderLayout.NORTH);
		
		JPanel formPanel		= new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		

		cons.gridx = 0;
		cons.gridy = 0;
		cons.insets= new Insets(5,5,5,5);
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Placa: "),cons);
		
		cons.gridx  = 2;
		formPanel.add(new JTextField(15),cons);
		
		cons.gridy = 1;
		cons.gridx = 0;
		formPanel.add(new JLabel("Ano de Fabricação: "),cons);
		
		cons.gridx = 2;
		ano = new JTextField(15);
		formPanel.add(ano,cons);
		
		cons.gridy = 2;
		cons.gridx = 0;
		formPanel.add(new JLabel("Fabricante: "),cons);
		
		cons.gridx = 2;
		comboFabricante = new JComboBox();
		comboModelo		= new JComboBox();
		comboFabricante.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					Fabricante f = (Fabricante) e.getItem();
					populaModelos(f.getId());
				}
			}
		});
		
		populaFabricantes();
		formPanel.add(comboFabricante,cons);
		
		cons.gridy = 3;
		cons.gridx = 0;
		formPanel.add(new JLabel("Modelo: "),cons);
		
		cons.gridx = 2;
		formPanel.add(comboModelo,cons);
		
		cons.gridy = 4;
		cons.gridx = 0;
		formPanel.add(new JLabel("Cor: "),cons);
		
		cons.gridx = 2;
		formPanel.add(new JComboBox(new String[]{"Preto","Branco","Prata"}),cons);
		
		cons.gridy = 5;
		cons.gridx = 0;
		cons.gridwidth = 5;
		JPanel panelDetalhes = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panelDetalhes.setBorder(new TitledBorder("Detalhes do Automóvel"));
		
		panelDetalhes.add(new JLabel("Vidros: "));
		panelDetalhes.add(new JCheckBox());
		panelDetalhes.add(new JLabel("Ar Condicionado: "));
		panelDetalhes.add(new JCheckBox());
		panelDetalhes.add(new JLabel("Direção Hidraulica: "));
		panelDetalhes.add(new JCheckBox());
		panelDetalhes.add(new JLabel("Portas"));
		panelDetalhes.add(new JComboBox(new String[]{"2","4"}));
		
		formPanel.add(panelDetalhes,cons);	
		
		
		//KM
		cons.gridy = 6;
		cons.gridx = 0;
		formPanel.add(new JLabel("Kilometragem:"),cons);
		
		cons.gridx = 2;
		formPanel.add(new JTextField(10),cons);
		
		cons.gridy = 7;
		cons.gridx = 0;
		formPanel.add(new JLabel("Preço KM: "),cons);
		
		cons.gridx = 2;
		formPanel.add(new JTextField(10),cons);
		
		cons.gridy = 8;
		cons.gridx = 0;
		formPanel.add(new JLabel("Taxa Diaria: "),cons);
		
		cons.gridx = 2;
		formPanel.add(new JTextField(10),cons);
		
		
		cons.gridy = 9;
		cons.gridx = 0;
		formPanel.add(new JLabel("Observacoes:"),cons);
		
		cons.gridx = 2;
		cons.gridwidth = 5;
		JTextArea obs = new JTextArea(5,25);		
		JScrollPane scrollObs = new JScrollPane(obs);
		
		//obs.setLineWrap(true);
		formPanel.add(scrollObs,cons);
		
		mainPanel.add(topoPanel,BorderLayout.NORTH);
		mainPanel.add(formPanel,BorderLayout.CENTER);
		add(mainPanel);
	}
	
	
	public void populaFabricantes(){
		
		AutomoveisModel model = new AutomoveisModel();
		ArrayList<Fabricante> fabricantes = model.getFabricantes();
		
		for(Fabricante fabricante:fabricantes){
			comboFabricante.addItem(fabricante);
		}
		
	}
	
	
	/*
	 * Métodos responsavel por popular um ComboBox 
	 */
	public void populaModelos(String idFabricante){
		AutomoveisModel model = new AutomoveisModel();
		ArrayList<ModeloAutomovel> modelos = model.getModelos(idFabricante);
		comboModelo.removeAllItems();
		for(ModeloAutomovel modelo:modelos){
			comboModelo.addItem(modelo.nome);
			
		}
	}
	
}
