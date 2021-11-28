/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class Accueil {

    String login;
    String mdp;
 ResultSet res=null;
    public Accueil(String log, String mp) {
        this.login = log;
        this.mdp = mp;
    }

    public int verifgroup() {
       
        cnx c = new cnx();
        
        int group = 0;
        res = c.execR("select Matricule,Mpasse,id_group from user;");
        try {
            while (res.next()) {
                if (login.equals(res.getString("Matricule")) && mdp.equals(res.getString("Mpasse"))) {

                    switch (res.getInt("id_group")) {
                        case 1:
                            group = 1;
                            break;
                        case 2:
                            group = 2;
                            break;
                        case 3:
                            group = 3;
                            break;
                        case 4:
                            group = 4;
                            break;
                        case 5:
                            group = 5;
                            break;
                        default:
                            group = 7;
                            break;
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }

}
