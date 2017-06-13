package br.com.aurelio.empresa;

import java.util.HashMap;
import java.util.Map;

public class Empresa {
	Map<String, Funcionario> empregado = new HashMap<String, Funcionario>();
	String cnpj;
	String nome;


	public void adiciona(Funcionario f){
		this.empregado.put(f.getNome(), f);
	}
	
	public int qtdFuncionarios(){
		return	this.empregado.size();
	}
	public Funcionario getFuncionario (int index) {
		//return this.empregado.get(index);
		return  null;
	}
	
	public void mostraEmpregados(){
		
		for (Map.Entry<String, Funcionario> entry : empregado.entrySet())
		{
		    System.out.println( entry.getValue().toString() );
		}
		
	}
	
	@Override
	public String toString() {
		return "Empresa [empregado=" + empregado + ", cnpj=" + cnpj + ", nome=" + nome + "]";
	}

	public boolean contem(String nome){
		return empregado.containsKey( nome );
	}
}
