/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.projekat;

import java.awt.Rectangle;

/**
 *
 * @author Windows 8
 */
public class Lopta {
    
  /**
 * duzina i sirina polja
 */
    private static final int width = 800;
	private static final int height = 500;
        
        /**
 * pocetna pozicija bele i crvene loptice i njihove dimenzije
 */
     public static int loptaXPoz = width / 2, loptaYPoz = height / 2, precnik = 25, lopta2XPoz = width/2, lopta2YPoz = height/50; 
    
     /**
 * Definisu brzinu kretanja loptica
 */
     private int korakX = 2;
     private int korakY = 2;
      private int korak2X = 3;
    private int korak2Y = 3;

    public Lopta() {

  }

    public int getKorakX() {
        return korakX;
    }

    public void setKorakX(int korakX) {
        this.korakX = korakX;
    }

    public int getKorakY() {
        return korakY;
    }

    public void setKorakY(int korakY) {
        this.korakY = korakY;
    }
    
    
     public int getKorak2X() {
        return korak2X;
    }

    public void setKorak2X(int korak2X) {
        this.korak2X = korak2X;
    }

    public int getKorak2Y() {
        return korak2Y;
    }

    public void setKorak2Y(int korak2Y) {
        this.korak2Y = korak2Y;
    }
    
 
}

