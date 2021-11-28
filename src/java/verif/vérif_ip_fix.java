/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verif;

import connexion.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author serv-web
 */
public class vérif_ip_fix {
    //vérification si mac existante 
    //retour 0 inexistant 1 existe
    public int verif(String mac){
        int i=0;
        System.out.println(mac);
      String k=recherche_ip_fix(mac);
        System.out.println(k);
        if (k!=null){
            i=1;
        }
        return i;
    
    }
    //recherche dans la base de donnée 
    //table : client_ipfix
    //recherche par @ mac 
    public String recherche_ip_fix(String mac){
        connection conn = null;
        String i=null;
        String sql = "select mac from client_ipfix where mac like '%"+mac+"%'";
        ResultSet res;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {

                i = res.getString("mac");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }
    //test main vérification d'exstence de ip fix
    public static void main(String[] args) {
        vérif_ip_fix k=new vérif_ip_fix();
        int i=k.verif("180F76CFCEE0");
        System.out.println(i);
    }
}

