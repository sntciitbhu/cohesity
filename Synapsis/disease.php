<html>

<head>
    <title>Latest Diseases</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/MAIN.css">
    <!-- <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .navbar-brand{
          transform: translateX(-50%);
          left: 50%;
          position: absolute;
          }

          #aad:hover, #lcny:hover, #cu:hover
          {
            box-shadow: 2px 2px 10px grey ;
          }

          .panel-body{
            padding:10px ;
          }

          .panel-body div{
            padding:5px ;
          }
    </style>

</head>

<body>

    <nav class="navbar navbar-inverse">
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
        <div class="col-md-8">
          <div><h3 class="text-center">Latest News</h3></div>
          <?php
          $con = mysqli_connect("localhost","root","","datablood");
          $sql="SELECT * FROM news" ;
          $result = mysqli_query($con,$sql) ;
          if(mysqli_num_rows($result)>0){
            while($row = mysqli_fetch_assoc($result)){
            echo ' <div class="panel panel-default"><div class="panel-body"><div><strong>TITLE:</strong>'. $row['title'] .'</div><div><strong>DATE:</strong>'. $row['date'] .'</div><div><strong>DESCRIPTION:</strong>'. $row['body'] .'</div></div></div> ';
            }
          }

          ?>

          <!-- <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">A Basic Panel</div>
          </div> -->
        </div>
        <div class="col-md-4 text-center" style="padding-top:15%;">
          <div id="aad" class="panel panel-default" style="background-color:#1abc9c;color:#fff;">
            <div class="panel-body">Ask A Doctor</div>
          </div>
          <div id="lcny" class="panel panel-default" style="background-color:#e67e22;color:#fff;">
            <div class="panel-body">Locate a Clinic Near You</div>
          </div>
          <div id="cu" class="panel panel-default" style="background-color:#c0392b;color:#fff;">
            <div class="panel-body">Contact Us</div>
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
    <script>
      $(function(){

        $("#aad").hover(function(){
          $(this).css("cursor", "pointer");
          });

        $("#lcny").hover(function(){
          $(this).css("cursor", "pointer");
          });

        $("#cu").hover(function(){
          $(this).css("cursor", "pointer");
          });

        $('#lcny').click(function(){

          function showPosition(position) {
            var lat = position.coords.latitude ;
            var lon = position.coords.longitude;
            //alert(lat + "," + lon) ;
            link = 'https://www.google.com/maps/search/Hospitals/@' + lat + ',' + lon +',13z/data=!3m1!4b1'
            window.open(link, '_blank') ;
          }

          if (navigator.geolocation) {
              navigator.geolocation.getCurrentPosition(showPosition);
            } else {
              alert("Geolocation is not supported by this browser.") ;
            }

        });

        $('#aad').click(function(){
          window.location.href = "ask.php" ;
        });

        $('#cu').click(function(){
          window.location.href = "about.php" ;
        });
      });
    </script>
</body>


</html>
