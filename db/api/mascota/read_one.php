<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: access");
header("Access-Control-Allow-Methods: GET");
header("Access-Control-Allow-Credentials: true");
header('Content-Type: application/json');
  
include_once '../config/database.php';
include_once '../objects/mascota.php';
  
$database = new Database();
$db = $database->getConnection();
  
$mascota = new Mascota($db);
$mascota->id = isset($_GET['id']) ? $_GET['id'] : die();
  
$mascota->readOne();
  
if($mascota->nombre!=null){

    $mascota_arr = array(
            "id" =>  $mascota->id,
            "nombre" => $mascota-> nombre,
            "raza" => $mascota-> raza,
            "contacto" => $mascota-> contacto,
            "sexo" => $mascota-> sexo,
            "especie" => $mascota-> especie,
            "foto" => $mascota-> foto
  
    );
  
    http_response_code(200); //OK
    echo json_encode($mascota_arr);
}
  
else{
    http_response_code(404);
    echo json_encode(array("message" => "La mascota no existe"));
}
?>