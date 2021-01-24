<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
  

include_once '../config/database.php';
include_once '../objects/mascota.php';
  
// instantiate database and product object
$database = new Database();
$db = $database->getConnection();

$mascota = new Mascota($db);

$stmt = $mascota->read();
$num = $stmt->rowCount();
  
// Si se han encontrado mas de 0 resultados de mascota
if($num>0){
  
    // products array
    $mascotas_arr=array();
    $mascotas_arr["records"]=array();
  
    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
        extract($row);
  
        $mascota_item=array(
            "nombre" => $nombre,
            "raza" => $raza,
            "contacto" => $contacto,
            "sexo" => $sexo,
            "especie" => $especie
        );
  
        array_push($mascotas_arr["records"], $mascota_item);
    }
  

    http_response_code(200); // OK
    echo json_encode($mascotas_arr); // Envia datos como json
}
  
else{
    // No se han encontrado mascotas
    http_response_code(404); // Error
    echo json_encode(
        array("message" => "No se encontro a la mascota")
    );
}

