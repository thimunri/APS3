package Models;

import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Automovel;
import Entidades.Cliente;
import Entidades.Locacao;

public class LocacoesModel extends Model {

	Statement stm;
	ResultSet rs;

	public LocacoesModel(){
		super();
	}
	
	
	public void salva(Locacao loc){
		Locacao 	locacao = loc;
		Cliente 	cliente	= locacao.getCliente();
		Automovel	auto	= locacao.getAutomovel();

		
	}
	
	
}
