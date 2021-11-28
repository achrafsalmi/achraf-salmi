/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import connexion.connection_radius;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author serv-web
 */
public class test_authentification_radius {
connection_radius con_radius;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String  vérif ="283B82DAB027";
         String sql ="select authdate from radpostauth WHERE  `username` LIKE '%"+vérif+"%'";
        ResultSet res;
        String i=null;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
           res  = ps.executeQuery();
           while (res.next()) {
             i=  res.getString("authdate");
             
           }System.out.println(i);
                   } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
     
}
