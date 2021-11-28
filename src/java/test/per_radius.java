/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import connexion.connection_Stock;
import connexion.connection_historadius;
import connexion.connection_radius;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author serv-web
 */
public class per_radius {

    connection_radius con_radius;
   connection_Stock conn;
   connection_historadius con_histo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String sql = "select tel_adsl from verif ";
        ResultSet res;
        int i = 0;
        try {
            PreparedStatement ps = connection_Stock.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                int tel;
                tel=res.getInt("tel_adsl");
               
            String tel1=Integer.toString(tel);
            
                per_radius.recherche_tel(tel);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void recherche_tel (int tel) {
        
        String sql = "select Login from Bee_net_tn where telephone="+tel+"";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String mac =null;
                      mac  =res1.getString("Login");
                
per_radius.insert(mac,tel);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
     public static void insert (String histo,int tel) {
        
        String sql = "update verif SET stoptime= '"+histo+"'where tel_adsl='"+tel+"'";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_Stock.getConnection().prepareStatement(sql);
            i= ps.executeUpdate();
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
