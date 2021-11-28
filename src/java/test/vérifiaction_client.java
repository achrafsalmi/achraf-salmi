/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import connexion.connection;
import connexion.connection_radius;
import dao.stock.persImpli2;
import initiationjee.SSHConnectionJava1ava1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.personne;

/**
 *
 * @author serv-web
 */
public class vérifiaction_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ajout_verf();
    }
   public static void ajout_verf(){ 
       connexion.connection conn=null;
       String m=null;
       String l=null;
       String d=null;
       String j=null;
       String sql = "select * from verification_client";
        ResultSet res=null;
        List<personne> perso = new ArrayList<personne>();
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery(sql);
             while (res.next()) {
                 
                 String k=  res.getString("tel_adsl");
                 String o=  res.getString("id");
                 int b=Integer.parseInt(k);
         persImpli2 login = new persImpli2();
         d=login.rech_login(b);
         
         initiationjee.SSHConnectionJava ssh = new initiationjee.SSHConnectionJava();
        m= ssh.sh(d);
                                j="LNS ouardia"+m;
                                if (m == null || m.isEmpty()) {
                                    SSHConnectionJava1ava1 ss = new SSHConnectionJava1ava1();
                                    m = ss.sh(d);
                                    j="LNS bélvédére"+m;
                                }
                                if(j.contains("Vi2.")){
                                   
                                   j="client est connecté";
                                    
                                }else{
                                   j="client n'est pas connecté";
                                   
                                   
                                } 
         System.out.println(d);
         System.out.println(m);
         connection_radius conn1 = null;
            String sql1 = "select * from radacct WHERE `username` LIKE '%"+d+"%'";
         ResultSet res1 = null;

        try {
      
            PreparedStatement ps = conn1.getConnection().prepareStatement(sql1);
           
            res1 = ps.executeQuery(sql1);
            while (res1.next()) {
                
      l=  res1.getString("acctuniqueid");
     
}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

String sql5 = "INSERT INTO  `ajout vérification` (`tesl_adsl`, `etat historique`, `etat connexion`) VALUES("+k+","+l+","+j+")";
try {
            PreparedStatement ps5 = conn.getConnection().prepareStatement(sql5);
            
            System.out.println(sql5);
           
            int test = ps5.executeUpdate();
		System.out.println(test);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                        }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    
       
   }
   
   public static void ajout(String a,String b,String c){
   connexion.connection conn=null;
    
        String sql5 = "INSERT INTO  `ajout vérification` (`tesl_adsl`, `etat historique`, `etat connexion`) VALUES("+c+","+b+","+a+")";
        
        try {
            PreparedStatement ps5 = conn.getConnection().prepareStatement(sql5);
            
            
            int test = ps5.executeUpdate();
		System.out.println(test);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   }
}
