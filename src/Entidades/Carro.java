package Entidades;

public class Carro {

	private String cod,placa, ano, codModelo, nomeModelo, codFabricante, nomeFabricante, cor, vidro, direcao, ar, disponibilidade, observacoes, img;
	private int km,portas;
	double valorKm, taxa;
	
		
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
	
	
	
	public void setNomeModelo(String modelo){
		this.nomeModelo = modelo;
	}
	
	public String getNomeModelo(){
		return  this.nomeModelo;
	}
	
	
	public void setCodModelo(String cod){
		this.codModelo = cod;
	}
	
	public String getCodModel(String cod){
		return this.codModelo;
	}
	
	public void setNomeFabricante(String fabricante){
		this.nomeFabricante = fabricante;
	}
	
	public String getNomeFabricante(){
		return this.nomeFabricante;
	}
	
	public void setCodFabricante(String cod){
		this.codFabricante = cod;
	}
	
	public String getCodFabricante(){
		return this.codFabricante;
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
