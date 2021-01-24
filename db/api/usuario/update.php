<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
  
// include database and object files
include_once '../config/database.php';
include_once '../objects/usuario.php';
  
// get database connection
$database = new Database();
$db = $database->getConnection();
  
// prepare product object
$usuario = new Usuario($db);
  
// get id of product to be edited
$data = json_decode(file_get_contents("php://input"));
  
// set ID property of product to be edited
$usuario->idUsuario = $data->idUsuario;
  
// set product property values
$usuario->nombreUsuario = $data->nombreUsuario;
$usuario->apellidoUsuario = $data->apellidoUsuario;
$usuario->email = $data->email;
$usuario->celular = $data->celular ;
$usuario->direccion = $data->direccion;
$usuario->edad = $data->edad;
  
// update the product
if($usuario->update()){
  
    // set response code - 200 ok
    http_response_code(200);
  
    // tell the user
    echo json_encode(array("mensaje" => "El usuario fue actualizado."));
}
  
// if unable to update the product, tell the user
else{
  
    // set response code - 503 service unavailable
    http_response_code(503);
  
    // tell the user
    echo json_encode(array("mensaje" => "No se puedo actualizar el usuario."));
}
?>