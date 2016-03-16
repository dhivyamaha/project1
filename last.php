<?php

  mysql_connect("localhost", "root","");

  mysql_select_db("tollplaza");

  $id=$_REQUEST['id'];
    
   // $id = '70';

    $type = 'BUS';

  // $type=$_REQUEST['type'];


  if($type=="BUS")
  {
    
    $query_search = "select * from bus where id= '".$id."'";

    $query_exec = mysql_query($query_search) or die(mysql_error());

    $row = mysql_fetch_assoc($query_exec);

    echo $row['vehicleno']."@@@@".$row['passtype']."@@@@".$row['amount']."@@@@".$row['status'];
  }

  else if($type=="CAR")
  {
    
    $query_search = "select * from car where id= '".$id."'";

    $query_exec = mysql_query($query_search) or die(mysql_error());

    $row = mysql_fetch_assoc($query_exec);

    echo $row['vehicleno']."@@@@".$row['passtype']."@@@@".$row['amount']."@@@@".$row['status'];
  }

  else if($type=="LCV")
  {
    
    $query_search = "select * from lcv where id= '".$id."'";

    $query_exec = mysql_query($query_search) or die(mysql_error());

    $row = mysql_fetch_assoc($query_exec);

    echo $row['vehicleno']."@@@@".$row['passtype']."@@@@".$row['amount']."@@@@".$row['status'];
  }

  else if($type=="THREE-WHEELER")
  {
    
    $query_search = "select * from three where id= '".$id."'";

    $query_exec = mysql_query($query_search) or die(mysql_error());

    $row = mysql_fetch_assoc($query_exec);

    echo $row['vehicleno']."@@@@".$row['passtype']."@@@@".$row['amount']."@@@@".$row['status'];
  }
?>