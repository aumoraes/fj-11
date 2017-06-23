package br.com.aumoraes.banco.contas;

public abstract class Cliente {
	
	protected String nome;
	
	protected String telefone;
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome( String nome){
		this.nome = nome;
	}
	
	public String getTelefone(){
		return this.telefone;
	}
	
	public void setTelefone( String telefone ){
		this.telefone = telefone;
	}
	
	abstract boolean validaDados( String numeroRegistro);

}
