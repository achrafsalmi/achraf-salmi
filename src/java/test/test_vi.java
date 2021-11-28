/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author serv-web
 */
public class test_vi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String n;
        String vi=null;
        n="Vi2.1826 180F76CFDC70@Bee.n PPPoVPDN - 41.231.12.205 ";
        
        
        int i =n.length();
        for(int j=0 ;j<i;j++){
        char s=n.charAt(j);
        char a=' ';
       
         if (s==a){
             i=j;
              vi=n.substring(2, j);
         }
        }
        System.out.println(vi);
        
    }
    
}
