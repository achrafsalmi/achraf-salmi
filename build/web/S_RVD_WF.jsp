<%-- 
    Document   : ajout.jsp
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

        <script type="text/javascript" src="js/jquery.1.8.3.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery-scrolltofixed.js"></script>
        <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="js/jquery.isotope.js"></script>
        <script type="text/javascript" src="js/wow.js"></script>
        <script type="text/javascript" src="js/classie.js"></script>
        <script type="text/javascript" src="js/magnific-popup.js"></script>
        <script src="contactform/contactform.js"></script>
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                padding-top: 100px; /* Location of the box */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            }

            /* Modal Content */
            .modal-content {
                background-color: #fefefe;
                margin: auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
            }

            /* The Close Button */
            .close {
                color: #aaaaaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: #000;
                text-decoration: none;
                cursor: pointer;
            }
        </style>
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
                    <li class="small-logo"><a href="#header"><img style="width: 70px;height: 70px;" src="img/bee.png" alt=""></a></li>
                </ul>
                <a class="res-nav_click" href="#"><i class="fa fa-bars"></i></a>
            </div>
        </nav>


        <section class="main-section paddind" id="Portfolio">
            <!--main-section-start-->
            <div class="container">
                <h2>Détails client</h2>
                <center>
                    <%

                        if (request.getAttribute("msg") != null) {
                    %>

                    <h2 class="animated fadeInDown delay-07s"><%=request.getAttribute("msg")%></h2>
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
                        if ((request.getAttribute("bee1") != null)) {
                    %>
                    <h5>LNS Belvédére</h5>
                    <p><%=request.getAttribute("bee1")%></p>
                    <%}
                    %>
                </center>
                <form method="post" action="WF_TT">
                    <center>
                        <br>
                        <fieldset>
                            <legend>Recherche client par REF TT/CIN :</legend>

                        </fieldset>
                        <input type="text" name="ref_tt" required minlength="6" style="color: black; font-size: 19px;"  placeholder="REF TT/CIN"   /><input type="submit" class="link animated fadeInUp delay-1s servicelink" name="bt_action"  value="Recherche" /><br>
                        </form>
                        <br> 


                        <script>$("input[value='value1']").change(function () {
                                $("input[name='ref_tt']").prop('disabled', false);
                                $("input[value='Recherche_par_ref']").prop('disabled', false);

                                $("input[name='cin']").prop('disabled', true);
                                $("input[value='Recherche_par_cin']").prop('disabled', true);
                            });
                            $("input[value='value2']").change(function () {
                                $("input[name='ref_tt']").prop('disabled', true);
                                $("input[value='Recherche_par_ref']").prop('disabled', true);

                                $("input[name='cin']").prop('disabled', false);
                                $("input[value='Recherche_par_cin']").prop('disabled', false);
                            });

                        </script>
                </form>
                </center>

            </div>
            <div class="portfolioContainer wow fadeInUp delay-04s">

            </div>
        </section>
        <%
            if ((request.getAttribute("s") != null)) {
        %>

        <!--main-section-start-->
        <div class="container">
            <h2>BEE Follow-up</h2>
            <center>
                <%persImpli ps = new persImpli();
                    String sql = (String) request.getAttribute("s");
                    System.out.println(sql);
                    ResultSet res = null;
                    connection conn = null;
                    PreparedStatement ps1 = connection.getConnection().prepareStatement(sql);
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
                        <th> CSC</th>
                        <th>   motif_instance</th>
                        <th>commentaire</th>
                    </tr>
                </thead>
                <tbody>
                    <%while (res.next()) {


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
                        <td> <%=res.getString("csc")%></td>
                        <td>   <%=res.getString("motif_instance")%></td>
                        <td>


                            <!-- Trigger/Open The Modal -->
                            <button id="myBtn">send</button>

                            <!-- The Modal -->
                            <div id="myModal" class="modal">

                                <!-- Modal content -->
                                <div class="modal-content">
                                    <span class="close">&times;</span>
                                    <form method="post" action="">
                                    <select name="Service">

                                        <option selected="yes">fait un choix</option>
                                        <option>Service Commercial </option>
                                        <option>Service BackOffice</option>

                                    </select>
                                    <input type="hidden" name="sujet" value="<%=res.getString("ref_tt")%>" placeholder="Sujet">
                                    <input type="text" name="sujet" placeholder="Sujet">
                                    <textarea name="commantaire" placeholder="commantaire"></textarea>
                                    
                                    <button type="submit" name="bt_valid">Valider</button>
                                    </form>
                                </div>

                            </div>

                            <script>
                                // Get the modal
                                var modal = document.getElementById("myModal");

                                // Get the button that opens the modal
                                var btn = document.getElementById("myBtn");

                                // Get the <span> element that closes the modal
                                var span = document.getElementsByClassName("close")[0];

                                // When the user clicks the button, open the modal 
                                btn.onclick = function () {
                                    modal.style.display = "block";
                                }

                                // When the user clicks on <span> (x), close the modal
                                span.onclick = function () {
                                    modal.style.display = "none";
                                }

                                // When the user clicks anywhere outside of the modal, close it
                                window.onclick = function (event) {
                                    if (event.target == modal) {
                                        modal.style.display = "none";
                                    }
                                }
                            </script>

                            </select>

                        </td>




                    </tr>
                    <%}%>

                </tbody>
                <tfoot>
                    <tr>
                        <th>ref_tt</th>
                        <th>tel_adsl</th>
                        <th>contrat</th>
                        <th>date_depot</th>
                        <th>type_demande</th>
                        <th>client</th>
                        <th>debit</th>
                        <th>etat</th>
                        <th>date_etat</th>
                        <th>csc</th>
                        <th>motif_instance</th>
                        <th>commentaire</th>
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

        <%}
        %>

        <br><br><br><br><br><br><br><br>
        <footer class="footer">
            <div class="container">
                <div class="footer-logo"><a href="#"><img style="width: 45px;height: 45px;" src="img/bee.png" alt=""></a></div>
                <span class="copyright">&copy; BEE TUNISIE. All Rights Reserved</span>
                <div class="credits">
                    Pwored BY <a href="https://bee.net.tn/">BEETUNISIE</a>
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
