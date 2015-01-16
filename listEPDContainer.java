/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resourcefinder;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.web.WebEngine;

/**
 *
 * @author adnan
 */
public class listEPDContainer {
    SimpleStringProperty description = null; 
    SimpleStringProperty resourceID = null; 
    String location = "Sample location";
    Hyperlink locationLink;
    String fileType; 
    
    
    public listEPDContainer(WebEngine engine) {
    
}
    
     public String getResourceID() {
            
            
            return resourceID.get();
        
        }
         
        public void setResourceID( String ID) {
        
            
            resourceID.set(ID);
            
        }
   
        
         public Hyperlink getLocation() {
            
            
            return locationLink;
        
        }
         
        public void setLocation( String loc) {
        
            
            location = loc;
            
        }
        
          public String getDescription() {
            
            
            return description.get();
        
        }
         
        public void setDescription( String loc) {
        
            
            description.set(loc);
            
        }
  
    
    
    
    
    
}
