package br.com.aurelio.banco;

import br.com.aurelio.banco.contas.Cliente;
import br.com.aurelio.banco.contas.ContaInterface;
import br.com.aurelio.banco.contas.ContaPoupanca;
import br.com.aurelio.banco.contas.PessoaFisica;
import br.com.aurelio.banco.contas.ValorInvalidoException;

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
