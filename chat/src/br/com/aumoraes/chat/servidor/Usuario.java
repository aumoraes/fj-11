package br.com.aumoraes.chat.servidor;

import java.io.InputStream;
import java.io.PrintStream;

public class Usuario {
	private int id;
	private String ip;
	private String nome;
	private PrintStream mensageiro;
	private InputStream coletorDeMensagem;
	
	public PrintStream getMensageiro() {
		return mensageiro;
	}
	public void setMensageiro(PrintStream mensageiro) {
		this.mensageiro = mensageiro;
	}
	public InputStream getColetorDeMensagem() {
		return coletorDeMensagem;
	}
	public void setColetorDeMensagem(InputStream coletorDeMensagem) {
		this.coletorDeMensagem = coletorDeMensagem;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", ip=" + ip + ", nome=" + nome + "]";
	}
	
	
	
}
