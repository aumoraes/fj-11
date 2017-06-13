package br.com.aurelio.banco.contas;

public class ContaPoupanca implements ContaInterface{
	private int id;
	private Cliente cliente;
	private double saldo;
	private String tipoDeConta = "Conta Poupança";
	
	static String identificador = "cp";
	static int contador = 0;
	
	
	public ContaPoupanca(int id, Cliente cliente, double saldo ){
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
			throw new ValorInvalidoException("Você não pode tentar sacar um valor negativo na sua conta poupança. Valor: " + valor);
		}
		this.saldo -= valor;		
	}

	@Override
	public void deposita( double valor ) throws ValorInvalidoException {
		if( valor < 0 ){
			throw new ValorInvalidoException("Você não pode tentar depositar um valor negativo na sua conta poupança. Valor: " + valor);			
		}
		this.saldo += valor;
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
		this.saldo += this.saldo * taxaSelic;
	}
	
}
