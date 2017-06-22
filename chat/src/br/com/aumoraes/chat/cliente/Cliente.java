package br.com.aumoraes.chat.cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import br.com.aumoraes.chat.ApplicationProperties;


public class Cliente {
	private static ApplicationProperties properties;
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		properties = ApplicationProperties.getInstance();
		
		new Cliente( properties.getServer(), properties.getPort()).executa();		
	}
	
	private String host;
	private int porta;
	private boolean connection = false;
	
	public Cliente (String host, int porta) {
		this.host = host;
		this.porta = porta;
	}
	
	public void executa(){

		String userName = "";
		
		try(Socket cliente = new Socket(this.host, this.porta);
			PrintStream saida = new PrintStream(cliente.getOutputStream());
			Scanner teclado = new Scanner(System.in) ){
			
			
			Recebedor r = new Recebedor(cliente.getInputStream(), this, properties);		
			new Thread(r).start();
		
			userName = teclado.nextLine();
			saida.println( userName );	
						
			
			while (teclado.hasNextLine()) {
				if( ! connection ){
					userName = teclado.nextLine();
					saida.println( userName );
				}else{
					saida.println(userName + " says: \n" + teclado.nextLine());	
				}			
			}

		} catch (IOException e) {
			System.out.println(e + "No momento não há um servidor disponível, tente mais tarde.");
		} catch (NoSuchElementException ex){
			System.out.println("");
		}
		
	}
	
	public void setConnection(){
		this.connection = true;
	}
}
