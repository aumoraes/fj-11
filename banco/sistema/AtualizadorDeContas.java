package br.com.aurelio.banco.sistema;

import br.com.aurelio.banco.contas.ContaInterface;

public class AtualizadorDeContas {

	private double saldoTotal = 0;
	private double selic;
	
	public AtualizadorDeContas(double selic) {
		this.selic = selic;
	}
	public void roda(ContaInterface contaInterface) {
		System.out.println("Saldo anterior: " + contaInterface.getSaldo());
		contaInterface.atualiza(selic);
		saldoTotal += contaInterface.getSaldo();
		System.out.println("Saldo final: " + contaInterface.getSaldo());
	}

	public double getSaldoTotal(){
		return this.saldoTotal;
	}
	

}
