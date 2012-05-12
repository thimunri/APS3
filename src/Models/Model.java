package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Model {

	private static Connection conn;
	private static Statement stm;
	
	public Model(){
		initConnection();
	}
	
	public static Connection getConection(){
		return Model.conn;
	}
	
	
	public static Statement getStatement(){
		return stm;
	}
	
	
	public void initConnection(){
		
		try{
			//Tenta carregar o driver para o banco de dados
			Class.forName("org.hsqldb.jdbcDriver");
			
			String path_db = System.getProperty("user.dir") + "/DB/db_aps";
			
			//Inicia conexao
			conn = DriverManager.getConnection("jdbc:hsqldb:file:"+path_db, "SA", "");
		}
		
		catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		} 
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
}
