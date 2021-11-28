/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RECTT;

import connexion.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author serv-web
 */
public class sqlrectt {
     public static ArrayList<String> recherche (String tel_adsl) {
    String sql = "select objet,date_rec_tt,date_etat,etat from rec_tt where tel_adsl="+tel_adsl+"";
    ArrayList<String> test1 = new ArrayList<String>();
    test1.add(null);
                test1.add(null);
                test1.add(null);
                test1.add(null);
        ResultSet res;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                String objet,date_rec_tt,date_etat,etat;
                objet=res.getString("objet");
                date_rec_tt=res.getString("date_rec_tt");
                date_etat=res.getString("date_etat");
                etat=res.getString("etat");
                test1.set(0,objet);
                test1.set(1,date_rec_tt);
                test1.set(2,date_etat);
                test1.set(3,etat);
                
            
            
                
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return test1;
    }
}
