/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.projekat;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 8
 */
public class Baza {
    static private java.sql.Connection connection = null;
    static private String url = "jdbc:mysql://localhost/cs102_projekat";
    static private String username = "root";
    static private String password = "";
   
/**
 * Metoda za iscitavanje podataka iz tabela                          
 *     
 * @return lista vraca listu igraca sa njihovim rezultatima.
 */
    public static List<Igrac> getAllIgraci() {

      
        List<Igrac> lista = new ArrayList();

        try {
            connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM igraci igr JOIN rezultati rez  WHERE igr.sifra = rez.sifra ORDER BY rezultat DESC";
           // String query = "SELECT * FROM igraci ig JOIN rezultati rz ON ig.id_i = rz.id_r ORDER BY rezultat DESC";
                                                                
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
   
                String ime = rs.getString("ime");
            
                int rezultat = rs.getInt("rezultat");
               
    
                lista.add(new Igrac( ime, null, rezultat));
              
            }
                   connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Operacija nije izvrsena. ");
        }

        return lista;

    }
    
    
    /**
 * Metoda proverava da li postoji takva sifra u bazi                      
 *
 * @param  String sifra - Metodi se prosledjuje sifra koju upisemo u tekstualn polje       
 * @return provera - vraca sifru ako je ima u bazi a ako nema ostaje prazan string.
 */
    public static String proveraSifre(String sifra) {
        String provera = "";
        try {
            connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT sifra FROM igraci WHERE sifra =  '" + sifra + "';";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                provera = rs.getString("sifra");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Operacija nije izvrsena. ");
        }
        return provera;
    }
    
   
    
     /**
 * Metoda dodaje novog igraca i njegov reiltat u bazu                     
 *
 * @param  Igrac igrac - Metodi se prosledjuje objekat igrac       
 * 
 */
     public static void addIgrac(Igrac igrac) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO igraci(ime,sifra)" + "VALUES( ?, ?)";
            PreparedStatement st = connection.prepareStatement(query);
                st.setString(1, igrac.getIme());
                st.setString(2, igrac.getSifra());
               
                st.execute();
                
            
                 String query2 = "INSERT INTO rezultati(sifra, rezultat)" + "VALUES(?, ?)";
            PreparedStatement st2 = connection.prepareStatement(query2);
            
             st2.setString(1, igrac.getSifra());
              st2.setInt(2, igrac.getRezultat());
             st2.execute();
             
             st.close();
                st2.close();
            
           connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Operacija nije izvrsena. ");
        }
        
     }
    
   
    
   
     
     /**
 * Metoda brise igraca i njegov reiltat u bazu na snovu njegove sifre                    
 *
 * @param  String sifra - Metodi se prosledjuje sifra koju unesemo u polje       
 * 
 */      
   
     public static void deleteIgrac(String sifra) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            String query ="DELETE FROM igraci  WHERE sifra = ? ";
          //  String query3 ="DELETE FROM igraci igr JOIN rezultati rez ON igr.sifra = rez.sifra WHERE sifra = ? ";
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, sifra);
            st.execute();
            
            
              String query2 ="DELETE FROM rezultati  WHERE sifra = ? ";
               PreparedStatement st2 = connection.prepareStatement(query2);
                st2.setString(1, sifra);
            st2.execute();
            
            st.close();
            st2.close();
            connection.close();
           
        }catch(SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Operacija nije izvrsena. ");
        }
    }  
     
     
     // Za admina funkcije
     
     
       /**
 * Metoda proverava da li postoji admin u bazi                      
 *
 * @param  String ime - Metodi se prosledjuje ime koju upisemo u tekstualn polje  
 * @param  String sifra - Metodi se prosledjuje sifra koju upisemo u tekstualn polje       
 * @return b - vraca vrednost 1 ako admin postoji ili 0 ako ne postoju.
 */
    public static int proveraAdmina(String ime,String sifra) {
        String imeA = null;
        String sifraA = null;
        int b = 0;
        try {
            connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT ime, sifra FROM admin WHERE ime =  '" + ime + "' AND sifra = '" + sifra + "';";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                imeA = rs.getString("ime");
                sifraA = rs.getString("sifra");
                
                if(imeA != null && sifraA != null){
                    b += 1;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Operacija nije izvrsena. ");
        }
        return b;
    }
     
     
     
     /**
 * Metoda za iscitavanje podataka iz tabela                          
 *     
 * @return lista vraca listu igraca sa njihovim rezultatima.
 */
    public static List<Igrac> getAllIgraciAdmin() {

      
        List<Igrac> lista = new ArrayList();

        try {
            connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM igraci igr JOIN rezultati rez  WHERE igr.sifra = rez.sifra ORDER BY rezultat DESC";
           // String query = "SELECT * FROM igraci ig JOIN rezultati rz ON ig.id_i = rz.id_r ORDER BY rezultat DESC";
                                                                
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
   
                String ime = rs.getString("ime");
                String sifra = rs.getString("sifra");
                int rezultat = rs.getInt("rezultat");
               
    
                lista.add(new Igrac( ime, sifra, rezultat));
              
            }
                   connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Operacija nije izvrsena. ");
        }

        return lista;

    }
     
}
