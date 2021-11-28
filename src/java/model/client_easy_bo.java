/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author serv-web
 */
public class client_easy_bo {
    String Code_Abonnement, ReferenceTT, Intitule_Client, Identifiant, Date_de_naissance, Téléphone_Fixe, Contact, Offre, Debit, Frequence_De_Paiement, Date_Creation, Ville, Gouvernorat, CodeRegion, Adresse, Etape, Statut, Motif, Abonnement_résilié_le, Pourcentage, Utilisateur,Code_Client, AGENCE_CREATION, AGENCE_REVENDEUR, AGENCE_LIVRAISON, Type_Agence,Facturation_Suspendu,last_upd;

    public client_easy_bo(String Code_Abonnement, String ReferenceTT, String Intitule_Client, String Identifiant, String Date_de_naissance, String Téléphone_Fixe, String Contact, String Offre, String Debit, String Frequence_De_Paiement, String Date_Creation, String Ville, String Gouvernorat, String CodeRegion, String Adresse, String Etape, String Statut, String Motif, String Abonnement_résilié_le, String Pourcentage, String Utilisateur, String Code_Client, String AGENCE_CREATION, String AGENCE_REVENDEUR, String AGENCE_LIVRAISON, String Type_Agence, String Facturation_Suspendu, String last_upd) {
        this.Code_Abonnement = Code_Abonnement;
        this.ReferenceTT = ReferenceTT;
        this.Intitule_Client = Intitule_Client;
        this.Identifiant = Identifiant;
        this.Date_de_naissance = Date_de_naissance;
        this.Téléphone_Fixe = Téléphone_Fixe;
        this.Contact = Contact;
        this.Offre = Offre;
        this.Debit = Debit;
        this.Frequence_De_Paiement = Frequence_De_Paiement;
        this.Date_Creation = Date_Creation;
        this.Ville = Ville;
        this.Gouvernorat = Gouvernorat;
        this.CodeRegion = CodeRegion;
        this.Adresse = Adresse;
        this.Etape = Etape;
        this.Statut = Statut;
        this.Motif = Motif;
        this.Abonnement_résilié_le = Abonnement_résilié_le;
        this.Pourcentage = Pourcentage;
        this.Utilisateur = Utilisateur;
        this.Code_Client = Code_Client;
        this.AGENCE_CREATION = AGENCE_CREATION;
        this.AGENCE_REVENDEUR = AGENCE_REVENDEUR;
        this.AGENCE_LIVRAISON = AGENCE_LIVRAISON;
        this.Type_Agence = Type_Agence;
        this.Facturation_Suspendu = Facturation_Suspendu;
        this.last_upd = last_upd;
    }

    @Override
    public String toString() {
        return "client_easy_bo{" + "Code_Abonnement=" + Code_Abonnement + ", ReferenceTT=" + ReferenceTT + ", Intitule_Client=" + Intitule_Client + ", Identifiant=" + Identifiant + ", Date_de_naissance=" + Date_de_naissance + ", T\u00e9l\u00e9phone_Fixe=" + Téléphone_Fixe + ", Contact=" + Contact + ", Offre=" + Offre + ", Debit=" + Debit + ", Frequence_De_Paiement=" + Frequence_De_Paiement + ", Date_Creation=" + Date_Creation + ", Ville=" + Ville + ", Gouvernorat=" + Gouvernorat + ", CodeRegion=" + CodeRegion + ", Adresse=" + Adresse + ", Etape=" + Etape + ", Statut=" + Statut + ", Motif=" + Motif + ", Abonnement_r\u00e9sili\u00e9_le=" + Abonnement_résilié_le + ", Pourcentage=" + Pourcentage + ", Utilisateur=" + Utilisateur + ", Code_Client=" + Code_Client + ", AGENCE_CREATION=" + AGENCE_CREATION + ", AGENCE_REVENDEUR=" + AGENCE_REVENDEUR + ", AGENCE_LIVRAISON=" + AGENCE_LIVRAISON + ", Type_Agence=" + Type_Agence + ", Facturation_Suspendu=" + Facturation_Suspendu + ", last_upd=" + last_upd + '}';
    }

    public client_easy_bo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCode_Abonnement() {
        return Code_Abonnement;
    }

    public void setCode_Abonnement(String Code_Abonnement) {
        this.Code_Abonnement = Code_Abonnement;
    }

    public String getReferenceTT() {
        return ReferenceTT;
    }

    public void setReferenceTT(String ReferenceTT) {
        this.ReferenceTT = ReferenceTT;
    }

    public String getIntitule_Client() {
        return Intitule_Client;
    }

    public void setIntitule_Client(String Intitule_Client) {
        this.Intitule_Client = Intitule_Client;
    }

    public String getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(String Identifiant) {
        this.Identifiant = Identifiant;
    }

    public String getDate_de_naissance() {
        return Date_de_naissance;
    }

    public void setDate_de_naissance(String Date_de_naissance) {
        this.Date_de_naissance = Date_de_naissance;
    }

    public String getTéléphone_Fixe() {
        return Téléphone_Fixe;
    }

    public void setTéléphone_Fixe(String Téléphone_Fixe) {
        this.Téléphone_Fixe = Téléphone_Fixe;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getOffre() {
        return Offre;
    }

    public void setOffre(String Offre) {
        this.Offre = Offre;
    }

    public String getDebit() {
        return Debit;
    }

    public void setDebit(String Debit) {
        this.Debit = Debit;
    }

    public String getFrequence_De_Paiement() {
        return Frequence_De_Paiement;
    }

    public void setFrequence_De_Paiement(String Frequence_De_Paiement) {
        this.Frequence_De_Paiement = Frequence_De_Paiement;
    }

    public String getDate_Creation() {
        return Date_Creation;
    }

    public void setDate_Creation(String Date_Creation) {
        this.Date_Creation = Date_Creation;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public String getGouvernorat() {
        return Gouvernorat;
    }

    public void setGouvernorat(String Gouvernorat) {
        this.Gouvernorat = Gouvernorat;
    }

    public String getCodeRegion() {
        return CodeRegion;
    }

    public void setCodeRegion(String CodeRegion) {
        this.CodeRegion = CodeRegion;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getEtape() {
        return Etape;
    }

    public void setEtape(String Etape) {
        this.Etape = Etape;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }

    public String getMotif() {
        return Motif;
    }

    public void setMotif(String Motif) {
        this.Motif = Motif;
    }

    public String getAbonnement_résilié_le() {
        return Abonnement_résilié_le;
    }

    public void setAbonnement_résilié_le(String Abonnement_résilié_le) {
        this.Abonnement_résilié_le = Abonnement_résilié_le;
    }

    public String getPourcentage() {
        return Pourcentage;
    }

    public void setPourcentage(String Pourcentage) {
        this.Pourcentage = Pourcentage;
    }

    public String getUtilisateur() {
        return Utilisateur;
    }

    public void setUtilisateur(String Utilisateur) {
        this.Utilisateur = Utilisateur;
    }

    public String getCode_Client() {
        return Code_Client;
    }

    public void setCode_Client(String Code_Client) {
        this.Code_Client = Code_Client;
    }

    public String getAGENCE_CREATION() {
        return AGENCE_CREATION;
    }

    public void setAGENCE_CREATION(String AGENCE_CREATION) {
        this.AGENCE_CREATION = AGENCE_CREATION;
    }

    public String getAGENCE_REVENDEUR() {
        return AGENCE_REVENDEUR;
    }

    public void setAGENCE_REVENDEUR(String AGENCE_REVENDEUR) {
        this.AGENCE_REVENDEUR = AGENCE_REVENDEUR;
    }

    public String getAGENCE_LIVRAISON() {
        return AGENCE_LIVRAISON;
    }

    public void setAGENCE_LIVRAISON(String AGENCE_LIVRAISON) {
        this.AGENCE_LIVRAISON = AGENCE_LIVRAISON;
    }

    public String getType_Agence() {
        return Type_Agence;
    }

    public void setType_Agence(String Type_Agence) {
        this.Type_Agence = Type_Agence;
    }

    public String getFacturation_Suspendu() {
        return Facturation_Suspendu;
    }

    public void setFacturation_Suspendu(String Facturation_Suspendu) {
        this.Facturation_Suspendu = Facturation_Suspendu;
    }

    public String getLast_upd() {
        return last_upd;
    }

    public void setLast_upd(String last_upd) {
        this.last_upd = last_upd;
    }

}
