/**
 * 
 */
package br.com.aurelio.banco;

import br.com.aurelio.banco.contas.Cliente;
import br.com.aurelio.banco.contas.ContaCorrente;
import br.com.aurelio.banco.contas.ContaTributavel;
import br.com.aurelio.banco.contas.PessoaFisica;
import br.com.aurelio.banco.contas.Tributavel;
import br.com.aurelio.banco.contas.ValorInvalidoException;

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
