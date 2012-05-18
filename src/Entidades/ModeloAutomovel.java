package Entidades;

public class ModeloAutomovel {

	public String id;
	public String nome;
	
	public ModeloAutomovel(String id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public ModeloAutomovel(){
		
	}
	
	public String toString(){
		return nome;
	}
}
