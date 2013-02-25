<?php
/** 
 * Connect to the database and delete orders for a robot using its ip address.
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-25
 */
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}

// get the target of the command
if (isset($_GET["target"])){
	$robot_ip = $_GET["target"];
}else{
	echo "undefined target";
	$robot_ip = 0;
	exit();
}

// get the order sequence 
if (isset($_GET["seq"])){
	$seq = $_GET["seq"];
	mysqli_query($link,"DELETE FROM Command WHERE ip='$robot_ip' AND seq = '$seq'");
}else{
	// delete all commands for the target
	mysqli_query($link,"DELETE FROM Command WHERE ip='$robot_ip'");
}

