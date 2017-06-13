package br.com.aurelio.banco.contas;

public class PessoaJuridica extends Cliente{
	
	private String cnpj;	
	
	public PessoaJuridica(String cnpj, String nome, String telefone) {		
		this.nome = nome;
		this.telefone = telefone;
		
		if( validaDados(cnpj) ){
			this.cnpj = cnpj;	
		} else {
			return;
		}
	}
	
	public String getCnpf(){
		return this.cnpj;
	}
	
	public void setCnpj( String cnpj){
		this.cnpj = cnpj;
	}
	
	@Override
	public boolean validaDados(String numeroRegistro) {
		String[] formatedCnpj = numeroRegistro.split(".|-");
		if(formatedCnpj.length == 10){
			return true;
		} else {
			return false;
		}
	}

}
