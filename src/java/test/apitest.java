/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
 
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 *
 * @author serv-web
 */
public class apitest {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws Exception {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
        };
 
        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
 
        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
 
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
 
        //URL url = new URL("https://41.231.228.100:16443/helpdesk/index.php/Api/clients_list/?_format=json&limit=1");
       //URL url = new URL(" https://41.231.228.100:16443/helpdesk/index.php/Api/tickets_list?limit=10&code_client=CL22875");
// https://41.226.166.25:16443/helpdesk/index.php/Api/tickets_list?limit=10&code_client=CL22875       
URL url = new URL("https://easybo.bee.net.tn:17443/api/RechercheFactImpayees/?_format=json&Identifiant=04540072&NumFix=70665051");
        
        URLConnection con = url.openConnection();
        Reader reader = new InputStreamReader(con.getInputStream());
        
            BufferedReader in = new BufferedReader(
	  new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer content = new StringBuffer();
	while ((inputLine = in.readLine()) != null) {
	    content.append(inputLine);
           
	}
        System.out.println(content);
            
        }
    }


