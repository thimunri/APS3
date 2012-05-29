package Entidades;

public class Automovel {

	private String km,portas, valorKm, taxa, cod,placa, ano, cor, vidro, direcao, ar, disponibilidade, observacoes, img;
	private Fabricante fabricante;
	private ModeloAutomovel modelo;
		
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
	
	public void setKm(String km){
		this.km = km;
	}
	
	public String getKm(){
		return this.km;
	}
	
	public void setTaxa(String taxa){
		this.taxa = taxa;
	}
	
	public String getTaxa(){
		return this.taxa;
	}
	
	public void setFabricante(Fabricante f){
		fabricante = f;
	}
	
	public Fabricante getFabricante(){
		return fabricante;
	}
	
	public void setModelo(ModeloAutomovel mod){
		this.modelo = mod;
	}
	
	public ModeloAutomovel getModelo(){
		return this.modelo;
	}
	
	
	public void setCor(String cor){
		this.cor = cor;
	}
	
	
	public String getCor(){
		return this.cor;
	}
	
	
	
	public void setPortas(String portas){
		this.portas = portas;
	}
	
	public String getPortas(){
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
	
	public String getDisponibilidade(){
		return this.disponibilidade;
	}
	
	
	public void setObservacoes(String obs){
		this.observacoes = obs;
	}
	
	
	public void setValorKm(String valor){
		this.valorKm = valor;
	}
	
	public String getValorKm(){
		return this.valorKm;
	}
	
	
	public String toString(){
		return this.placa;
	}
	
}
