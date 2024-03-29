package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Entidades.Automovel;
import Entidades.Cliente;
import Entidades.Fabricante;
import Entidades.ModeloAutomovel;
import Listeners.BuscarAutomoveisListener;
import Listeners.FinalizaLocacaoListener;
import Models.AutomoveisModel;

public class FormNovaLocacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JComboBox comboFabricante, comboModelo;
	private static Cliente cliente;
	private static DefaultTableModel modelBuscaAutomoveis;
	private static JTable tableResultAuto;
	
	private JTextField cpf,nome,email,logradouro, bairro, cidade, uf, cep;

	public FormNovaLocacao(){
		super("Fiction");
		this.setSize(800,600);
		inicializaComponentes();
		this.setVisible(true);
	}
	
	
	
	public FormNovaLocacao(Cliente c){
		
		super("Fiction");
		this.cliente = c;
		this.setSize(800,600);
		inicializaComponentes();
		setSubFormCliente(c);
		this.setVisible(true);
		
		
	}
	
	public void inicializaComponentes(){
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel topoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topoPanel.setBackground(new Color(255,255,255));
		
		JLabel lblTitulo = new JLabel("Alugar Automovel");
		lblTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		topoPanel.add(lblTitulo);
		
		
		//Panel que contem os 2 subFormularios "cliente" e "automovel"
		JPanel formPanel = new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridy = 0;
		cons.gridx = 0;
		cons.insets = new Insets(5,5,5,5);
		
		//Sub-Formulário com os detalhes do cliente
		JPanel panelCliente = new JPanel(new GridBagLayout());
		
		panelCliente.setBorder(new TitledBorder("Dados do Cliente"));
		panelCliente.add(new JLabel("CPF: "),cons);
		
		cons.gridx = 1;
		cons.gridwidth = 2;
		cpf = new JTextField(10);
		panelCliente.add(cpf,cons);
		
		cons.gridx = 3;
		cons.gridwidth = 1;
		JButton btn	=	new JButton("");
		btn.setIcon( new ImageIcon( getClass().getResource("/resources/icons/find_16.png")));
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panelCliente.add(btn,cons);
		
		cons.gridy = 1;
		cons.gridx = 0;
		panelCliente.add(new JLabel("Nome:"),cons);
		
		cons.gridx = 1; 
		nome = new JTextField(10);
		panelCliente.add(nome,cons);
		
		cons.gridx = 3; 
		panelCliente.add(new JLabel("Email:"),cons);
		
		cons.gridx = 4;
		email = new JTextField(15);
		panelCliente.add(email,cons);
		
		cons.gridy = 2;
		cons.gridx = 0;
		panelCliente.add(new JLabel("Logradouro:"),cons);
		
		cons.gridx = 1;
		logradouro	=	new JTextField(10);
		panelCliente.add(logradouro,cons);
		
		cons.gridx = 3;
		panelCliente.add(new JLabel("Cidade:"),cons);
		
		cons.gridx = 4;
		cidade = new JTextField(15);
		panelCliente.add(cidade,cons);
		
		cons.gridx = 5;
		panelCliente.add(new JLabel("Bairro: "),cons);
		
		cons.gridx = 6;
		bairro = new JTextField(15);
		panelCliente.add(bairro,cons);
		
		cons.gridy = 3;
		cons.gridx = 0;
		panelCliente.add(new JLabel("Estado:"),cons);
		
		cons.gridx = 1;
		uf = new JTextField(10);
		panelCliente.add(uf,cons);
		
		cons.gridx = 3;
		panelCliente.add(new JLabel("CEP: "),cons);
		
		cons.gridx = 4;
		cep =  new JTextField(15);
		panelCliente.add(cep,cons);
		
		
		GridBagConstraints consFormPanel = new GridBagConstraints();
		consFormPanel.gridx = 0;
		consFormPanel.gridy = 0;
		
		//Add o sub de cliente
		formPanel.add(panelCliente,consFormPanel);
		
		
		//Cria o subFormulario de Automovel
		JPanel panelCarro = new JPanel(new GridBagLayout());
		panelCarro.setBorder(new TitledBorder("Utilize os campos abaixo para localizar o automovel"));
		
		GridBagConstraints consCarro = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		
		panelCarro.add(new JLabel("Fabricante: "),consCarro);
		
		consCarro.gridx = 1;
		consCarro.insets = new Insets(5,5,5,5);
		
		comboFabricante = new JComboBox();
		comboModelo = new JComboBox();
		comboFabricante.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					Fabricante f = (Fabricante) e.getItem();
					populaModelos(f.getId());
				}
			}
		});
		populaFabricantes();
		panelCarro.add(comboFabricante,consCarro);
		
		
		//MODELO
		consCarro.gridx = 2;
		panelCarro.add(new JLabel("Modelo: "),consCarro);
		
		consCarro.gridx = 3;
		panelCarro.add(comboModelo,consCarro);
		
		consCarro.gridx = 4;
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new BuscarAutomoveisListener());
		panelCarro.add(btnBuscar,consCarro);
		
		
		consCarro.gridy			= 1;
		consCarro.gridx			= 0;
		consCarro.gridwidth		= 5;
		modelBuscaAutomoveis	= new DefaultTableModel(null,new String[]{"Cod","Fabricante","Modelo","Ano","Taxa Diaria","Valor KM","Kilometragem","Disponivel"});
		tableResultAuto			= new JTable(modelBuscaAutomoveis);
		
		JScrollPane scrollResultAuto = new JScrollPane(tableResultAuto);
		scrollResultAuto.setPreferredSize(new Dimension(700,200));
		//JPanel panelResult = new JPanel(new BorderLayout());
		
		
		panelCarro.add(scrollResultAuto,consCarro);
		
		/*
		consCarro.gridx = 2;
		panelCarro.add(new JLabel("Modelo: "),consCarro);
		
		consCarro.gridx = 3;
		panelCarro.add(new JTextField(15),consCarro);
		
		consCarro.gridx = 4;
		panelCarro.add(new JLabel("Kilometragem: "),consCarro);
		
		consCarro.gridx = 5;
		panelCarro.add(new JTextField(10),consCarro);
		
		consCarro.gridy = 2;
		consCarro.gridx = 0;
		panelCarro.add(new JLabel("Taxa: "),consCarro);
		
		consCarro.gridx = 1;
		panelCarro.add(new JTextField(10),consCarro);
		
		consCarro.gridx = 2;
		panelCarro.add(new JLabel("Preço KM: "),consCarro);
		
		consCarro.gridx = 3;
		panelCarro.add(new JTextField(15),consCarro);*/
		
		
		
		//Add o sub de carros
		consFormPanel.gridy = 2;
		formPanel.add(panelCarro,consFormPanel);
		
		
		JPanel panelBotoesRodape = new JPanel(new FlowLayout( FlowLayout.RIGHT ));
		JButton btnFinaliza = new JButton("Finalizar Locacao");
		btnFinaliza.addActionListener(new FinalizaLocacaoListener());
		
		panelBotoesRodape.add(btnFinaliza);
		
		mainPanel.add(formPanel,BorderLayout.CENTER);
		mainPanel.add(topoPanel,BorderLayout.NORTH);
		mainPanel.add(panelBotoesRodape,BorderLayout.SOUTH);
		
		add(mainPanel);
	}
	
	
	public void setSubFormCliente(Cliente c){
		cpf.setText(c.cpf);
		nome.setText(c.nome);
		email.setText(c.email);
		logradouro.setText(c.logradouro);
		bairro.setText(c.bairro);
		cidade.setText(c.cidade);
		uf.setText(c.uf);
		cep.setText(c.cep);
		
	}
	
	public void populaFabricantes(){
		
		AutomoveisModel model = new AutomoveisModel();
		ArrayList<Fabricante> fabricantes = model.getFabricantes();
		
		for(Fabricante fabricante:fabricantes){
			comboFabricante.addItem(fabricante);
		}
		
	}	
	
	/*
	 * Popula'
	 */
	
	public void populaModelos(String idFabricante){
		AutomoveisModel model = new AutomoveisModel();
		ArrayList<ModeloAutomovel> modelos = model.getModelos(idFabricante);
		comboModelo.removeAllItems();
		
		for(ModeloAutomovel modelo:modelos){
			comboModelo.addItem(modelo);
		}
	}
	
	public static Fabricante getFabricante(){
		return (Fabricante) comboFabricante.getSelectedItem();
	}
	
	
	public static ModeloAutomovel getModelo(){
		return (ModeloAutomovel) comboModelo.getSelectedItem();
	}
	
	
	public static void ZeraResult(){
		modelBuscaAutomoveis.setRowCount(0);
	}
	
	public static void insereLinhaResultAutomoveis(Automovel carro){
		modelBuscaAutomoveis.addRow(new String[]{carro.getCod(), carro.getFabricante().toString(),carro.getModelo().toString(), carro.getAno(),carro.getTaxa(),carro.getValorKm(),carro.getKm(),carro.getDisponibilidade()});
	}
	
	
	public static Automovel getSelectedAutomovel(){
		Automovel auto	= new Automovel();
		int linha		= tableResultAuto.getSelectedRow();
		if(linha == -1){
			JOptionPane.showMessageDialog(null, "Voce precisa selecionar um automovel");
		} else {
			auto.setCod( (String) modelBuscaAutomoveis.getValueAt(linha, 0) );
			auto.setDisponibilidade( (String) modelBuscaAutomoveis.getValueAt(linha,7));
			auto.setKm( (String) modelBuscaAutomoveis.getValueAt(linha, 6));
		}
		return auto;
	}
	
	public static Cliente getCliente(){
		return FormNovaLocacao.cliente;
	}
	
	
}
