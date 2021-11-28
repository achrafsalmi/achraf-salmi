<%-- 
    Document   : ajout client radius 
    Created on : 24 déc. 2019, 16:00:37
    Author     : serv-web
--%>

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
                    <li><a href="<%=request.getContextPath() + "/page acc"%>">Home</a></li>
                    <li><a href="<%=request.getContextPath() + "/page auth"%>">Vérification</a></li>
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
                <h2>Ajouter client</h2>
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
                <form method="post" action="ajout_client">
                    <center>
                        
                        <table>
                            <tr>
                                <td><label>Nom :</label><input type="text" name="Nom"  style="color: black; font-size: 19px;" class="form-control input-text" id="name" placeholder=""  data-rule="minlen:4" data-msg="Please enter at least 4 chars" required="required"/></td>
                                <td><label>Telephone Fix :</label><input type="text" name="telephone"  style="color: black; font-size: 19px;" class="form-control input-text" id="name" placeholder=""  data-rule="minlen:4" data-msg="Please enter at least 4 chars" value="<%=request.getAttribute("fix")%>" required="required" disabled="disabled"/>
                                    <input type="hidden" name="telephone"     value="<%=request.getAttribute("fix")%>" />
                                </td>
                            </tr>
                            <tr>
                                <td><label>Login :</label><input type="text" name="Login"  style="color: black; font-size: 19px;" class="form-control input-text" id="name" placeholder=""  data-rule="minlen:4" data-msg="Please enter at least 4 chars" required="required"/></td>
                                <td><label>Mot de passe :</label><input type="text" name="value"  style="color: black; font-size: 19px;" class="form-control input-text" id="name" placeholder=""  data-rule="minlen:4" data-msg="Please enter at least 4 chars" required="required"/></td>
                            </tr>
                            <tr>
                                <td><label>CIN :</label><input type="text" name="CIN"  style="color: black; font-size: 19px;" class="form-control input-text" id="name" placeholder=""  data-rule="minlen:4" data-msg="Please enter at least 4 chars" required="required"/></td>
                                <td><label>Type abonnement :</label><select name="groupname" class="form-control input-text"jè required="required">
                                        <option value="Adsl">Adsl</option>
                                        <option value="Vdsl">Vdsl</option>
                                        <option value="Vdsl">IPFIX</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td><input type="submit" class="link animated fadeInUp delay-1s servicelink" name="bt_action"  value="Valider"/></td>
                        </tr>
                    </table>
                    </center>
                </form>
            </div>
            
        </section>
                <br><br><br><br><br><br><br><br>
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
