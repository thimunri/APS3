package Entidades;

import java.sql.Date;

public class Locacao {

	private Automovel automovel;
	private Cliente cliente;
	private String status, valor, kmAtual, kmRodada;
	private Date dataDevolucao, dataLocacao;
	
	
	public void setAutomovel(Automovel automovel){
		this.automovel = automovel;
	}
	
	public Automovel getAutomovel(){
		return this.automovel;
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public Cliente getCliente(){
		return this.cliente;
	}
	
	public void setDataLocacao(Date data){
		this.dataLocacao = data;
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
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setValor(String valor){
		this.valor = valor;
	}
	
	public String getValor(){
		return this.valor;
	}
}
