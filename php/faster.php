<?php
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}
$robot_ip = $_GET["target"];
$faster = $_GET["action"];

if ($faster == 1){
	$speed = 5;
}
else
{
	$speed = -5;
}

mysqli_query($link,"UPDATE Command c, Parameter p SET p.value = p.value+$speed WHERE p.id_c = c.id_c AND c.ip = '$robot_ip'");
mysqli_close($link);
?>

<a href="http://192.168.0.35/faster.php?<?php echo "target=",$robot_ip,"&action=1"  ?>">FASTER</a>
<a href="http://192.168.0.35/faster.php?<?php echo "target=",$robot_ip,"&action=0"  ?>">SLOWER</a>
<br/>
speed : <?php echo $speed; ?>
