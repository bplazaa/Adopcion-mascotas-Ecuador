<?php

require './vendor/autoload.php';


$mascotas = [];
echo 'hola';
$redis = new Predis\Client();
echo 'hola';
$cachedEntry = $redis->get('mascotas');

if($cachedEntry)
{
	echo "REDIS";
	$mascotas = $cachedEntry;
	
}else
{
	echo "REST API";
	$mascotas = file_get_contents("http://ec2-100-24-28-1.compute-1.amazonaws.com/Adopcion-mascotas-Ecuador/db/api/mascota/read.php");
	$redis -> set  ('mascotas',$mascotas);
	$redis -> expire ('mascotas', 10);
}

echo $mascotas

?>