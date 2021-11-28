/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verif;

import connexion.cnx_radius;
import connexion.connection;
import connexion.connection_Stock;
import connexion.connection_histo_mois;
import connexion.connection_radius;
import connexion.connection_historadius;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import test.per_cnx;

/**
 *
 * @author serv-web
 */
public class verif_fact_RM {
 
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
                verif_fact_RM.recherche_tel(tel);
                ArrayList<String> rec=verif_fact_RM.recherche_mes(tel);
                verif_fact_RM.insert_mes(rec, tel);
                System.out.println(tel);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//recherche rect accès sana
    /*public static ArrayList<String> recherche_reclamation(int tel_adsl) {
        String sql = "select * from rec_tt where tel_adsl="+ tel_adsl +" ";
        ResultSet res;
        String resultat="";
        int i;
        ArrayList<String> reclamation=new ArrayList<String>();
        ArrayList<String> sujet=new ArrayList<String>();
        int o = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
              
               String objet = res.getString("objet");
String date_etat = res.getString("date_etat");
String etat = res.getString("etat");
String date_rec_tt = res.getString("date_rec_tt");
                //resultat=resultat+"\n"+tel_adsl+"reclamation: "+objet+"date_créaction :"+date_rec_tt+"etat :"+etat+"le :"+date_etat;
reclamation.add(etat);
o=o++;

               

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reclamation;
              
    }*/
    public static ArrayList<String> recherche_reclamation(int tel_adsl) {
        String sql = "select * from rec_tt where tel_adsl="+ tel_adsl +" ";
        ResultSet res;
        String resultat="";
        int i;
        ArrayList<String> reclamation=new ArrayList<String>();
        ArrayList<String> sujet=new ArrayList<String>();
        int o = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
              
               String objet = res.getString("objet");
String date_etat = res.getString("date_etat");
String etat = res.getString("etat");
String date_rec_tt = res.getString("date_rec_tt");
                //resultat=resultat+"\n"+tel_adsl+"reclamation: "+objet+"date_créaction :"+date_rec_tt+"etat :"+etat+"le :"+date_etat;
reclamation.add(etat);
o=o++;

               

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reclamation;
              
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
                verif_fact_RM.recherche_histo(mac, tel);
                verif_fact_RM.recherche_histo_last(mac, tel);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
 public static ArrayList<String> recherche_mes(int tel) {

        String sql = "SELECT * FROM `wf` WHERE `tel_adsl` LIKE '"+tel+"'";
         
        ResultSet res;
        String resultat="";
        int i;
        ArrayList<String> reclamation=new ArrayList<String>();
        int o = 0;
        try {
            PreparedStatement ps = connection.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
              
               String objet = res.getString("date_conf");
               //resultat=resultat+"\n"+tel_adsl+"reclamation: "+objet+"date_créaction :"+date_rec_tt+"etat :"+etat+"le :"+date_etat;
reclamation.add(objet);               
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reclamation;
    }
    public static void recherche_histo(String mac, int tel) {

        String sql = "select framedipaddress,acctstarttime from radacct where username= '" + mac + "' order by radacctid asc limit 1 ";
        // String sql = "select framedipaddress,acctstarttime from 31_08_2019_01_04_back where username= '" + mac + "' order by radacctid asc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
           // PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
           // PreparedStatement ps = connection_historadius.getConnection().prepareStatement(sql);
           // PreparedStatement ps = cnx_radius.getConnection().prepareStatement(sql);
            //PreparedStatement ps = connection_histo_mois.getConnection().prepareStatement(sql);
             PreparedStatement ps = cnx_radius.getConnection().prepareStatement(sql);
            
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo, stop = null;
                histo = res1.getString("acctstarttime");
                stop = res1.getString("framedipaddress");
                verif_fact_RM.insert(histo+"_"+stop, tel);
                System.out.println(histo);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
        public static void recherche_histo_last(String mac, int tel) {

        String sql = "select framedipaddress,acctstarttime from radacct where username= '" + mac + "' order by radacctid desc limit 1 ";
        //String sql = "select framedipaddress,acctstarttime from 31_08_2019_01_04_back where username= '" + mac + "' order by radacctid desc limit 1 ";
       // String sql = "select framedipaddress,acctstarttime from total02-08-2021 where username= '" + mac + "' order by radacctid desc limit 1 ";
        //String sql = "select framedipaddress,acctstarttime from radacct where username= '" + mac + "' order by radacctid desc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
            
          //  PreparedStatement ps = connection_histo_mois.getConnection().prepareStatement(sql);
           // PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
           //PreparedStatement ps = connection_historadius.getConnection().prepareStatement(sql);
           //PreparedStatement ps = connection_historadius.getConnection().prepareStatement(sql);
            PreparedStatement ps = cnx_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo, stop = null;
                histo = res1.getString("acctstarttime");
                stop = res1.getString("framedipaddress");
                verif_fact_RM.insert_last(histo+"_"+stop, tel);
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
        public static void insert_mes(ArrayList<String> mes, int tel) {

        String sql = "update 1_cnx_fact_RM SET  mes_date= '" + mes + "'where tel_adsl='" + tel + "'";
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
