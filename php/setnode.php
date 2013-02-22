<?php
/** 
 * Connect to the database and print the state of a node.
 * @author Faly Razakarison
 * @version 1.0
 * @since 2013-02-21
 */
$link = mysqli_connect('localhost','root','projetbip','projetbip');
if(mysqli_connect_errno()){
	echo 'Connection error';
	exit();
}

// get the node id to update
if (isset($_GET["node"])){
	$node = $_GET["node"];
}else{
	$node = 0;
	echo "undefined node";
	exit();
}

// get the new value of the node
if (isset($_GET["value"])){
	$new_value = $_GET["value"];
}else{
	$new_value = 0;
	echo "undefined value";
	exit();
}

// update the node
mysqli_query($link,"UPDATE Node SET is_taken = '$new_value' WHERE id_node ='$node'");
mysqli_close($link);
?>
