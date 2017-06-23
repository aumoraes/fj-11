package br.com.aumoraes.banco.testes;

import br.com.aumoraes.banco.contas.Cliente;
import br.com.aumoraes.banco.contas.ContaInterface;
import br.com.aumoraes.banco.contas.ContaPoupanca;
import br.com.aumoraes.banco.contas.PessoaFisica;
import br.com.aumoraes.banco.contas.ValorInvalidoException;

public class TestaDeposita {

	public static void main(String[] args) {
		Cliente c2 = new PessoaFisica("11246488876", "maria da silva cesario", "960294667");
		ContaInterface cp = new ContaPoupanca(1, c2, 500);
		try {
			cp.deposita(-100);
		} catch (ValorInvalidoException e) {
			System.out.println(e);
		}
		

	}

}
