package br.com.aumoraes.empresa.teste;

import br.com.aumoraes.empresa.Data;
import br.com.aumoraes.empresa.Gerente;

public class TesteFuncionario {
	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		Data dataEntrada = new Data();
		dataEntrada.dia = 20;
		dataEntrada.mes = 11;
		dataEntrada.ano = 2015;
		g1.setNome("Hugo");
		g1.setSalario(100);
		g1.setDataEntrada(dataEntrada);
		g1.setBonificacao(50);
		System.out.println( g1.toString() );
	}
}
