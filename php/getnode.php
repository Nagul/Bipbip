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
if (isset($_GET["node"])){
	$node = $_GET["node"];
}else{
	$node = 0;
	echo "undefined node";
	exit();
}

$node_result = mysqli_query($link,"SELECT is_taken FROM Node WHERE id_node='$node' ");
$node_row = mysqli_fetch_array($node_result,MYSQLI_ASSOC);
// print the node state
echo $node_row["is_taken"];

mysqli_free_result($node_result);
mysqli_close($link);
?>
