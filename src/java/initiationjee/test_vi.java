/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiationjee;

import dao.stock.persImpli2;
import initiationjee.dao.persImpli;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import test.*;
import connexion.connection;
import java.util.ArrayList;
import java.util.List;
import model.personne;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author serv-web
 */
public class test_vi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       String sql = "select mac,tel_adsl from coupure";
        ResultSet res;
        String mac = null, tel = null;
         String vi=null;
         List<String>v_i=new ArrayList<String>();
      try {
            PreparedStatement ps1 = connection.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            persImpli update = new persImpli();
            try {
                while (res.next()) {

                    persImpli rech = new persImpli();
                    mac = res.getString("mac");
                    tel = res.getString("tel_adsl");
                    rad_rec ssh5 = new rad_rec();
        ssh5.initSession();
        int o=Integer.parseInt(tel);
                 persImpli2 log = new persImpli2();
                 mac=log.rech_login(o);
                 
       
        String k =null;
        persImpli login_user = new persImpli();
       SSHConnectionJava ssh3 = new SSHConnectionJava();
        k = ssh3.sh(mac);
        if (k==null){
        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
        k = ssh4.sh(mac);}
      int i =k.length();
        for(int j=4 ;j<i;j++){
        char s=k.charAt(j);
        char a=' ';
       System.out.println(s);
         if (s==a){
             i=j;
             vi=k.substring(2, j);
               
         }
        }vi=vi.replace("Vi", "");
        vi=vi.replaceAll(" ", "");
       System.out.println(k);
        vi=StringUtils.chomp(vi);
        v_i.add(vi);
        update.ajout_vi(tel, vi);
        }
                } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }} catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
      
      ////--------------------------------------//--
      
     
       
            persImpli update = new persImpli();
            
              for (int i =0 ; i<v_i.size();i++) { 
                  vi=v_i.get(i);
        SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
       String m = ssh.sh(vi);
        SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
        m = ssh1.sh(vi);
        
     /* int j=  login_user.clear();*/
      
       System.out.println(vi);
       System.out.println(m);
       
      update.ajout_coupure(tel, vi);
      }
        }
            
      
    }



