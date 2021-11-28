/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import RECTT.sqlrectt;
import WFTT.sqlwftt;
import connexion.connection_radius;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import verif.verif_fact_RM;
import verif.verif_rad_MG;

/**
 *
 * @author serv-web
 */
public class testtableautechnique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String tel_adsl = "70665051";
        sqlwftt.recherche(tel_adsl);
        System.out.println("wftt");
        sqlrectt.recherche(tel_adsl);
        System.out.println("recTT");
        recherche_tel(tel_adsl);
        System.out.println("radius");
        recherche_histo(tel_adsl);
        System.out.println("histo");
    }

    public static String recherche_tel(String tel) {

        String sql = "select Login,Nom from Bee_net_tn where telephone=" + tel + "";
         String mac = null;
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                
                mac = res1.getString("Login");
                System.out.println(mac);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mac;

    }
    public static String recherche_histo(String mac) {

        String sql = "select acctstarttime,acctstoptime from radacct where username= '" + mac + "' order by radacctid desc limit 1 ";
        ResultSet res1;
        String s=null;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo, stop ;
                histo = res1.getString("acctstarttime");
                stop = res1.getString("acctstoptime");
                s=(histo+"-->"+stop);
                System.out.println(histo+"-->"+stop);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;

    }

}
