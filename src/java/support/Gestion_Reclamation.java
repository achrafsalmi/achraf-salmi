package support;
public class Gestion_Reclamation {

    public void Reclamation_User(String Matricule, String Bureau, String Poste,String Departement, String Type_Reclamation, String Description) {
        cnx c = new cnx();
        String sql = "INSERT INTO `reclamation` (`Matricule`, `Bureau`, `Poste`, `Departement`,`Type_Reclamation`, `Description`) VALUES ( '" + Matricule + "','" + Bureau + "','" + Poste + "','" + Departement + "','" + Type_Reclamation + "','" + Description + "' )";
        c.execR(sql);
    }
    
    public void Materiel_User(String Matricule, String Bureau, String Poste, String Departement, String Type_Materiel, String Marque, String Num_Serie, String Description) {
        cnx c = new cnx();
        String sql = "INSERT INTO `materiel` (`Matricule`, `Bureau`, `Poste`, `Departement`, `Type_Materiel`, `Marque`, `Num_Serie`, `Description`) VALUES ('" + Matricule + "','" + Bureau + "','" + Poste + "','" + Departement + "','" + Type_Materiel + "','" + Marque + "','" + Num_Serie + "','" + Description + "')";
        c.insertest(sql);
    } 

    public void modifier_reclamation(String Id, String Type_Reclamation, String Description) {
        cnx c = new cnx();
        String sql = "UPDATE `reclamation` SET  (`Type_Reclamation`,`Description`) VALUES ('" + Type_Reclamation + "','" + Description + "' ) where `Id` ='" + Id + "' ";
        c.update(sql);
    }
    
    public void modifier_materiel(int IDRec, String Bureau, String Poste, String Departement, String Type_Materiel, String Marque, String Num_Serie, String Description) {
        cnx c = new cnx();
        String sql = "UPDATE `reclamation` SET  (`Bureau`, `Poste`, `Departement`, `Type_Materiel`, `Marque`, `Num_Serie`, `Description`) VALUES ('" + Bureau + "','" + Poste + "','" + Departement + "','" + Type_Materiel + "','" + Marque + "','" + Num_Serie + "''" + Description + "') where `Id` ='" + IDRec + "' ";
        c.insertest(sql);
    }
    
    public void Reclamation_Help(String Id,String Group_A) {
        cnx c = new cnx();
        String sql = "INSERT INTO `reclamation` (`Group_A`) VALUES ('" + Group_A + "') where `Id` ='" + Id + "' ";
        c.insertest(sql);
    }
    
    public void Reclamation_Intervention(int IDRec,String Acteur, String Etat) {
        cnx c = new cnx();
        String sql = "INSERT INTO `reclamation` (`Acteur`,`Etat`) VALUES ('" + Acteur + "','" + Etat + "') where `Id` ='" + IDRec + "' ";
        c.insertest(sql);
    }
    
    public void Reclamation_Maintenance(int IDRec,String Acteur, String Etat, String Num_Serie , String Adr_Mac, String Code ) {
        cnx c = new cnx();
        String sql = "INSERT INTO `materiel` (`Acteur`,`Etat`, `Num_Serie`, `Adr_Mac`, `Code`) VALUES ('" + Acteur + "','" + Etat + "','" + Num_Serie + "','" + Adr_Mac + "','" + Code + "') where `Id` ='" + IDRec + "' ";
        c.insertest(sql);
    }  
}
