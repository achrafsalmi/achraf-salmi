package dao.stock;

import initiationjee.dao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.connection_Stock;
import connexion.connection_radius;
import model.ip;

public class persImpli2 implements persInterface {

    connection_Stock conn;
    
    connection_radius con_radius;

    @Override
    public void updpers(int mac, int sn) {
        String sql = "update IP set ip1=?,ip2=?";
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, mac);
            ps.setInt(2, sn);
            int test = ps.executeUpdate();
		//variable qui contient les retour de la requet 
		/*if(test!=0){
             System.out.println("Ajout effectuer avec succ�e");
             }else{
             System.out.println("Erreur d'ajout dans la table");
			
             }
             */
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String rechmac(String s) {
        String sql = "SELECT * FROM `modem` WHERE `SN` LIKE '%" + s + "%'";
        ResultSet res;
        String i = null;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {

                i = res.getString("Mac");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }
    @Override
    public String rechmac_webS(String s) {
        String sql = "SELECT * FROM `modem` WHERE `SN` LIKE '" + s + "'";
        ResultSet res;
        String i = null;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {

                i = res.getString("Mac");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }
    @Override
    public int rechmac_id(String s) {
        String sql = "SELECT id FROM `modem` WHERE `SN` LIKE '" + s + "'";
        ResultSet res;
        int i = 0;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {

                i = res.getInt("id");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public String rechsn(String s) {
        String sql = "SELECT * FROM `modem` WHERE `Mac` LIKE '%" + s + "%'";
        ResultSet res;
        String i = null, j = null;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {

                j = res.getString("SN");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return j;
    }

    @Override
    public String rech_login(int s) {
        String sql = "SELECT * FROM `Bee_net_tn` WHERE `telephone` LIKE '%" + s + "%'";
        ResultSet res;
        String j = null;
        try {
            PreparedStatement ps1 = con_radius.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {

                j = res.getString("Login");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return j;
    }

    @Override
    public void update_radius(String id, String Nom, String telephone, String Login, String value, String groupname, String CIN, String IPADDRESS) {
        String sql = "UPDATE `Bee_net_tn` SET Nom=?,telephone=?,Login=?,value=?,IPADDRESS=?,CIN=?,groupname=? WHERE id=?";
        
        try {
            PreparedStatement ps = con_radius.getConnection().prepareStatement(sql);
            int id1 = Integer.parseInt(id);
            int telephone1 = Integer.parseInt(telephone);
            ps.setString(1, Nom);
            ps.setInt(2, telephone1);
            ps.setString(3, Login);
            ps.setString(4, value);
            ps.setString(5, IPADDRESS);
            ps.setString(6, CIN);
            ps.setString(7, groupname);
            ps.setInt(8, id1);
            
            int test = ps.executeUpdate();
		
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void sup_radius(int id) {
        String sql ="DELETE FROM `Bee_net_tn` WHERE id=?";
        ResultSet res;
        try {
            PreparedStatement ps = con_radius.getConnection().prepareStatement(sql);
            
            ps.setInt(1, id);
           
            
           int i  = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public int verif_radius(String verif) {
         String sql ="select id from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '%"+verif+"%' OR `Login` LIKE '%"+verif+"%' OR `Nom` LIKE '%"+verif+"%' OR `CIN` LIKE '%"+verif+"%'";
        ResultSet res;
        int i=0;
        try {
            PreparedStatement ps = con_radius.getConnection().prepareStatement(sql);
           res  = ps.executeQuery();
           while (res.next()) {
             i=  res.getInt("id");
           }
                   } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return i;
    }
     @Override
    public int verif_radius_par_mac(String verif) {
         String sql ="select id from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `Login` LIKE '"+verif+"'";
        ResultSet res;
        int i=0;
        try {
            
            PreparedStatement ps = con_radius.getConnection().prepareStatement(sql);
           res  = ps.executeQuery();
           while (res.next()) {
             i=  res.getInt("id");
           }
                   } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return i;
    }
    @Override
    public int verif_radius_par_tel(String verif) {
         String sql ="select id from Bee_net_tn WHERE `attribute` NOT LIKE 'Calling-Station-Id' AND `telephone` LIKE '"+verif+"'";
        ResultSet res;
        int i=0;
        try {
            PreparedStatement ps = con_radius.getConnection().prepareStatement(sql);
           res  = ps.executeQuery();
           while (res.next()) {
             i=  res.getInt("id");
           }
                   } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public void ajout_radius(String Nom, int telephone, String Login, String value, String CIN, String groupname) {
        String sql="INSERT INTO `Bee_net_tn`(`Nom`, `telephone`, `Login`, `attribute`, `op`, `value`,`IPADDRESS`,`IPROUTE`, `actif`, `Observation`,`CIN`, `groupname`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    int res=0;
        
        try {
            PreparedStatement ps = con_radius.getConnection().prepareStatement(sql);
           ps.setString(1, Nom);
           ps.setInt(2, telephone);
           ps.setString(3, Login);
           ps.setString(4, "User-Password");
           ps.setString(5, ":=");
           ps.setString(6, value);
           ps.setString(7,"");
           ps.setString(8,"");
           ps.setInt(9, 10);
           ps.setString(10,"");
           ps.setString(11, CIN);
           ps.setString(12, groupname);
           res  = ps.executeUpdate();
           System.out.println("ajout ok");
                   } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String verif_auth(String verif) {
       String sql ="select authdate,reply,raison from radpostauth WHERE  `username` LIKE '%"+verif+"%'";
        ResultSet res;
        String i=null;
        try {
            PreparedStatement ps = connection_radius.getConnection().prepareStatement(sql);
           res  = ps.executeQuery();
           while (res.next()) {
             String k=  res.getString("authdate");
             String j=  res.getString("reply");
             String o=  res.getString("raison");
             i=j+" "+k+" "+o;
           }System.out.println(i);
                   } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return i;
    }
    
}
