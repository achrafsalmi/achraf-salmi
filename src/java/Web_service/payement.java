/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web_service;

import dao.stock.persImpli2;
import initiationjee.com_reactivation;
import initiationjee.dao.persImpli;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author serv-web
 */
public class payement {
    int k=0;
    String log=null;
        String nb=null;
         String mac=null;
   public int pay(String m,String j) {
       
    int o=Integer.parseInt(m);
                 persImpli2 login = new persImpli2();
                 mac=login.rech_login(o);
                 if (!j.isEmpty()){
                     k=1;
                   } else {
    com_reactivation test = new com_reactivation();

        test.initSession();
           nb= test.runCommand("nl /etc/freeradius/users |grep "+ mac +" |awk '{print $1}'");
          test.disconnectSession();
          if ((nb!=null)&&(mac!=null)){
        Connection connection;
        Statement statement;

        // R�cup�ration des donn�es depuis le fichier excel
        

        DateTimeFormatter datetime=DateTimeFormatter.ofPattern("yyy/MM/dd:HH:mm:ss");
        LocalDateTime now =LocalDateTime.now();
        String date=datetime.format(now);
        String action ="reactivation";
        String type="2";
        persImpli rect = new persImpli();
        rect.ajout_rectivation(log,action,m,date,type);
       // rect.ver_client();

       int i= rect.ligne_couppure();
       i=i*30;
       i=i/60;
       k=2;
}else{
              String msg="client n'est pas suspendu";
              k=3;
        
}
                }
        return k;
       } } 
     

