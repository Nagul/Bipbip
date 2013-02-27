<?php
/** 
 * Connect to the database and get ip addresses of connected robots.
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-27
 */
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}

$ip_result = mysqli_query($link,"SELECT ip FROM Robot WHERE online = 1");

while ($robot = mysqli_fetch_array($ip_result,MYSQLI_ASSOC)){
	echo $robot["ip"]." <br/>";
}

mysqli_free_result($ip_result);
mysqli_close($link);
?>
