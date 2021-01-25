<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

// include database and object files
include_once '../config/database.php';
include_once '../objects/mascota.php';

// instantiate database and product object
$database = new Database();
$db = $database->getConnection();

$mascota = new Mascota($db);


// get posted data
$data = json_decode(file_get_contents("php://input"));
  
// make sure data is not empty
if(
        !empty($data->nombre) &&
        !empty($data->raza) &&
        !empty($data->contacto) &&
        !empty($data->sexo)&&
        !empty($data->especie)&&
        !empty($data->foto)
){

        // set pet property values
        $mascota->nombre = $data->nombre;
        $mascota->raza = $data->raza;
        $mascota->contacto = $data->contacto;
        $mascota->sexo = $data->sexo;
        $mascota->especie = $data->especie;
        $mascota->foto = $data->foto;
    
        // create the pet
        if($mascota->create()){
    
            // set response code - 201 created
            http_response_code(201);
    
            // tell the user
            echo json_encode(array("mensaje" => "La macota fue creada."));
        }
    
        // if unable to create the pet, tell the user
        else{
    
            // set response code - 503 service unavailable
            http_response_code(503);
    
            // tell the user
            echo json_encode(array("mensaje" => "No se puede crear la mascota."));
        }
    }
    
    // tell the user data is incomplete
    else{
    
        // set response code - 400 bad request
        http_response_code(400);
    
        // tell the user
        echo json_encode(array("mensaje" => "No se puede crear la mascota. Datos incompletos."));
    }
?>