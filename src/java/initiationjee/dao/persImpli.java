


package initiationjee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.connection;
import dao.stock.persImpli2;
import initiationjee.ExcelReading;
import initiationjee.SSHConnectionJava;
import initiationjee.SSHConnectionJava1av3;
import initiationjee.SSHConnectionJava1ava1;
import initiationjee.SSHConnectionJava3;
import initiationjee.com_reactivation;
import initiationjee.rad_java;
import initiationjee.rad_rec;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.client_easy_bo;
import model.ip;
import model.personne;
import model.status_cnx;
import org.apache.commons.lang3.StringUtils;

public class persImpli implements persInterface {

    connection conn;

    @Override
    public void updpers(int p1, int p2) {
        String sql = "update IP set ip1=?,ip2=?";
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, p1);
            ps.setInt(2, p2);
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
    public int rechip1() {

        String sql = "select * from IP";
        ResultSet res;
        int i = 0, j = 0;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {

                i = res.getInt("ip1");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public int rechip2() {
        String sql = "select * from IP";
        ResultSet res;
        int i = 0, j = 0;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {

                j = res.getInt("ip2");

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return j;
    }

    public String susp(String n, String mac) {
        String m;
        String vi = null;

        Connection connection;
        Statement statement;

        // R�cup�ration des donn�es depuis le fichier excel
        String nb = null;
        int i, j;
        connection con = new connection();
        String msg = "";
        persImpli rech = new persImpli();
        i = rech.rechip1();
        j = rech.rechip2();

        rad_rec ssh5 = new rad_rec();
        ssh5.initSession();
        if (i >= 254) {
            i = 1;
            j = j + 1;
        } else if (i <= 254) {
            i = i + 1;
        }
        int o = Integer.parseInt(n);
        persImpli2 login = new persImpli2();
        mac = login.rech_login(o);
        SSHConnectionJava ssh3 = new SSHConnectionJava();
        com_reactivation test = new com_reactivation();

        test.initSession();
        nb = test.runCommand("nl /etc/freeradius/users |grep " + mac + " |awk '{print $1}'");
        test.disconnectSession();
        persImpli update = new persImpli();
        if (nb == null) {
            //déclaration 
            String b3 = "" + n + "\n";
            String b22 = "" + mac + "              Auth-Type := CHAP\n";
            String b23 = "Service-Type = Framed,";
            String b24 = "Framed-Protocol = PPP,\n";
            String b25 = "Framed-IP-Address = 10.100." + j + "." + i + ",\n";
            String b26 = "Framed-IP-Netmask = 255.255.255.255\n";
//ajout in users
            m = ssh5.runCommand1("sed -i '1i#" + b3 + "'   /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '2i" + b22 + "'   /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '3i\\              \\" + b23 + "' /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '4i\\              \\" + b24 + "' /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '5i\\              \\" + b25 + "' /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '6i\\               \\" + b26 + "' /etc/freeradius/users ");
//ajout in users ~
            m = ssh5.runCommand1("sed -i '1i#" + b3 + "'   /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '2i" + b22 + "'   /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '3i\\              \\" + b23 + "' /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '4i\\              \\" + b24 + "' /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '5i\\              \\" + b25 + "' /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '6i\\               \\" + b26 + "\n' /etc/freeradius/users~ ");
            ssh5.disconnectSession();

            update.updpers(i, j);
            rad_java ssh6 = new rad_java();
            m = ssh6.sh(mac);

            String g;
            String k = null;

            k = ssh3.sh(mac);
            if (k == null) {
                SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
                k = ssh4.sh(mac);
            }
            if (k != null) {
                int l = k.length();
                for (int l1 = 4; l1 < l; l1++) {
                    char s = k.charAt(l1);
                    char a = ' ';

                    if (s == a) {
                        l = l1;
                        vi = k.substring(0, l1);
                    }
                }
                vi = vi.replace("Vi", "");
                SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
                g = ssh.sh(vi);
                SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
                g = ssh1.sh(vi);
                msg = "suspension ok";
                update.ajout_coupure(n, vi + msg);
            } else {
                msg = "client n'est pas connecté";
                update.ajout_coupure(n, msg);
            }
        } else {
            msg = "client est déja suspendu";
            update.ajout_coupure(n, msg);
        }
        return msg;

    }

    @Override
    public void susp_automatique() {

        String sql = "select * from coupure";
        ResultSet res;
        String mac = null, tel = null;
        String n = null;
        String nb = null;
        String m = null;
        String msg = null;
        String g;
        String k = null;
        String vi = null;
        String d, d1 = null;
        List<String> v_i = new ArrayList<String>();
        List<String> tel_adsl = new ArrayList<String>();
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            persImpli update = new persImpli();
            try {
                while (res.next()) {

                    persImpli rech = new persImpli();
                    mac = res.getString("type");
                    tel = res.getString("tel_adsl");
                    com_reactivation test1 = new com_reactivation();

                    test1.initSession();
                    nb = test1.runCommand("nl /etc/freeradius/users |grep " + tel + " |awk '{print $1}'");
                    test1.disconnectSession();
                    System.out.println(nb);
                    if (mac.equals("1") && nb == null) {
                        int i = rech.rechip1();
                        int j = rech.rechip2();

                        rad_rec ssh5 = new rad_rec();
                        ssh5.initSession();
                        if (i >= 254) {
                            i = 1;
                            j = j + 1;
                        } else if (i <= 254) {
                            i = i + 1;
                        }
                        int o = Integer.parseInt(tel);
                        persImpli2 login = new persImpli2();
                        mac = login.rech_login(o);
                        SSHConnectionJava ssh3 = new SSHConnectionJava();
                        com_reactivation test = new com_reactivation();

                        test.initSession();
                        nb = test.runCommand("nl /etc/freeradius/users |grep " + mac + " |awk '{print $1}'");
                        test.disconnectSession();
                        //déclaration 
                        String b3 = "" + tel + "\n";
                        String b22 = "" + mac + "              Auth-Type := CHAP\n";
                        String b23 = "Service-Type = Framed,";
                        String b24 = "Framed-Protocol = PPP,\n";
                        String b25 = "Framed-IP-Address = 10.102." + j + "." + i + ",\n";
                        String b26 = "Framed-IP-Netmask = 255.255.255.255\n";
//ajout in users
                        m = ssh5.runCommand1("sed -i '1i#" + b3 + "'   /etc/freeradius/users ");
                        m = ssh5.runCommand1("sed -i '2i" + b22 + "'   /etc/freeradius/users ");
                        m = ssh5.runCommand1("sed -i '3i\\              \\" + b23 + "' /etc/freeradius/users ");
                        m = ssh5.runCommand1("sed -i '4i\\              \\" + b24 + "' /etc/freeradius/users ");
                        m = ssh5.runCommand1("sed -i '5i\\              \\" + b25 + "' /etc/freeradius/users ");
                        m = ssh5.runCommand1("sed -i '6i\\               \\" + b26 + "' /etc/freeradius/users ");
//ajout in users ~
                        m = ssh5.runCommand1("sed -i '1i#" + b3 + "'   /etc/freeradius/users~ ");
                        m = ssh5.runCommand1("sed -i '2i" + b22 + "'   /etc/freeradius/users~ ");
                        m = ssh5.runCommand1("sed -i '3i\\              \\" + b23 + "' /etc/freeradius/users~ ");
                        m = ssh5.runCommand1("sed -i '4i\\              \\" + b24 + "' /etc/freeradius/users~ ");
                        m = ssh5.runCommand1("sed -i '5i\\              \\" + b25 + "' /etc/freeradius/users~ ");
                        m = ssh5.runCommand1("sed -i '6i\\               \\" + b26 + "\n' /etc/freeradius/users~ ");

                        update.updpers(i, j);
                        rad_java ssh6 = new rad_java();
                        m = ssh6.sh(mac);

                        try {

                            k = ssh3.sh(mac);
                            if (k == null) {
                                SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
                                k = ssh4.sh(mac);
                            }
                            System.out.println(k);
                            //if((k!=null)&&(k.indexOf("VI")==-1)){
                            int l = k.length();
                            for (int l1 = 4; l1 < l; l1++) {
                                char s = k.charAt(l1);
                                char a = ' ';

                                if (s == a) {
                                    l = l1;
                                    vi = k.substring(0, l1);
                                }
                            }
                            if (vi != null) {
                                vi = vi.replace("Vi", "");
                                vi = vi.replaceAll(" ", "");
                                vi = StringUtils.chomp(vi);
                                v_i.add(vi);
                                tel_adsl.add(tel);
                                update.ajout_coupure(tel, "client n'est pas connecter" + mac);
                                sup_rectivation(tel);
                            } else {
                                update.ajout_coupure(tel, "client n'est pas connecter" + mac);
                                sup_rectivation(tel);
                            }
                            ssh5.disconnectSession();
                            msg = "suspension ok";
                            update.ajout_coupure(tel, vi + msg + mac);
                            //      }else{
                            //   System.out.println("erreur client");
                            //  }
                        } catch (Exception ex) {
                            // TODO Auto-generated catch block
                            update.ajout_coupure(tel, "client n'est pas connecter" + mac);
                            sup_rectivation(tel);
                        }

                    } else if (mac.equals("2")) {
                        rad_rec ssh5 = new rad_rec();
                        ssh5.initSession();

                        int o = Integer.parseInt(tel);
                        persImpli2 login = new persImpli2();
                        mac = login.rech_login(o);
                        SSHConnectionJava ssh3 = new SSHConnectionJava();
                        com_reactivation test = new com_reactivation();
                        System.out.println("rect");
                        System.out.println(o);
                        test.initSession();
                        nb = test.runCommand("nl /etc/freeradius/users |grep " + mac + " |awk '{print $1}'");
                        System.out.println(nb);
                        if (nb != null) {
                            String nb1 = nb.replaceAll("\n", "");
                            int i = Integer.parseInt(nb1);

                            int ll1 = i - 1;
                            int ll2 = i + 4;
                            d = test.runCommand("sed -i -e '" + ll1 + "," + ll2 + " d' /etc/freeradius/users");

                            //------
                            d1 = test.runCommand("sed -i -e '" + ll1 + "," + ll2 + " d' /etc/freeradius/users~");

                            test.disconnectSession();

                            rad_java ssh6 = new rad_java();
                            m = ssh6.sh(mac);
                            try {
                                k = ssh3.sh(mac);
                                System.out.println("lns Wardia");
                                System.out.println(k);
                                if (k == null) {
                                    SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
                                    k = ssh4.sh(mac);
                                    System.out.println("lns bel");
                                    System.out.println(k);

                                }
                                System.out.println(k);
                                System.out.println(k.indexOf("Vi"));

                                int l = k.length();
                                System.out.println(l);
                                for (int l1 = 4; l1 < l; l1++) {
                                    char s = k.charAt(l1);
                                    char a = ' ';
                                    System.out.println(s);
                                    if (s == a) {
                                        l = l1;
                                        vi = k.substring(0, l1);
                                    }
                                }
                                if (vi != null) {
                                    vi = vi.replace("Vi", "");
                                    vi = vi.replaceAll(" ", "");
                                    vi = StringUtils.chomp(vi);
                                    v_i.add(vi);
                                    tel_adsl.add(tel);
                                    update.ajout_coupure(tel, "réactivation ok");
                                    sup_rectivation(tel);
                                } else {
                                    update.ajout_coupure(tel, "client n'est pas connecter");
                                    sup_rectivation(tel);
                                }
                                ssh5.disconnectSession();
                            } catch (Exception ex) {
                                // TODO Auto-generated catch block
                                update.ajout_coupure(tel, "client n'est pas connecter");
                                sup_rectivation(tel);
                            }

                        } else {
                            update.ajout_coupure(tel, "client non suspendu");
                            sup_rectivation(tel);
                        }
                    }
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        ///-------------------------////
        persImpli update = new persImpli();

        for (int i = 0; i < v_i.size(); i++) {
            vi = v_i.get(i);
            tel = tel_adsl.get(i);

            SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
            m = ssh.sh(vi);
            SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
            m = ssh1.sh(vi);

            /* int j=  login_user.clear();*/
            System.out.println(vi);
            System.out.println(m);
            sup_rectivation(tel);
            msg = "réactivation ok";
            update.ajout_coupure(tel, vi + msg);
        }
        sup_rectivation(tel);
        /* try {
         /* PreparedStatement ps1 = conn.getConnection().prepareStatement("TRUNCATE coupure");
         res = ps1.executeQuery();
         } catch (SQLException ex) {
         Logger.getLogger(persImpli.class.getName()).log(Level.SEVERE, null, ex);
         }*/

    }

    @Override
    public void ajout_coupure(String n, String m) {
        String sql = "INSERT INTO `liste copure`(`tel_adsl`, `statut`) VALUES (?,?)";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, n);
            ps.setString(2, m);
            res = ps.executeUpdate();
            System.out.println("ajout ok ");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void ajout_action_radius(String agent, String action, String tel_adsl, String date, String Nom, String Login, String value, String CIN, String IPADDRESS, String groupname) {
        String sql = "INSERT INTO `action_radius`(`agent`,`action`,`tel_adsl`,`Date`,`Nom`,`Login`,`value`,`CIN`,`IPADDRESS`,`groupname`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, agent);
            ps.setString(2, action);
            ps.setString(3, tel_adsl);
            ps.setString(4, date);
            ps.setString(5, Nom);
            ps.setString(6, Login);
            ps.setString(7, value);
            ps.setString(8, CIN);
            ps.setString(9, "");
            ps.setString(10, groupname);
            res = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("ajout action");
        }

    }

    @Override
    public void ajout_vi(String tel, String vi) {
        String sql = "INSERT INTO `VI`(`tel`, `vi`) VALUES (?,?)";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, tel);
            ps.setString(2, vi);
            res = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void delet_coupure(String n) {
        String sql = "DELETE FROM `liste copure` WHERE `tel_adsl`=?";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, n);

            res = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet affpresonne() {

        String sql = "select * from liste_action";
        ResultSet res = null;
        List<personne> perso = new ArrayList<personne>();
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;

    }

    @Override
    public int login_user(String login, String mdp) {
        String sql = "SELECT * FROM `user` WHERE `matricule` LIKE '%" + login + "%' ";
        ResultSet res=null;
        int i = 0;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {
                if (mdp.equals(res.getString("Mpasse"))) {
                    i = res.getInt("id_group");

                } else {
                    i = 0;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public int rech_user(String login) {
        String sql = "SELECT * FROM `user` WHERE `matricule` LIKE '%" + login + "%' ";
        ResultSet res;
        String log, mdp, nom;
        int i = 0;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            while (res.next()) {
                log = res.getString("matricule");
                mdp = res.getString("Mpasse");
                nom = res.getString("Nom");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return i;
    }

    public void clear_interface(String mac) {
        String m;
        String k = null;

        String vi = null;

        SSHConnectionJava ssh3 = new SSHConnectionJava();
        k = ssh3.sh(mac);
        if (k == null) {
            SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
            k = ssh4.sh(mac);
        }
        System.out.println(k);
        int i = k.length();
        for (int j = 4; j < i; j++) {
            char s = k.charAt(j);
            char a = ' ';
            System.out.println(s);
            if (s == a) {
                i = j;
                vi = k.substring(0, j);

            }
        }

        vi = vi.replace("Vi", "");

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

    @Override
    public int clear() {
        String sql = "select mac,tel_adsl from coupure";
        ResultSet res;
        String mac = null, tel = null;
        String n = null;
        String nb = null;
        String m = null;
        String msg = null;
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            persImpli update = new persImpli();
            try {
                while (res.next()) {

                    persImpli rech = new persImpli();
                    mac = res.getString("mac");
                    tel = res.getString("tel_adsl");
                    rad_rec ssh5 = new rad_rec();
                    ssh5.initSession();
                    int o = Integer.parseInt(tel);
                    persImpli2 log = new persImpli2();
                    mac = log.rech_login(o);
                    System.out.println(mac);
                    SSHConnectionJava ssh3 = new SSHConnectionJava();
                    rad_java ssh6 = new rad_java();
                    m = ssh6.sh(mac);
                    System.out.println(m);
                    clear_interface(mac);
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        /* try {
         PreparedStatement ps1 = conn.getConnection().prepareStatement("TRUNCATE coupure");
         res = ps1.executeQuery();
         } catch (SQLException ex) {
         Logger.getLogger(persImpli.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        return 1;
    }

    @Override
    public void ver_client() {

        String sql = "select tel_adsl,type from reactivation";
        //String sql2 = "DELETE FROM `reactivation` WHERE `tel_adsl`=?";
        ResultSet res;
        String mac = null, tel = null;
        String n = null;
        String nb = null;
        String m, d, d1 = null;
        String msg = null;
        String g;
        String k = null;
        String vi = null;
        List<String> v_i = new ArrayList<String>();
        List<String> tel_adsl = new ArrayList<String>();
        try {
            PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery();
            persImpli update = new persImpli();
            try {
                while (res.next()) {

                    persImpli rech = new persImpli();

                    tel = res.getString("tel_adsl");
                    String type = res.getString("type");
                    System.out.println(type);
                    if (type.equals("2")) {
                        System.out.println("susp");
                        susp_unique(tel);
                        persImpli rech1 = new persImpli();
                        rech1.sup_rectivation(tel);
                        rad_java ssh6 = new rad_java();
                        m = ssh6.sh(mac);
                        ////////////    
                        SSHConnectionJava ssh3 = new SSHConnectionJava();
                        k = ssh3.sh(mac);
                        if (k == null) {
                            SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
                            k = ssh4.sh(mac);
                            System.out.println(k);
                        }

                        int l = k.length();
                        for (int l1 = 4; l1 < l; l1++) {
                            char s = k.charAt(l1);
                            char a = ' ';

                            if (s == a) {
                                l = l1;
                                vi = k.substring(0, l1);
                            }
                        }
                        if (vi != null) {
                            vi = vi.replace("Vi", "");
                            vi = vi.replaceAll(" ", "");
                            vi = StringUtils.chomp(vi);
                            v_i.add(vi);
                            tel_adsl.add(tel);

                        }
                        update.ajout_coupure(tel, vi);

                    } else {
                        System.out.println(tel);
                        rect_unique(tel);
                        persImpli rech1 = new persImpli();
                        rech1.sup_susp(tel);
                        rad_java ssh6 = new rad_java();
                        m = ssh6.sh(mac);
                        SSHConnectionJava1ava1 ssh4 = new SSHConnectionJava1ava1();
                        k = ssh4.sh(mac);
                        System.out.println(k);
                        if (k == null) {
                            SSHConnectionJava ssh3 = new SSHConnectionJava();
                            k = ssh3.sh(mac);
                            System.out.println(k);
                        }

                        int l = k.length();
                        for (int l1 = 4; l1 < l; l1++) {
                            char s = k.charAt(l1);
                            char a = ' ';

                            if (s == a) {
                                l = l1;
                                vi = k.substring(0, l1);
                            }
                        }
                        if (vi != null) {
                            vi = vi.replace("Vi", "");
                            vi = vi.replaceAll(" ", "");
                            vi = StringUtils.chomp(vi);
                            v_i.add(vi);
                            tel_adsl.add(tel);

                        }
                        update.ajout_coupure(tel, vi);
                    }
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        ///-------------------------////
        persImpli update = new persImpli();

        for (int i = 0; i < v_i.size(); i++) {
            vi = v_i.get(i);
            tel = tel_adsl.get(i);
            SSHConnectionJava1av3 ssh = new SSHConnectionJava1av3();
            m = ssh.sh(vi);
            SSHConnectionJava3 ssh1 = new SSHConnectionJava3();
            m = ssh1.sh(vi);

            /* int j=  login_user.clear();*/
            System.out.println(vi);
            System.out.println(m);

        }

    }

    @Override
    public void ajout_rectivation(String agent, String action, String n, String date, String type) {
        String sql = "INSERT INTO `coupure`(`tel_adsl`,`type`) VALUES (?,?)";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, n);
            ps.setString(2, type);
            res = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ajout_action(agent, action, n, date);
    }

    @Override
    public void ajout_action(String agent, String action, String tel_adsl, String date) {
        String sql = "INSERT INTO `list_action`(`agent`,`action`,`tel_adsl`,`Date`) VALUES (?,?,?,?)";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, agent);
            ps.setString(2, action);
            ps.setString(3, tel_adsl);
            ps.setString(4, date);
            res = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void sup_rectivation(String tel) {
        connection conn = null;
        String sql2 = "DELETE FROM `coupure` WHERE `tel_adsl`=?";
        int res2;
        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql2);
            ps.setString(1, tel);

            res2 = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void sup_susp(String tel) {
        connection conn = null;
        String sql2 = "DELETE FROM `reactivation` WHERE `tel_adsl`=?";
        int res2;
        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql2);
            ps.setString(1, tel);

            res2 = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void susp_unique(String tel) {
        String m;

        Connection connection;
        Statement statement;

        String nb = null;
        int i, j;
        connection con = new connection();
        String msg = "";
        persImpli rech = new persImpli();
        i = rech.rechip1();
        j = rech.rechip2();
        String n = tel;
        String mac = null;
        rad_rec ssh5 = new rad_rec();
        ssh5.initSession();
        if (i >= 254) {
            i = 1;
            j = j + 1;
        } else if (i <= 254) {
            i = i + 1;
        }
        int o = Integer.parseInt(n);
        persImpli2 login = new persImpli2();
        mac = login.rech_login(o);
        SSHConnectionJava ssh3 = new SSHConnectionJava();
        com_reactivation test = new com_reactivation();

        test.initSession();
        nb = test.runCommand("nl /etc/freeradius/users |grep " + mac + " |awk '{print $1}'");
        test.disconnectSession();
        if (nb == null) {
            //déclaration 
            String b3 = "" + n + "\n";
            String b22 = "" + mac + "              Auth-Type := CHAP\n";
            String b23 = "Service-Type = Framed,";
            String b24 = "Framed-Protocol = PPP,\n";
            String b25 = "Framed-IP-Address = 10.100." + j + "." + i + ",\n";
            String b26 = "Framed-IP-Netmask = 255.255.255.255\n";
//ajout in users
            m = ssh5.runCommand1("sed -i '1i#" + b3 + "'   /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '2i" + b22 + "'   /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '3i\\              \\" + b23 + "' /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '4i\\              \\" + b24 + "' /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '5i\\              \\" + b25 + "' /etc/freeradius/users ");
            m = ssh5.runCommand1("sed -i '6i\\               \\" + b26 + "' /etc/freeradius/users ");
//ajout in users ~
            m = ssh5.runCommand1("sed -i '1i#" + b3 + "'   /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '2i" + b22 + "'   /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '3i\\              \\" + b23 + "' /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '4i\\              \\" + b24 + "' /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '5i\\              \\" + b25 + "' /etc/freeradius/users~ ");
            m = ssh5.runCommand1("sed -i '6i\\               \\" + b26 + "\n' /etc/freeradius/users~ ");

            persImpli update = new persImpli();
            update.updpers(i, j);

        }
    }

    @Override
    public void rect_unique(String tel) {
        ResultSet res;
        String mac = null;
        String n = null;
        String nb = null;
        String m, d, d1 = null;
        String msg = null;
        String g;
        String k = null;
        String vi = null;

        rad_rec ssh5 = new rad_rec();
        ssh5.initSession();

        int o = Integer.parseInt(tel);
        persImpli2 login = new persImpli2();
        mac = login.rech_login(o);
        SSHConnectionJava ssh3 = new SSHConnectionJava();
        com_reactivation test = new com_reactivation();
        System.out.println("rect");
        test.initSession();
        nb = test.runCommand("nl /etc/freeradius/users |grep " + mac + " |awk '{print $1}'");
        System.out.println(nb);
        if (nb != null) {
            String nb1 = nb.replaceAll("\n", "");
            int i = Integer.parseInt(nb1);

            int ll1 = i - 1;
            int ll2 = i + 4;
            d = test.runCommand("sed -i -e '" + ll1 + "," + ll2 + " d' /etc/freeradius/users");

            //------
            d1 = test.runCommand("sed -i -e '" + ll1 + "," + ll2 + " d' /etc/freeradius/users~");

            test.disconnectSession();

        }

    }

    @Override
    public int ligne_couppure() {
        String sql = "select count(*) from coupure";
        ResultSet res;
        int i = 0;
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            res = ps.executeQuery();
            try {
                while (res.next()) {
                    i = res.getInt(1);
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public client_easy_bo[] back_office_easy() {
        String sql = "SELECT * FROM easybee where `Identifiant` in (SELECT `Identifiant` FROM easybee GROUP by `Identifiant` HAVING COUNT(*) < 3) AND `Téléphone_Fixe` like '' AND `Statut` LIKE 'Nouveau' AND `ReferenceTT` LIKE '' ";
        ResultSet res;
        int len = 0;
        client_easy_bo[] p = null;
        int i = 1;
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            res = ps.executeQuery();

            try {
                while (res.next()) {
                    ArrayList list = new ArrayList();
                    client_easy_bo l = new client_easy_bo();
                    l.setReferenceTT(res.getString("ReferenceTT"));
                    l.setIntitule_Client(res.getString("Intitule_Client"));
                    l.setIdentifiant(res.getString("Identifiant"));
                    l.setDate_de_naissance(res.getString("Date_de_naissance"));
                    l.setTéléphone_Fixe(res.getString("Téléphone_Fixe"));
                    l.setContact(res.getString("Contact"));
                    l.setOffre(res.getString("Offre"));
                    l.setDebit(res.getString("Debit"));
                    l.setFrequence_De_Paiement(res.getString("Frequence_De_Paiement"));
                    l.setDate_Creation(res.getString("Date_Creation"));
                    l.setVille(res.getString("Ville"));
                    l.setGouvernorat(res.getString("Gouvernorat"));
                    l.setCodeRegion(res.getString("CodeRegion"));
                    l.setAdresse(res.getString("Adresse"));
                    l.setEtape(res.getString("Etape"));
                    l.setStatut(res.getString("Statut"));
                    l.setMotif(res.getString("Motif"));
                    l.setAbonnement_résilié_le(res.getString("Abonnement_résilié_le"));
                    l.setPourcentage(res.getString("Pourcentage"));
                    l.setUtilisateur(res.getString("Utilisateur"));
                    l.setCode_Client(res.getString("Code_Client"));
                    l.setAGENCE_CREATION(res.getString("AGENCE_CREATION"));
                    l.setAGENCE_REVENDEUR(res.getString("AGENCE_REVENDEUR"));
                    l.setAGENCE_LIVRAISON(res.getString("AGENCE_LIVRAISON"));
                    l.setType_Agence(res.getString("Type_Agence"));
                    l.setFacturation_Suspendu(res.getString("Facturation_Suspendu"));
                    l.setLast_upd(res.getString("last_upd"));

                    p[len] = l;
                    len++;
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void affectation_easy(int id, String t) {
        String sql = "UPDATE `easybee_doub` SET `id_agent`=" + id + " WHERE `Code_Abonnement` LIKE '" + t + "'  ";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            //ps.setString(1,"30");
            int test = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void insert_back() {
        String sql = "INSERT INTO `easybee_doub` (SELECT `Code_Abonnement`, `ReferenceTT`, `Intitule_Client`, `Identifiant`, `Date_de_naissance`, `Téléphone_Fixe`, `Contact`, `Offre`, `Debit`, `Frequence_De_Paiement`, `Date_Creation`, `Ville`, `Gouvernorat`, `CodeRegion`, `Adresse`, `Etape`, `Statut`, `Motif`, `Abonnement_résilié_le`, `Pourcentage`, `Utilisateur`, `Code_Client`, `AGENCE_CREATION`, `AGENCE_REVENDEUR`, `AGENCE_LIVRAISON`, `Type_Agence`, `Facturation_Suspendu`, `last_upd`, `id_agent`, `id_traitement`,`dat_cre` FROM easybee where `Identifiant` in (SELECT `Identifiant` FROM easybee GROUP by `Identifiant` HAVING COUNT(*) < 3) AND `Téléphone_Fixe` like '' AND `Statut` LIKE 'Nouveau' AND `ReferenceTT` LIKE '')";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            res = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> select_back(int min, int max,java.sql.Date debut,java.sql.Date fin) {

        String sql = "SELECT `Code_Abonnement` FROM easybee_doub where `dat_cre` BETWEEN ? AND ? AND id_agent IS NULL  limit ?,? ";
        ResultSet res;
        ArrayList list = new ArrayList();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setDate(1, debut);
            ps.setDate(1, fin);
            ps.setInt(3, min);
            ps.setInt(4, max);
            res = ps.executeQuery();

            try {
                while (res.next()) {
                    list.add(res.getString("Code_Abonnement"));
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public client_easy_bo[] back_office_api(int k) {
        String sql = "SELECT * FROM `easybee` WHERE `id_agent` = " + k + "";
        ResultSet res;
        int len = 0;
        client_easy_bo[] p = null;
        int i = 1;
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);

            res = ps.executeQuery();

            try {
                while (res.next()) {
                    ArrayList list = new ArrayList();
                    client_easy_bo l = new client_easy_bo();
                    l.setReferenceTT(res.getString("ReferenceTT"));
                    l.setIntitule_Client(res.getString("Intitule_Client"));
                    l.setIdentifiant(res.getString("Identifiant"));
                    l.setDate_de_naissance(res.getString("Date_de_naissance"));
                    l.setTéléphone_Fixe(res.getString("Téléphone_Fixe"));
                    l.setContact(res.getString("Contact"));
                    l.setOffre(res.getString("Offre"));
                    l.setDebit(res.getString("Debit"));
                    l.setFrequence_De_Paiement(res.getString("Frequence_De_Paiement"));
                    l.setDate_Creation(res.getString("Date_Creation"));
                    l.setVille(res.getString("Ville"));
                    l.setGouvernorat(res.getString("Gouvernorat"));
                    l.setCodeRegion(res.getString("CodeRegion"));
                    l.setAdresse(res.getString("Adresse"));
                    l.setEtape(res.getString("Etape"));
                    l.setStatut(res.getString("Statut"));
                    l.setMotif(res.getString("Motif"));
                    l.setAbonnement_résilié_le(res.getString("Abonnement_résilié_le"));
                    l.setPourcentage(res.getString("Pourcentage"));
                    l.setUtilisateur(res.getString("Utilisateur"));
                    l.setCode_Client(res.getString("Code_Client"));
                    l.setAGENCE_CREATION(res.getString("AGENCE_CREATION"));
                    l.setAGENCE_REVENDEUR(res.getString("AGENCE_REVENDEUR"));
                    l.setAGENCE_LIVRAISON(res.getString("AGENCE_LIVRAISON"));
                    l.setType_Agence(res.getString("Type_Agence"));
                    l.setFacturation_Suspendu(res.getString("Facturation_Suspendu"));
                    l.setLast_upd(res.getString("last_upd"));

                    p[len] = l;
                    len++;
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void supprimer_agent_double() {

       connection conn = null;
        String sql2 = "TRUNCATE TABLE `easybee_doub`";
        int res2;
        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql2);
            

            res2 = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        

    }

    @Override
    public void rein_id_agent() {
        connection conn = null;
        String sql2 = "UPDATE `easybee` SET `id_agent`=null WHERE `id_agent` is not null";
        int res2;
        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql2);
            

            res2 = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    @Override
    public ArrayList<Date> select_date() {
        
        String sql = "SELECT str_to_date(`date_creaction`,'%d/%m/%Y') as date FROM `easybee_doub`";
        ResultSet res;
        ArrayList list = new ArrayList();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            res = ps.executeQuery();

            try {
                while (res.next()) {
                    list.add(res.getDate("date"));
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void inster_date(Date date_easy,String date_easy_1) {
         String sql = "UPDATE `easybee_doub` SET `dat_cre`=? WHERE `Code_Abonnement` = ?";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            java.sql.Date sDate = new java.sql.Date(date_easy.getTime());
            ps.setDate(1, sDate);
            
            ps.setString(2, date_easy_1);
            res = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> select_date_1() {
        String sql = "SELECT `date_creaction` FROM `easybee_doub`";
        ResultSet res;
        ArrayList list = new ArrayList();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            res = ps.executeQuery();

            try {
                while (res.next()) {
                   
                    list.add(res.getString("date_creaction"));
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public ArrayList<String> select_code() {
        String sql = "SELECT `Code_Abonnement` FROM `easybee_doub`";
        ResultSet res;
        ArrayList list = new ArrayList();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            res = ps.executeQuery();

            try {
                while (res.next()) {
                   
                    list.add(res.getString("Code_Abonnement"));
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public ArrayList<sana> select_sana() {
        String sql = "SELECT `id`, `num_fixe`, `offre`, `code`, `lib`, `montant`, `montant2`, STR_TO_DATE(`debut`,\"%d/%m/%y\")as, STR_TO_DATE(`fin`,\"%d/%m/%y\") FROM `sana`";
        ResultSet res;
        ArrayList<sana> list = new ArrayList();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            res = ps.executeQuery();

            try {
                while (res.next()) {
                   sana i=new sana();
                   i.id=res.getInt("id");
                   i.code=res.getString("code");
                   i.debut=res.getString("debut");
                   i.fin=res.getString("fin");
                   i.lib=res.getString("lib");
                   i.montant=res.getString("montant");
                   i.montant2=res.getString("montant2");
                   i.num_fixe=res.getString("num_fixe");
                   i.offre=res.getString("offre");
                   
                    list.add(i);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public ArrayList<sana_hekp> select_sana1(String tel_dsl) {
        String sql = "SELECT * FROM `saanaa` where tel LIKE '"+tel_dsl+"'";
        ResultSet res;
        ArrayList<sana_hekp> list = new ArrayList();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            res = ps.executeQuery();

            try {
                while (res.next()) {
                   sana_hekp i=new sana_hekp();
                   i.id=res.getInt("id");
                   i.tel=res.getString("tel");
                   i.debut=res.getString("debut");
                   i.fin=res.getString("fin");
                   i.etat=res.getString("etat");
                   i.status=res.getString("statut");
                   i.last=res.getString("last");
                   
                    list.add(i);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public ArrayList<String> select_tel_sana() {
        String sql = "SELECT COUNT(*) AS `nb_tel`,`tel` FROM saanaa GROUP BY `tel` HAVING COUNT(*) > 0";
        ResultSet res;
        ArrayList<String> list = new ArrayList();
        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            res = ps.executeQuery();

            try {
                while (res.next()) {
                 String i=null;
                  
                   i=res.getString("tel");
                   
                   
                   
                    list.add(i);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    public void insert(){
    ArrayList<String> tel_fix =new ArrayList();
    tel_fix=select_tel_sana();
    for(int k=0;k<tel_fix.size();k++){
    String tel=tel_fix.get(k);
    ArrayList<sana_hekp> list = new ArrayList();
   list=select_sana1(tel);
        System.out.println(list);
        
       
     String sql = "INSERT INTO `sana1`(`num_fixe`, `help`) VALUES (?,?)";
        int res;

        try {

            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, tel);
            ps.setString(2,  list.toString());
            res = ps.executeUpdate();
            System.out.println("ajout ok ");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    }
}
