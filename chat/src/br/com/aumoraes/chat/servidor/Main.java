package br.com.aumoraes.chat.servidor;

import java.io.IOException;

import br.com.aumoraes.chat.ApplicationProperties;

public class Main {
	
	public static void main(String[] args) throws IOException {
		ApplicationProperties properties;
		properties = ApplicationProperties.getInstance();
		new Servidor( properties.getPort() ).executa() ;		
	}

}
