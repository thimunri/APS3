package Entidades;

import java.sql.Date;
import java.text.SimpleDateFormat;

import Entidades.Cliente;
import Entidades.Automovel;

public class Aluguel {
	
	private Cliente cliente;
	private Automovel automovel;
	
	private Date dataLocacao;
	private Date dataDevolucao;

	
	public Aluguel(){
		this.dataLocacao = new Date(System.currentTimeMillis());
	}
	
	public Aluguel(Cliente cliente){
		super();
		this.cliente = cliente;
	}
	
	public Aluguel(Automovel automovel){
		super();
		this.automovel = automovel;
	}
	
	public void setCliente(Cliente c){
		this.cliente = c;
	}
	
	public Cliente getCliente(){
		return this.cliente;
	}
	
	public void setAutomovel(Automovel auto){
		this.automovel = auto;
	}
	
	public Automovel getAutomovel(){
		return this.automovel;
	}
	
	public Date getDataLocacao(){
		return this.dataLocacao;
	}

	public void setDataDevolucao(Date data){
		this.dataDevolucao = data;
	}
	
	public Date getDataDevolucao(){
		return this.dataDevolucao;
	}
	
}
