package br.com.aumoraes.banco.contas;

public interface ContaInterface {
	
	public int getId();
	
	public void saca(double valor) throws ValorInvalidoException;
	
	public void deposita(double valor) throws ValorInvalidoException;
	
	public String getNomeDonoConta();
	
	public double getSaldo();
	
	void transfere(ContaInterface conta, double valor) throws ValorInvalidoException;
	
	public String TipoConta();
	
	public void atualiza(double taxaSelic);
	
	

	
}
