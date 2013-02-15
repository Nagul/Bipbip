<?php
// add the ip address of a robot to the database and initialize its order
// TODO error case (target unset)
$robot_ip = $_GET["target"];
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}else{
	$result = mysqli_query($link,"SELECT * FROM Robot WHERE ip = '$robot_ip'");
	if (mysqli_num_rows($result) > 0){
	// change the state of the robot
		mysqli_query($link,"UPDATE Robot SET is_connected = 1 WHERE ip ='$robot_ip'");
		mysqli_query($link,"UPDATE Command c SET action = 'NONE' WHERE c.ip = '$robot_ip'");
	}else{
	// add the robot ip to database
		mysqli_query($link,"INSERT INTO Robot (ip,is_connected) VALUES ('$robot_ip','1')");
		mysqli_query($link,"INSERT INTO Command (id_c,action,datebegin,ip) VALUES (NULL,'NONE','now','$robot_ip')");
	}
}
mysqli_close($link);
?>
