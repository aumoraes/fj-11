package br.com.aumoraes.banco.testes;

import br.com.aumoraes.banco.contas.Banco;
import br.com.aumoraes.banco.contas.Cliente;
import br.com.aumoraes.banco.contas.ContaCorrente;
import br.com.aumoraes.banco.contas.ContaInterface;
import br.com.aumoraes.banco.contas.ContaPoupanca;
import br.com.aumoraes.banco.contas.PessoaFisica;
import br.com.aumoraes.banco.sistema.AtualizadorDeContas;

public class TesteBanco {
	public static void main(String[] args) {
		
		Cliente c1 = new PessoaFisica("40636490831", "aurelio de moraes", "29925618");
		ContaInterface cc = new ContaCorrente(0, c1, 2000);
		
		Cliente c2 = new PessoaFisica("11246488876", "maria da silva cesario", "960294667");
		ContaInterface cp = new ContaPoupanca(1, c2, 2000);
		
		
		Banco banco = new Banco();
		
		banco.adiciona(cc);
		banco.adiciona(cp);
		
		AtualizadorDeContas adc = new AtualizadorDeContas(0.01);
		
		for(int i = 0; i < banco.pegaTotalDeContas(); i++){
			adc.roda(banco.pegaConta(i));
		}
		
		System.out.println("Saldo Total: " + adc.getSaldoTotal());
	}
}
