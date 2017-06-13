package br.com.aurelio.banco.sistema;

import br.com.aurelio.banco.contas.Tributavel;

public class GerenciadorDeImpostoDeRenda {
	
	private double total;
	
	public void adiciona(Tributavel t) {
		System.out.println("Adicionando tributavel: " + t);
		this.total += t.calculaTributos();
	}
	
	public double getTotal() {
		return this.total;
	}
}
