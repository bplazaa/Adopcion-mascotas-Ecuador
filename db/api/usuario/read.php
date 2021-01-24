<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
  

include_once '../config/database.php';
include_once '../objects/usuario.php';
  
// instantiate database and product object
$database = new Database();
$db = $database->getConnection();

$usuario = new Usuario($db);

$stmt = $usuario->read();
$num = $stmt->rowCount();
  
// Si se han encontrado mas de 0 resultados de mascota
if($num>0){
  
    // products array
    $usuario_arr=array();
    $usuario_arr["records"]=array();
  
    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
        extract($row);
  
        $usuario_item=array(
            "idUsuario"=>$idUsuario,
            "nombreUsuario" => $nombreUsuario,
            "apellidoUsuario" => $apellidoUsuario,
            "email" => $email,
            "celular" => $celular,
            "direccion" => $direccion,
            "edad" => $edad
        );
  
        array_push($usuario_arr["records"], $usuario_item);
        
    }
  

    http_response_code(200); // OK
    echo json_encode($usuario_arr); // Envia datos como json
}
  
else{
    // No se han encontrado usuarios
    http_response_code(404); // Error
    echo json_encode(
        array("mensaje" => "No se encontro ningun usuario  :(")
    );
}

