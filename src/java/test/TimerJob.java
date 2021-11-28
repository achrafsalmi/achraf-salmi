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
import initiationjee.SSHConnectionJava1av3;
import initiationjee.SSHConnectionJava1ava1;
import initiationjee.SSHConnectionJava3;
import initiationjee.clear_1;
import initiationjee.dao.persImpli;
import java.text.SimpleDateFormat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerJob {
    public void test (String n){
String m;
        String k=null;
       
        String vi=null;
        
        initiationjee.SSHConnectionJava ssh3 = new initiationjee.SSHConnectionJava();
        k = ssh3.sh(n);
        if (k==null){
        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
        k = ssh4.sh(n);}
        
        int i =k.length();
        for(int j=4 ;j<i;j++){
        char s=k.charAt(j);
        char a=' ';
       
         if (s==a){
             i=j;
              vi=k.substring(0, j);
         }
        }
        
        vi=vi.replace("Vi", "");
        SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
        m = ssh.sh(vi);
        SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
        m = ssh1.sh(vi);

      

		// TODO Auto-generated method stub
        ///////////////
        /*PrintWriter aff=resp.getWriter();
         String nom=req.getParameter("nom");
		
         aff.println("votre nom est : "+nom);
         resp.sendRedirect("affichage.jsp");*/
		/////////////////////////////////
		//n varialble pour prandre les parametre 
        //String n =req.getParameter("nom");
        //donnee un nom pour l'attribue
        //req.setAttribute("name", n);
        //redirection ver la page conserner 
        //req.getRequestDispatcher("affichage.jsp").forward(req, resp);
    }
 public static void main(String[] args) {
        ScheduledExecutorService scheduler
                            = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new Runnable() {
             String k="283B82DA72E7",test= null;
            public void run() {
             // Task
                
                
                    initiationjee.SSHConnectionJava ssh = new initiationjee.SSHConnectionJava();
        test = ssh.sh(k);
        System.out.println(test);
        if (test==null){
          clear_1 kl = new clear_1();
          kl.clear_interface(k); 
        
        }else {
            System.out.println("pas PB");
                }
            }
            
                    };
 
        int delay = 5;
        scheduler.scheduleAtFixedRate(task, delay,50 ,TimeUnit.SECONDS);
       // scheduler.shutdown();
    }
}
