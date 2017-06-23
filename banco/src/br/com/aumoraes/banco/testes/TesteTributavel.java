/**
 * 
 */
package br.com.aumoraes.banco.testes;

import br.com.aumoraes.banco.contas.Cliente;
import br.com.aumoraes.banco.contas.ContaCorrente;
import br.com.aumoraes.banco.contas.ContaTributavel;
import br.com.aumoraes.banco.contas.PessoaFisica;
import br.com.aumoraes.banco.contas.Tributavel;
import br.com.aumoraes.banco.contas.ValorInvalidoException;

/**
 * @author aumoraes
 *
 */
public class TesteTributavel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Cliente c2 = new PessoaFisica("11246488876", "maria da silva cesario", "960294667");
		ContaTributavel cc = new ContaCorrente(1, c2, 0);
		
		try {
			cc.deposita(100);
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
		System.out.println(cc.calculaTributos());
		// testando polimorfismo:
		Tributavel t = cc;
		System.out.println(t.calculaTributos());

	}

}
