/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.projekat;


import javafx.application.Application;
import javafx.stage.Stage;


/**
 *
 * @author Windows 8
 */
public class Main extends Application{
    public void start(Stage primaryStage) throws Exception {
    
        Igra igra = new Igra();
        igra.start(primaryStage);
        
        
    }
    
     public static void main(String[] args) {
        launch(args);
       
    }
}
