/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiationjee;

/**
 *
 * @author serv-web
 */


import initiationjee.dao.persImpli;
import java.text.SimpleDateFormat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerJob {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new Runnable() {
            int ip21 = 0;

            public void run() {
                // Task
                persImpli rect = new persImpli();
                rect.susp_automatique();
                System.out.println("ok");

            }

        };

        int delay = 5;
        scheduler.scheduleAtFixedRate(task, delay, 20, TimeUnit.SECONDS);
        // scheduler.shutdown();
    }
}
