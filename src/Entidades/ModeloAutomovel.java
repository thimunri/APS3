package Entidades;

public class ModeloAutomovel {

	public String id;
	public String nome;
	
	public ModeloAutomovel(String id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	
	public ModeloAutomovel(){
		
	}
	
	public String toString(){
		return nome;
	}
}
