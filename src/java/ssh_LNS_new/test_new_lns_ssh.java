/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ssh_LNS_new;

/**
 *
 * @author serv-web
 */
public class test_new_lns_ssh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lns_war_cnx lns= new lns_war_cnx();
      String l=  lns.sh("283B82DAAA47");
        System.out.println(l);
        lns_bel_cnx s=new lns_bel_cnx();
        String k=s.sh("283B82DAAA47");
        System.out.println(k);
    }
    
}
