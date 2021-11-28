/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author serv-web
 */
public class test_date {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleDateFormat formater = null;

    Date aujourdhui = new Date();

    formater = new SimpleDateFormat("dd-MM-yy");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("ddMMyy");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("yyMMdd");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("h:mm a");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("K:mm a, z");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("hh:mm a, zzzz");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("EEEE, d MMM yyyy");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("'le' dd/MM/yyyy 'à' hh:mm:ss");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("'le' dd MMMM yyyy 'à' hh:mm:ss");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("dd MMMMM yyyy GGG, hh:mm aaa");
    System.out.println(formater.format(aujourdhui));

    formater = new SimpleDateFormat("yyyyMMddHHmmss");
    System.out.println(formater.format(aujourdhui));
  }
}

    
    

