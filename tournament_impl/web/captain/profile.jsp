<%-- 
    Document   : profile
    Created on : 29-Jan-2019, 19:20:11
    Author     : rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Tournament</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="icon" href="assets/img/png/flaming-football.png">
        <link href="assets/css/jquery.bracket.min.css" rel="stylesheet">
        <link href="assets/css/login-register.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <script src="assets/js/jquery.bracket.min.js"></script>
        <script type="text/javascript" src="assets/js/addfield.js"></script>
        <script src="assets/js/login-register.js" type="text/javascript"></script>
        <script src="assets/js/addpic.js"></script>
    </head>


    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/captainmain"><img class="img-responsive" src="assets/img/png/football-championship-trophy-variant.png">
                    Ensias Tournament <img class="img-responsive" src="assets/img/png/football-championship-trophy-variant.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link " href="${pageContext.request.contextPath}/captainmain">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/captainprofile">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/captainteam">Team</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="${pageContext.request.contextPath}">Log Out</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!--title and picture -->
        <div class="container col-6 padding">
            <div class="display-4">
                You can change the password, See how nice we are :)
            </div>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">Old Password </span>
                </div>
                <input type="text" class="form-control">
            </div>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">New Password </span>
                </div>
                <input type="text" class="form-control">
            </div>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">Confirm </span>
                </div>
                <input type="text" class="form-control">
            </div>
            <div class="input-group">
                <button class="btn btn-primary" type="button" name="button">Change password</button>
            </div>
        </div>

        <!--footer-->
        <footer>
            <div class="container-fluid padding">
                <div class="row text-center">
                    <div class="col-md-4">
                        <img id="lastimg" src="assets/img/png/football-championship-trophy-variant.png">
                        <hr class="light">
                        <p> 0612345678</p>
                        <p> email@gmail.com</p>
                        <p> Al Irfan</p>
                        <p> Rabat, Morocco</p>
                    </div>
                    <div class="col-md-4">
                        <hr class="light">
                        <h5>Our Goals</h5>
                        <hr class="light">
                        <p>Expand to new colleges</p>
                        <p>Help people have fun</p>
                    </div>
                    <div class="col-md-4">
                        <hr class="light">
                        <h5>Last words</h5>
                        <hr class="light">
                        <p>Good luck</p>
                        <p>Have fun</p>
                    </div>
                    <div class="col-12">
                        <hr class="light">
                        <h5>&copy;<a href="http://www.Ensias.ma">www.Ensias.ma</a></h5>
                    </div>
                </div>
            </div>
        </footer>

    </body>

</html>
