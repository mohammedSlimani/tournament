<%-- 
    Document   : main
    Created on : 29-Jan-2019, 15:51:28
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
        <link href="assets/js/jquery.bracket.min.css" rel="stylesheet">
        <link href="assets/css/login-register.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <script src="assets/js/jquery.bracket.min.js"></script>
        <script src="assets/js/login-register.js" type="text/javascript"></script>
    </head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/adminmain"><img class="img-responsive" src="assets/img/png/football-championship-trophy-variant.png">
                    Ensias Tournament <img class="img-responsive" src="assets/img/png/football-championship-trophy-variant.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link " href="${pageContext.request.contextPath}/admincontrol">Control Room</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/adminmain">Admin Room</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="${pageContext.request.contextPath}">Log Out</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Button trigger modal -->
        <div class="container padding">
            <div class="row">
                <div class="display-4">
                    List of responsibles
                </div>
                <div class="col-12">
                    <c:forEach var="r" items="${responsibles}" varStatus="vs">
                        <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#exampleModalCentered${vs.index}">
                            ${r.getName()}
                        </button>
                        <br>
                        <!-- Modal -->
                        <div class="modal" id="exampleModalCentered${vs.index}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenteredLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalCenteredLabel">Confirm Delete</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        Do you want to delete this responsible?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Delete</button>
                                        <button type="button" class="btn btn-primary">cancel</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>


        <hr class="my-4">

        <!--Stats-->
        <div class="container">
            <div class="col-12">
                <h4 class="display-6 text-center">Stats</h4>
            </div>
        </div>
        <div class="container padding">
            <div class="row padding">
                <div class="card">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Total Goals Marked:</li>
                        <li class="list-group-item">Total numbers of teams:</li>
                    </ul>
                </div>
            </div>
        </div>

    </body>

</html>
