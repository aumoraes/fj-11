package br.com.aumoraes.chat.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	public static void main(String[] args) throws IOException {
		// inicia o servidor		
		new Servidor(12345).executa();
	}
	
	private int porta;
	private List<Usuario> listaDeUsuarios; 
	private int userId = 0;
	private int connections = 0;
	
	public Servidor (int porta) {
		this.porta = porta;
		this.listaDeUsuarios = new ArrayList<Usuario>();
	}
	
	public void executa () throws IOException {
		//TODO Definir porta atravez de arquivo config
		try(ServerSocket servidor = new ServerSocket(this.porta)){		
		
			System.out.println("O servidor está de pé na porta: " + this.porta);
			
			
			
			while (true) {
				// aceita um cliente
				Socket cliente = servidor.accept();
				
				Usuario user = new Usuario();
				user.setIp( cliente.getInetAddress().getHostAddress() );
				user.setId( userId );
				user.setNome( "cliente " + userId );
				user.setColetorDeMensagem( cliente.getInputStream() );
				System.out.println("Nova conexão com o cliente id: " +	user.getId() + ", ip: " + user.getIp() + ", nome: " + user.getNome() );
				
				
				// Cria uma referencia a um objeto que ira imprimir a saido do cliente no console 
				PrintStream ps = new PrintStream(cliente.getOutputStream());
				user.setMensageiro( ps );
				// adiciona saida do cliente à lista
				this.listaDeUsuarios.add( user );
				
							  
				// cria tratador de cliente numa nova thread
				TrataCliente tc = new TrataCliente(this, user);
				new Thread(tc).start();
				userId++;
				connections++;
				mostraCliente();
			}
		} catch (Exception e) {
			System.out.println("O Servidor está parado, motivo: " + e);
		}
		
		
		
	}
	public void remove( Usuario user ) {
		distribuiMensagem("Info: O usuario " + user.getNome() + " se desconectou");
		
		
		//TODO Por que esse metodo da pau?
		try {
			this.listaDeUsuarios.remove( user );
		} catch (Exception e) {
			System.out.println("aconteceu algum erro aqui>>>>> ");
		}
		
		connections--;
		System.out.println("cliente se desconectou " + user.toString());
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
}
