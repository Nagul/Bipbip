<?php
// connect to the database and print the state of a node
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}
if (isset($_GET["node"])){
	$node = $_GET["node"];
}else{
	$node = 0;
	// TODO error : unset node
	exit();
}
if (isset($_GET["value"])){
	$new_value = $_GET["value"];
}else{
	$new_value = 0;
	// TODO error : unset value
	exit();
}

mysqli_query($link,"UPDATE Node SET is_taken = '$new_value' WHERE id_node ='$node'");
mysqli_close($link);
?>
