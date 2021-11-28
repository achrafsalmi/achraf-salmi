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

public class sana {
    int id;
    String num_fixe;
    String offre;
    String code;
    String lib;
    String montant;
    String montant2;
    String debut;

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_fixe(String num_fixe) {
        this.num_fixe = num_fixe;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public void setMontant2(String montant2) {
        this.montant2 = montant2;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public sana(int id, String num_fixe, String offre, String code, String lib, String montant, String montant2, String debut, String fin) {
        this.id = id;
        this.num_fixe = num_fixe;
        this.offre = offre;
        this.code = code;
        this.lib = lib;
        this.montant = montant;
        this.montant2 = montant2;
        this.debut = debut;
        this.fin = fin;
    }
    public sana() {
        this.id = id;
        this.num_fixe = num_fixe;
        this.offre = offre;
        this.code = code;
        this.lib = lib;
        this.montant = montant;
        this.montant2 = montant2;
        this.debut = debut;
        this.fin = fin;
    }

    public String getNum_fixe() {
        return num_fixe;
    }

    public String getOffre() {
        return offre;
    }

    public String getCode() {
        return code;
    }

    public String getLib() {
        return lib;
    }

    public String getMontant() {
        return montant;
    }

    public String getMontant2() {
        return montant2;
    }

    public String getDebut() {
        return debut;
    }

    public String getFin() {
        return fin;
    }
    String fin;
}
