package br.com.aurelio.empresa;

public class Data {
	public int dia;
	public int mes;
	public int ano;
	
	String formatadata(){
		return this.dia + "/" + this.mes + "/" + this.ano;
	}

}
