<html>

<head>
    <title></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/MAIN.css">
    <!-- <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css" rel="stylesheet">
    <style>
        .navbar-brand{
    transform: translateX(-50%);
    left: 50%;
    position: absolute;
}
 #join
 {margin-bottom: 0;

}


 
</style>
</head>

<body>
    <nav class="navbar navbar-inverse" id="join">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#" style="color:cyan;">SYNAPSES</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="register.php"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="login.php"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- <div class="header">
        <header class="home-section">
            <img src="img/business-care-clinic-1282308.jpg" class="rounded" width="100%" height="81%">
        </header>
    </div> -->

    <!-- Set up your HTML -->
    <div class="owl-carousel owl-theme owl-loaded">
        <div class="owl-stage-outer">
            <div class="owl-stage">
                <div class="owl-item"><img src="img/cor-image/img1.jpg" class="rounded" width="100%" height="81%"></div>
                <div class="owl-item"><img src="img/cor-image/img2.jpg" class="rounded" width="100%" height="81%"></div>
                <div class="owl-item"><img src="img/cor-image/img3.jpg" class="rounded" width="100%" height="81%"></div>
            </div>
        </div>
    </div>
    <section id="head section" class="section1">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 col-lg-12 col-sm-12">
                    <h2 class="text-center">OUR SERVICES</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 an" id="one">
                    <div class="thumbnail">
                        <h3 class="text-center">SURGERY</h3>
                        <center><i style="font-size:80px;padding:20px;color:#2ecc71;" class="fa fa-heartbeat"></i></center>
                        <center> <a type="button" class="btn btn-primary" href="surgery">Know More.</a></center>
                    </div>
                </div>
                <div class="col-md-4 an" id="two">
                    <div class="thumbnail">
                        <h3 class="text-center">BLOOD BANK</h3>
                        <center><i style="font-size:80px;padding:20px;color:#e74c3c;" class="fa fa-tint"></i></center>
                        <center> <a type="button" class="btn btn-primary" href="bank.php">Know More.</a> </center>

                    </div>
                </div>

                <div class="col-md-4 an" id="three">
                    <div class="thumbnail">
                        <h3 class="text-center">ORGAN BANK</h3>
                        <center><i style="font-size:80px;padding:20px;color:#f39c12;" class="fa fa-odnoklassniki"></i></center>
                        <center> <a type="button" class="btn btn-primary" href="organ.php">Know More.</a></center>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 an" id="four">
                    <div class="thumbnail">
                        <h3 class="text-center">FIND YOUR DOCTOR</h3>
                        <center><i style="font-size:80px;padding:20px;color:#c0392b;" class="fa fa-user-md"></i></center>
                        <center> <a type="button" class="btn btn-primary" href="discover.php">Know More.</a></center>
                    </div>
                </div>
                <div class="col-md-6 an" id="five">
                    <div class="thumbnail">
                        <h3 class="text-center">DISCOVER</h3>
                        <center><i style="font-size:80px;padding:20px;color:f39c12;" class="fa fa-search"></i></center>
                        <center> <a type="button" class="btn btn-primary" href="disease.php">Know More.</a> </center>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <br>
    <br>
    <footer class="page-footer">
        <div class="container-fluid">
            <div class="text-center">

                <div class="row" style="background:black">
                    <div class="col-md-12 col-sm-12 col-lg-12" style="background:black ;color:white;">
                        <img src="img/foot.png">
                        <p style="text-align:center">DESIGNED BY TEAM Cloud Busters© 2019 Copyright</p>
                    </div>
                </div>
          </div>
        </div>
    </footer>


    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Bootstrap JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>


    <script>
        $(document).ready(function () {
            var owl = $('.owl-carousel');
            owl.owlCarousel({
                items: 1,
                loop: true,
                margin: 20,
                autoplay: true,
                autoplayTimeout: 1800,
                dots: false
            });
        });
    </script>

</body>


</html>