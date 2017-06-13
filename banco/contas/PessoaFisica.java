package br.com.aurelio.banco.contas;

public class PessoaFisica extends Cliente{
	
	private String cpf;
	
	public PessoaFisica(String cpf, String nome, String telefone) {
		
		this.nome = nome;
		this.telefone = telefone;
		
		if( validaDados(cpf) ){
			this.cpf = cpf;	
		} else {
			return;
		}
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean validaDados(String numeroRegistro) {
		String[] formatedCpf = numeroRegistro.split(".|-");
		if(formatedCpf.length == 11){
			return true;
		} else {
			return false;
		}
	}

}
