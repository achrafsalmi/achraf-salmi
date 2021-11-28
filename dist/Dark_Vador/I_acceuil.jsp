<!DOCTYPE html>
<html class="no-js">
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
	<header class="header" id="header">
		<!--header-start-->
		<div class="container">
			<figure class="logo animated fadeInDown delay-07s">
				<a href="#"><img src="img/logo.png" alt=""></a>
			</figure>
			<h1 class="animated fadeInDown delay-07s">Welcome To DarkVador System</h1>
			<ul class="we-create animated fadeInUp delay-1s">
			<% 
                                    
                                    if (request.getAttribute("msg") != null){
                                    %>
                                    
              <h1 class="animated fadeInDown delay-07s"><%=request.getAttribute("msg")%></h1>
              <%}
            %>	
                            <li>Sign in</li>
				<form method="post" action="login">
			</ul>
			<ul class="we-create animated fadeInUp delay-1s">
				<li><input type="text" name="matricule" class="form-control input-text" id="name" placeholder="Login" data-rule="minlen:4" data-msg="Please enter at least 4 chars" /></li>
			<li><input type="password" name="mdp" class="form-control input-text" id="name" placeholder="password" data-rule="minlen:4" data-msg="Please enter at least 4 chars" /></li>
			</ul>
			
                        <input type="submit" class="link animated fadeInUp delay-1s servicelink"  value="Get Started">
		</form>
                </div>
	</header>

<footer class="footer">
		<div class="container">
			<div class="footer-logo"><a href="#"><img src="img/footer-logo.png" alt=""></a></div>
			<span class="copyright">&copy; DarkVador. All Rights Reserved</span>
			<div class="credits">
				
				Pwored BY <a href="#">BEETUNISIE</a>
			</div>
		</div>
	</footer></html>