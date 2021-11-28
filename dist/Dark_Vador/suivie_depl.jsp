)<%-- 
    Document   : historique com
    Created on : 24 déc. 2019, 16:00:37
    Author     : serv-web
--%>

<%@page import="connexion.connection_radius"%>
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
        <LINK href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel=stylesheet type=text/css>

        <script type="text/javascript" src="js/jquery.1.8.3.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery-scrolltofixed.js"></script>
        <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="js/jquery.isotope.js"></script>
        <script type="text/javascript" src="js/wow.js"></script>
        <script type="text/javascript" src="js/classie.js"></script>
        <script type="text/javascript" src="js/magnific-popup.js"></script>
        <script src="contactform/contactform.js"></script>

        <!-- =======================================================
    Theme Name: Knight
    Theme URL: https://bootstrapmade.com/knight-free-bootstrap-theme/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
        ======================================================= -->

    </head>
    <body>
        <nav class="main-nav-outer" id="test">
            <!--main-nav-start-->
            <div class="container">
                <ul class="main-nav">
                    <li><a href="<%=request.getContextPath() + "/auth_com"%>">Home</a></li>


                    <li class="small-logo"><a href="#header"><img src="img/small-logo.png" alt=""></a></li>

                    <li><a href="#team">${sessionScope.login}</a></li>
                    <li><a href="<%=request.getContextPath() + "/dex"%>"><img src="ph/exit.png" width="20" height="20" ></a></li>
                </ul>
                <a class="res-nav_click" href="#"><i class="fa fa-bars"></i></a>
            </div>
        </nav>


        <section class="main-section paddind" id="Portfolio">
            <!--main-section-start-->
            <div class="container">
                <h2>historique client</h2>
                <center>
                    <%persImpli ps = new persImpli();
                        String s = (String) request.getAttribute("msg");
                        String sql = "select * from radacct WHERE `username` LIKE '%" + s + "%'ORDER BY `radacctid` DESC LIMIT 100";
                        ResultSet res = null;
                        connection_radius conn = null;
                        PreparedStatement ps1 = conn.getConnection().prepareStatement(s);
                        res = ps1.executeQuery(s);

                    %>
                    <%                        if (request.getAttribute("msg") != null) {
                    %>


                    <%}
                    %>
                    <%
                        if ((request.getAttribute("bee") != null)) {
                    %>

                    <h3><%=request.getAttribute("bee")%></h3>
                    <%}
                    %>


                    <%
                        if ((request.getAttribute("bee1") != null)) {
                    %>

                    <p><%=request.getAttribute("bee1")%></p>
                    <%}
                    %>
                    <%
                        String p = (String) request.getAttribute("Mac");
                        String t = (String) request.getAttribute("tel");
                        String n = (String) request.getAttribute("nom");
                        String v = (String) request.getAttribute("verif");
                    %>
                </center>
                <div class="portfolioFilter">
                    <center>
                        <% if (v.equals("oui")) {%>
                        <input type="hidden" name="telephone" value="<%=p%>">
                       
                            <input type="hidden" name="id" value="<%=p%>">
                            <input type="hidden" name="Nom" value="<%=n%>">
                            <input type="hidden" name="telephone" value="<%=t%>">
                           
                        <%}%>
                    </center>
                </div>

            </div>
            <div class="portfolioContainer wow fadeInUp delay-04s">

                <table id="example" class="display" style="width:100%">

                    <thead>
                        <tr>
                            <th>Login</th>
                            <th>type status</th>
                            <th>Start time</th>
                            <th>stop time</th>
                            <th>session time</th>  
                            <th>adresse ip</th>
                            <th>id</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%while (res.next()) {


                        %>
                        <tr>
                            <td><%=res.getString("username")%></td>
                            <td><%=res.getString("acctstatustype")%></td>
                            <td><%=res.getString("acctstarttime")%></td>
                            <td><%=res.getString("acctstoptime")%></td>
                            <%String time = res.getString("acctsessiontime");
                                int time1 = Integer.parseInt(time);
                                int hour = time1 / (3600);

                                int minute = time1 / 60;
                                minute = minute % 60;
                                int seconde = time1 % 60;
                            %>

                            <td><%out.println(hour + "h " + minute + "m " + seconde + "s");%></td>
                            <td><%=res.getString("framedipaddress")%></td>
                            <td><%=res.getString("radacctid")%></td>



                        </tr>
                        <%}%>

                    </tbody>
                    <tfoot>
                        <tr>
                            <th>Login</th>
                            <th>type status</th>
                            <th>Start time</th>
                            <th>stop time</th>
                            <th>session time</th>
                            <th>adresse ip</th>
                            <th>Id</th>

                        </tr>
                    </tfoot>
                </table>   

                <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
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
