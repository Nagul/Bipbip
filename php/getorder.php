<?php
// connect to the database and get the order for a robot using its ip address
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}
if (isset($_GET["target"])){
	$robot_ip = $_GET["target"];
}else{
	$robot_ip = 0;
	// TODO error : unset target
	exit();
}
if (isset($_GET["seq"])){
	$seq = $_GET["seq"];
}else{
	$nb_cmd_query = mysqli_query($link,"SELECT COUNT(*) FROM Command WHERE ip = '$robot_ip'");
	$nb_cmd = mysqli_fetch_row($nb_cmd_query);
	echo $nb_cmd[0];
	exit();
}
if (isset($_GET["reset"])){
	mysqli_query($link,"DELETE FROM Command WHERE ip='$robot_ip'");
	exit();
}
// get order id
$order_result = mysqli_query($link,"SELECT ct.id_nxc FROM Command c, CommandType ct WHERE c.ip = '$robot_ip' AND ct.action = c.action AND seq='$seq'");
$order = mysqli_fetch_array($order_result,MYSQLI_ASSOC);
// get parameters of the command
$param_result = mysqli_query($link,"SELECT label,value FROM Parameter WHERE ip = '$robot_ip' AND seq='$seq'");

// print the result
echo $order["id_nxc"];
while ($parameters = mysqli_fetch_array($param_result,MYSQLI_ASSOC)){
	echo ";".$parameters["label"].":".$parameters["value"];
}
mysqli_free_result($order_result);
mysqli_free_result($param_result);
mysqli_close($link);
?>
