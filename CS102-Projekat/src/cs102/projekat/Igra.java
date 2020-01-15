/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.projekat;


import javafx.scene.control.Button;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class Igra extends Application {
/**
 * duzina i sirina polja   
 */
    private static final int width = 800;
    private static final int height = 500;
    
 /**
 * ostvareni broj poena  
 */
    public static int rezultat ;
    private boolean partija; // podrazumevano false
 
    Lopta lopta = new Lopta();
    Lopta lopta2 = new Lopta();
    Klizac klizac = new Klizac();
       
    public void start(Stage primaryStage) throws Exception {

        FlowPane flowpane = new FlowPane();
        Pane pane = new Pane();

        HBox hbox = new HBox();

        Button newGame = new Button("Nova Igra");
        Button upisi = new Button("Upisi rezultat");
        Button lista = new Button("Lista bodova");
        Button delete = new Button("Izbrisi");
        Button preporuka = new Button("Lista igrica");
        Button admin = new Button("Admin");

        newGame.setPrefSize(100, 20);
        upisi.setPrefSize(100, 20);
        lista.setPrefSize(100, 20);
        delete.setPrefSize(100, 20);
        preporuka.setPrefSize(100, 20);
        admin.setPrefSize(100, 20);
        
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10, 5, 10, 5));
        hbox.setSpacing(38);

        Canvas canvas = new Canvas(width, height);
        pane.getChildren().add(canvas);
        hbox.getChildren().addAll(newGame, upisi, lista, delete, preporuka, admin);

        flowpane.getChildren().addAll(pane, hbox);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.stop();
        pane.setOnMouseMoved(e -> klizac.polozajX = e.getX());
        pane.setOnMouseClicked(e -> partija = true);
        pane.setOnMouseClicked(e -> reset());

        primaryStage.setScene(new Scene(new Pane(flowpane)));
        primaryStage.setTitle("Super Pong");
        primaryStage.show();
        tl.play();

        preporuka.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    MiniClip mini = new MiniClip();
                    mini.start(primaryStage);

                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        });

        newGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                    reset();

                } catch (Exception ex) {
                    ex.printStackTrace();
                     JOptionPane.showMessageDialog(null, "Neuspeh.");
                }
            }
        });
        
        upisi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {
                   Upis upis = new Upis();
                   upis.start(primaryStage);

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
        
        
        delete.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                Brisanje del = new Brisanje();
                del.start(primaryStage);
                
            }
       });
        
        
        
        admin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                Admin adm = new Admin();
                adm.start(primaryStage);
               
            }
       });
    }

  
       
    public void run(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

       gc.fillText("Rezultat: " + rezultat, width / 2, 50);

        if (partija) {
            lopta.loptaXPoz += lopta.getKorakX();
            lopta.loptaYPoz += lopta.getKorakY();

            if (rezultat > 1) {
                lopta2.lopta2XPoz += lopta2.getKorak2X();
                lopta2.lopta2YPoz += lopta2.getKorak2Y();
                gc.setFill(Color.RED);
                gc.fillOval(lopta2.lopta2XPoz, lopta2.lopta2YPoz, lopta2.precnik, lopta2.precnik);
            }

            if (lopta.loptaXPoz < 0) {
                lopta.setKorakX(-lopta.getKorakX());
            }
            if (lopta.loptaYPoz < 0) {
                lopta.setKorakY(-lopta.getKorakY());
            }
            if (lopta.loptaXPoz > width) {
                lopta.setKorakX(-lopta.getKorakX());
            }
        
		
		if (lopta.loptaYPoz > klizac.MarginTop - klizac.Sirina && lopta.loptaXPoz >= klizac.getPolozajX() && lopta.loptaXPoz <= klizac.getPolozajX() + klizac.Duzina) {
			
                          lopta.setKorakY(-lopta.getKorakY()-1);
                        rezultat++;
		}

            if (lopta2.lopta2XPoz < 0) {
                lopta2.setKorak2X(-lopta2.getKorak2X());
            }
            if (lopta2.lopta2YPoz < 0) {
                lopta2.setKorak2Y(-lopta2.getKorak2Y());
            }
            if (lopta2.lopta2XPoz > width) {
                lopta2.setKorak2X(-lopta2.getKorak2X());
            }
            if (lopta2.lopta2YPoz > height) {
          
              lopta2.lopta2YPoz = height/50;
             }
      
       if (lopta2.lopta2YPoz > klizac.MarginTop - klizac.Sirina && lopta2.lopta2XPoz >= klizac.getPolozajX() && lopta2.lopta2XPoz <= klizac.getPolozajX() + klizac.Duzina) {
			
                        lopta2.setKorak2Y(-lopta2.getKorak2Y()-2);
                        rezultat--;
		}
       
            // iscrtava lopticu i klizac
            gc.setFill(Color.WHITE);
            gc.fillOval(lopta.loptaXPoz, lopta.loptaYPoz, lopta.precnik, lopta.precnik);
            gc.fillRect(klizac.polozajX, klizac.MarginTop, klizac.Duzina, klizac.Sirina);
            
        } else {
            // iscrtava tekst
            gc.setStroke(Color.YELLOW);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Kliknite da biste poceli", width / 2, height / 2);
          
			
        }

     
        if (lopta.loptaYPoz > height) {
            partija = false;
            gc.setFill(Color.RED);
            gc.fillText("Kraj Igre", width / 2, height / 2 - 50);
             gc.setStroke(Color.RED);
            gc.strokeText("Ako zelite da prijavite rezultat, kliknite na Upisi rezultat", width / 2, height / 2 + 50);

           
        }
        
}
        
  /**
 * Nakon zavrsene igre funkcuja resetuje vrednosti na pocetne                          
 */
    public void reset() {
        partija = true;
        klizac.getPolozajX();
        lopta.loptaXPoz = width/2;
        lopta.loptaYPoz = height/2;
        lopta.setKorakX(2);
        lopta.setKorakY(2);
        lopta2.lopta2XPoz = width/2;
        lopta2.lopta2YPoz = height/50;
        lopta2.setKorak2X(3);
        lopta2.setKorak2Y(3);
        rezultat = 0;
    }
   
    
// Metode za JUnit testove kreirane za proveu if uslova
public int korak1(int dimX, int pozX, int korX){
        if(pozX > dimX){
            korX *= -1;
        }
        return korX;
}

   public int korak2(int dimY, int pozY, int korY){
        if(pozY < dimY){
            korY *= -1;
        }
        return korY;
}

}
