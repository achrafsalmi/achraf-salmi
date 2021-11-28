/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restart_aplication;

/**
 *
 * @author serv-web
 */
import test.*;
import initiationjee.dao.persImpli;
import java.text.SimpleDateFormat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class restart_rom_task {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();

        Runnable task = new Runnable() {
            int ip21 = 0;

            public void run() {
                // Task
                restart_com c=new restart_com();
        c.initSession();
        c.runCommand1();
        c.runCommand();
        c.disconnectSession();

            }

        };

        int delay = 5;
        scheduler.scheduleAtFixedRate(task, delay, 21, TimeUnit.HOURS);
        // scheduler.shutdown();
    }
}
