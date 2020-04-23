<?php include('server.php'); ?>



<html>

<head>
    <title>SIGNUP-PAGE</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="stylesheet" href="css/sign1.css">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"> -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <a class="navbar-brand" href="../index.php" style="color:cyan">SYNAPSES</a>

            <div class="collapse navbar-collapse" aria-expanded="true">
                <ul class="nav navbar-nav navbar-center">
                    <!-- <li class="active"><a href="/Synapses/index.php">HOME</a></li> -->
                    <li><a href="surgery">SURGERY</a></li>
                    <li><a href="/Synapses/bank.php">BLOOD BANK</a></li>
                    <li><a href="/Synapses/organ.php">ORGAN BANK</a></li>
                    <!-- <li><a href="dashboard.html">DASHBOARD</a></li>-->
                    <li><a href="about.php">ABOUT</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
            <div class="panel panel-success">
      <div class="panel-heading">Create An Account</div>
      <div class="panel-body">
      <form method="post" action="register.php" role="form">
                    <?php include('errors.php'); ?>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="name">NAME:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control " id="name" placeholder="NAME" name="fname">
                            <?php echo $username; ?>
                        </div>
                    </div>
                    <br>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class=" control-label col-sm-3" for="email">EMAIL:</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" id="email" placeholder="EMAIL" name="fmail">
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-3 " for="usid">CONFIRM EMAIL:</label>
                        <div class="col-sm-4">
                            <input type="USID" class="form-control " id="userid" placeholder="CONFIRM EMAIL" name="fmail1">
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-md-3" for="adharcard">AADHARCARD NO:</label>
                        <div class="col-sm-4">
                            <input type="USID" class="form-control " id="aadharcard" placeholder="AADHARCARD NO" name="fanumber">
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="gender">GENDER:</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="gender1" name="fgender">
                                <option value="Male">MALE</option>
                                <option value="Female">FEMALE</option>
                                <option value="Other's">Other's</option>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-md-3" for="confirmation">CONSULTED DOCTOR PREVIOUSLY:</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="confirmation1" name="fconsult">
                                <option value="Yes">YES</option>
                                <option value="No">NO</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3" for="confirmation">Registering As:</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="confirmation1" name="loginas">
                                <option value="User">User</option>
                                <option value="Admin">Agent</option>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="password">PASSWORD:</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control " id="password" placeholder="PASSWORD" name="fpassword">
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <center>
                            <button type="submit" name="register" class="btn btn-primary">Register</button>
                        </center>
                    </div>
                    <p>Already Registered <a href="login.php">Login</a></p>
                </form></div>
    </div>
            </div>
        </div>
    </div>

    
</body>

</html>