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
        <style>
            table.dataTable tbody td {

                font-size: 15px;
                vertical-align: top;

            }

        </style>
    </head>
    <body>

        <nav class="main-nav-outer" id="test">
           <%persImpli ps = new persImpli();
                String s = (String) request.getAttribute("msg");

                ResultSet res = null;
                ResultSet res1 = null;
                connection_radius conn = null;
                PreparedStatement ps1 = conn.getConnection().prepareStatement(s);
                res = ps1.executeQuery(s);%>
            <!--main-nav-start-->
            <div class="container">
                <ul class="main-nav">
                    <li><a href="<%=request.getContextPath() + "/page acc"%>">Home</a></li>
                    <li><a href="<%=request.getContextPath() + "/page auth"%>">Stock Modem</a></li>
                    <li class="small-logo"><a href="#header"><img src="img/small-logo.png" alt=""></a></li>

                    <li><a href="#team">${sessionScope.login}</a></li>
                    <li><a href="<%=request.getContextPath() + "/dex"%>"><img src="ph/exit.png" width="20" height="20" ></a></li>

                </ul>
                <a class="res-nav_click" href="#"><i class="fa fa-bars"></i></a>
            </div>
        </nav>


        
            <!--main-section-start-->
            <br>
    <div class="container" style="width: 300px;margin-bottom:80 px ;">
        <fieldset style="border: 1px;">
            <legend>Modification:</legend>
            <form action="modif_compte" method="post">
           
              <div class="form-group">
                <label for="disabledTextInput">Id</label>
                <input type="text"  name="Id" class="form-control" placeholder="id" disabled="disabled">
              </div>
            
              <div class="form-group">
                <label for="inputAddress">Nom</label>
                <input type="text" class="form-control" name="nom" placeholder="name">
              </div>

              <div class="form-group">
                <label for="inputAddress">Login</label>
                <input type="text" class="form-control" name="login" placeholder="login">
              </div>

              <div class="form-group">
                <label for="inputAddress">Ancienne mot de passe</label>
                <input type="password" class="form-control" name="OldMdp" placeholder="mot de passe">
              </div>

              <div class="form-group">
                <label for="inputAddress">Nouvelle mot de passe</label>
                <input type="password" class="form-control" name="NewMdp" placeholder="mot de passe">
              </div>

              <div class="form-group">
                <label for="inputAddress">Nouvelle mot de passe</label>
                <input type="password" class="form-control" name="NewMdp2" placeholder="mot de passe">
              </div>
               
              <button type="submit" class="btn btn-primary">Submit</button>
           
          </form>
        </fieldset> 
      </div>  



      <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  


            

           

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
</body>

</html>

