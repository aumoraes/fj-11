package br.com.aumoraes.chat.cliente;

import java.io.InputStream;

import java.util.Scanner;

import br.com.aumoraes.chat.ApplicationProperties;

public class Recebedor implements Runnable{
	
	private InputStream servidor;
	private Cliente cliente;
	private ApplicationProperties properties;
	
	public Recebedor(InputStream servidor, Cliente cliente, ApplicationProperties properties) {
		this.servidor = servidor;
		this.cliente = cliente;
		this.properties = properties;
	}
	
	public void run() {
		// recebe msgs do servidor e imprime na tela
		Scanner s = new Scanner(this.servidor);
		while (s.hasNextLine()) {
			String msg = s.nextLine();
			String connectionMessage = properties.getConnectionMessage();
			if( msg.equals( connectionMessage ) ){
				cliente.setConnection();
			}else{
				System.out.println( msg );	
			}
			
		}
		System.out.println("Desconectado");
		s.close();
	}
	
}
