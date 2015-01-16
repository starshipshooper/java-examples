/*
 * To change this license header, choose License Headers in Project PropertiesManager.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resourcefinder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author adnan
 */
public class PropertiesManager {
    
    static Properties defaultProperties = null;
    static Properties applicationProperties = null;
    static FileInputStream defaultFile;
    static File defaultPropertiesFile; 
    static File appPropertiesfile;
    public PropertiesManager() throws FileNotFoundException, IOException {
                     defaultPropertiesFile = new File(System.getProperty("user.home")+"\\test.properties");
                    defaultPropertiesFile.createNewFile(); 
                     appPropertiesfile = new File(System.getProperty("user.home")+"\\appProperties.properties"); 
                    appPropertiesfile.createNewFile();
		// create and load default properties
			 defaultProperties = new Properties();
		   //write default settings to properties file
                         System.out.println("**"+System.getProperty("user.home")+"\\test.properties");
                       
			 FileOutputStream defaultFileWriter = new FileOutputStream(defaultPropertiesFile);
			 defaultProperties.setProperty("Location", "URL LOCATION OF EXCEL FILE HERE");
			 defaultProperties.store(defaultFileWriter, "Default server Location. In case user never has set one.");
			 defaultFileWriter.close();
                        defaultFile = new FileInputStream(defaultPropertiesFile);
                        
                        defaultProperties.load(defaultFile);
                        defaultFile.close();

			//create application properties with default
			 applicationProperties = new Properties(defaultProperties);
			//now load properties from last invocation
			FileInputStream userAppFile = new FileInputStream(appPropertiesfile);
			applicationProperties.load(userAppFile);
			userAppFile.close();
	
    }
    
    
    
        public static void setNewEPDMenu(String newEPDLocation) throws FileNotFoundException, IOException {

		//block that allows user to change settings: 
//		applicationProperties.setProperty("language", "English");
		applicationProperties.setProperty("Location", newEPDLocation);
		FileOutputStream userAppFileWriter = new FileOutputStream(appPropertiesfile);
		applicationProperties.store(userAppFileWriter, "EPD Finder settings");
		userAppFileWriter.close();
		
		System.out.println(applicationProperties.getProperty("Location"));
            
            
            
    }

    
}



