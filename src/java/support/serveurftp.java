package support;

import java.io.*;
import java.net.*;

 
public class serveurftp extends Object
{
    /**
     * Si le flag est a true l'on affiche les messages FTP entrant/sortant
     */
    private static boolean PRINT_DEBUG_INFO = false;
 
    /**
     * Le flag défini le type de connection pour les transfers de donnée.
     * 0: Passif (PASV)
     * 1: Actif (PORT)
     */
    private static int CONNECTION_MODE = 0;
 
    /**
     * Le socket avec lequel l'on se connecte
     */
    private Socket connectionSocket = null;
 

 

    private PrintStream outputStream = null;
 
    private BufferedReader inputStream = null;
 
  
 

    
    public serveurftp ()
    {
    	//Constructeur par defaut
    }
 
 
    
    public serveurftp (boolean debugOut,int mode)
    {
    	PRINT_DEBUG_INFO = debugOut;
    	CONNECTION_MODE = mode;
    }
 
 
    /**
     * Affiche les informations de debugging si le flag PRINT_DEBUG_INFO est on.
     */
    private void debugPrint(String message) 
    {
        if (PRINT_DEBUG_INFO) System.err.println(message);
    }
 
 
    /**
     * Se connect au FTP donné sur le port par defaut 21
     */
    public boolean connect(String host)throws UnknownHostException, IOException
    {
        return connect(host, 21);
    }
 
 
    /**
     * Se connect au FTP donné sur le port donné
     */
    public boolean connect(String host, int port)throws UnknownHostException, IOException
    {
        connectionSocket = new Socket(host, port);
        outputStream = new PrintStream(connectionSocket.getOutputStream());
        inputStream = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
 
        
 
        return true;
    }
}
 