/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

/**
 *
 * @author E5430
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ajout_g {
    String idg;
    String nomg;
   
    String res = null;

    public ajout_g( String idgr, String nomgr) {
        
        this.idg = idgr;
        
        this.nomg = nomgr;

    }

    public void sudate() {

        cnx c = new cnx();

        res = c.insertest("insert into user_group (id_group,nom_group) values ('" + idg + "','" + nomg +  "')");
    


        
       
   

}
}
