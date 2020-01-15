/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.projekat;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Windows 8
 */
public class MiniClip extends Application{
    
  
  
    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException{

      
         Document doc = Jsoup.connect("https://www.miniclip.com/games/en/").get();
        
        Elements newsHeadlines = doc.select("ol > li > a.tooltip");
        
        TextArea rezultatPretrage = new TextArea();
        
        rezultatPretrage.setPrefSize(500, 200);

         ScrollPane scrollPane = new ScrollPane(rezultatPretrage);
         rezultatPretrage.setEditable(false);
        

         
                   
             new Thread(new Runnable() {  
     @Override 
     public void run() { 
 try { 
       

        Platform.runLater(new Runnable() {
         @Override
                  public void run() { 
                       for(Element e: newsHeadlines){
            
           // rezultatPretrage.appendText(String.format("%s\n", e.attr("href")));
            rezultatPretrage.appendText(String.format("%s\n\n", e.html()));
       }
                   
                    } 
                    }); 
         Thread.sleep(0); 
      
 }
  catch (InterruptedException ex) {
  }
     }
 }).start();
         
         
       HBox hbox = new HBox();
            
           
            
            Button pocetna = new Button("Pocetna");
            
             
            
            pocetna.setPrefSize(100,20);
           
            
            
              hbox.getChildren().addAll(pocetna);
             
            
             hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10, 0, 10, 10));
        hbox.setSpacing(30);    
      
        
        FlowPane flowpane = new FlowPane(); 
         flowpane.getChildren().addAll(scrollPane,hbox);
         
           Pane root = new Pane();
        root.getChildren().addAll(flowpane);
        
        
        
        
        
        
         pocetna.setOnAction((ActionEvent e) -> {
             
             try{
                 Igra main = new Igra();
                 main.start(primaryStage);
             }catch (Exception ex) {
                    ex.printStackTrace();
                   
                }
           

        });

        
      
        Scene scene = new Scene(root, 500, 250);
        
       primaryStage.setTitle("Preporucene igrice");
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    
   
}

