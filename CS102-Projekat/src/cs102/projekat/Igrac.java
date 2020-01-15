/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.projekat;

/**
 *
 * @author Windows 8
 */
public class Igrac {
 /**
 * ime igraca
 * sifra igraca
 * rezultat igraca
 */
    private String ime;
    private String sifra;
    private int rezultat;
    
    public Igrac(){
    }

    public Igrac(String ime, String sifra, int rezultat) {
        this.ime = ime;
        this.sifra = sifra;
        this.rezultat = rezultat;
    }
    
   

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getRezultat() {
        return rezultat;
    }

    public void setRezultat(int rezultat) {
        this.rezultat = rezultat;
    }

    @Override
    public String toString() {
        return "Igrac{" + "ime=" + ime + ", sifra=" + sifra + ", rezultat=" + rezultat + '}';
    }
    
    
}
