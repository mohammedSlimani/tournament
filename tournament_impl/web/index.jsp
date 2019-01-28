<%-- 
    Document   : index
    Created on : 27-Jan-2019, 20:35:17
    Author     : rick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Tournament</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
        <link rel="icon" href="assests/img/png/flaming-football.png"/>
        <link href="assets/css/jquery.bracket.min.css" rel="stylesheet"/>
        <link href="assets/css/login-register.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet"/>
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

        <div id="slides" class="carousel slide" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0" class="active"></li>
                <li data-target="#slides" data-slide-to="1"></li>
            </ul>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="assets/img/background.jpg">
                    <div class="carousel-caption">
                        <h1 class="display-2">Ensias Tournament</h1>
                        <h3> Register Your Team Now!</h3>
                        <button type="button" data-toggle="modal" onclick="openLoginModal();" class="btn btn-primary btn-lg">Get Started</button>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="assets/img/background3.jpg">
                    <div class="carousel-caption">
                        <h3><br>Leave the management to us and worry about winning</h3>
                    </div>
                </div>
            </div>
        </div>

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
                                        <input class="btn btn-default btn-login" type="submit" value="Login" >
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

        <!-- Welcome Section -->
        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4">Current Match </h1>
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

        <!--bracket view-->
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

        <!--More info-->
        <div class="container padding">
            <div class="row padding">
                <div class="col-lg-6">
                    <h2>But Wait, there is more</h2>
                    <p>You can check the history of every Tournament that has been played before </p>
                    <p>Yeah, we know curious people like you exists </p>
                    <br>
                    <a href="more.html" class="btn btn-primary">Learn more</a>
                </div>
                <div class="col-lg-6">
                    <div class="tenor-gif-embed" data-postid="12587594" data-share-method="host" data-width="100%" data-aspect-ratio="1.0375">
                        <a href="https://tenor.com/view/john-travolta-lost-where-confused-gif-12587594">John Travolta Lost GIF</a>
                    </div>
                    <script type="text/javascript" async src="https://tenor.com/embed.js"></script>
                </div>
            </div>
        </div>
        <hr class="my-4">

        <!--- Fixed background -->
        <figure>
            <div class="fixed-wrap">
                <div id="fixed">
                </div>
            </div>
        </figure>

        <!-- Meet the team -->
        <div class="container-fluid padding">
            <div class="row welcome text-center">
                <div class="col-12">
                    <h1 class="display-4"> Meet The Team</h1>
                </div>
                <hr>
            </div>
        </div>

        <!--- Cards -->
        <div id="team" class="container-fluid padding">
            <div class="row padding">
                <div class="col-md-3 col-sm-6">
                    <div class="card">
                        <img class="card-img-top" src="assets/img/team/slimani.jpg">
                        <div class="card-body">
                            <h4 class="card-title">Slimani Med</h4>
                            <p class="card-text">Just another dude, Nothing to worry about. Keep scrolling </p>
                            <a href="https://www.facebook.com/smed.slimani" target="_blank" class="btn btn-outline-secondary"> See Profile</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="card">
                        <img class="card-img-top" src="assets/img/team/amine.jpg">
                        <div class="card-body">
                            <h4 class="card-title">Sebâaoui Amine</h4>
                            <p class="card-text"> Know also as "MR Steal your Girl, Better watch out for your girl." </p>
                            <a href="https://www.facebook.com/amine.sebaaoui/" target="_blank" class="btn btn-outline-secondary"> See Profile</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="card">
                        <img class="card-img-top" src="assets/img/team/tarouchi.jpg">
                        <div class="card-body">
                            <h4 class="card-title">Tarouchi Hossam</h4>
                            <p class="card-text"> He is a lot longer than he seams in pictures</p>
                            <a href="https://www.facebook.com/HOSSAM.TAROUCHI" target="_blank" class="btn btn-outline-secondary"> See Profile</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="card">
                        <img class="card-img-top" src="assets/img/team/soufi.jpg">
                        <div class="card-body">
                            <h4 class="card-title">Soufi Hassan</h4>
                            <p class="card-text">A legend with no picture of him online. A ghost, ? </p>
                            <a href="https://www.facebook.com/profile.php?id=100010305279439" target="_blank" class="btn btn-outline-secondary"> See Profile</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--- Footer -->
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
