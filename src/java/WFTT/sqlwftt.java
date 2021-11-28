/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WFTT;

import connexion.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import verif.verif_rad_MG;

/**
 *
 * @author serv-web
 */
public class sqlwftt {
     public static ArrayList<String> recherche (String tel_adsl) {
    String sql = "select csc,region,contact,date_etat,contrat from wf where tel_adsl="+tel_adsl+"";
    ArrayList<String> test1 = new ArrayList<String>(); 
     test1.add(null);
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
                String csc,region,contact,date_etat,contrat;
                csc=res.getString("csc");
                region=res.getString("region");
                contact=res.getString("contact");
                date_etat=res.getString("date_etat");
                contrat=res.getString("contrat");
                test1.set(0,csc);
                test1.set(1,region);
                test1.set(2,contact);
                test1.set(3,date_etat);
                test1.set(4,contrat);
                
                //System.out.println(csc+"__"+region+"__"+contact+"__"+date_etat);
            
            
                
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return test1;
    }
}
