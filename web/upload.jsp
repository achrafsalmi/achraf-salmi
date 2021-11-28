<%-- 
Document   : ajout.jsp
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
                    <li><a href="<%=request.getContextPath() + "/page auth"%>">Stock Modem</a></li>
                    <li><a href="<%=request.getContextPath() + "/page auth"%>">import</a></li>

                    <li class="small-logo"><a href="#header"><img src="img/small-logo.png" alt=""></a></li>

                    <li><a href="<%=request.getContextPath() + "/page auth"%>">historique action</a>
                    </li>
                    <li><a href="#team">${sessionScope.login}</a></li>
                    <li><a href="<%=request.getContextPath() + "/dex"%>"><img src="ph/exit.png" width="20" height="20" ></a></li>
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

                <div class="portfolioContainer wow fadeInUp delay-04s">

                    <div class=" Portfolio-box branding">
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>
                        <fieldset>
                            <legend>ajout client WF:</legend>
                            <input type="radio" name="group" value="value1">disabled
                           
                        </fieldset>

                        
                            <form action="guru_upload" method="post"
                              enctype="multipart/form-data" disabled="disabled">
                            
                        
                        <script>$("input[value='value1']").change(function () {
                                $("input[name='items_radius']").prop('disabled', false);
                                $("input[name='bt_radius']").prop('disabled', false);
                                $("input[name='guru_file']").prop('disabled', false);
                                $("input[name='items_susp']").prop('disabled', true);
                                $("input[name='items_per_cnx']").prop('disabled', true);
                            });
                            
                        </script>
                        
                            <input type="file" name="guru_file" size="50" disabled="disabled"/>
                            <br>
                            <input type="submit" name="bt_radius" value="Upload" disabled="disabled"/>
                        </form>
                    </div>
                </div>
                <!--   *******************************************************************************
                import wf client
                **********************************************************************************
                -->
                
                
                
                <div class="Portfolio-box branding">
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>
                        <fieldset>
                            <legend>ajout reclamation WF:</legend>
                            <input type="radio" name="group" value="value2">disabled
                        </fieldset>
                        <script>$("input[value='value2']").change(function () {
                                $("input[name='items_radius']").prop('disabled', true);
                                $("input[name='items_susp']").prop('disabled', false);
                                $("input[name='items_per_cnx']").prop('disabled', true);
                                $("input[name='bt_radius']").prop('disabled', true);
                                $("input[name='guru_file']").prop('disabled', true);
                            });

                        </script>
                        <form action="upload_recl_tt" method="post"
                              enctype="multipart/form-data" disabled="disabled">
                            <input type="file" name="items_susp" size="50" disabled="disabled"/>
                            <br>
                            <input type="submit" name="items_susp" value="Upload" disabled="disabled"/>
                        </form>

                </div>
                <div class=" Portfolio-box webdesign">
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>
                        <fieldset>
                            <legend>radio:</legend>
                            <input type="radio" name="group" value="value3">disabled
                        </fieldset>

                        <fieldset>
                            <legend>checkbox:</legend>
                            <input type="checkbox" name="items_per_cnx" value="1" disabled="disabled" checked="">id
                            <input type="checkbox" name="items_per_cnx" value="2" disabled="disabled"checked="">tel_adsl
                            <input type="checkbox" name="items_per_cnx" value="3" disabled="disabled"checked="">Mac
                            <input type="checkbox" name="items_per_cnx" value="4" disabled="disabled"checked="">SN
                            <input type="checkbox" name="items_per_cnx" value="5" disabled="disabled"checked="">CIN
                        </fieldset>
                        <script>$("input[value='value3']").change(function () {
                               $("input[name='items_radius']").prop('disabled', true);
                                $("input[name='items_susp']").prop('disabled', true);
                                $("input[name='items_per_cnx']").prop('disabled', false);
                                $("input[name='bt_radius']").prop('disabled', true);
                                $("input[name='guru_file']").prop('disabled', true);
                            });
                        </script>
                        <form action="guru_upload" method="post"
                              enctype="multipart/form-data" disabled="disabled">
                            <input type="file" name="items" size="50" disabled="disabled"/>
                            <br>
                            <input type="submit" name="items" value="Upload" disabled="disabled"/>
                        </form>

                </div>
                <div class=" Portfolio-box printdesign">
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.0/jquery.min.js"></script>
                        <fieldset>
                            <legend>radio:</legend>
                            <input type="radio" name="group" value="value1">disabled
                            <input type="radio" name="group" value="value2">enabled
                        </fieldset>

                        <fieldset>
                            <legend>checkbox:</legend>
                            <input type="checkbox" name="items_radius" value="1" disabled="disabled" checked="">id
                            <input type="checkbox" name="items_radius" value="2" disabled="disabled"checked="">tel_adsl
                            <input type="checkbox" name="items_radius" value="3" disabled="disabled"checked="">Mac
                            <input type="checkbox" name="items_radius" value="4" disabled="disabled"checked="">SN
                            <input type="checkbox" name="items_radius" value="5" disabled="disabled"checked="">CIN
                        </fieldset>
                        <script>$("input[value='value1']").change(function () {
                                $("input[name='items_radius']").prop('disabled', false);
                            });

        // Enable checkbox
                            $("input[value='value2']").change(function () {
                                $("input[name='items']").prop('disabled', );
                            });
                        </script>
                        <form action="guru_upload" method="post"
                              enctype="multipart/form-data" disabled="disabled">
                            <input type="file" name="items" size="50" disabled="disabled"/>
                            <br>
                            <input type="submit" name="items" value="Upload" disabled="disabled"/>
                        </form>

                </div>
                <div class=" Portfolio-box printdesign">
                    <ul class="we-create animated fadeInUp delay-1s"> 
                        <form method="post"  class="d-flex" action="activation" >
                            <li><input min="70000000" max="79999999" name="bee_rec" style="color: black; font-size: 19px;" type="number"class="form-control input-text" id="name" class="form-control mr-3" placeholder="71 XXX XXX"data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                                <input type="submit" value="Réactivation par Tel" class="link animated fadeInUp delay-1s servicelink"></li>
                        </form></ul>
                    <h3>Réactivation client</h3>

                </div>
                <div class=" Portfolio-box printdesign">

                    <ul class="we-create animated fadeInUp delay-1s">
                        <form method="post" method="post" class="d-flex" action="BEE1" >
                            <li>  <input type="text" name="macid"  style="color: black; font-size: 19px;" class="form-control input-text" id="name" placeholder="MAC ID"  data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                <input type="submit" class="link animated fadeInUp delay-1s servicelink"  value="Clear"/>
                        </form></ul>
                    <h3>clear interface</h3>
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


