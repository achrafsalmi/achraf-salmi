/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initiationjee.dao;

/**
 *
 * @author serv-web
 */
public class sana_hekp {
  int id;
  String tel;
  String debut;
  String fin;
  String etat;
   String status;
    String last;
    @Override
    public String toString() {
        return "sana_hekp{" + "id=" + id + ", tel=" + tel + ", debut=" + debut + ", fin=" + fin + ", etat=" + etat + ", status=" + status + ", last=" + last + '}';
    }


    public void setId(int id) {
        this.id = id;
    }

    public sana_hekp() {
        this.id = id;
        this.tel = tel;
        this.debut = debut;
        this.fin = fin;
        this.etat = etat;
        this.status = status;
        this.last = last;
    }

    public sana_hekp(int id, String tel, String debut, String fin, String etat, String status, String last) {
        this.id = id;
        this.tel = tel;
        this.debut = debut;
        this.fin = fin;
        this.etat = etat;
        this.status = status;
        this.last = last;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLast(String last) {
        this.last = last;
    }
 

    public int getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public String getDebut() {
        return debut;
    }

    public String getFin() {
        return fin;
    }

    public String getEtat() {
        return etat;
    }

    public String getStatus() {
        return status;
    }

    public String getLast() {
        return last;
    }
 
  
}
