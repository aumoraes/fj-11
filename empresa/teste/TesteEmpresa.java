package br.com.aurelio.empresa.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.aurelio.empresa.Empresa;
import br.com.aurelio.empresa.Funcionario;
import br.com.aurelio.empresa.Gerente;

public class TesteEmpresa {
	

	public static void main(String[] args) {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		Empresa empresa = new Empresa();
		int quantidadeDeFuncionarios = 3;
		
		for( int i = 0 ; i < quantidadeDeFuncionarios; i++ ){
			Gerente f = new Gerente("joao" + i);
			f.setSalario( 1000 + i * 100 );	
			empresa.adiciona(f);
			funcionarios.add(f);
		}
			
		Collections.sort(funcionarios);
		

		empresa.mostraEmpregados();		
		
		System.out.println("Total de funcionario criados: " + Funcionario.getIdentificador() );
		
		System.out.println("funcionarios ordenados por nome");
		
		for( int i = 0 ; i < funcionarios.size(); i++ ){
			System.out.println( funcionarios.get(i).toString() );
		}
		
		Funcionario novoFunc = new Gerente();
		novoFunc.setNome("joao1");
		//System.out.println(empresa.contem( novoFunc.getNome() ));
		//System.out.println(empresa.contem(novoFunc));
	}
}
