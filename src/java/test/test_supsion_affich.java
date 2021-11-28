/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import initiationjee.com_reactivation;

/**
 *
 * @author serv-web
 */
public class test_supsion_affich {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       com_reactivation test = new com_reactivation();

                        test.initSession();
                        String k = "E01CFC9C3CF3";
                        String nb = null;
                        String susp;

                        nb = test.runCommand("nl /etc/freeradius/users |grep " + k + " |awk '{print $1}'");
                        System.out.println(nb);
    }
    
}
