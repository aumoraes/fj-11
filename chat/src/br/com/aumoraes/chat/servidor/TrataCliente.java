package br.com.aumoraes.chat.servidor;

import java.util.Scanner;

public class TrataCliente implements Runnable {
	private Servidor servidor;
	private Usuario user;
	
	public TrataCliente( Servidor servidor, Usuario user ) {
		this.servidor = servidor;
		this.user = user;
	}
	
	public void run() {
		// quando chegar uma msg, distribui pra todos
		try(Scanner s = new Scanner(this.user.getColetorDeMensagem())){
			while (s.hasNextLine()) {
				servidor.distribuiMensagem(s.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Alguem erro ocorreu ao inciar a thread " + e);
		}
		// Saiu do loop, é porque desconectou...
        servidor.remove( this.user ); // Remove da lista de clientes da classe Servidor lá trás...
		
	}
}
