/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verif;

import connexion.connection;
import connexion.connection_Stock;
import connexion.connection_radius;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import test.per_radius;

/**
 *
 * @author serv-web
 */
public class verif_rad {
    public static void recherche () {
    String sql = "select tel_adsl from 1_cnx_fact";
        ResultSet res;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                int tel;
                tel=res.getInt("tel_adsl");
                System.out.println(tel);
            String tel1=Integer.toString(tel);
            
                verif_rad.recherche_tel(tel);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void recherche_tel (int tel) {
        
        String sql = "select Login,Nom from Bee_net_tn where telephone="+tel+"";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String mac =null,Nom=null;
                      mac  =res1.getString("Login");
                      Nom=res1.getString("Nom");
                System.out.println(mac);
verif_rad.insert(mac,tel,Nom);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
     public static void insert (String histo,int tel,String Nom) {
        
        String sql = "update 1_cnx_fact SET Nom='" + Nom + "',modif= '"+histo+"'where tel_adsl='"+tel+"'";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            i= ps.executeUpdate();
             System.out.println(histo);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
