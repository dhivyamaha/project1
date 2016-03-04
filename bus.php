<?php
	mysql_connect("localhost","root","");
	mysql_select_db("tollplaza");
	
	$name=$_REQUEST['name'];
	$vehicleno=$_REQUEST['vehicleno'];
	$passtype=$_REQUEST['passtype'];
        $amount=$_REQUEST['amount'];
	
$SQL = "INSERT INTO `bus`(`name`,`vehicleno`,`passtype`,`amount`,`status`) VALUES ('".$name."','".$vehicleno."','".$passtype."','".$amount."','not paid')";   
	$RES = mysql_query($SQL); 
$sql1 = "select id from bus where vehicleno='".$vehicleno."' ";

$result=mysql_query($sql1);
while ($row = mysql_fetch_array($result))
{
	$r=$row['id']; 


}
echo $r;
	  
	
	
?>
