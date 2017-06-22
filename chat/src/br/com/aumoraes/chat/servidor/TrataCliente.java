package br.com.aumoraes.chat.servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import br.com.aumoraes.chat.ApplicationProperties;

public class TrataCliente implements Runnable {
	
	private Socket cliente;
	private Usuario user;
	private int userId = 0;
	private Servidor servidor;
	private ApplicationProperties properties;
	
	// Cria uma referencia a um objeto que ira imprimir a saido do cliente no console 
	private PrintStream ps;
	
	public TrataCliente( Servidor servidor , Socket cliente, int userId ) {
		this.cliente = cliente;
		this.userId = userId;
		this.servidor = servidor;
		properties = ApplicationProperties.getInstance();
	}
	
	public void run() {
		
		int numeroDeMensagensEnviadas = 0;
		
		try(Scanner s = new Scanner( this.cliente.getInputStream() )){
			
			if( numeroDeMensagensEnviadas == 0 ){
				String userName = "";
				
				ps = new PrintStream(cliente.getOutputStream());
				ps.println("Qual o nome do usuario?");
								
				userName = s.nextLine();
				
				while( this.servidor.validations( userName ) ){
					ps.println("Nome de usuario já existe, escolha outro");
					userName = s.nextLine();
				}
				
				ps.println( properties.getConnectionMessage() );
				
				modelaCliente(userName);
				numeroDeMensagensEnviadas++;
				
			}
			while (s.hasNextLine()) {
				this.servidor.distribuiMensagem(s.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Alguem erro ocorreu ao inciar a thread " + e);
		}
		if( numeroDeMensagensEnviadas != 0){
			//Saiu do loop, é porque desconectou...
			this.servidor.remove( this.user );
		}

		
	}
	
	private void modelaCliente(String nome) throws IOException{
		
		this.user = new Usuario();
		
		this.user.setIp( this.cliente.getInetAddress().getHostAddress() );
		
		this.user.setId( userId );
		
		this.user.setNome( nome );
		
		this.user.setColetorDeMensagem( this.cliente.getInputStream() );
		
		System.out.println("Nova conexão com o cliente id: " +	this.user.getId() + ", ip: " + this.user.getIp() + ", nome: " + this.user.getNome() );	

		user.setMensageiro( this.ps );
		
		this.servidor.addUser(this.user);
		
		this.servidor.mostraCliente();
		
		this.servidor.distribuiMensagem("O usuario " + this.user.getNome() + " acabou de se conectar");
	}
	
	
}
