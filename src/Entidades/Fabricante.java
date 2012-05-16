package Entidades;

public class Fabricante {

	private String id;
	private String nome;
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	
	public String toString(){
		return this.nome;
	}
	
	
}
