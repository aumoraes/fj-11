package br.com.aurelio.banco.contas;

import java.util.ArrayList;
import java.util.List;

public class Banco{
	List<ContaInterface> contasInterface = new ArrayList<ContaInterface>();
	
	public void adiciona(ContaInterface c){
		contasInterface.add(c);
	}	
	
	public ContaInterface pegaConta(int x){
		return contasInterface.get(x);
	}
	
	public int pegaTotalDeContas(){
		return contasInterface.size();
	}
}