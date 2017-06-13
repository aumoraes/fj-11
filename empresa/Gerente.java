package br.com.aurelio.empresa;

public class Gerente extends Funcionario{
	
	
	public Gerente() {}
	
	public Gerente(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void setBonificacao(double aumento) {
		this.bonificacao  = this.salario * 1.4 + 1000;
	}


}
