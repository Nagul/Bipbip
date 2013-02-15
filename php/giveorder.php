<?php
// connect to the database and update the order for a robot using its ip address
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}
// TODO error case (action or target unset)
$action = $_GET["action"];
$id_c = 0;
if (isset($_GET["target"])){
	$robot_ip = $_GET["target"];
	$id_result = mysqli_query($link,"SELECT id_c FROM Command WHERE ip='$robot_ip'");
	$id_row = mysqli_fetch_array($id_result,MYSQLI_ASSOC);
	$id_c = $id_row["id_c"];
}else{
	$robot_ip = 0;
	// TODO error
}
foreach ($_GET as $key => $value){
	if ($key != "action" & $key != "target"){
		$result = mysqli_query($link,"SELECT * FROM Parameter WHERE label = '$key'");
		if (mysqli_num_rows($result) > 0){
			// change the value of the parameter in the database
			mysqli_query($link,"UPDATE Parameter SET value = '$value' WHERE label='$key' AND id_c=$id_c");
		}else{
			// add the parameter in the database
			mysqli_query($link,"INSERT INTO Parameter (label,value,id_c) VALUES ('$key','$value',$id_c)");
		}
	}
}
mysqli_query($link,"UPDATE Command c, CommandType ct SET c.action = ct.action WHERE ct.id_nxc = $action AND c.ip = '$robot_ip'");
mysqli_close($link);
?>

<a href="http://192.168.0.35/projetbip/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=0">NONE</a>
<a href="http://192.168.0.35/projetbip/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=1">STOP</a>
<a href="http://192.168.0.35/projetbip/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=2">FORWARD </a>
<a href="http://192.168.0.35/projetbip/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=3">BACKWARD</a>
<a href="http://192.168.0.35/projetbip/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=4">LEFT</a>
<a href="http://192.168.0.35/projetbip/giveorder.php?<?php echo "target=",$robot_ip  ?>&action=5">RIGHT</a>
