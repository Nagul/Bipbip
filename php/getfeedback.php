<?php
/** 
 * Connect to the database and print information sent by a robot.
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
	// TODO Change and print information from all robot 
	exit();
}

// get order id
$feedback_result = mysqli_query($link,"SELECT label, value, sending_date FROM Feedback WHERE ip = '$robot_ip' AND acknoledgement = 0 ORDER BY sending_date");

// print the result
while ($feedback = mysqli_fetch_array($feedback_result,MYSQLI_ASSOC)){
	echo $feedback["sending_date"]." : ".$feedback["label"]." => ".$feedback["value"]." <br/>";
}
mysqli_free_result($feedback_result);
mysqli_close($link);
?>
