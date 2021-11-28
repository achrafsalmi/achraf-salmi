/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
/**
 *
 * @author serv-web
 */
public class fmondat_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test_command test = new test_command();
        test.initSession();
        String RIBD="1253632583";
        RIBD=RIBD+" ";
        String l;
        System.out.println(RIBD);
        System.out.println(RIBD.length());
        int i=25-RIBD.length();
        
        System.out.println(i);
        if (RIBD.length()<20){
        RIBD=RIBD+" ";
        }
        Format f=new SimpleDateFormat("dd/MM/yyyy");
        String strTime = f.format(new Date());
        System.out.println(strTime);
        l=test.runCommand("echo 'DEBUT FICHIER I2S "+strTime+"'>/home/serv-web/Documents/virm/FMONDAT ");
        l=test.runCommand("echo 'D"+RIBD+"'>>/home/serv-web/Documents/virm/FMONDAT");
        System.out.println(l);
        test.disconnectSession();
    }
    
}
