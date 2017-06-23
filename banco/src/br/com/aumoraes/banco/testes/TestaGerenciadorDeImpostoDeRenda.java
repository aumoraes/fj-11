package br.com.aumoraes.banco.testes;

import br.com.aumoraes.banco.contas.Cliente;
import br.com.aumoraes.banco.contas.ContaCorrente;
import br.com.aumoraes.banco.contas.ContaTributavel;
import br.com.aumoraes.banco.contas.PessoaFisica;
import br.com.aumoraes.banco.contas.SeguroDeVida;
import br.com.aumoraes.banco.contas.ValorInvalidoException;
import br.com.aumoraes.banco.sistema.GerenciadorDeImpostoDeRenda;

public class TestaGerenciadorDeImpostoDeRenda {

	public static void main(String[] args) {
		
		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
		
		SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adiciona(sv);
		
		
		Cliente c1 = new PessoaFisica("40636490831", "aurelio de moraes", "29925618");
		ContaTributavel cc = new ContaCorrente(0, c1, 0);
		try {
			cc.deposita(1000);
		} catch (ValorInvalidoException e) {
			e.printStackTrace();
		}
		gerenciador.adiciona(cc);
		System.out.println(gerenciador.getTotal());
		System.out.printf( "O saldo é: %.2f", gerenciador.getTotal() );
		
	}
}