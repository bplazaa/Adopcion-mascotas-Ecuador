<?php
error_reporting(E_ALL);
date_default_timezone_set('America/Guayaquil');
 
// variables used for jwt
$key = "example_key";
$issued_at = time();
$expiration_time = $issued_at + (60 * 60); // valid for 1 hour
// $issuer = "http://localhost/CodeOfaNinja/RestApiAuthLevel1/";
?>