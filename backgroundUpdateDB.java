/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resourcefinder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author adnan
 */
public class backgroundUpdateDB extends Task<String> {
Stage  backgroundupdateDBStage;
String backgroundupdateDBLink;
    
    public backgroundUpdateDB(/*final Stage  updateDBStage*/ String Link) {
        
        //backgroundupdateDBStage =  updateDBStage;
        
        backgroundupdateDBLink = Link;
    
    
    }
    @Override
    protected String call() throws Exception {
               
                try {
                   
                    new TempDatabase(backgroundupdateDBLink);
                System.out.println("Updated DB in the background!!!!!!");
                    
                } catch (IOException ex) {
                    Logger.getLogger(backgroundUpdateDB.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("BackgroundUpdateDB ERROR!!!");
                  
                }  
        String message = "backgroundUpdatedDB!!";
        System.out.println(message);
        
        return message; 
    }
    
    
    
    
    
}
