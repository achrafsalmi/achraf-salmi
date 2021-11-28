<%-- 
    Document   : historique réactivation
    Created on : 24 déc. 2019, 16:00:37
    Author     : serv-web
--%>

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
 
 String sql = "select * from wf";
        ResultSet res=null;
          connection conn=null;
PreparedStatement ps1 = conn.getConnection().prepareStatement(sql);
            res = ps1.executeQuery(sql);%>
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
            <div class="portfolioContainer wow fadeInUp delay-04s">
                
                <table id="example" class="display" style="width:100%;font-size: 15px;font-weight: bold;">
        <thead>
            <tr>
                <th>ref_tt</th>
                <th>tel_adsl</th>
              <th>  contrat</th>
              <th>  date_depot</th>
              <th>  type_demande</th>
              <th>  client</th>
              <th>  debit</th>
              <th>  etat</th>
               <th> date_etat</th>
              <th>  adresse</th>
             <th>   contact</th>
              <th>  cin</th>
              <th>  region</th>
               <th> csc</th>
             <th>   motif_instance</th>
              <th>  ref_smart</th>
              <th>  date_etat_e</th>
              <th>  date_etat_v</th>
             <th>   date_conf</th>
                
                
            </tr>
        </thead>
        <tbody>
 <%while (res.next()) 
 {
	 
 
 %>
            <tr>
                <td><%=res.getString("ref_tt")%></td>
                <td><%=res.getString("tel_adsl")%></td>
              <td>  <%=res.getString("contrat")%></td>
              <td>  <%=res.getString("date_depot")%></td>
              <td>  <%=res.getString("type_demande")%></td>
              <td>  <%=res.getString("client")%></td>
              <td>  <%=res.getString("debit")%></td>
              <td>  <%=res.getString("etat")%></td>
               <td> <%=res.getString("date_etat")%></td>
              <td>  <%=res.getString("adresse")%></td>
             <td>   <%=res.getString("contact")%></td>
              <td>  <%=res.getString("cin")%></td>
              <td>  <%=res.getString("region")%></td>
               <td> <%=res.getString("csc")%></td>
             <td>   <%=res.getString("motif_instance")%></td>
              <td>  <%=res.getString("ref_smart")%></td>
              <td>  <%=res.getString("date_etat_e")%></td>
              <td>  <%=res.getString("date_etat_v")%></td>
             <td>   <%=res.getString("date_conf")%></td>
                
                
                
            </tr>
            <%}%>
            
        </tbody>
        <tfoot>
            <tr>
                <th>ref_tt</th>
                <th>tel_adsl</th>
              <th>  contrat</th>
              <th>  date_depot</th>
              <th>  type_demande</th>
              <th>  client</th>
              <th>  debit</th>
              <th>  etat</th>
               <th> date_etat</th>
              <th>  adresse</th>
             <th>   contact</th>
              <th>  cin</th>
              <th>  region</th>
               <th> csc</th>
             <th>   motif_instance</th>
              <th>  ref_smart</th>
              <th>  date_etat_e</th>
              <th>  date_etat_v</th>
             <th>   date_conf</th>
               
            </tr>
        </tfoot>
                </table>  
                <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
                <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
                <script src="https://cdn.datatables.net/1.10.20/js/dataTables.jqueryui.min.js"></script>
                <script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
                <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
                <script>
                    $(document).ready(function () {
                        $('#example').DataTable({
                            "pagingType": "full_numbers",
                            dom: 'Bfrtip',
                            buttons: [
                                'copyHtml5',
                                'excelHtml5',
                                'csvHtml5',
                                'pdfHtml5'
                            ]
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

        <script type="text/javascript">
            $(window).load(function () {


                var $container = $('.portfolioContainer'),
                        $body = $('body'),
                        colW = 375,
                        columns = null;


                $container.isotope({
                    // disable window resizing
                    resizable: true,
                    masonry: {
                        columnWidth: colW
                    }
                });

                $(window).smartresize(function () {
                    // check if columns has changed
                    var currentColumns = Math.floor(($body.width() - 30) / colW);
                    if (currentColumns !== columns) {
                        // set new column count
                        columns = currentColumns;
                        // apply width to container manually, then trigger relayout
                        $container.width(columns * colW)
                                .isotope('reLayout');
                    }

                }).smartresize(); // trigger resize to set container width
                $('.portfolioFilter a').click(function () {
                    $('.portfolioFilter .current').removeClass('current');
                    $(this).addClass('current');

                    var selector = $(this).attr('data-filter');
                    $container.isotope({
                        filter: selector,
                    });
                    return false;
                });

            });
        </script>
    </body>
</html>
