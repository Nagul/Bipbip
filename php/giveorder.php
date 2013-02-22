<?php
/** 
 * Connect to the database and update the order for a robot using its ip address.
 * @author Faly Razakarison
 * @version 1.4
 * @since 2013-02-15
 */
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}
// get the command to execute
if (isset($_GET["action"])){
	$action = $_GET["action"];
}else{
	$action = "NONE";
	echo "undefined action";
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
}else{
	$seq = 0;
}

mysqli_query($link,"INSERT INTO Command (seq,action,datebegin,ip) SELECT '$seq',action,'now','$robot_ip' FROM CommandType WHERE id_nxc = $action");

// reset parameters of a specified command (uncomment the following line)
//mysqli_query($link,"DELETE FROM Parameter WHERE seq=$seq AND ip=$robot_ip");
foreach ($_GET as $key => $value){
	if ($key != "action" & $key != "target" & $key != "seq"){
		// add the parameter in the database
		mysqli_query($link,"INSERT INTO Parameter (label,value,seq,ip) VALUES ('$key','$value',$seq,'$robot_ip')");
	}
}

mysqli_close($link);
?>
