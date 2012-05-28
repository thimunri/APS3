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

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Entidades.Cliente;

public class FormNovaLocacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	
	private JTextField cpf,nome,email,logradouro, bairro, cidade, uf, cep;

	public FormNovaLocacao(){
		super("Fiction");
		this.setSize(800,600);
		inicializaComponentes();
		this.setVisible(true);
	}
	
	
	
	public FormNovaLocacao(Cliente c){
		
		super("Fiction");
		cliente = c;
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
		panelCarro.setBorder(new TitledBorder("Detalhes Automovel"));
		
		GridBagConstraints consCarro = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		
		panelCarro.add(new JLabel("Placa: "),consCarro);
		
		consCarro.gridx = 1;
		consCarro.insets = new Insets(5,5,5,5);
		panelCarro.add(new JTextField(10),consCarro);
		
		
		consCarro.gridx = 2;
		JButton btnAuto = new JButton("");
		btnAuto.setIcon( new ImageIcon( getClass().getResource("/resources/icons/find_16.png")));
		btnAuto.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new FormBuscaAutomovel();
			}
			
		});
		
		panelCarro.add(btnAuto,consCarro);
		
		consCarro.gridy = 1;
		consCarro.gridx = 0;
		panelCarro.add(new JLabel("Fabricante: "),consCarro);
		
		consCarro.gridx = 1;
		panelCarro.add(new JTextField(10),consCarro);
		
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
		panelCarro.add(new JTextField(15),consCarro);
		
		
		
		//Add o sub de carros
		consFormPanel.gridy = 2;
		formPanel.add(panelCarro,consFormPanel);
		
		
		
		
		mainPanel.add(formPanel,BorderLayout.CENTER);
		mainPanel.add(topoPanel,BorderLayout.NORTH);
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
	
	
}
