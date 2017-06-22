package br.com.aumoraes.chat.servidor;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import br.com.aumoraes.chat.ApplicationProperties;

public class Servidor {
	private int porta; 
	private int userId = 0;	
	private int connections = 0;
	private List<Usuario> listaDeUsuarios;
	private static ApplicationProperties properties;
	
	
	public Servidor (int porta) {
		this.porta = porta;
		this.listaDeUsuarios = new ArrayList<Usuario>();
	}
	
	public void executa () {

		try(ServerSocket servidor = new ServerSocket(this.porta)){
			System.out.println("O servidor está de pé na porta: " + properties.getPort());
			while (true) {
				Socket cliente = servidor.accept();
				
				TrataCliente tc = new TrataCliente(this, cliente, userId);
				new Thread(tc).start();
				connections++;
				userId++;
			}
		} catch (Exception e) {
			System.out.println("O Servidor está parado, motivo: " + e);
		}
		
	}
	
	public void addUser( Usuario user ) {
		this.listaDeUsuarios.add( user );
	}
	
	public void remove( Usuario user ) {
		try {
			distribuiMensagem("Info: O usuario " + user.getNome() + " se desconectou");
			this.listaDeUsuarios.remove( user );
		} catch (Exception e) {
			System.out.println("aconteceu algum erro aqui ");
		}
		
		connections--;
		System.out.println("cliente se desconectou " + user.toString());
		totalClientes();
	}
	
	public void distribuiMensagem(String msg) {
		// envia msg para todo mundo
		for (Usuario user : this.listaDeUsuarios) {
			PrintStream mensagem = user.getMensageiro();
			mensagem.println(msg);
		}
	}
	

	public void mostraCliente(){
		System.out.println("** Lista de usuarios ***");
		for (Usuario user : this.listaDeUsuarios) {
			System.out.println( user.toString() );
		}
		
		totalClientes();
	}
	
	public void totalClientes(){
		System.out.println("numero de pessoas conectadas: " + this.connections);
	}
	
	public boolean validations(String userName){
		boolean ans = false;
		Usuario user = new Usuario();
		user.setNome(userName);
		if( listaDeUsuarios.contains( user ) ){
			ans = true;
		}
		return ans;
	}

	
}
