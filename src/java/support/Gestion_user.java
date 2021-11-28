/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

public class Gestion_user {

    public void user(String matricule, String mot_passe, String nom, String idgroup) {
        cnx c = new cnx();

        String sql = "INSERT INTO `user` (`Matricule`,`Mpasse`, `Nom`,`id_group`) VALUES ('" + matricule + "','" + mot_passe + "','" + nom + "','" + idgroup + "' )";
        c.insertest(sql);
    }
    
    public void agent(String Matricule, String Mpasse, String Nom, String Batiment, String Num_B, String Etage) {
        cnx c = new cnx();

        String sql = "INSERT INTO `agent` (`Matricule`,`Batiment`, `Etage`,`Num_B`,`Mpasse`, `Nom`) VALUES ('" + Matricule + "','" + Batiment  + "','" + Etage  + "','" + Num_B + "','" + Mpasse  + "','" + Nom + "')";
        c.insertest(sql);
    }

    public void modifier(String matricule, String mot_passe, String nom, String idgroup) {
        cnx c = new cnx();

        String sql = "UPDATE `user` SET  (`Matricule`,`Mpasse`, `Nom`,`id_group`) VALUES ('" + matricule + "','" + mot_passe + "','" + nom + "','" + idgroup + "' ) where `Matricule` ='" + matricule + "' ";
        c.update(sql);
    }

    public void supprimer(String Id) {

        String res = null;
        cnx c = new cnx();
        res = c.insertest("DELETE FROM `user` WHERE `user`.`id_user` ='" + Id + "' ");

    }

}
