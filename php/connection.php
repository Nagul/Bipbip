<?php
// add the ip address of a robot to the database and initialize its order
if (isset($_GET["target"])){
	$robot_ip = $_GET["target"];
}else{
	$robot_ip = 0;
	// TODO error : unset target
	echo "undefined target";
	exit();
}
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}else{
	$result = mysqli_query($link,"SELECT * FROM Robot WHERE ip = '$robot_ip'");
	if (mysqli_num_rows($result) > 0){
	// change the state of the robot
		mysqli_query($link,"UPDATE Robot SET is_connected = 1 WHERE ip ='$robot_ip'");
		mysqli_query($link,"DELETE FROM Command WHERE ip='$robot_ip'");
		mysqli_query($link,"INSERT INTO Command (seq,action,datebegin,ip) VALUES ('0','NONE','now','$robot_ip')");
	}else{
	// add the robot ip to database
		mysqli_query($link,"INSERT INTO Robot (ip,is_connected) VALUES ('$robot_ip','1')");
		mysqli_query($link,"DELETE FROM Command WHERE ip='$robot_ip'");
		mysqli_query($link,"INSERT INTO Command (seq,action,datebegin,ip) VALUES ('0','NONE','now','$robot_ip')");
	}
}
mysqli_close($link);
?>
