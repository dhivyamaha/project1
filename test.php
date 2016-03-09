<?php
mysql_connect("localhost", "root","");
mysql_select_db("credit");
	$cardno=$_REQUEST['cardno'];	
        $amount=$_REQUEST['amount'];
         $cvv=$_REQUEST['cvv'];
        $id=$_REQUEST['id1'];
        $type=$_REQUEST['type'];
$query = "SELECT amount FROM statebank where cardno='".$cardno."' AND cvv='".$cvv."'";
$result = mysql_query($query);    
 while ($row = mysql_fetch_array($result))
{
	$r=$row['amount']; 
}
echo $r;
if($r>$amount)
{      
$red=$r-$amount;

$sql = "UPDATE statebank SET amount=$red WHERE cardno='".$cardno."' AND cvv='".$cvv."' ";

if (mysql_query($sql) == TRUE) 
{
mysql_connect("localhost", "root","");
mysql_select_db("tollplaza");
 
 if($type=="BUS")
 {

		$que="UPDATE bus SET status='paid' WHERE id='".$id."'";

		$res=mysql_query($que);
 }
 else if($type=="CAR")
 {

		$que="UPDATE car SET status='paid' WHERE id='".$id."'";

		$res=mysql_query($que);
 }
 else if($type=="LCV")
 {

		$que="UPDATE lcv SET status='paid' WHERE id='".$id."'";

		$res=mysql_query($que);
 }
 
 else if($type=="THREE-WHEELER")
 {

		$que="UPDATE three SET status='paid' WHERE id='".$id."'";

		$res=mysql_query($que);
 }   
}
} 


?>