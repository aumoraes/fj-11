package br.com.aumoraes.banco.contas;

public class ContaInvestimento implements ContaInterface{
	private int id;
	private Cliente cliente;
	private double saldo;
	private String tipoDeConta = "Conta Investimento";

	public ContaInvestimento(int id, Cliente cliente, double saldo ){
		this.id = id;
		this.cliente = cliente;
		this.saldo = saldo;	
	}
	
	public int getId(){
		return this.id;		
	}
	
	@Override
	public void saca(double valor) throws ValorInvalidoException{
		if(valor < 0){
			throw new IllegalArgumentException("Você não pode tentar sacar um valor negativo na sua conta investimento. Valor: " + valor);
		}
		this.saldo -= valor;		
	}

	@Override
	public void deposita(double valor) throws ValorInvalidoException {}

	@Override
	public String getNomeDonoConta() {
		return this.cliente.getNome();
	}

	@Override
	public double getSaldo() {
		return this.saldo;
	}

	@Override
	public void transfere(ContaInterface conta, double valor) throws ValorInvalidoException {}

	@Override
	public String TipoConta() {
		return this.tipoDeConta;
	}

	@Override
	public void atualiza(double taxaSelic) {
		this.saldo += this.saldo * taxaSelic;	
	}
}
