package br.com.aumoraes.empresa.teste;

import br.com.aumoraes.empresa.Empresa;
import br.com.aumoraes.empresa.Gerente;

public class TestePerformance {

	public static void main(String[] args) {
		int quantidadeDeFuncionarios = 100000;
		
		Empresa empresa = new Empresa();
		
		for( int i = 0 ; i < quantidadeDeFuncionarios; i++ ){
			Gerente f = new Gerente("joao" + i);
			//f.setSalario( 1000 + i * 100 );
			f.setRg("a"+i);
			empresa.adiciona(f);
			//funcionarios.add(f);
		}
		long inicio = System.currentTimeMillis();
		empresa.mostraEmpregados();
		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto: " + tempo);
	}

}
