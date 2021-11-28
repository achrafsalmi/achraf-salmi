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
public class rec_tt {

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
                String tel;
                tel=res.getString("tel_adsl");
            
            
                rec_tt.recherche_histo(tel);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void recherche_tel (String k) {
        
        String sql = "DELETE FROM `rec_tt` WHERE ref_rec_tt LIKE'%"+k+"%'";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            i = ps.executeUpdate();
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void recherche_histo (String tel) {
        
        String sql = "select ref_rec_tt,date_rec_tt,date_etat,objet from rec_tt where tel_adsl LIKE '%"+tel+"%' order by ref_rec_tt asc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo,stop =null;
                String objet,id;
                      histo  =res1.getString("date_rec_tt");
                      stop=res1.getString("date_etat");
                      objet=res1.getString("objet");
                      id=res1.getString("ref_rec_tt");
                rec_tt.insert(histo,stop,objet, tel);
rec_tt.recherche_tel(id);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
     public static void insert (String histo,String stop,String objet,String tel) {
        
        String sql = "update verif SET etat_cnx= '"+histo+"',stoptime='"+stop+"',modif='"+objet+"' where tel_adsl LIKE '%"+tel+"%'";
        ResultSet res1=null;
        
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
