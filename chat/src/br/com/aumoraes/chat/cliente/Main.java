package br.com.aumoraes.chat.cliente;

import java.io.IOException;
import java.net.UnknownHostException;

import br.com.aumoraes.chat.ApplicationProperties;

public class Main {

	
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ApplicationProperties properties;		
		properties = ApplicationProperties.getInstance();		
		new Cliente( properties.getServer(), properties.getPort()).executa();		
	}

}
