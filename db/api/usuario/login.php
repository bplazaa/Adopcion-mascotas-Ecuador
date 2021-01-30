<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

include_once '../config/database.php';
include_once '../objects/usuario.php';

$database = new Database();
$db = $database->getConnection();

$usuario = new Usuario($db);

$data = json_decode(file_get_contents("php://input"));
 
$usuario->email = $data->email;
$email_exists = $usuario->emailExists();

include_once '../config/core.php';
include_once '../libs/php-jwt-master/src/BeforeValidException.php';
include_once '../libs/php-jwt-master/src/ExpiredException.php';
include_once '../libs/php-jwt-master/src/SignatureInvalidException.php';
include_once '../libs/php-jwt-master/src/JWT.php';

use \Firebase\JWT\JWT;

if($email_exists && password_verify($data->password, $usuario->password)){
 
    $token = array(
       "iat" => $issued_at,
       "exp" => $expiration_time,
       "iss" => $issuer,
       "data" => array(
           "idUsuario" => $usuario->idUsuario,
           "nombreUsuario" => $usuario->nombreUsuario,
           "apellidoUsuario" => $usuario->apellidoUsuario,
           "email" => $usuario->email,
           "celular" => $usuario->celular,
           "direccion" => $usuario->direccion,
           "edad" => $usuario->edad
       )
    );
 
    http_response_code(200);
 
    $jwt = JWT::encode($token, $key);
    echo json_encode(
            array(
                "message" => "Inicio de sesion exitoso.",
                "jwt" => $jwt
            )
        );
}

else{
    http_response_code(401); // Error
    echo json_encode(array("message" => "No se pudo iniciar sesion"));
}

?>