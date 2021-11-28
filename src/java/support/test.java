/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class test {
 
    public static void main(String[] args) {
         
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/stgpi","root", "");
            stmt = con.createStatement();
            String query = "UPDATE `reclamation` SET `Acteur` = 'jihed', `Etat` = 'gueleg' WHERE `reclamation`.`Id` = 4250 ;";
            //count will give you how many records got updated
            stmt.executeUpdate(query);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}