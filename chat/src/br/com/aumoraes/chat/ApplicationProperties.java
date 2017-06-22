package br.com.aumoraes.chat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

	private static Properties properties;
	private static ApplicationProperties uniqueInstance;
	
	private ApplicationProperties() {} 

    public static synchronized ApplicationProperties getInstance() {                      
        if (uniqueInstance == null){                                                          
          uniqueInstance = new ApplicationProperties();                                        
        }                                                                                              
        return uniqueInstance;                                                                
      }
    
	private Properties getProperties() {
		if (properties == null) {
			try {
				properties = new Properties();
				String pathToFile = "";
				if( (pathToFile = System.getProperty("chat.conf.path")) == null)
					pathToFile = getPath();
				
				InputStream inputStreamPath = null;
				inputStreamPath = new FileInputStream( pathToFile );
				properties.load( inputStreamPath );
				
				//properties.load(ApplicationProperties.class.getClassLoader().getResourceAsStream("app.properties"));
			} catch (IOException e) {
				throw new RuntimeException("Erro ao ler o arquivo de configuração " + e);
			}
		}
		return properties;
	}
	
	public String getPath(){
		String pathToFile = new File("").getAbsolutePath() + "/src/br/com/aumoraes/chat/servidor/app.properties";
		
		return pathToFile;
	}
		
	private String getProperty(String property) {
		return getProperties().getProperty(property).trim();
	}

	public int getPort() {
		return Integer.parseInt( getProperty("app.port").trim() );
	}
	public String getServer() {
		return getProperty("app.server").trim();
	}
	public String getConnectionMessage() {
		return getProperty("app.connectionMessage").trim();
	}
}
