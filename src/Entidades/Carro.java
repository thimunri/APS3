package Entidades;

public class Carro {

	private String cod,placa, ano, modelo, fabricante, cor, vidro, direcao, ar, disponibilidade, observacoes, img;
	private int km,portas;
	double valorKm, taxa;
	
	public Carro(){
		
	}
	
	public Carro(String pl, String an , String mod, String fab){
		placa		=	pl;
		ano			=	an;
		modelo		=	mod;
		fabricante	=	fab;
	}
	
	public void setCod(String cod){
		this.cod = cod;
	}
	
	public String getCod(){
		return this.cod;
	}
	
	public void setPlaca(String placa){
		this.placa = placa;
	}
	
	public String getPlaca(){
		return this.placa;
	}
	
	
	
	public void setAno(String ano){
		this.ano = ano;
	}
	
	public String getAno(){
		return this.ano;
	}
	
	
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	public String getModelo(){
		return  this.modelo;
	}
	
	
	
	public void setFabricante(String fabricante){
		this.fabricante = fabricante;
	}
	
	public String getFabricante(){
		return this.fabricante;
	}
	
	
	
	public void setCor(String cor){
		this.cor = cor;
	}
	
	
	public String getCor(){
		return this.cor;
	}
	
	
	
	public void setPortas(int portas){
		this.portas = portas;
	}
	
	public int getPortas(){
		return this.portas;
	}
	
	
	
	public void setVidros(String vidros){
		this.vidro = vidros;
	}
	
	public void setDirecao(String direcao){
		this.direcao = direcao;
	}
	
	public void setDisponibilidade(String disp){
		this.disponibilidade = disp;
	}
	
	
	
	public void setObservacoes(String obs){
		this.observacoes = obs;
	}
	
	
	
	public void setKm(int km){
		this.km = km;
	}
	
	public int getKm(){
		return this.km;
	}
	
	
	
	public void setValorKm(double valor){
		this.valorKm = valor;
	}
	
	public double getValorKm(){
		return this.valorKm;
	}
	
	
	
	public void setTaxa(double taxa){
		this.taxa = taxa;
	}
	
	public double getTaxa(){
		return this.taxa;
	}
	
	
	
}
