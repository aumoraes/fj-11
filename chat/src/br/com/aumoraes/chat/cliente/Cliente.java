package br.com.aumoraes.chat.cliente;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// dispara cliente
		new Cliente("10.110.60.86", 12345).executa();		
	}
	
	private String host;
	private int porta;
	
	public Cliente (String host, int porta) {
		this.host = host;
		this.porta = porta;
	}
	
	public void executa() throws UnknownHostException, IOException {
		
		Scanner inputName = new Scanner(System.in);
		
		System.out.println("Digite um nome de usuário");
		String userName = inputName.nextLine();
		
		Socket cliente = new Socket(this.host, this.porta);

		System.out.println("O cliente " + userName + " acabou de se conectar ao servidor!");
		
		// thread para receber mensagens do servidor
		Recebedor r = new Recebedor(cliente.getInputStream());		
		new Thread(r).start();
		
		// le msgs do teclado e manda pro servidor
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		while (teclado.hasNextLine()) {
			
			saida.println(userName + " says: \n" + teclado.nextLine());
			
		}
		inputName.close();
		saida.close();
		teclado.close();
		cliente.close();
	}
}
