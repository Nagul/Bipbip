<?php
/** 
 * Connect to the database and send information from a robot to the server.
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-18
 */
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}
if (isset($_GET["target"])){
	$robot_ip = $_GET["target"];
}else{
	$robot_ip = 0;
	echo "undefined target";
	exit();
}

foreach ($_GET as $key => $value){
	if ($key != "target"){
		// write information in the database
		mysqli_query($link,"INSERT INTO Feedback (label,value,sending_date,acknoledgement,ip) VALUES ('$key','$value',NOW(),'0','$robot_ip')");
	}
}

mysqli_close($link);
?>
