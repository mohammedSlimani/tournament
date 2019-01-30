<%-- 
    Document   : more
    Created on : 29-Jan-2019, 20:51:29
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
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home"><img class="img-responsive" src="assets/img/png/football-championship-trophy-variant.png">
                    Ensias Tournament <img class="img-responsive" src="assets/img/png/football-championship-trophy-variant.png"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/home">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">Log in</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!--- Image Slider -->
        <div class="modal fade login" id="loginModal">
            <div class="modal-dialog login animated">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Login</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box">
                            <div class="content">
                                <div class="division">
                                    <div class="line l"></div>
                                    <span></span>
                                    <div class="line r"></div>
                                </div>
                                <div class="error"></div>
                                <div class="form loginBox">
                                    <form method="post" action="/login" accept-charset="UTF-8">
                                        <input id="email" class="form-control" type="text" placeholder="Email" name="email">
                                        <input id="password" class="form-control" type="password" placeholder="Password" name="password">
                                        <input class="btn btn-default btn-login" type="button" value="Login" onclick="loginAjax()">
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="box">
                            <div class="content registerBox" style="display:none;">
                                <div class="form">
                                    <form method="post" data-remote="true" action="/register" accept-charset="UTF-8">
                                        <input id="username" class="form-control" type="text" placeholder="username" name="username">
                                        <input id="email" class="form-control" type="text" placeholder="Email" name="email">
                                        <input id="password" class="form-control" type="password" placeholder="Password" name="password">
                                        <input id="password_confirmation" class="form-control" type="password" placeholder="Repeat Password" name="password_confirmation">
                                        <input id="team_title" class="form-control" type="text" placeholder="Team title" name="team_title">
                                        <input class="btn btn-default btn-register" type="submit" value="Create account" name="commit">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="forgot login-footer">
                            <span>Looking to
                                <a href="javascript: showRegisterForm();">create an account</a>
                                ?</span>
                        </div>
                        <div class="forgot register-footer" style="display:none">
                            <span>Already have an account?</span>
                            <a href="javascript: showLoginForm();">Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- History -->
        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">History Of matches </h1>
                </div>
                <hr />
            </div>
        </div>

        <div class="container">
            <br />
            <div class="row justify-content-center">
                <div class="col-12 col-md-10 col-lg-8">
                    <form class="card card-sm">
                        <div class="card-body row no-gutters align-items-center">
                            <div class="col-auto">
                                <i class="fas fa-search h4 text-body"></i>
                            </div>
                            <!--end of col-->
                            <div class="col">
                                <input class="form-control form-control-lg form-control-borderless" type="search" placeholder="Search topics or keywords">
                            </div>
                            <!--end of col-->
                            <div class="col-auto">
                                <button class="btn btn-lg btn-success" type="submit">Search</button>
                            </div>
                            <!--end of col-->
                        </div>
                    </form>
                </div>
                <!--end of col-->
            </div>
        </div>


        <!-- Table -->
        <div class="container padding">
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
                            <th scope="row">3</th>
                            <td>A</td>
                            <td>0</td>
                            <td>1</td>
                            <td>B</td>
                        </tr>
                        <tr>
                            <th scope="row">4</th>
                            <td>C</td>
                            <td>10</td>
                            <td>11</td>
                            <td>D</td>
                        </tr>
                        <tr>
                            <th scope="row">5</th>
                            <td>A</td>
                            <td>0</td>
                            <td>1</td>
                            <td>B</td>
                        </tr>
                        <tr>
                            <th scope="row">6</th>
                            <td>C</td>
                            <td>10</td>
                            <td>11</td>
                            <td>D</td>
                        </tr>
                        <tr>
                            <th scope="row">7</th>
                            <td>A</td>
                            <td>0</td>
                            <td>1</td>
                            <td>B</td>
                        </tr>
                        <tr>
                            <th scope="row">8</th>
                            <td>C</td>
                            <td>10</td>
                            <td>11</td>
                            <td>D</td>
                        </tr>
                        <tr>
                            <th scope="row">9</th>
                            <td>A</td>
                            <td>0</td>
                            <td>1</td>
                            <td>B</td>
                        </tr>
                        <tr>
                            <th scope="row">10</th>
                            <td>C</td>
                            <td>10</td>
                            <td>11</td>
                            <td>D</td>
                        </tr>
                        <tr>
                            <th scope="row">11</th>
                            <td>A</td>
                            <td>0</td>
                            <td>1</td>
                            <td>B</td>
                        </tr>
                        <tr>
                            <th scope="row">12</th>
                            <td>C</td>
                            <td>10</td>
                            <td>11</td>
                            <td>D</td>
                        </tr>
                        <tr>
                            <th scope="row">13</th>
                            <td>A</td>
                            <td>0</td>
                            <td>1</td>
                            <td>B</td>
                        </tr>
                        <tr>
                            <th scope="row">14</th>
                            <td>C</td>
                            <td>10</td>
                            <td>11</td>
                            <td>D</td>
                        </tr>
                    </tbody>
                </table>
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
