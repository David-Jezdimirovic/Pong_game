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
public class Klizac {
    /**
 * duzina prozora i dimenzije klizaca
 */
    private int width = 800;
     public static final int Duzina = 100, Sirina = 20, MarginTop = 470;

   public double polozajX = width / 2;
 

   public Klizac(){
   
   }
   

    public double getPolozajX() {
        return polozajX;
    }

    public void setPolozajX(double polozajX) {
        this.polozajX = polozajX;
    }
   
    
}
