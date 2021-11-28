/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

/**
 *
 * @author as
 */
public class mod_u {

    public void modifier(String matricule, String Mpasse, String nom, String id_group, String id_user) {
        cnx c = new cnx();
        c.update("UPDATE `user` SET `Matricule` = '"+ matricule +"', `Mpasse` = '"+ Mpasse +"', `Nom` = '"+ nom +"', `id_group` = '"+ id_group +"' WHERE `user`.`id_user` ='"+ id_user +"' ;");
    }
}