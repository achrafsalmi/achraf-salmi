/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restart_aplication;

/**
 *
 * @author serv-web
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        restart_com c=new restart_com();
        c.initSession();
        c.runCommand();
        c.disconnectSession();
    }  
}
