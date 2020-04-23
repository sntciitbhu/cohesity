


<?php
include('head.php');
$bgoup='';
$bcity='';
$id=1;
$errors=array();
?>

<!DOCTYPE html>
<html>

<head>
    <title>Blood Bank</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <style>
    #footer
     {
    clear: both;
    position: relative;
    height: 10px;
    margin-top: -5px;
}
   
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="true" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.php" style="color:cyan">SYNAPSES</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.php">HOME</a></li>
                    <li><a href="surgery">SURGERY</a></li>
                    <li><a href="bank.php">BLOOD BANK</a></li>
                    <li><a href="organ.php">ORGAN BANK</a></li>
                    <li><a href="about.php">ABOUT US</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="login.php"><i class="glyphicon glyphicon-log-in"></i> LOGIN</a></li>
                </ul>
            </div>
        </div>
    </nav>


<div class="container-fluid">
<div class="panel panel-default">
      <div class="panel-heading panel-success">
            <h1>Doctors Based Upon your Query</h1>
      </div>
      <div class="panel-body panel-info">
            <h3> On The Basis Of Your Symptoms This Is The List Of specialist Doctors In There Fields </h3>
            


<?php


if(isset($_POST['submit']))
{
    $arr = $_POST['val'] ;
    $size = sizeof($arr) ;
    
    echo '<div class="col-md-12">';
    echo '<table class="table table-hover">' ;
    echo '<thead>';
    echo '<tr class="success">';
  
    echo '<th>Doctors Name</th>';
    echo '<th> Contact No</th> ';
    echo '</tr>';
    echo '</thead>';
    for($i=0;$i<$size;$i++){

        $sql2 ='SELECT DISTINCT docname,doccontact FROM docs WHERE sid=' .  $arr[$i];
        $query2=mysqli_query($con,$sql2);
        $result2 = mysqli_fetch_array($query2,MYSQLI_ASSOC);
       
    
        echo '<tbody>';
        echo '<tr>';
        echo '<td>'.$result2['docname'].'</td>';
        echo '<td>'.$result2['doccontact'].'</td>';
        echo '</tr>';
        echo '</tbody>';
        
       
        //echo mysqli_error($con) ;
        //echo $sql2 ;


    }
    
    echo '</table>';
    echo '</div>';
}




?>
 </div>
                </div>
            
</div>

    <footer class="page-footer" id="footer">
        <div class="container-fluid">
            <div class="text-center">

                <div class="row" style="background:black">
                    <div class="col-md-6" style="background:black ;color:white;left:25%">

                        <img src="img/foot.png">
                        <p style="text-align:center">DESIGNED BY TEAM Cloud Busters© 2019 Copyright</p>
                        </center>
                    </div>


                </div>
            </div>

    </footer>

</body>
</html>

