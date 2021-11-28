/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

/**
 *
 * @author achraf
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ajout_m {
     String marque;
    String num_serie;
    String panne;
    String etat;
    
   
    String res = null;

    public ajout_m( String marque, String num_serie,String panne,String etat) {
        
        this.marque = marque;
        
        this.num_serie = num_serie;
        this.panne = panne;
        this.etat = etat;

    }

    public void ajout() {

        cnx c = new cnx();

        res = c.insertest("insert into matriel_main (Marque,num_serie,panne,etat) values ('" + marque + "','" + num_serie +  "','" + panne +  "','" + etat +  "')");
    


        
       
   

}
}
