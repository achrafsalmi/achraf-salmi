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
public class ref_to_tel {

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
            
                ref_to_tel.recherche_tel(tel);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void recherche_tel (String tel) {
        
        String sql = "select etat_cnx from verif_wf where tel_adsl LIKE '%"+tel+"%'limit 1";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_Stock.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String mac =null;
                      mac  =res1.getString("etat_cnx");
                
ref_to_tel.insert(mac,tel);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void recherche_histo (String mac,String tel) {
        
        String sql = "select acctstarttime from radacct where username= '"+mac+"' order by radacctid asc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo,stop =null;
                      histo  =res1.getString("acctstarttime");
                      
                ref_to_tel.insert(histo, tel);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
     public static void insert (String histo,String tel) {
        
        String sql = "update verif SET modif= '"+histo+"'where tel_adsl='"+tel+"'";
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
