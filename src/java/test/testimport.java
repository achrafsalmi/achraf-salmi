/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import connexion.connection_Stock;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author serv-web
 */
public class testimport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sql="LOAD DATA LOCAL INFILE '/home/serv-web/Documents/file/verif_client.csv' INTO TABLE stock_modem.verif  FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n' IGNORE 1 LINES (id,tel_adsl,etat_cnx);";
                          ResultSet res1;
        int i = 0;
        try {
            PreparedStatement ps = connection_Stock.getConnection().prepareStatement(sql);
             ps.executeUpdate();
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
