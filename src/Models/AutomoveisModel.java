package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Carro;
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
	
	
	
	public ArrayList<Carro> getAutomoveis(){
		
		ArrayList<Carro> carros = new ArrayList<Carro>();
		
		try{
			stm = Model.getConection().createStatement();
			rs	= stm.executeQuery("SELECT automoveis.*, fabricante_automoveis.nome AS fabricante, modelo_automoveis.nome AS modelo FROM automoveis INNER JOIN fabricante_automoveis ON (automoveis.id_fabricante = fabricante_automoveis.id) INNER JOIN modelo_automoveis ON ( automoveis.id_modelo = modelo_automoveis.id)");
			
			while (rs.next()){
				Carro carro = new Carro();
				
				carro.setCod(rs.getString("id"));
				carro.setPlaca(rs.getString("placa"));
				carro.setAno(rs.getString("ano"));
				
				carro.setNomeFabricante(rs.getString("fabricante"));
				carro.setCodFabricante(rs.getString("id_fabricante"));
				carro.setNomeModelo(rs.getString("modelo"));
				carro.setCodModelo(rs.getString("id_modelo"));
				carro.setKm(Integer.parseInt(rs.getString("km")));
				carro.setValorKm(Double.parseDouble(rs.getString("valor_km")));
				carro.setDisponibilidade(rs.getString("disponibilidade"));
				carro.setTaxa(Double.parseDouble(rs.getString("taxa")));
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
