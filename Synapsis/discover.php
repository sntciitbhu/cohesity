<?php
include('head.php');
$sql = "SELECT * FROM  symptoms";
$query = mysqli_query($con,$sql);
$result = mysqli_num_rows($query);
$sql2 ="SELECT DISTINCT body_part FROM symptoms  ";
$query2 = mysqli_query($con,$sql2);

?>


<!DOCTYPE html>
<html>

<head>
    <title>Blood Bank</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/main1.css">
    <style>
    input[type='checkbox']{
        width:20px;
        height:20px;
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

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-bank">
                <div class="row">
                    <div class="col-md-12">
                       
                            <div class="form-group">
                                <div class="col-md-4 form-group">
                                    <label>
                                        <h4>Select the Body Part:</h4>
                                    </label>
                                </div>

                                <div class="col-md-6">
                                    <select name="bpart" class="form-control" onchange="req(this.value)">
                                        <option value="NULL">--SELECT--</option>
                                        <?php
                                          while($row2=mysqli_fetch_assoc($query2)){
                                              $id = $row2['body_part'];
                                           echo "<option value=$id>$id</option>";
                                          }
                                           ?>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">

                            </div>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>

    

    <div class="row hid" style="display:none">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-bank">
                <div class="row">
                    <div class="col-md-12">
                        <form action="sym.php" method="post" style="display: block">
                            <div class="form-group">
                                <div class="col-md-12 form-group">
   



        <?php
                                          $sql3 = "SELECT * FROM symptoms WHERE body_part= 'Problems On Brains'";
                                          $query3 = mysqli_query($con,$sql3);
                      echo '<div>';                     
              echo '<table class="table table-stripped  ">' ;
              echo '<thead>';
              echo '<tr>';
            
              echo '<th>Symptoms</th>';
              echo '<th> select</th> ';
            
              echo '</tr>';
              echo '</thead>';
                                          while($row3=mysqli_fetch_assoc($query3)){
                                            echo '<tbody>';
                                            echo '<tr>';
                                                     
                                            echo '<td>'.$row3['symptom'].'</td>';
                                            echo '<td><input type="checkbox" name="val[]" value="' . $row3['sid'] .'"></td>';
                                            echo '</tr>';
                                            echo '</tbody>';
                                              
                                          }
                                          echo '<tr>';
                                          echo '<td></td>';
                                          echo '<td><center><button type="submit" name="submit" class="btn btn-success">Submit</button> </center></td>';
                                          echo '</tr>';
                                          
                                          echo '</table>' ;
                                          echo '</div>';
                                           ?>
    
    </div>
                            </div>
                            <div class="form-group">

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="row hid" style="display:none">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-bank">
                <div class="row">
                    <div class="col-md-12">
                        <form action="sym.php" method="post" role="list" style="display: block">
                            <div class="form-group">
                                <div class="col-md-12 form-group">


    <?php
                                          $sql4 = "SELECT * FROM symptoms WHERE body_part= 'glands_and_harmones'";
                                          $query4 = mysqli_query($con,$sql4);
                      echo '<div>';                     
              echo '<table class="table table-stripped">' ;
              echo '<thead>';
              echo '<tr>';
            
              echo '<th>Symptoms</th>';
              echo '<th> select</th> ';
            
              echo '</tr>';
              echo '</thead>';
                                          while($row4=mysqli_fetch_assoc($query4)){
                                            echo '<tbody>';
                                            echo '<tr>';
                                                     
                                            echo '<td>'.$row4['symptom'].'</td>';
                                            echo '<td><input type="checkbox" name="val[]" style="padding:20%" value="' . $row4['sid'] .'" onclick="func(this.value)" ></td>';
                                        
                                            
                                            echo '</tr>';
                                            echo '</thead>';
                                            
                                              
                                          }
                                          echo '<tr>';
                                          echo '<td></td>';
                                          echo '<td><center><button type ="submit" name="submit" class="btn btn-success">Submit</button> </center></td>';
                                          echo '</tr>';
                                          
                                          echo '</table>' ;
                                          echo '</div>';
                                           ?>
                                           </div>
                            </div>
                            <div class="form-group">

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row hid" style="display:none">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-bank">
                <div class="row">
                    <div class="col-md-12">
                        <form action="sym.php" method="post" role="list" style="display: block">
                            <div class="form-group">
                                <div class="col-md-12 form-group">
   
    

    <?php
                                          $sql5 = "SELECT * FROM symptoms WHERE body_part= 'ENT'";
                                          $query5 = mysqli_query($con,$sql5);
                      echo '<div>';                     
              echo '<table class="table table-stripped">' ;
              echo '<thead>';
              echo '<tr>';
            
              echo '<th>Symptoms</th>';
              echo '<th> select</th> ';
            
              echo '</tr>';
              echo '</thead>';
                                          while($row5=mysqli_fetch_assoc($query5)){
                                            echo '<tbody>';
                                            echo '<tr>';
                                                     
                                            echo '<td>'.$row5['symptom'].'</td>';
                                            echo '<td class="custom-control custom-checkbox"><input type="checkbox" class="custom-control-input " name="val[]" value="' . $row5['sid'] .'" onclick="func(this.value)" ></td>';
 
                                            
                                            echo '</tr>';
                                            echo '</tbody>';
                                              
                                          }
                                          echo '<tr>';
                                          echo '<td></td>';
                                          echo '<td><center><button type ="submit" name="submit" class="btn btn-success">Submit</button> </center></td>';
                                          echo '</tr>';
                                          
                                          echo '</table>' ;
                                          echo '</div>';
                                           ?>
    </div>
                            </div>
                            <div class="form-group">

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row hid" style="display:none">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-bank">
                <div class="row">
                    <div class="col-md-12">
                        <form action="sym.php" method="post" role="list" style="display: block">
                            <div class="form-group">
                                <div class="col-md-12 form-group">
   

    <?php
                                          $sql6 = "SELECT * FROM symptoms WHERE body_part= 'EYE'";
                                          $query6= mysqli_query($con,$sql6);
                      echo '<div>';                     
              echo '<table class="table table-stripped">' ;
              echo '<thead>';
              echo '<tr>';
            
              echo '<th>Symptoms</th>';
              echo '<th> select</th> ';
              echo '</tr>';
              echo '</thead>';
                                          while($row6=mysqli_fetch_assoc($query6)){
                                            echo '<tbody>';
                                            echo '<tr>';
                                                     
                                            echo '<td>'.$row6['symptom'].'</td>';
                                            echo '<td><input type="checkbox" name="val[]" value="' . $row6['sid'] .'" onclick="func(this.value)" ></td>';
 
                                            
                                            echo '</tr>';
                                            echo '</tbody>';
                                              
                                          }
                                          echo '<tr>';
                                          echo '<td></td>';
                                          echo '<td><center><button type ="submit" name="submit" class="btn btn-success">Submit</button> </center></td>';
                                          echo '</tr>';
                                          
                                          echo '</table>' ;
                                          echo '</div>';
                                           ?>
    </div>
                            </div>
                            <div class="form-group">

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


<script>
    function req(e){
        var a = document.getElementsByClassName("hid");
      if(e == "Problems"){
        a[0].style.display = "block" ;
        a[1].style.display = "none" ;
        a[2].style.display = "none" ;
        a[3].style.display = "none" ;
      }  
      else if(e == "glands_and_harmones"){
        a[0].style.display = "none" ;
        a[1].style.display = "block" ;
        a[2].style.display = "none" ;
        a[3].style.display = "none" ;
      }
      else if(e == "ENT"){
        a[0].style.display = "none" ;
        a[1].style.display = "none" ;
        a[2].style.display = "block" ;
        a[3].style.display = "none" ;
      }
      else if(e == "EYE"){
        a[0].style.display = "none" ;
        a[1].style.display = "none" ;
        a[2].style.display = "none" ;
        a[3].style.display = "block" ;
      }
      else{
        a[0].style.display = "none" ;
        a[1].style.display = "none" ;
        a[2].style.display = "none" ;
        a[3].style.display = "none" ;  
      }
    }
</script>
</body>

</html>