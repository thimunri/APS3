package Models;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Cliente;
import Entidades.Locacao;

public class LocacoesModel extends Model {

	Statement stm;
	ResultSet rs;
	
	private Locacao locacao;
	private Cliente cliente;
	
	public LocacoesModel(){
		super();
	}
	
	public Locacao getLocacao(){
		locacao = new Locacao();
		return locacao;
	}
	
	
}
