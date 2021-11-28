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
public class per_histo_ancien1 {

    connection_radius con_radius;
   connection_Stock conn;
   connection_historadius con_histo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String sql = "select from radacct";
        ResultSet res;
        int i = 0;
        String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26,a27 ;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                int tel;
                tel=res.getInt("tel_adsl");
              a1=res.getString("radacctid");
  a2=res.getString("acctsessionid");
  a3=res.getString("acctuniqueid");
  a4=res.getString("username");
  a5=res.getString("groupname");
  a6=res.getString("realm");
  a7=res.getString("nasipaddress");
  a8=res.getString("nasportid");
  a9=res.getString("nasporttype");
  a10=res.getString("acctstatustype");
  a11=res.getString("acctstarttime");
  a12=res.getString("acctstoptime");
  a13=res.getString("acctsessiontime");
  a14=res.getString("acctauthentic");
  a15=res.getString("connectinfo_start");
  a16=res.getString("connectinfo_stop");
  a17=res.getString("acctinputoctets");
  a18=res.getString("acctoutputoctets");
  a19=res.getString("calledstationid");
  a20=res.getString("callingstationid");
  a21=res.getString("acctterminatecause");
  a22=res.getString("servicetype");
  a23=res.getString("framedprotocol");
  a24=res.getString("framedipaddress");
  a25=res.getString("acctstartdelay");
  a26=res.getString("acctstopdelay");
  a27=res.getString("xascendsessionsvrkey");
            String tel1=Integer.toString(tel);
            
                per_histo_ancien1.recherche_tel(tel, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void recherche_tel (int tel,String a1,String a2,String a3,String a4,String a5,String a6,String a7,String a8,String a9,String a10,String a11,String a12,String a13,String a14,String a15,String a16,String a17,String a18,String a19,String a20,String a21,String a22,String a23,String a24,String a25,String a26,String a27) {
        
        String sql = "select Login from Bee_net_tn where telephone="+tel+"";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String mac =null;
                      mac  =res1.getString("Login");
                
per_histo_ancien1.recherche_histo(mac,tel);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void recherche_histo (String mac,int tel) {
        //30_03_18_07_back
        //18_07_01_09_back
        String sql = "select acctstarttime from 30_03_18_07_back where username= '"+mac+"' order by radacctid asc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_historadius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo,stop =null;
                      histo  =res1.getString("acctstarttime");
                      
                per_histo_ancien1.insert(histo, tel);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
     public static void insert (String histo,int tel) {
        
        String sql = "update verif SET etat_cnx= '"+histo+"'where tel_adsl='"+tel+"'";
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
