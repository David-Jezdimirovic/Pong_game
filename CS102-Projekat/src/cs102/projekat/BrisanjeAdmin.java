/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.projekat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 8
 */
public class BrisanjeAdmin extends Application{
    
  @Override
    public void start(Stage primaryStage) {

       
        Label l1 = new Label("Sifra:");
      
        PasswordField t1 = new PasswordField();
       

        l1.setPrefSize(100, 20);
      
        t1.setPrefSize(200, 20);
     
       

        Button brisanje = new Button("Obrisi");
        Button pocetna = new Button("Pocetna");
        Button lista = new Button("Lista");
        
    
       
        
        brisanje.setPrefSize(80, 20);
        pocetna.setPrefSize(80, 20);
        lista.setPrefSize(80, 20);
      
      
       brisanje.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
               
                try {
                    Baza.deleteIgrac(t1.getText());
                 
                    t1.clear();
                    
                    JOptionPane.showMessageDialog(null, "Igrac obrisan");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Greska");
                  
                }
                
               
            }
        });
       
       
        pocetna.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                  Main main = new Main();
                  main.start(primaryStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                  JOptionPane.showMessageDialog(null, "Neuspeh");
                  
                }
            }
        });
       
        
             lista.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                ListaAdmin list = new ListaAdmin();
                list.start(primaryStage);
                
            }
       });
        
         GridPane gridPane = new GridPane();
 
        gridPane.add(l1, 0, 0);
        gridPane.add(t1, 1, 0);
      
      
        gridPane.setPadding(new Insets(20, 20, 20,20));
        gridPane.setVgap(10);
      
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(100, 0, 10, 10));
        hbox.setSpacing(35);
        
        hbox.getChildren().addAll(brisanje,pocetna,lista);
       Pane root = new Pane();
        root.getChildren().addAll(gridPane,hbox);

        Scene scene = new Scene(root, 350, 200);

        primaryStage.setTitle("Brisanje");
        primaryStage.setScene(scene);
        primaryStage.show();
       
}
   
}

