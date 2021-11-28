package support;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class scan {

    /**
     * Ping sur une adresse ip
     *
     * @param Ipv4Adr ip adresse ip du poste
     * @return boolean
     */
    public boolean isAlive(String Ipv4Adr) {
        Process p1;
        boolean reachable = false;
        try {
            p1 = java.lang.Runtime.getRuntime().exec("ping -w 2 -n 2 " + Ipv4Adr);
            int returnVal = p1.waitFor();
            reachable = (returnVal == 0);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(scan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reachable;
    }

    /**
     * @param ip adresse ip du poste
     * @return String
     */
    public String scanPort(String ip) {
        String openPort = "";

        //Port de communication FTP
        if (portIsOpen(ip, 21, 100)) {
            openPort += " FTP";
        }
        //Port standard pour le web, par ex Apache
        if (portIsOpen(ip, 80, 100)) {
            openPort += " Http";
        }
        //Port d'une imprimante
        if (portIsOpen(ip, 515, 100)) {
            openPort += " Printer";
        }
        //Port du serveur MySql
        if (portIsOpen(ip, 3306, 100)) {
            openPort += " MySql";
        }

        return openPort.trim();
    }

    /**
     * Tester l'état du port sur un poste
     *
     * @param ip adresse ip du poste
     * @param port Numero du port
     * @param timeout délai en ms
     * @return port ouvert ou non
     */
    public boolean portIsOpen(String ip, int port, int timeout) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * @param ip adresse ip du poste
     * @return
     * @throws IOException
     */
    public static String getARPTable(String ip) throws IOException {
        String systemInput = "";
//to renew the system table before querying 
        Runtime.getRuntime().exec("arp -a");
        Scanner s = new Scanner(Runtime.getRuntime().exec("arp -a " + ip).getInputStream()).useDelimiter("\\A");
        systemInput = s.next();
        String mac = "";
        NetworkInterface network;
        InetAddress myip = InetAddress.getLocalHost();
        network = NetworkInterface.getByInetAddress(myip);
        Pattern pattern = Pattern.compile("\\s{0,}([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
        Matcher matcher = pattern.matcher(systemInput);
        if (matcher.find()) {
            mac = mac + matcher.group().replaceAll("\\s", "");
        } else {
            byte[] mymac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mymac.length; i++) {
                sb.append(String.format("%02X%s", mymac[i], (i < mymac.length - 1) ? ":" : ""));
                mac = sb.toString();
            }
        }
        return mac;
    }
}
