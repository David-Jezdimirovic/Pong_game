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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 8
 */
public class ListaAdmin extends Application{
     @Override
    public void start(Stage primaryStage) {
        
         Button pocetna = new Button("Pocetna");
        Button izbrisi = new Button("Izbrisi");
       
        
        pocetna.setPrefSize(80, 20);
        izbrisi.setPrefSize(80, 20);
       

        HBox hbox = new HBox();

        hbox.getChildren().addAll(pocetna, izbrisi);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20, 50, 20, 70));
        hbox.setSpacing(50);

        FlowPane flowPane = new FlowPane();
        
     TextArea rezultatPretrage = new TextArea();

        rezultatPretrage.setPrefSize(350, 300);

        ScrollPane scrollPane = new ScrollPane(rezultatPretrage);
        rezultatPretrage.setEditable(false);
        
        
        
         List<Igrac> lista = Baza.getAllIgraciAdmin();
               rezultatPretrage.clear();
               
               rezultatPretrage.appendText("\t\t\t\t ===   Igraci   === \n\n");
                rezultatPretrage.appendText("\t\t Ime      \t\t\t Sifra \t\t   Rezultat     \n\n     ");
                int i = 0;
                
                for (Igrac igrac : lista) {
                 ++i;
                   
                rezultatPretrage.appendText("\t\t" + i +". "+ igrac.getIme() +"\t\t\t"+ igrac.getSifra() +"\t\t\t"+ Integer.toString(igrac.getRezultat())+ "\n\n");
                 
                  
                }
        
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
         
         
         izbrisi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                BrisanjeAdmin del = new BrisanjeAdmin();
                del.start(primaryStage);
                
            }
       });
         
        flowPane.getChildren().addAll(scrollPane,hbox);
        
        Pane root = new Pane();
        root.getChildren().addAll(flowPane);
        
         Scene scene = new Scene(root, 350, 400);

        primaryStage.setTitle("Lista");
        primaryStage.setScene(scene);
        primaryStage.show();
}
   
}

