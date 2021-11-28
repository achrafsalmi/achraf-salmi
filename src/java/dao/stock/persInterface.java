package dao.stock;

import initiationjee.dao.*;
import java.util.List;

import model.ip;

public interface persInterface {
//public void persajout(personne p);
//personne pour prandre vriable de classe personne 
public String rechmac(String s);
public String rechmac_webS(String s);
public int rechmac_id(String s);
public String rechsn(String s);
public void updpers(int mac,int sn);
public void update_radius(String id,String Nom,String telephone,String Login,String value,String groupname,String CIN,String IPADDRESS);
public String rech_login(int s);
public void sup_radius(int id);
public int verif_radius(String verif);
public int verif_radius_par_mac(String verif);
public int verif_radius_par_tel(String verif);
public void ajout_radius(String Nom,int telephone,String Login,String value,String CIN,String groupname);
public String verif_auth(String verif);

}
