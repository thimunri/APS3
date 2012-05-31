package Models;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entidades.Automovel;
import Entidades.Cliente;
import Entidades.Fabricante;
import Entidades.Locacao;
import Entidades.ModeloAutomovel;

public class LocacoesModel extends Model {

	Statement stm;
	ResultSet rs;

	public LocacoesModel(){
		super();
	}
	
	
	
	public void salva(Locacao loc){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Locacao 	locacao = loc;
		Cliente 	cliente	= locacao.getCliente();
		Automovel	auto	= locacao.getAutomovel();
		
		try{
			stm = Model.getConection().createStatement();
			stm.executeQuery("INSERT INTO locacoes (id_cliente,id_automovel,data_locacao,km_inicial) " +
							 "VALUES ('"+cliente.cod+"','"+auto.getCod()+"','"+dateFormat.format(locacao.getDataLocacao())+"','"+auto.getKm()+"')");
			
			stm.executeQuery("UPDATE automoveis SET disponibilidade = 'Nao' WHERE id = '"+auto.getCod()+"'");
			stm.execute("SHUTDOWN");
			
		}
		
		catch(SQLException e){
			System.out.println(e.getMessage());
		}

		
	}
	
	
	
	public Locacao getLocacaoCliente(Cliente cliente){
		Locacao 	locacao = new Locacao();
		Automovel	auto	= new Automovel();
		
		try{
			stm	= Model.getConection().createStatement();
			rs	= stm.executeQuery( "SELECT locacoes.km_inicial, locacoes.data_locacao,modelo.id AS id_modelo, modelo.nome AS modelo, fabricante.nome AS fabricante, fabricante.id AS id_fabricante FROM locacoes " + 
									"LEFT JOIN automoveis ON (locacoes.id_automovel = automoveis.id) " +
									"LEFT JOIN modelo_automoveis AS modelo ON (modelo.id = automoveis.id_modelo) " +
									"LEFT JOIN fabricante_automoveis AS fabricante ON (fabricante.id = automoveis.id_fabricante)" + 
									"WHERE id_cliente = '"+cliente.cod+"' ");
			rs.next();
			
			auto.setModelo(new ModeloAutomovel(rs.getString("id_modelo"), rs.getString("modelo")));
			auto.setFabricante(new Fabricante(rs.getString("id_fabricante"), rs.getString("fabricante")));
			
			locacao.setDataLocacao(rs.getDate("data_locacao"));
			locacao.setAutomovel(auto);
			locacao.setKmInicial(rs.getString("km_inicial"));
		}
		catch(SQLException e){
			
		}
		
		return locacao;
	}
	
	
}
