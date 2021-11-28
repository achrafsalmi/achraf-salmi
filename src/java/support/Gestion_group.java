/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

/**
 *
 * @author steg
 */
public class Gestion_group {

    public void sudate(String idg, String nomg) {
        String res = null;
        cnx c = new cnx();
        res = c.insertest("insert into user_group (id_group,nom_group) values ('" + idg + "','" + nomg + "')");

    }

    public void supprimer(String Id) {
        String res = null;
        cnx c = new cnx();
        res = c.insertest("DELETE FROM `user_group` WHERE `user_group`.`id_group` ='" + Id + "' ");

    }

}
