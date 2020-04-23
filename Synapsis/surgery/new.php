<?php
$db = mysqli_connect('localhost','root','','datablood');
$bp="eye";
$sql="SELECT  *  from symptoms WHERE bodypart= '$bp' ";

$query=mysqli_query($con,$sql);
$result=mysqli_num_rows($query);
if($result>0)
{
    echo '<table class="table table-striped table-bordered table-hover table-condensed">';
    echo '<tr><th>id</th><th>body parts</th><th>symptom</th>';
    while($row = mysqli_fetch_array($query,MYSQLI_ASSOC))
    {
        echo '<tr>';
        echo '<td>'.$id++.'</td>';
        echo '<td>'.$row['body part'].'</td>';
        echo '<td>'.$row['symptom'].'</td>';
        echo '<td><a href="'.$row['book'].'">Click Here</a></td>';
        echo '</tr>';
    }

}
$sql2="SELECT * from doctors where body part= '$bp'  ";
$query2=mysqli_query($con,$sql2);
$result2=mysqli_num_rows($query2);
if($result2>0){

}

