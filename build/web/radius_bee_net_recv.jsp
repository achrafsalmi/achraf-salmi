<%@page import="initiationjee.com_reactivation"%>
<%@page import="dao.stock.persImpli2"%>
<%@page import="initiationjee.SSHConnectionJava1ava1"%>
<%@page import="initiationjee.SSHConnectionJava"%>
)<%-- 
    Document   : ajout.jsp
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
        <LINK href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel=stylesheet type=text/css>
        <LINK href="https://cdn.datatables.net/1.10.20/css/dataTables.jqueryui.min.css" rel=stylesheet type=text/css>


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
                    <li><a href="<%=request.getContextPath() + "/auth_recv"%>">Home</a></li>
                    <li><a href="<%=request.getContextPath() + "/auth_recv_up"%>">import</a></li>
                    <li><a href="<%=request.getContextPath() + "/liste_coupure"%>">coupure</a></li>
                    <li class="small-logo"><a href="#header"><img src="img/small-logo.png" alt=""></a></li>
                    <li><a href="<%=request.getContextPath() + "/suivie_coupure"%>">historique action</a></li>
                    <li><a href="<%=request.getContextPath() + "/liste_suspension"%>">liste client suspendu</a></li>
                    <li><a href="#team">${sessionScope.login}</a></li>
                    <li><a href="<%=request.getContextPath() + "/dex"%>"><img src="ph/exit.png" width="20" height="20" ></a></li>

                </ul>
                <a class="res-nav_click" href="#"><i class="fa fa-bars"></i></a>
            </div>
        </nav>


        <section class="main-section paddind" id="Portfolio">
            <!--main-section-start-->
            <div class="container">
                <h2>état client</h2>
                <center>
                    <%persImpli ps = new persImpli();
                        String s = (String) request.getAttribute("msg");

                        ResultSet res = null;
                        ResultSet res1 = null;
                        connection_radius conn = null;
                        PreparedStatement ps1 = conn.getConnection().prepareStatement(s);
                        res = ps1.executeQuery(s);%>

                    <%
                        if ((request.getAttribute("bee") != null)) {
                    %>

                    <h3><%=request.getAttribute("bee")%></h3>
                    <%}
                    %>


                    <%
                        if ((request.getAttribute("bee1") != null)) {
                    %>
                    <h5>LNS Belvédére</h5>
                    <p><%=request.getAttribute("bee1")%></p>
                    <%}
                    %>
                </center>
                <div class="portfolioFilter">

                </div>

            </div>


            <table id="example" class="display"  style="width:100%;">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Nom</th>
                        <th>telephone FIX</th>
                        <th>Login</th>
                        <th>mot de passe</th>
                        <th>groupname</th>
                        <th>CIN</th>
                        <th>IP FIXE</th>
                        <th>Statut client</th>
                        <th>état suspension</th>
                        <th>Num série</th>
                        <th>authentification</th>
                        <th>action</th>
                    </tr>
                </thead>
                <tbody>
                    <%while (res.next()) {


                    %>
                    <tr>


                        <td><%=res.getString("id")%></td>
                        <td><%=res.getString("Nom")%></td>
                        <td><%=res.getString("telephone")%></td>
                        <td><%=res.getString("Login")%></td>
                        <td><%=res.getString("value")%></td>
                        <td><%=res.getString("groupname")%></td>
                        <td><%=res.getString("CIN")%></td>
                        <td><%=res.getString("IPADDRESS")%></td>
                        <td><%SSHConnectionJava ssh = new SSHConnectionJava();
                            String n = (String) res.getString("Login");
                            String m = ssh.sh(n);
                            String j = "LNS ouardia" + m;
                            if (m == null || m.isEmpty()) {
                                SSHConnectionJava1ava1 ss = new SSHConnectionJava1ava1();
                                m = ss.sh(n);
                                j = "LNS bélvédére" + m;
                            }
                            if (j.contains("Vi2.")) {
                            %>
                            <label style="color: green;"><%=j%></label><%

                            } else {
                                j = "client n'est pas connecter";
                            %>
                            <label style="color: red;"><%=j%></label><%
                                }

                            %>
                        </td>
                        <td><% String k = (String) res.getString("Login");

                            com_reactivation test = new com_reactivation();

                            test.initSession();

                            String nb = null;
                            String susp;

                            nb = test.runCommand("nl /etc/freeradius/users |grep " + k + " |awk '{print $1}'");

                            if (nb != null) {
                                susp = "suspendu";
                            %><label style="color: red;"><%=susp%></label>
                            <% } else {
                                susp = "Pas de PB Suspension";

                            %>  <label style="color: green;"><%=susp%></label><%}%>

                        </td>
                        <td><% String l = (String) res.getString("Login");
                            persImpli2 pers = new persImpli2();
                            String SN = pers.rechsn(l);
                            out.println(SN);%>
                        </td>
                        <td><% String i = null;

                            i = pers.verif_auth(k);
                            out.println(i);
                            %>

                        </td>
                        <td>


                            <form style="margin:0px;" method="post" action="acct_histo">
                                <input type="hidden" name="id" value="<%=res.getString("Login")%>">
                                <input type="hidden" name="Nom" value="<%=res.getString("Nom")%>">
                                <input type="hidden" name="telephone" value="<%=res.getString("telephone")%>">
                                <button type="submit" name="bt_histo" value="historique__client" title="historique client"><img style="width: 20px;height: 20px" src="ph/icons8-liste-64.png"/></button>
                            </form>
                            <form style="margin:0px;" method="post"  class="d-flex" action="reactivation_recv" >
                                <input type="hidden" name="bee_rec" value="<%=res.getString("telephone")%>">
                                <input type="hidden" name="bee_rec1" value="<%=res.getString("IPADDRESS")%>">
                                <input type="hidden" name="bee_rec2" value="com">
                                <button type="button" onclick="confSubmit3(this.form);"  value="réactivation" title="réactivation"><img style="width: 20px;height: 20px" src="ph/icons8-approuver-40.png"/></button>
                            </form>
                                <form style="margin:0px;" method="post"  class="d-flex" action="susp_par1" >
                                <input type="hidden" name="bee_rec2" value="<%=res.getString("telephone")%>">
                                <button type="button" onclick="confSubmit3(this.form);"  value="suspension" title="suspension"><img style="width: 20px;height: 20px" src="ph/suppresion.png"/></button>
                            </form>
                            <form style="margin:0px;" method="post" action="modif_radius">
                                <input type="hidden" name="id" value="<%=res.getString("id")%>">
                                <input type="hidden" name="telephone" value="<%=res.getString("telephone")%>">

                                <button type="submit" name="modif" value="actualiser_info" title="actualiser"><img style="width: 20px;height: 20px" src="ph/ac.png"/></button>
                            </form>
                            <script type="text/javascript">
                                function confSubmit1(form) {
                                    if (confirm("voulez-vous vraiment de faire clear interface au client?")) {
                                        form.submit();
                                    }

                                    else {
                                        alert("You decided to not submit the form!");
                                    }
                                }
                            </script>
                            <script type="text/javascript">
                                function confSubmit2(form) {
                                    if (confirm("voulez-vous vraiment supprimer le client?")) {
                                        form.submit();
                                    }

                                    else {
                                        alert("You decided to not submit the form!");
                                    }
                                }
                            </script>
                            <script type="text/javascript">
                                function confSubmit3(form) {
                                    if (confirm("voulez-vous vraiment réactiver le client?")) {
                                        form.submit();
                                    }

                                    else {
                                        alert("You decided to not submit the form!");
                                    }
                                }
                            </script>
                            <script type="text/javascript">
                                function confSubmit3(form) {
                                    if (confirm("voulez-vous vraiment suspendre le client?")) {
                                        form.submit();
                                    }

                                    else {
                                        alert("You decided to not submit the form!");
                                    }
                                }
                            </script>

                        </td>

                    </tr>
                    <%}%>

                </tbody>
                <tfoot>
                    <tr>
                        <th>id</th>
                        <th>Nom</th>
                        <th>telephone FIX</th>
                        <th>Login</th>
                        <th>mot de passe</th>
                        <th>groupname</th>
                        <th>CIN</th>
                        <th>IP FIXE</th>
                        <th>Statut client</th>
                        <th>état suspension</th>
                        <th>Num série</th>
                        <th>authentification</th>
                        <th>Action</th>
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

        var table = $('#example').DataTable({
            scrollY: "300px",
            scrollX: true,
            scrollCollapse: true,
            paging: false,
            fixedColumns: true,
            autoWidth: false,
            dom: 'Bfrtip',
            buttons: [
                'copyHtml5',
                'excelHtml5',
                'csvHtml5',
                'pdfHtml5'
            ],
        });
    });</script> 

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
