<?php
// connect to the database and get the order for a robot using its ip address
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}
// TODO error case (unset target)
$robot_ip = $_GET["target"];
// get order id
$order_result = mysqli_query($link,"SELECT ct.id_nxc FROM Command c, CommandType ct WHERE c.ip = '$robot_ip' AND ct.action = c.action");
$order = mysqli_fetch_array($order_result,MYSQLI_ASSOC);

// get parameters of the command
$param_result = mysqli_query($link,"SELECT p.label,p.value FROM Parameter p, Command c WHERE c.ip = '$robot_ip' AND p.id_c=c.id_c");

// print the result
echo $order["id_nxc"];
while ($parameters = mysqli_fetch_array($param_result,MYSQLI_ASSOC)){
	echo ";".$parameters["label"].":".$parameters["value"];
}
mysqli_free_result($order_result);
mysqli_free_result($param_result);
mysqli_close($link);
?>