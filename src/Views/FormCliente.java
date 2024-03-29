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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Entidades.Cliente;
import Entidades.Locacao;
import Models.ClienteModel;
import Models.LocacoesModel;

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
	
		BorderLayout border = new BorderLayout();
		
		JPanel mainPanel	= new JPanel(new BorderLayout());
		
		JPanel panelTopo	= new JPanel(new BorderLayout());
		JPanel panelBotoes	= new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btnAlugar = new JButton("Alugar um veiculo");
		btnAlugar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				ClienteModel model = new ClienteModel();
				if(model.possuiPendencia(cliente.cod) == 1){
					JOptionPane.showMessageDialog(null, "Este cliente ja possui um automovel alugado, nao e possivel alugar um novo automovel");
				} else {
					new FormNovaLocacao(cliente);
				}
			}
			
		});
		
		panelBotoes.add(btnAlugar);
		panelBotoes.setBackground(new Color(255,255,255));
		
		JLabel labelTitulo	= new JLabel("Cliente");
		labelTitulo.setIcon(new ImageIcon( getClass().getResource("/resources/icons/user_add_32.png")));
		labelTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		
		panelTopo.setBackground(new Color(255,255,255));
		panelTopo.add(labelTitulo,BorderLayout.WEST);
		panelTopo.add(panelBotoes,BorderLayout.EAST);
		
		
		JPanel	formPanel		=	new JPanel(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		
		//NOME
		cons.gridx  = 0;
		cons.gridy  = 0;
		cons.insets = new Insets(5,5,5,5);
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Nome: "),cons);
		
		cons.gridx = 1;
		JTextField txtNome = new JTextField(15);
		txtNome.setText(cliente.nome);
		formPanel.add(txtNome);
		
		
		
		//EMAIL
		cons.gridx = 3;
		cons.anchor = GridBagConstraints.EAST;
		formPanel.add(new JLabel("Email: "),cons);
		
		cons.gridx = 4;
		JTextField txtEmail = new JTextField(15);
		txtEmail.setText(cliente.email);
		formPanel.add(txtEmail,cons);
		
		//CPF
		cons.gridy = 1;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("CPF: "),cons);
		
		cons.gridx = 1;
		JTextField txtCPF = new JTextField(15);
		txtCPF.setText(cliente.cpf);
		formPanel.add(txtCPF, cons);
		
		
		//CEP
		cons.gridx  = 3;
		cons.anchor = GridBagConstraints.EAST;
		formPanel.add(new JLabel("CEP: "),cons);
		
		cons.gridx = 4;
		JTextField txtCEP = new JTextField(15);
		txtCEP.setText(cliente.cep);
		formPanel.add(txtCEP,cons);
		
		cons.gridx = 5;
		JButton btn = new JButton();
		btn.setIcon( new ImageIcon( getClass().getResource("/resources/icons/find_16.png")));		
		formPanel.add(btn,cons);		
		
		
		//LOGRADOURO
		cons.gridy = 2;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Logradouro: "),cons);
		
		cons.gridx = 1;
		JTextField txtLogradouro = new JTextField(15);
		txtLogradouro.setText(cliente.logradouro);
		formPanel.add(txtLogradouro,cons);
		
		
		//BAIRRO
		cons.gridx = 3;
		cons.anchor = GridBagConstraints.EAST;
		formPanel.add(new JLabel("Bairro: "),cons);
		
		cons.gridx = 4;
		JTextField txtBairro = new JTextField(15);
		txtBairro.setText(cliente.bairro);
		formPanel.add(txtBairro,cons);
		
		
		//CIDADE
		cons.gridy = 3;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Cidade: "),cons);
		
		JTextField txtCidade = new JTextField(15);
		txtCidade.setText(cliente.cidade);
		cons.gridx = 1;
		formPanel.add(txtCidade,cons);
		
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
		
		//TELEFONE
		cons.gridy = 4;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Telefone: "),cons);
		
		cons.gridx = 1;
		JTextField txtTelefone = new JTextField(15);
		txtTelefone.setText(cliente.telefone);
		formPanel.add(txtTelefone,cons);
		
		
		//CELULAR
		cons.gridx = 3;
		formPanel.add(new JLabel("Celular: "),cons);
		
		cons.gridx = 4;
		JTextField txtCelular = new JTextField(15);
		txtCelular.setText(cliente.celular);
		formPanel.add(txtCelular,cons);
		
		
		//TELEFONE RECADO
		cons.gridy = 5;
		cons.gridx = 0;
		cons.anchor = GridBagConstraints.WEST;
		formPanel.add(new JLabel("Telefone Recado:"),cons);
		
		cons.gridx = 1;
		JTextField txtTelRecado = new JTextField(15);
		txtTelRecado.setText(cliente.telRecado);
		formPanel.add(txtTelRecado,cons);
		
		
		//Painel de abas
        JTabbedPane tabbedPane = new JTabbedPane();
        
        
        //Aba Carro Alugado -----------------------------------------------------------------
        JPanel panelCarroAlugado		= new JPanel(new GridBagLayout());
        GridBagConstraints consCarro	= new GridBagConstraints();
        
        ClienteModel model = new ClienteModel();
        
        if(model.possuiPendencia(cliente.cod) == 1){
        LocacoesModel modelLocacao		= new LocacoesModel();
        Locacao locacaoAtual = modelLocacao.getLocacaoCliente(cliente);
        
        consCarro.gridx = 0;
        consCarro.gridy = 0;
        panelCarroAlugado.add(new JLabel("Data da locacao: "+locacaoAtual.getDataLocacao()),consCarro);
        consCarro.gridy = 1;
        panelCarroAlugado.add(new JLabel("Automovel Alugado: " + locacaoAtual.getAutomovel().getModelo()),consCarro);
        consCarro.gridy = 2;
        panelCarroAlugado.add(new JLabel("Kilometragem na data da locacao: " + locacaoAtual.getKmInicial()),consCarro);
        }
        
        tabbedPane.add(panelCarroAlugado, "Carro locado por este cliente" );
        //------------------------------------------------------------------------------------
        
        tabbedPane.add(new JPanel(), "Histórico de locação");  
        tabbedPane.add(new JPanel(), "Anotações Gerais"); 
        tabbedPane.setPreferredSize(new Dimension(0,250));
        
        
        mainPanel.add(tabbedPane,BorderLayout.SOUTH);
		
		mainPanel.add(panelTopo,BorderLayout.NORTH);
		mainPanel.add(formPanel,BorderLayout.WEST);
		
		add(mainPanel);
		
	}
	
}
