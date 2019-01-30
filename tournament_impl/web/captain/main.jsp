<%-- 
    Document   : main
    Created on : 29-Jan-2019, 19:17:24
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
        <script src="assets/js/login-register.js" type="text/javascript"></script>
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
                            <a class="nav-link active" href="${pageContext.request.contextPath}/captainmain">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="${pageContext.request.contextPath}/captainprofile">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/captainteam">Team</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!--Waiting for aproval message-->

        <div class="container-fluid">
            <div class="col-12">
                <div class="alert alert-warning text-center alert-dismissible fade show" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>Great</strong> Your submission is waiting aprouval from the Admin.
                </div>
            </div>
        </div>

        <!-- Next match-->
        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">Next Match </h1>
                    <h4 class="display-6">Date</h4>
                </div>
                <hr />
                <div class="col-5">
                    <div class="card">
                        <div class="card-body"> Team A </div>
                        <img class="card-img-bottom" src="assets/img/png/football-fan-raising-flag.png" alt="Card image cap">
                    </div>
                </div>
                <div class="col-2">
                    <div class="card">
                        <img class="card-img" src="assets/img/vs.jpg" alt="Card image cap">
                    </div>
                </div>
                <div class="col-5">
                    <div class="card">
                        <div class="card-body"> Team b</div>
                        <img class="card-img-bottom" src="assets/img/png/football-fan-raising-flag.png" alt="Card image cap">
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">History Of matches </h1>
                </div>
                <hr />
            </div>
        </div>
        <div class="container">
            <div class="tournament col-12">
                <script>
                    var minData = {
                        teams: [
                            ["A", "B"],
                            ["C", "D"],
                            ["E", "F"],
                            ["G", "H"]
                        ],
                        results: [
                            [
                                [1, 3],
                                [1, 4],
                                [2, 5],
                                [5, 1]
                            ],
                            [
                                [1, 2],
                                [4, 3]
                            ],
                            [
                                [4, 7],
                                [5, 4]
                            ]
                        ]
                    }
                    $('.tournament').bracket({
                        init: minData
                    });
                </script>
            </div>
        </div>


        <!-- Two Column Section -->

        <div class="container padding">
            <div class="col-12">
                <div class="display-4">
                    Your History of matches
                </div>
            </div>
            <div class="col-12">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Team A</th>
                            <th>Score A</th>
                            <th>Score B</th>
                            <th>Team B</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>A</td>
                            <td>0</td>
                            <td>1</td>
                            <td>B</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>C</td>
                            <td>10</td>
                            <td>11</td>
                            <td>D</td>
                        </tr>
                        <tr>
                            <th scope="row">1</th>
                            <td>A</td>
                            <td>0</td>
                            <td>1</td>
                            <td>B</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>C</td>
                            <td>10</td>
                            <td>11</td>
                            <td>D</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Stats -->
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
                        <li class="list-group-item">Total Goals on you:</li>
                    </ul>
                </div>
            </div>
        </div>


        <!--Footer-->
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

