package br.com.aumoraes.banco.testes;

import br.com.aumoraes.banco.contas.Cliente;
import br.com.aumoraes.banco.contas.ContaCorrente;
import br.com.aumoraes.banco.contas.ContaInterface;
import br.com.aumoraes.banco.contas.ContaPoupanca;
import br.com.aumoraes.banco.contas.PessoaFisica;
import br.com.aumoraes.banco.contas.ValorInvalidoException;

public class TestaContas {
	public static void main(String[] args) {
		
		Cliente c1 = new PessoaFisica("11246488876", "maria da silva cesario", "960294667");
		ContaInterface cc = new ContaCorrente(1, c1, 500);
		
		Cliente c2 = new PessoaFisica("11246488876", "maria da silva cesario", "960294667");
		ContaInterface cp = new ContaPoupanca(1, c2, 500);
		
		
		try {
			cc.deposita(1000);
			cp.deposita(1000);
		} catch (ValorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cc.atualiza(0.01);
		cp.atualiza(0.01);
		
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
		//cp.saca(500);
	}
}