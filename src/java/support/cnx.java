package support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 *
 */
public class cnx {

    Connection con = null;
    Statement requete = null;
    ResultSet resultat = null;

    public Connection connect() throws ClassNotFoundException, SQLException {
        Connection c = null;
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/stgpi", "root", "");
        return c;
    }

    public String insertest(String sql) {
        String b = null;

        try {
            con = this.connect();
            requete = con.createStatement();
            requete.executeUpdate(sql);
        } catch (ClassNotFoundException cnfe) {
            b = "Erreur Driver";
        } catch (SQLException se) {
            b = "erreur database";

        }
        return b;
    }

    public String update(String sql) {

        try {
            con = this.connect();
            requete = con.createStatement();
            requete.executeUpdate(sql);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();

        }
        return null;

    }

    public ResultSet execR(String sql) {

        try {

            con = this.connect();
            requete = con.createStatement();
            return (requete.executeQuery(sql));
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Erreur Driver");
        } catch (SQLException se) {
            System.out.println("erreur database");

        }
        return null;

    }

    public void cnxupd(String sql) {
        try {
            con = this.connect();
            requete = con.createStatement();
            requete.executeUpdate(sql);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Erreur Driver");
        } catch (SQLException se) {
            System.out.println("erreur database");

        }

    }

    public String testcnx() {
        try {
            con = this.connect();
            requete = con.createStatement();
            return ("ok");
        } catch (ClassNotFoundException cnfe) {
            return ("driver");
        } catch (SQLException se) {
            return ("stgpi");

        }
    }
}
