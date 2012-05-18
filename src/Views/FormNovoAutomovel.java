package Views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import Models.AutomoveisModel;
import Entidades.Automovel;
import Entidades.Fabricante;
import Entidades.ModeloAutomovel;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.util.ArrayList;

public class FormNovoAutomovel extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField ano,placa, km, valorKm, taxa;
	private static JComboBox comboFabricante, comboModelo, cor;
	private JTextArea obs;
	
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
		lblTitulo.setIcon( new ImageIcon( getClass().getResource("/resources/icons/car_add_32.png")));
		lblTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		topoPanel.setBackground(new Color(255,255,255));
		topoPanel.add(lblTitulo,BorderLayout.NORTH);
		
		JPanel formPanel		= new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		//PLACA
		cons.gridx = 0;
		cons.gridy = 0;
		cons.insets= new Insets(5,5,5,5);
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Placa: "),cons);
		
		cons.gridx  = 2;
		placa	=	new JTextField(15);
		formPanel.add(placa,cons);
		
		
		//ANO
		cons.gridy = 1;
		cons.gridx = 0;
		formPanel.add(new JLabel("Ano de Fabricação: "),cons);
		
		cons.gridx = 2;
		ano = new JTextField(15);
		formPanel.add(ano,cons);
		
		
		//FABRICANTE
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
		
		
		//MODELO
		cons.gridy = 3;
		cons.gridx = 0;
		formPanel.add(new JLabel("Modelo: "),cons);
		
		cons.gridx = 2;
		formPanel.add(comboModelo,cons);
		
		
		//DETALHES
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
		panelDetalhes.add(new JLabel("Cor: "));
		panelDetalhes.add(new JComboBox(new String[]{"Vermelho","Prata"}));
		
		formPanel.add(panelDetalhes,cons);	
		
		
		//KM
		cons.gridy = 6;
		cons.gridx = 0;
		formPanel.add(new JLabel("Kilometragem:"),cons);
		
		cons.gridx = 2;
		km	=	new JTextField(10);
		formPanel.add(km,cons);
		
		
		//PRECO KM
		cons.gridy = 7;
		cons.gridx = 0;
		formPanel.add(new JLabel("Preço KM: "),cons);
		
		cons.gridx = 2;
		valorKm	=	new JTextField(10);
		formPanel.add(valorKm,cons);
		
		
		//TAXA
		cons.gridy = 8;
		cons.gridx = 0;
		formPanel.add(new JLabel("Taxa Diaria: "),cons);
		
		cons.gridx = 2;
		taxa = new JTextField(10);
		formPanel.add(taxa,cons);
		
		
		cons.gridy = 9;
		cons.gridx = 0;
		formPanel.add(new JLabel("Observacoes:"),cons);
		
		cons.gridx = 2;
		cons.gridwidth = 5;
		obs = new JTextArea(5,25);		
		JScrollPane scrollObs = new JScrollPane(obs);
		
		//obs.setLineWrap(true);
		formPanel.add(scrollObs,cons);
		
		JPanel panelBottom 	= 	new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnSalvar 	=	new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				AutomoveisModel model = new AutomoveisModel();
				if( model.salva(getAutomovel()) ){
					JOptionPane.showMessageDialog(null, "Automovel cadastrado com sucesso!");
					fechar();
				} 
		}});
		
		
		JButton btnCancelar	=	new JButton("Cancelar");
		
		panelBottom.add(btnSalvar);
		panelBottom.add(new JButton("Cancelar"));
		

		mainPanel.add(topoPanel,BorderLayout.NORTH);
		mainPanel.add(formPanel,BorderLayout.CENTER);
		mainPanel.add(panelBottom,BorderLayout.SOUTH);
		add(mainPanel);
	}
	
	public void fechar(){
		this.dispose();
	}
	
	public void populaFabricantes(){
		
		AutomoveisModel model = new AutomoveisModel();
		ArrayList<Fabricante> fabricantes = model.getFabricantes();
		
		for(Fabricante fabricante:fabricantes){
			comboFabricante.addItem(fabricante);
		}
		
	}
	
	
	/*
	 * Método responsavel por popular um ComboBox 
	 */
	public void populaModelos(String idFabricante){
		AutomoveisModel model = new AutomoveisModel();
		ArrayList<ModeloAutomovel> modelos = model.getModelos(idFabricante);
		comboModelo.removeAllItems();
		for(ModeloAutomovel modelo:modelos){
			comboModelo.addItem(modelo);
		}
	}
	
	
	public Automovel getAutomovel(){
		Automovel novoAutomovel = new Automovel();
		Fabricante 			f = (Fabricante) comboFabricante.getSelectedItem();
		ModeloAutomovel		m = (ModeloAutomovel) comboModelo.getSelectedItem();
		
		novoAutomovel.setPlaca(placa.getText());
		novoAutomovel.setAno(ano.getText());
		novoAutomovel.setFabricante(f);
		novoAutomovel.setModelo(m);
		novoAutomovel.setKm(km.getText());
		novoAutomovel.setValorKm(valorKm.getText());
		novoAutomovel.setTaxa(taxa.getText());
		
		return novoAutomovel;
	}
	
	
}
