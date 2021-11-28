package initiationjee.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.client_easy_bo;

import model.ip;
import model.personne;
import model.status_cnx;

public interface persInterface {
//public void persajout(personne p);
//personne pour prandre vriable de classe personne 
public int rechip1();
public int rechip2();
public void updpers(int p1,int p2);
public void susp_automatique();
public void ajout_coupure(String n,String m);
public void ajout_vi(String n,String m);
public void delet_coupure(String n);
public ResultSet affpresonne();
public int login_user(String login,String mdp);
public int rech_user(String login);
public int clear();
public void ver_client();
public void ajout_rectivation(String agent,String action,String n, String date,String type);
public void ajout_action(String agent,String action,String tel_adsl, String date);
public void sup_rectivation(String tel);
public void sup_susp(String tel);
public void susp_unique(String tel);
public void rect_unique(String tel);
public void ajout_action_radius(String agent, String action, String tel_adsl, String date,String Nom,String Login,String value,String CIN,String IPADDRESS,String groupname);
public int ligne_couppure();
public client_easy_bo[] back_office_easy();
public void affectation_easy(int id,String t);
public void insert_back();
public ArrayList<String> select_back(int min,int max,java.sql.Date debut,java.sql.Date fin);
public client_easy_bo[] back_office_api(int k);
public void supprimer_agent_double();
public void rein_id_agent();
public ArrayList<Date> select_date(); 
public ArrayList<String> select_date_1(); 
public ArrayList<String> select_code(); 
public ArrayList<sana> select_sana();
public void inster_date(Date date_easy,String date_easy_1);
public ArrayList<sana_hekp> select_sana1(String tel_dsl);
public ArrayList<String> select_tel_sana();
//public List<personne> affprville(String viile);
}
