package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Entidades.Cliente;

public class FormCliente extends JFrame{

	private static final long serialVersionUID = 1L;
	private Cliente cliente;

	public FormCliente(Cliente c){
			
			super("Fiction Locadora de Veículos  - Visualizar / Editar Cliente");

			cliente = c;
			
			this.setSize(800,600);
			inicializaComponentes();
			this.setVisible(true);
			
	}
	
	
	
	private void inicializaComponentes(){
	
		JPanel mainPanel	= new JPanel(new BorderLayout());
		JPanel panelTopo	= new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel labelTitulo	= new JLabel("Cliente");
		
		labelTitulo.setIcon(new ImageIcon( getClass().getResource("/resources/icons/user_add_32.png")));
		labelTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		
		panelTopo.setBackground(new Color(255,255,255));
		panelTopo.add(labelTitulo);
		
		
		JPanel	formPanel		=	new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx  = 0;
		cons.gridy  = 0;
		cons.insets = new Insets(5,5,5,5);
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Nome: "),cons);
		
		
		cons.gridx = 1;
		JTextField txtNome = new JTextField(15);
		txtNome.setText(cliente.nome);
		formPanel.add(txtNome);
		
		cons.gridx = 3;
		cons.anchor = GridBagConstraints.EAST;
		formPanel.add(new JLabel("Email: "),cons);
		
		cons.gridx = 4;
		formPanel.add(new JTextField(15),cons);
		
		
		cons.gridy = 1;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("CPF: "),cons);
		
		cons.gridx = 1;
		formPanel.add(new JTextField(15), cons);
		
		cons.gridx  = 3;
		cons.anchor = GridBagConstraints.EAST;
		formPanel.add(new JLabel("CEP: "),cons);
		
		cons.gridx = 4;
		formPanel.add(new JTextField(15),cons);
		
		cons.gridx = 5;
		JButton btn = new JButton();
		btn.setIcon( new ImageIcon( getClass().getResource("/resources/icons/find_16.png")));		
		formPanel.add(btn,cons);		
		
		
		cons.gridy = 2;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Logradouro: "),cons);
		
		cons.gridx = 1;
		formPanel.add(new JTextField(15),cons);
		
		cons.gridx = 3;
		cons.anchor = GridBagConstraints.EAST;
		formPanel.add(new JLabel("Bairro: "),cons);
		
		cons.gridx = 4;
		formPanel.add(new JTextField(15),cons);
		
		cons.gridy = 3;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Cidade: "),cons);
		
		cons.gridx = 1;
		formPanel.add(new JTextField(15),cons);
		
		cons.gridx = 3;
		cons.anchor = GridBagConstraints.EAST;
		formPanel.add(new JLabel("Estado: "),cons);
		
		cons.gridx = 4;
		String[] ufs = new String[]{"Acre - AC","Alagoas - AL","Amapá - AP","Amazonas - AM","Bahia  - BA","Ceará - CE","Distrito Federal  - DF",
				"Espirito Santo - ES","Goias - GO","Maranhão - MA","Mato Grosso - MT","Mato Grosso do Sul - MS","Minas Gerais - MG","Pará - PA",
				"Paraíba - PB","Paraná - PR","Pernambuco - PE","Piauí - PI","Rio de Janeiro - RJ","Rio Grande do Norte - RN","Rio Grande do Sul - RS",
				"Rondônia - RO","Roraima - RR","Santa Catarina - SC","São Paulo - SP","Sergipe - SE","Tocantins - TO"};
		JComboBox comboEstado = new JComboBox(ufs);
		formPanel.add(comboEstado,cons);
		
		
		cons.gridy = 4;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Telefone: "),cons);
		
		cons.gridx = 1;
		formPanel.add(new JTextField(15),cons);
		
		cons.gridx = 3;
		formPanel.add(new JLabel("Celular: "),cons);
		
		cons.gridx = 4;
		JTextField txtCelular = new JTextField(15);
		txtCelular.setText(cliente.celular);
		formPanel.add(txtCelular,cons);
		
		cons.gridy = 5;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Telefone Recado:"),cons);
		
		cons.gridx = 1;
		formPanel.add(new JTextField(15),cons);
		
	      JTabbedPane pane = new JTabbedPane();  
	      pane.add(new JPanel(), "Carro locado por este cliente" );  
	      pane.add(new JPanel(), "Histórico de locação");  
	      pane.add(new JPanel(), "Anotações Gerais"); 
	      
	      mainPanel.add(pane,BorderLayout.SOUTH);
		
		
		mainPanel.add(panelTopo,BorderLayout.NORTH);
		mainPanel.add(formPanel,BorderLayout.WEST);
		add(mainPanel);
		
		
	}
	
}
