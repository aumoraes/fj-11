package br.com.aurelio.banco.contas;

public class ContaCorrente implements ContaTributavel{
	
	private int id;
	private Cliente cliente;
	private double saldo;
	private String tipoDeConta = "Conta Corrente";
	private double limite = 900.00;
	
	static String identificador = "cp";
	static int contador = 0;
	
	public ContaCorrente(int id, Cliente cliente, double saldo ){
		this.id = id;
		this.cliente = cliente;
		this.saldo = saldo;
		identificador = identificador + ++contador; 
	}
	
	public int getId(){
		return this.id;
	}
	public static String getIdentificador(){
		return identificador;
	}
	
	@Override
	public void saca(double valor) throws ValorInvalidoException{
		if(valor < 0){
			throw new IllegalArgumentException("Você não pode tentar sacar um valor negativo na sua conta corrente. Valor: " + valor);
		}
		this.saldo -= valor;		
	}
	
	@Override
	public void deposita( double valor ) throws ValorInvalidoException {
		if( valor < 0 ){
			throw new IllegalArgumentException("Você não pode tentar depositar um valor negativo na sua conta corrente. Valor: " + valor);					
		}
		this.saldo += valor - 0.10;
	}
	

	@Override
	public String getNomeDonoConta() {
		return this.cliente.getNome();
	}

	@Override
	public double getSaldo() {
		return this.saldo;
	}

	@Override
	public void transfere(ContaInterface conta, double valor) throws ValorInvalidoException {
		this.saca(valor);
		conta.deposita(valor);		
	}

	@Override
	public String TipoConta() {
		return this.tipoDeConta;
	}

	
	@Override
	public void atualiza(double taxaSelic) {
		this.saldo += this.saldo * taxaSelic * 2;	
	}
	
	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}

	public double getLimite(){
		return this.limite;
	}
	public void setLimite(double limite){
		this.limite = limite;
	}
	
	public double getSaldoComLimite(){
		return this.saldo + this.limite;
	}
	
}
