/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.projekat;

import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 8
 */
public class Upis extends Application{
    
     @Override
    public void start(Stage primaryStage) {

        Label l1 = new Label("Ime:");
        Label l2 = new Label("Sifra:");
       

        TextField t1 = new TextField();
        PasswordField t2 = new PasswordField();
       

        l1.setPrefSize(100, 20);
        l2.setPrefSize(100, 20);
       

        t1.setPrefSize(200, 20);
        t2.setPrefSize(200, 20);
       

        Button insert = new Button("Unesi");
        Button pocetna = new Button("Pocetna");
        Button lista = new Button("Lista");
        
    
       
        
        insert.setPrefSize(80, 20);
        pocetna.setPrefSize(80, 20);
        lista.setPrefSize(80, 20);
      
      
       insert.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                String provera = Baza.proveraSifre(t2.getText());
                if(provera == ""){
                try {
                    Baza.addIgrac(new Igrac(t1.getText(), t2.getText(), Igra.rezultat));
                  
                    
                    t1.clear();
                    t2.clear();
                  
                    JOptionPane.showMessageDialog(null, "Igrac dodat");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Greska");
                  
                }
                
                }else{ 
                    JOptionPane.showMessageDialog(null, "Takva sifra vec postoji. Promenite sifru.");
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
                  
                  JOptionPane.showMessageDialog(null, "Neuspeh.");
                }
            }
        });
       
        
             lista.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                Lista list = new Lista();
                list.start(primaryStage);
                
      
            }
       });
        
         GridPane gridPane = new GridPane();
 
        gridPane.add(l1, 0, 0);
        gridPane.add(t1, 1, 0);
        gridPane.add(l2, 0, 1);
        gridPane.add(t2, 1, 1);
      
        gridPane.setPadding(new Insets(20, 20, 20,20));
        gridPane.setVgap(10);
      
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(100, 0, 10, 10));
        hbox.setSpacing(35);
        
        hbox.getChildren().addAll(insert,pocetna,lista);
       Pane root = new Pane();
        root.getChildren().addAll(gridPane,hbox);

        Scene scene = new Scene(root, 350, 200);

        primaryStage.setTitle("Upis");
        primaryStage.setScene(scene);
        primaryStage.show();
       
}
    
}