/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import connexion.connection_Stock;
import connexion.connection_historadius;
import connexion.connection_radius;
import initiationjee.SSHConnectionJava1av3;
import initiationjee.SSHConnectionJava1ava1;
import initiationjee.SSHConnectionJava3;
import initiationjee.clear_1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author serv-web
 */
public class per_cnx {

    connection_radius con_radius;
   connection_Stock conn;
   connection_historadius con_histo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String sql = "select * from verif ";
        ResultSet res;
        int i = 0;
        try {
            PreparedStatement ps = connection_Stock.getConnection().prepareStatement(sql);
            res = ps.executeQuery();
            while (res.next()) {
                String tel;
                tel=res.getString("tel_adsl");
                System.out.println(tel);
            //String tel1=Integer.toString(tel);
            
               clear_interface(tel);
                
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
                
per_cnx.recherche_histo(mac,tel);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void recherche_histo (String mac,int tel) {
        
        String sql = "select acctstarttime from radacct where username= '"+mac+"' order by radacctid asc limit 1 ";
        ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
            res1 = ps.executeQuery();
            while (res1.next()) {
                String histo,stop =null;
                      histo  =res1.getString("acctstarttime");
                      
                per_cnx.insert(histo, tel);

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
     public static void clear_interface(String mac) {
        String m;
        String k=null;
        
        String vi=null;
        
        initiationjee.SSHConnectionJava ssh3 = new initiationjee.SSHConnectionJava();
        k = ssh3.sh(mac);
        if (k==null){
        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
        k = ssh4.sh(mac);}
        
        int i =k.length();
        for(int j=4 ;j<i;j++){
        char s=k.charAt(j);
        char a=' ';
       
         if (s==a){
             i=j;
              vi=k.substring(0, j);
         }
        }
        
        vi=vi.replace("Vi", "");
        System.out.println("clear inter ok");
        SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
        m = ssh.sh(vi);
        SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
        m = ssh1.sh(vi);

      

		
    }
}
