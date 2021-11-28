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
public class per_histo_ancien {

    connection_radius con_radius;
   connection_Stock conn;
   connection_historadius con_histo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("t");
        per_histo_ancien.recherche_tel(1);

    }

    public static void recherche_tel (int tel) {
        System.out.println("t");
        String sql = "select * from Bee_net_tn where date_ajout IS NULL";
        ResultSet res1;
        
        int i = 0;
        
        try {
            System.out.println("t");
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
           
            res1 = ps.executeQuery();
             System.out.println("t");
            while (res1.next()) {
                int mac =0;
                System.out.println("t");
                      mac  =res1.getInt("id");
                      System.out.println(mac);
                
per_histo_ancien.insert("ok",mac);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void recherche_histo (String mac,int tel) {
        //30_03_18_07_back
        //18_07_01_09_back
        //31_08_2019_01_04_back
        String sql = "select acctstarttime from 31_08_2019_01_04_back where username= '"+mac+"' order by radacctid asc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_historadius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo,stop =null;
                      histo  =res1.getString("acctstarttime");
                      
                per_histo_ancien.insert(histo, tel);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
     public static void insert (String histo,int tel) {
        
        String sql = "update Bee_net_tn SET date_ajout= '2020-04-09 'where id='"+tel+"'";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            i= ps.executeUpdate();
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
