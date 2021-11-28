package test;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static sun.security.krb5.Confounder.bytes;

public class SSHConnectionJava {

	public static void main(String[] args) throws SQLException, IOException {
		String name;
        String email;
        String phone;
        String ID;

        connection con = null ;
        String query = "Insert into NEWSTUDENT values(?,?,?,?)";
               PreparedStatement st = con.getConnection().prepareStatement(query);
                st.executeUpdate(query);        

        try {
            BufferedReader bReader = new BufferedReader(new FileReader("1000rows.csv"));

            while (bReader != null) {
                String read;
                try {
                    read = bReader.readLine();
                    if (read != null) 
                    {
                        String[] array = read.split(",+");
                        for(String result:array)
                        {
                            System.out.println(result);
                        }
                    } 
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                finally
                {
                   if (bReader == null) 
                    {
                        bReader.close();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }}
        

