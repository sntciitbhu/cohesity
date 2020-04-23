<html>
<head>
    <title>Ask Doctor</title>
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
 {
    margin-bottom: 0;


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

    <section id="head section" class="section1">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 col-lg-12 col-sm-12">
                    <h2 class="text-center">ASK DOCTORS</h2>
                </div>
            </div>
            <div class="row">
              <div class="container-fluid">
                <div class="panel panel-success">
                  <div class="panel-heading">Ask Your Queries Here</div>
                  <div class="panel-body">
                    <form class="form-horizontal" action="asksub.php" method="post">
                      <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Name:</label>
                        <div class="col-sm-10">
                          <input type="text" name="name" class="form-control" id="name" placeholder="Enter Name" required>
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Email:</label>
                        <div class="col-sm-10">
                          <input type="email" name="email" class="form-control" id="email" placeholder="Enter email" required>
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-sm-2" for="comment">Query/Question:</label>
                        <div class="col-sm-10">
                          <textarea class="form-control" name="comment" rows="5" id="comment" placeholder="Enter your Queries and Questions Here." required></textarea>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                          <button type="submit" name="submit" class="btn btn-success">Submit</button>
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="container-fluid">
                <div class="bg-warning">
                  <h3 class="text-center">*Keep an eye on your mailbox. You will be reverted shortly via E-mail</h3>
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

</body>


</html>
