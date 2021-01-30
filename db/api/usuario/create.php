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

// instantiate database and product object
$database = new Database();
$db = $database->getConnection();

$usuario = new Usuario($db);


// get posted data
$data = json_decode(file_get_contents("php://input"));
 
// make sure data is not empty
if(
        !empty($data->nombreUsuario) &&
        !empty($data->apellidoUsuario) &&
        !empty($data->email) &&
        !empty($data->celular)&&
        !empty($data->direccion)&&
        !empty($data->edad)
){

        // set product property values
        $usuario->nombreUsuario = $data->nombreUsuario;
        $usuario->apellidoUsuario = $data->apellidoUsuario;
        $usuario->email = $data->email;
        $usuario->celular = $data->celular;
        $usuario->direccion = $data->direccion;
        $usuario->edad = $data->edad;
        $usuario->password = $data->password;
    
        // create the product
        if($usuario->create()){
    
            // set response code - 201 created
            http_response_code(201);
    
            // tell the user
            echo json_encode(array("mensaje" => "Se ha creado un nuevo usuario."));
        }
    
        // if unable to create the product, tell the user
        else{
    
            // set response code - 503 service unavailable
            http_response_code(503);
    
            // tell the user
            echo json_encode(array("mensaje" => "No se puede crear el usuario."));
        }
    }
    
    // tell the user data is incomplete
    else{
    
        // set response code - 400 bad request
        http_response_code(400);
    
        // tell the user
        echo json_encode(array("mensaje" => "No se puede crear un usuario. Datos incompletos."));
    }
?>