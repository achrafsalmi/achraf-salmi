/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verif;

import connexion.cnx_radius;
import connexion.connection;
import connexion.connection_Stock;
import connexion.connection_radius;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import test.per_cnx;

/**
 *
 * @author serv-web
 */
public class verif_fact_MG {

    public static void recherche() {
        String sql = "select tel_adsl from 1_cnx_fact_RM ";
        ResultSet res;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                int tel;
                tel = res.getInt("tel_adsl");

                String tel1 = Integer.toString(tel);

                verif_fact_MG.recherche_tel(tel);
                System.out.println(tel);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void recherche_tel(int tel) {

        String sql = "select Login,Nom from Bee_net_tn where telephone=" + tel + "";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String mac = null, Nom = null;
                mac = res1.getString("Login");
                System.out.println(mac);
                verif_fact_MG.recherche_histo(mac, tel);
                verif_fact_MG.recherche_histo_last(mac, tel);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void recherche_histo(String mac, int tel) {

        String sql = "select acctstarttime from radacct where username= '" + mac + "' order by radacctid asc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo, stop = null;
                histo = res1.getString("acctstarttime");

                verif_fact_MG.insert(histo, tel);
                System.out.println(histo);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
        public static void recherche_histo_last(String mac, int tel) {

        String sql = "select acctstarttime from radacct where username= '" + mac + "' order by radacctid desc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo, stop = null;
                histo = res1.getString("acctstarttime");

                verif_fact_MG.insert_last(histo, tel);
                System.out.println(histo);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void insert(String histo, int tel) {

        String sql = "update 1_cnx_fact_RM SET  etat_cnx= '" + histo + "'where tel_adsl='" + tel + "'";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            i = ps.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void insert_last(String histo, int tel) {

        String sql = "update 1_cnx_fact_RM SET  stoptime= '" + histo + "'where tel_adsl='" + tel + "'";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            i = ps.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void vider() {
        String sql = "TRUNCATE 1_cnx_fact_RM";
        ResultSet res;
        int i = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
             ps.execute();
           
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
