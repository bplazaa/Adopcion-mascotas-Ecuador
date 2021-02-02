<?php
 require_once 'db_function.php';
 $db=new DB_Functions();
 $response = array("error"=>FALSE);
 if(isset($_POST['email']) && isset($_POST['password'])){
     
    $email=$_POST['email'];
    $password=$_POST['password'];
       
    $user = $db->getUserByEmailAndPassword($email,$password);
    if($user!=false)    {
        echo "ingreso" ;

        $response["error"]=FALSE;
        $response["uid"]=$user["unique_id"];
        $response["user"]["name"]=$user["name"];
        $response["user"]["email"]=$user["email"];
        $response["user"]["created_at"]=$user["created_at"];
        $response["user"]["updated_at"]=$user["updated_at"];
        echo json_encode($response);
        
    }else{
        echo "ingresoddddd" ;

        $response["error"]=TRUE;
        $response["error_msg"]="INFORMACION DEL LOGIN INCORRECTA!!";
        echo json_encode($response);

    }

    
  } else
 {
     $response["error"]=TRUE;
     $response["error_msg"]="error en los parametros!!";
     echo json_encode($response);
 }


 ?>