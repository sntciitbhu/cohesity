<?php include('server.php'); ?>

<?php
$username="";
$errors=array();
$db=mysqli_connect('localhost','root','','datablood');
if(isset($_POST['login']))
{ 
     echo "Rishav";
    $username = mysqli_real_escape_string($db,$_POST['uName']);
    $password_1 = mysqli_real_escape_string($db,$_POST['upass']);
    $loginas= mysqli_real_escape_string($db,$_POST['ulogin']);
    
    
    if(empty($username))
    {
        array_push($errors,"User Name is Required");
    }
    if(empty($password_1))
    {
        array_push($errors,"Password is Required");
    } 
    
    if(count($errors)==0)
    {
        $password = md5($password_1);
        $query="SELECT * FROM users WHERE email='$username' AND password='$password' AND loginas='$loginas'";
        $result = mysqli_query($db,$query);
        if(mysqli_num_rows($result)==1)
        {
            session_start();
            $_SESSION['username']=$username;
            $_SESSION['success']="you are now logged in";
            if($loginas=='User')
            {
                header('location: db.php');
            }
            if($loginas=='Admin')
            {
                header('location: dbadmin.php');
            }
        }
        else
        {
            array_push($errors,"Incorrect username/password");
        }
    }
}
?>



<!doctype html>
<html lang="en">
  <head>
    <title>Login</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
    body{
      background-image: url(img/login.jpg);
      background-repeat: no-repeat;
      background-size: cover;

    }
    #one
    {
      margin-top:50px;
    }
    </style>
  </head>
  <body>
  <div class="container" id="one">
  
  <div class="card">
  
    <div class="card-body bg-light text-dark">
    <div class="card-col-md-4">
    <h2 class="text-center">LOG IN</h2>
      <div class="container">
          <form action="login.php" method="post">
              <div class="form-group row">                  
                  <div class="col-sm-6 center">
                      <input type="text" class="form-control " name="uName"  placeholder="Username">
                  </div>
              </div>
              <div class="form-group row">
               <div class="col-sm-6 center">
                      <input type="password" class="form-control" name="upass" placeholder="Password">
               </div>
              </div>
              <div class="form-group">
                <div class="col-sm-6">
                <label for="ulogin">Login as</label>
                <select class="form-control" name="ulogin" >
                  <option value="User">User</option>
                  <option value="Admin">Admin</option>
                </select>
                </div>
              </div>
         <div class="form-group">
         <input type="submit" class="btn btn-success" value="Log in" name="login">
         </div>
          </form>
          
      </div>
      </div>
    
    
    </div>
  </div>
</div>
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
      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
