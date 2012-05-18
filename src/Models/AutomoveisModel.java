package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Automovel;
import Entidades.Fabricante;
import Entidades.ModeloAutomovel;

public class AutomoveisModel extends Model{

	Statement stm;
	ResultSet rs;
	
	public AutomoveisModel(){
		super();
	}
	
	
	
	public ArrayList<Fabricante> getFabricantes(){
		
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		
		try{
			stm = Model.getConection().createStatement();
			rs	= stm.executeQuery("SELECT * FROM fabricante_automoveis");
			while(rs.next()){
				Fabricante fabricante = new Fabricante();
				fabricante.setId( rs.getString("id") );
				fabricante.setNome( rs.getString("nome") );
				fabricantes.add(fabricante);
			}
			
		}
		catch(SQLException e){
			
		}
		return fabricantes;
	}
	
	
	
	
	public ArrayList<ModeloAutomovel> getModelos(String idFabricante){

		ArrayList<ModeloAutomovel> modelos = new ArrayList<ModeloAutomovel>();
		
		try{
			
			stm = Model.getConection().createStatement();
			rs	= stm.executeQuery("SELECT * FROM modelo_automoveis WHERE id_fabricante = " + idFabricante);

			while(rs.next()){
				ModeloAutomovel modelo = new ModeloAutomovel();
				
				modelo.id	=	rs.getString("id");
				modelo.nome	=	rs.getString("nome");
				
				modelos.add(modelo);
			}
			
		} 
		
		catch(SQLException e) {
			
		}

		return modelos;
		
		
	}
	
	
	public boolean salva(Automovel auto){

		try{
			String 				placa			= auto.getPlaca();
			String 				ano				= auto.getAno();
			String				idFabricante	= auto.getFabricante().getId();
			String				idModelo		= auto.getModelo().id;
			int					km				= Integer.parseInt(auto.getKm());
			double				valor_km		= Double.parseDouble(auto.getValorKm());
			double				taxa			= Double.parseDouble(auto.getTaxa());
			
			stm		= Model.getConection().createStatement();
			rs		= stm.executeQuery("INSERT INTO automoveis (placa,ano,id_fabricante,id_modelo,km,valor_km,disponibilidade,taxa) VALUES ('"+placa+"','"+ano+"','"+idFabricante+"','"+idModelo+"',"+km+","+valor_km+",'Sim',"+taxa+")");
			stm.execute("SHUTDOWN");
					
			return true;
			
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}
	
	
	
	public ArrayList<Automovel> getAutomoveis(){
		
		ArrayList<Automovel> carros = new ArrayList<Automovel>();
		
		try{
			stm = Model.getConection().createStatement();
			rs	= stm.executeQuery("SELECT automoveis.*, fabricante_automoveis.nome AS fabricante, modelo_automoveis.nome AS modelo FROM automoveis LEFT JOIN fabricante_automoveis ON (automoveis.id_fabricante = fabricante_automoveis.id) LEFT JOIN modelo_automoveis ON ( automoveis.id_modelo = modelo_automoveis.id)");
			
			while (rs.next()){
				Automovel carro = new Automovel();
				
				carro.setCod(rs.getString("id"));
				carro.setPlaca(rs.getString("placa"));
				carro.setAno(rs.getString("ano"));
				carro.setFabricante(new Fabricante(rs.getString("id_fabricante"), rs.getString("fabricante")));
				carro.setModelo(new ModeloAutomovel(rs.getString("id_modelo"), rs.getString("modelo")));
				carro.setKm(rs.getString("km"));
				carro.setValorKm(rs.getString("valor_km"));
				carro.setDisponibilidade(rs.getString("disponibilidade"));
				carro.setTaxa(rs.getString("taxa"));
				carro.setObservacoes(rs.getString("obs"));
				
				carros.add(carro);
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
		}
		
		return carros;
		
	}
	
}
