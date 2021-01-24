<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
  

include_once '../config/database.php';
include_once '../objects/mascota.php';
  
// db
$database = new Database();
$db = $database->getConnection();
  
$mascota = new Mascota($db);
  
$data = json_decode(file_get_contents("php://input"));
$mascota->id = $data->id;
  
if($mascota->delete()){
    http_response_code(200);
    echo json_encode(array("mensaje" => "Mascota eliminada"));
}
  
else{
  
    http_response_code(503);
    echo json_encode(array("mensaje" => "No se pudo eliminar a la mascota"));
}
?>