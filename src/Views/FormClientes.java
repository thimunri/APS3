package Views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import Entidades.Cliente;
import Listeners.*;
import Models.ClienteModel;

public class FormClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static JPanel mainPanel, menuPanel;
	private static JButton btnNovoCliente, btnDelCliente, btnEditCliente;
	private static JTable table;
	public static DefaultTableClientes modelClientes;
	
	
	public FormClientes(){
			super("Clientes");
			this.setVisible(true);
			this.setSize(800, 600);			
			inicializaComponentes();
	}
	
	public static DefaultTableClientes getModel(){
		return modelClientes;
	}
	
	
	private void inicializaComponentes(){
		
		mainPanel	=	new JPanel( new BorderLayout());
		menuPanel	=	new JPanel( new FlowLayout( FlowLayout.LEFT));
		
		btnNovoCliente	= new JButton("Novo Cliente");
		btnDelCliente	= new JButton("Remover Cliente");
		btnEditCliente	= new JButton("Editar/Visualizar Ciente");
		
		
		btnNovoCliente.addActionListener(new NovoClienteListener());
		btnDelCliente.addActionListener(new DeletaClienteListener());
		btnEditCliente.addActionListener(new ExibeClienteListener());
		
		menuPanel.add(btnNovoCliente);
		menuPanel.add(btnDelCliente);
		menuPanel.add(btnEditCliente);
		
		modelClientes	= new DefaultTableClientes();
		populaTabela();
		
		table  			= new JTable( modelClientes );
		
		JScrollPane scroll = new JScrollPane( table );
		
		mainPanel.add(menuPanel, BorderLayout.NORTH);
		mainPanel.add(scroll, BorderLayout.CENTER);
		
		this.getContentPane().add(mainPanel);
	}
	
	
	
	private void populaTabela(){

		//Obtem os cliente cadastrados no banco de dados
		ClienteModel model_cliente = new ClienteModel();
		
		//Monta um array de objetos do tipo Cliente
		ArrayList<Cliente> clientes = model_cliente.getClientes();
		
		for(Cliente cliente:clientes){
			//Adiciona Clientes na tabela do formulario
			modelClientes.addRow(new String[]{cliente.cod, cliente.nome, cliente.email, cliente.cpf, cliente.telefone, cliente.celular, cliente.telRecado, cliente.logradouro, cliente.bairro, cliente.cidade, cliente.uf, cliente.cep});
		}
		
	}
	
	
	public static void removeLinha(int linha){
		modelClientes.removeRow(linha);
	}
	
	
	public static int getLinhaSelecionada(){
		return table.getSelectedRow();
	}
	
	public static Cliente getSelectedCliente(){
		Cliente c = new Cliente();
		
		int linha = table.getSelectedRow();
		
		c.nome 			= (String) modelClientes.getValueAt(linha, 1);
		c.email			= (String) modelClientes.getValueAt(linha, 2);
		c.cpf			= (String) modelClientes.getValueAt(linha, 3);
		c.telefone		= (String) modelClientes.getValueAt(linha, 4);
		c.celular		= (String) modelClientes.getValueAt(linha, 5);
		c.telRecado		= (String) modelClientes.getValueAt(linha, 6);
		c.logradouro	= (String) modelClientes.getValueAt(linha, 7);
		c.bairro		= (String) modelClientes.getValueAt(linha, 8);
		c.cidade		= (String) modelClientes.getValueAt(linha, 9);
		c.uf			= (String) modelClientes.getValueAt(linha, 10);
		c.cep			= (String) modelClientes.getValueAt(linha, 11);
		
		return c;
	}
	
	
	public static String getCod(int linha){
		return (String) modelClientes.getValueAt(linha, 0);
	}
	
	
	public static String getCPF(int linha){
		String cpf = (String) modelClientes.getValueAt(linha, 3);
		return cpf;
	}
	
	
	public static String getNome(int linha){
		return (String) modelClientes.getValueAt(linha, 1);
	}
	
	
}
