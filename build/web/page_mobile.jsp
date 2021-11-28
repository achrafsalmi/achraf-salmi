<%-- 
    Document   : stock modem
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

        

    </head>
    <body>
        <nav class="main-nav-outer" id="test">
            <!--main-nav-start-->
            <div class="container">
                <ul class="main-nav">
                    <li><a href="<%=request.getContextPath() + "/page acc"%>">Home</a></li>
                    <li><a href="<%=request.getContextPath()+"/page auth"%>">Stock Modem</a></li>
                    <li class="small-logo"><a href="#header"><img src="img/small-logo.png" alt=""></a></li>
                    
                    <li><a href="#team">${sessionScope.login}</a></li>
                   <li><a href="<%=request.getContextPath()+"/dex"%>"><img src="ph/exit.png" width="20" height="20" ></a></li>
                </ul>
                <a class="res-nav_click" href="#"><i class="fa fa-bars"></i></a>
            </div>
        </nav>

        
        <section class="main-section paddind" id="Portfolio">
            <!--main-section-start-->
            <div class="container">
                <h2>Action</h2>
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
                            if ((request.getAttribute("bee1") != null) ) {
                        %>
                        <h5>LNS Belvédére</h5>
                        <p><%=request.getAttribute("bee1")%></p>
                        <%}
                        %>
                        <%

                            if ((request.getAttribute("name") != null)&&(request.getAttribute("name1") != null)) {
                        %>

                        <h2 class="animated fadeInDown delay-07s">MAC ID :<%=request.getAttribute("name") %></h2>
                        <%}
                        %><%

                            if ((request.getAttribute("name1") != null)&&(request.getAttribute("name") != null)) {
                        %>

                        <h2 class="animated fadeInDown delay-07s">S/N :<%=request.getAttribute("name1") %></h2>
                        <%}
                        %>
                       
                        </center>
                <div class="portfolioFilter">
                    <ul class="Portfolio-nav wow fadeIn delay-02s">
                        <li><a href="#" data-filter="*" class="current">All</a></li>
                       
                        <li><a href="#" data-filter=".photography">Stock Modem</a></li>
                    </ul>
                </div>

            </div>
            <div class="portfolioContainer wow fadeInUp delay-04s">
                
                <div class=" Portfolio-box photography">
                    <ul class="we-create animated fadeInUp delay-1s"> 
                    <form method="post"  class="d-flex" action="stock_client" >
                        <li><input  name="s/n" style="color: black; font-size: 19px;" class="form-control input-text" id="name" class="form-control mr-3" placeholder="S/N"data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                                    <input type="submit" value="recherch par S/N" class="link animated fadeInUp delay-1s servicelink"></li>
                                </form></ul>
                    <h3>stock modem</h3>
                    
                </div>
                <div class=" Portfolio-box photography">
                    <ul class="we-create animated fadeInUp delay-1s"> 
                    <form method="post"  class="d-flex" action="stock_client2" >
                        <li><input  name="mac" style="color: black; font-size: 19px;" class="form-control input-text" id="name" class="form-control mr-3" placeholder="MAC ID"data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                                    <input type="submit" value="recherch par MAC ID" class="link animated fadeInUp delay-1s servicelink"></li>
                                </form></ul>
                    <h3>stock modem</h3>
                    
                </div>
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




                                <!--<h2 class="footer-heading mb-4">Vérifiction Client Par Fix_ADSL</h2>
                                <form method="post" class="d-flex" action="rech_tel_mobile" >
                                    <input name="nom" type="number" class="form-control mr-3" min="70000000" max="79999999"  placeholder="71 XXX XXX">
                                    <input type="submit" value="Send" class="btn btn-primary">
                                </form>
                                <br>
                                <h2 class="footer-heading mb-4">Vérifiction Client Par MACID</h2>
                                <form method="post" method="post" class="d-flex" action="rech_mac_mobile" >
                                    <input  name="nom" type="text" class="form-control mr-3" minlength="2" maxlenght="12" placeholder="0CB6D2B7C851">
                                    <input type="submit" value="Send" class="btn btn-primary">
                                </form>
                                <br>
                                <h2 class="footer-heading mb-4">Vérifiction Nombre client</h2>
                                <form method="post" class="d-flex" action="BEE_mobile" >
                                    <input type="submit" value="           All Users            " class="btn btn-primary py-4 btn-custom-1">
                                </form>
                            </div>
                        </div>
                        
                        <div class="col-lg-4">
                            <div class="block-2 teal">
                                
                                
                                <form method="post"  class="d-flex" action="verif_susp_mobile" >
                                   <input min="70000000" max="79999999" name="bee_rec" type="number" class="form-control mr-3" placeholder="71 XXX XXX">
                                    <input type="submit" value="Send" class="btn btn-primary">
                                </form>
                            </div>
                            
                        
                            <div class="border-top pt-5">!-->
                                

