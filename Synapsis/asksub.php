<?php

if(isset($_POST['submit'])){

  $con = mysqli_connect("localhost","root","","datablood") ;

  function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
  }

  $name = test_input($_POST["name"]);
  $email = test_input($_POST["email"]);
  $comment = test_input($_POST["comment"]);

  $sql = "INSERT INTO `questions`(name, email, query) VALUES ('$name','$email','$comment')" ;

  if(mysqli_query($con, $sql)){
    echo '<script>alert("Your query has been submitted"); window.location = "index.php";</script>' ;
  }





}

?>
