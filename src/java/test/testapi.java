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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


import org.apache.http.*;
public class testapi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        
     // URL url=new URL("https://easybo.bee.net.tn:17443/api/RechercheFactImpayees/?_format=json&Identifiant=04540072&NumFix=70665051");
        URL url=new URL("https://41.226.166.25:16443/helpdesk/index.php/Api/clients_list?limit=10_list");
      HttpsURLConnection con =(HttpsURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      
      System.out.println("ok1");
      con.setConnectTimeout(5000);
      System.out.println("ok1");
      int status = con.getResponseCode();
      System.out.println("ok1");
      BufferedReader in = new BufferedReader(
	  new InputStreamReader(con.getInputStream()));
      System.out.println("ok1");
	String inputLine;
	StringBuffer content = new StringBuffer();
        System.out.println("ok1");
	while ((inputLine = in.readLine()) != null) {
	    content.append(inputLine);
            
	}
        System.out.println(content);
        System.out.println("ok1");
	in.close();
        con.disconnect();
    }
    
    
}
