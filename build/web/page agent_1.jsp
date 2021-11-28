<%-- 
    Document   : test_back
    Created on : 30 nov. 2020, 14:09:19
    Author     : serv-web
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="connexion.connection"%>
<%@page import="connexion.connection_radius"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="initiationjee.dao.persImpli"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, maximum-scale=1">

        <title>DarkVador</title>
        <link rel="icon" href="favicon.png" type="image/png">
        <link rel="shortcut icon" href="favicon.ico" type="img/x-icon">

        <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,800italic,700italic,600italic,400italic,300italic,800,700,600' rel='stylesheet' type='text/css'>

<LINK href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel=stylesheet type=text/css>
  <LINK href="https://cdn.datatables.net/1.10.20/css/dataTables.jqueryui.min.css" rel=stylesheet type=text/css>
    
  <%persImpli ps = new persImpli();
  
                
                 String s7=null;
                
                ResultSet res1 = null;
                connection_radius conn = null;
                connection conn1 = null;
                int k=0;
                
            int    i=0;
                String s1 = ("SELECT * FROM `easybee` WHERE `id_agent` = (SELECT  `id` from user where `matricule` = 'Majdi BETTAIEBI')");
PreparedStatement ps2 = conn1.getConnection().prepareStatement(s1);
                res1 = ps2.executeQuery(s1);
                
%>
                
                

                    
    <body>
        <form method="post" action="affectation_tache">
   <table id="example"  style="width:60%;font-size: 10px;font-weight: bold;">
        <thead>
           <tr>
                 <th>Code_Abonnement</th>
                 <th>ReferenceTT</th>
                 <th>Intitule_Client</th>
                 <th>Identifiant</th>
                <th> Date_de_naissance</th>
                 <th>Téléphone_Fixe</th>
                 <th>Contact</th>
                 <th>Offre</th>
                <th> Debit</th>
                 <th>Frequence_De_Paiement</th>
                <th> Date_Creation</th>
                 <th>Ville</th>
                 <th>Gouvernorat</th>
                 <th>CodeRegion</th>
                 <th>Adresse</th>
                <th> Etape</th>
                <th>Statut</th>
                <th> Motif</th>
                 <th>Abonnement_résilié_le</th>
                 <th>Pourcentage</th>
                <th> Utilisateur</th>
                <th> Code_Client</th>
                 <th>AGENCE_CREATION</th>
                <th> AGENCE_REVENDEUR</th>
                 <th>AGENCE_LIVRAISON</th>
                <th> Type_Agence</th>
                <th> Facturation_Suspendu</th>
            </tr>
        </thead>
        <tbody>
 <%while (res1.next()) 
 {

k++;

 %>
 
            <tr>
                <td><%=res1.getString("Code_Abonnement")%></td>
                <td><%=res1.getString("ReferenceTT")%></td>
                <td><%=res1.getString("Intitule_Client")%></td>
                <td><%=res1.getString("Identifiant")%></td>
                <td><%=res1.getString("Date_de_naissance")%></td>
                <td><%=res1.getString("Téléphone_Fixe")%></td>
                <td><%=res1.getString("Contact")%></td>
                <td><%=res1.getString("Offre")%></td>
                <td><%=res1.getString("Debit")%></td>
                <td><%=res1.getString("Frequence_De_Paiement")%></td>
                <td><%=res1.getString("Date_Creation")%></td>
                <td><%=res1.getString("Ville")%></td>
                <td><%=res1.getString("Gouvernorat")%></td>
                <td><%=res1.getString("CodeRegion")%></td>
                <td><%=res1.getString("Adresse")%></td>
                <td><%=res1.getString("Etape")%></td>
                <td><%=res1.getString("Statut")%></td>
                <td><%=res1.getString("Motif")%></td>
                <td><%=res1.getString("Abonnement_résilié_le")%></td>
                <td><%=res1.getString("Pourcentage")%></td>
                <td><%=res1.getString("Utilisateur")%></td>
                <td><%=res1.getString("Code_Client")%></td>
                <td><%=res1.getString("AGENCE_CREATION")%></td>
                <td><%=res1.getString("AGENCE_REVENDEUR")%></td>
                <td><%=res1.getString("AGENCE_LIVRAISON")%></td>
                <td><%=res1.getString("Type_Agence")%></td>
                <td><%=res1.getString("Facturation_Suspendu")%></td>
            </tr>
            <%}%>
            
        </tbody>
        <tfoot>
            <tr>
                <th>Code_Abonnement</th>
                 <th>ReferenceTT</th>
                 <th>Intitule_Client</th>
                 <th>Identifiant</th>
                <th> Date_de_naissance</th>
                 <th>Téléphone_Fixe</th>
                 <th>Contact</th>
                 <th>Offre</th>
                <th> Debit</th>
                 <th>Frequence_De_Paiement</th>
                <th> Date_Creation</th>
                 <th>Ville</th>
                 <th>Gouvernorat</th>
                 <th>CodeRegion</th>
                 <th>Adresse</th>
                <th> Etape</th>
                <th>Statut</th>
                <th> Motif</th>
                 <th>Abonnement_résilié_le</th>
                 <th>Pourcentage</th>
                <th> Utilisateur</th>
                <th> Code_Client</th>
                 <th>AGENCE_CREATION</th>
                <th> AGENCE_REVENDEUR</th>
                 <th>AGENCE_LIVRAISON</th>
                <th> Type_Agence</th>
                <th> Facturation_Suspendu</th>
            </tr>
        </tfoot>
                </table>  
            <input type="hidden" name="number1" value="<%=k%>">
                
        </form>        
                <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
                <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
                <script src="https://cdn.datatables.net/1.10.20/js/dataTables.jqueryui.min.js"></script>
                <script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
                <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
<script>
                    $(document).ready(function () {
                        $('#example tfoot th').each( function () {
        var title = $(this).text();
        $(this).html( '<input size="5px" type="text" placeholder="Search '+title+'" />' );
    } );
                         var table = $('#example').DataTable({
                           pagingType: "full_numbers",
                            dom: 'Bfrtip',
                            buttons: [
                                'copyHtml5',
                                'excelHtml5',
                                'csvHtml5',
                                'pdfHtml5'
                            ] ,
        initComplete: function () {
            // Apply the search
            this.api().columns().every( function () {
                var that = this;
 
                $( 'input', this.footer() ).on( 'keyup change clear', function () {
                    if ( that.search() !== this.value ) {
                        that
                            .search( this.value )
                            .draw();
                    }
                } );
            } );
        }
                
        });
                                
                       
                            
                         
        
        
   
    
                        
                    });</script>     
</body>
</html>
