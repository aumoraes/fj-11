package br.com.aumoraes.banco.sistema;

import br.com.aumoraes.banco.contas.Tributavel;

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
