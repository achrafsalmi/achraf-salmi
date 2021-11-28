/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import initiationjee.SSHConnectionJava1ava1;

/**
 *
 * @author serv-web
 */
public class testssh_1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
      SSHConnectionJava1ava1 ssh =new SSHConnectionJava1ava1();
      String s =ssh.sh("F0B4D2131412");
        System.out.println(s);
    }
    
}
