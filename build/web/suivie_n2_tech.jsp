<%-- 
    Document   : historique réactivation
    Created on : 24 déc. 2019, 16:00:37
    Author     : serv-web
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="connexion.connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="initiationjee.dao.persImpli"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, maximum-scale=1">

        <title>DarkVador</title>
        <link rel="icon" href="favicon.png" type="image/png">
        <link rel="shortcut icon" href="favicon.ico" type="img/x-icon">

        <link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,800italic,700italic,600italic,400italic,300italic,800,700,600' rel='stylesheet' type='text/css'>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
        <link href="css/responsive.css" rel="stylesheet" type="text/css">
        <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
        <link href="css/animate.css" rel="stylesheet" type="text/css">
<LINK href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel=stylesheet type=text/css>
  <LINK href="https://cdn.datatables.net/1.10.20/css/dataTables.jqueryui.min.css" rel=stylesheet type=text/css>

       

        <!-- =======================================================
    Theme Name: Knight
    Theme URL: https://bootstrapmade.com/knight-free-bootstrap-theme/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
        ======================================================= -->

    </head>
    <body style="color: black;">
        <nav class="main-nav-outer" id="test">
            <!--main-nav-start-->
            <div class="container">
                <ul class="main-nav">
                    <li><a href="<%=request.getContextPath() + "/home_fact"%>">Home</a></li>
                    <li><a href="<%=request.getContextPath() + "/import_fact"%>">import</a></li>
                    <li class="small-logo"><a href="#header"><img src="img/small-logo.png" alt=""></a></li>
                    <li><a href="<%=request.getContextPath() + "/suvie_1er_cnx"%>">1 connexion</a></li>
                    <li><a href="#team">${sessionScope.login}</a></li>
                    <li><a href="<%=request.getContextPath() + "/dex"%>"><img src="ph/exit.png" width="20" height="20" ></a></li>
                </ul>
                <a class="res-nav_click" href="#"><i class="fa fa-bars"></i></a>
            </div>
        </nav>

        
        <section class="main-section paddind" id="Portfolio">
            <!--main-section-start-->
            <div class="container">
                <h2>Suivie réactivation</h2>
                <center>
                    <%persImpli ps=new persImpli();
 
 String sql = "select * from helpdesk where Agent like '%2%'AND statut NOT LIKE 'Clôturé'AND statut NOT LIKE 'Résolu'";
        ResultSet res=null;
          connection conn=null;
PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery(sql);
                    
       
                    %>
                <%

                            if (request.getAttribute("gurumessage") != null) {
                        %>

                        <h2 class="animated fadeInDown delay-07s"><%=request.getAttribute("gurumessage")%></h2>
                        <%}
                        %>
                        <%
                            if ((request.getAttribute("bee") != null)) {
                        %>
                        <h5>LNS wardiya</h5>
                        <p><%=request.getAttribute("bee")%></p>
                        <%}
                        %>


                        <%
                            if ((request.getAttribute("bee1") != null) ) {
                        %>
                        <h5>LNS Belvédére</h5>
                        <p><%=request.getAttribute("bee1")%></p>
                        <%}
                        %>
                        </center>
                <div class="portfolioFilter">
                    
                </div>

            </div>
            <div >
                
                <table id="example"  style="width:60%;font-size: 10px;font-weight: bold;">
        <thead>
           <tr>
                <th>id</th>
                <th>type demande</th>
                <th>central</th>
                <th>tel_dsl</th>
                <th>GSM</th>
                <th>Nom client</th>
                <th>Probléme</th>
                <th>date MES</th>
                <th>date depot recTT</th>
                <th>MAC ID</th>
                <th>type recTT</th>
                <th>etat recTT</th>
                <th>date etat recTT</th>
                <th>region</th>
                <th>CSC</th>
                
                <th>etat helpdesk</th>
                <th>Agent</th>
                <th>last cnx</th>
                <th>traitement N2</th>
                <th>action</th>
                
            </tr>
        </thead>
        <tbody>
 <%while (res.next()) 
 {
String tel=res.getString("Tel_ADSL");
ArrayList<String> test1 = new ArrayList<String>(); 
ArrayList<String> test2 = new ArrayList<String>(); 
ArrayList<String> test3 = new ArrayList<String>(); 
ArrayList<String> test4 = new ArrayList<String>(); 
test1=WFTT.sqlwftt.recherche(tel);
test2=RECTT.sqlrectt.recherche(tel);
 String t=test.testtableautechnique.recherche_tel(tel);
 String t1=test.testtableautechnique.recherche_histo(t);
 %>
 
            <tr>
                <td><%=res.getString("id")%></td>
                <td><%=test1.get(4)%></td>
                <td></td>
                <td><%=res.getString("Tel_ADSL")%></td>
                <td><%=test1.get(2)%></td>
                <td><%=res.getString("Agcence")%></td>
                <td><%=res.getString("Sujet")%></td>
                <td><%=test1.get(3)%></td>
                <td><%=test2.get(1)%></td>
                <td><%=t%></td>
                <td><%=test2.get(0)%></td>
                <td><%=test2.get(3)%></td>
                <td><%=test2.get(2)%></td>
                
                <td><%=test1.get(1)%></td>
                <td><%=test1.get(0)%></td>
                <td><%=res.getString("statut")%></td>
                <td><%=res.getString("Agent")%></td>              
                <td><%=t1%></td>
                <td><%=res.getString("statut_ticket")%></td>
                 <td><form method="post" action="update_help">
                                    <input type="hidden" name="id" value="<%=res.getString("id")%>">
                                    <input type="submit" name="bt_dispo" value="Traitement en cours">
                     </form></td>
            </tr>
            <%}%>
            
        </tbody>
        <tfoot>
            <tr>
                <th>id</th>
                <th>type demande</th>
                <th>central</th>
                <th>tel_dsl</th>
                <th>GSM</th>
                <th>Nom client</th>
                <th>Probléme</th>
                <th>date MES</th>
                <th>date depot recTT</th>
                <th>MAC ID</th>
                <th>type recTT</th>
                <th>etat recTT</th>
                <th>date etat recTT</th>
                <th>region</th>
                <th>CSC</th>
                <th>etat helpdesk</th>
                <th>Agent</th>
                <th>last cnx</th>
                <th>traitement N2</th>
                <th>action</th>
            </tr>
        </tfoot>
                </table>  
                
                
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
            </div>
        </section>
<footer class="footer">
		<div class="container">
			<div class="footer-logo"><a href="#"><img src="img/footer-logo.png" alt=""></a></div>
			<span class="copyright">&copy; DarkVador. All Rights Reserved</span>
			<div class="credits">
				
				Pwored BY <a href="#">BEETUNISIE</a>
			</div>
		</div>
	</footer>
        <script type="text/javascript">
            $(document).ready(function (e) {

                $('#test').scrollToFixed();
                $('.res-nav_click').click(function () {
                    $('.main-nav').slideToggle();
                    return false

                });

                $('.Portfolio-box').magnificPopup({
                    delegate: 'a',
                    type: 'image'
                });

            });
        </script>

        <script>
            wow = new WOW({
                animateClass: 'animated',
                offset: 100
            });
            wow.init();
        </script>


        <script type="text/javascript">
            $(window).load(function () {

                $('.main-nav li a, .servicelink').bind('click', function (event) {
                    var $anchor = $(this);

                    $('html, body').stop().animate({
                        scrollTop: $($anchor.attr('href')).offset().top - 102
                    }, 1500, 'easeInOutExpo');
                    /*
                     if you don't want to use the easing effects:
                     $('html, body').stop().animate({
                     scrollTop: $($anchor.attr('href')).offset().top
                     }, 1000);
                     */
                    if ($(window).width() < 768) {
                        $('.main-nav').hide();
                    }
                    event.preventDefault();
                });
            })
        </script>

        
    </body>
</html>
