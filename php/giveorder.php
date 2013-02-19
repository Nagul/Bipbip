<?php
// connect to the database and update the order for a robot using its ip address
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}
// TODO error case (action or target unset)
$action = $_GET["action"];
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
	$seq = 0;
}

mysqli_query($link,"INSERT INTO Command (seq,action,datebegin,ip) SELECT '$seq',action,'now','$robot_ip' FROM CommandType WHERE id_nxc = $action");

// reset parameters of specified robot
//mysqli_query($link,"DELETE FROM Parameter WHERE seq=$seq AND ip=$robot_ip");
foreach ($_GET as $key => $value){
	if ($key != "action" & $key != "target" & $key != "seq"){
		// add the parameter in the database
		mysqli_query($link,"INSERT INTO Parameter (label,value,seq,ip) VALUES ('$key','$value',$seq,'$robot_ip')");
	}
}

mysqli_close($link);
?>

<a href="http://192.168.0.35/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=0">NONE</a>
<a href="http://192.168.0.35/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=1">STOP</a>
<a href="http://192.168.0.35/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=2">FORWARD </a>
<a href="http://192.168.0.35/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=3">BACKWARD</a>
<a href="http://192.168.0.35/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=4">LEFT</a>
<a href="http://192.168.0.35/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=5">RIGHT</a>
