<?php
class Usuario{
  
    // database connection and table name
    private $conn;
    private $table_name = "usuario";
  
    // object properties
    public $idUsuario;
    public $nombreUsuario;
    public $apellidoUsuario;
    public $email;
    public $celular;
    public $direccion;
    public $edad;
    public $password;

  
    // constructor with $db as database connection
    public function __construct($db){
        $this->conn = $db;
    }
 
    // update the user data
    function update(){
            
        // update query
        $query = "UPDATE usuario
                        SET
                            nombreUsuario = :nombreUsuario,
                            apellidoUsuario = :apellidoUsuario,
                            email = :email,
                            celular = :celular,
                            direccion = :direccion,
                            edad = :edad
                        WHERE
                            idUsuario = :idUsuario";
            
                // prepare query statement
                $stmt = $this->conn->prepare($query);
            
                // sanitize
                $this->nombreUsuario=htmlspecialchars(strip_tags($this->nombreUsuario));
                $this->apellidoUsuario=htmlspecialchars(strip_tags($this->apellidoUsuario));
                $this->email=htmlspecialchars(strip_tags($this->email));
                $this->celular=htmlspecialchars(strip_tags($this->celular));
                $this->direccion=htmlspecialchars(strip_tags($this->direccion));
                $this->edad=htmlspecialchars(strip_tags($this->edad));
                $this->idUsuario=htmlspecialchars(strip_tags($this->idUsuario));
            
                // bind new values
                $stmt->bindParam(':nombreUsuario', $this->nombreUsuario);
                $stmt->bindParam(':apellidoUsuario', $this->apellidoUsuario);
                $stmt->bindParam(':email', $this->email);
                $stmt->bindParam(':celular', $this->celular);
                $stmt->bindParam(':direccion', $this->direccion);
                $stmt->bindParam(':edad', $this->edad);
                $stmt->bindParam(':idUsuario', $this->idUsuario);
            
                // execute the query
                if($stmt->execute()){
                    return true;
                }
            
                return false;
    }

    function read(){
        $query = "SELECT
                    idUsuario,nombreUsuario, apellidoUsuario,email,celular,direccion,edad
                FROM usuario ";
      
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
      
        return $stmt;
    }
    function delete(){
  
        $query = "DELETE FROM usuario WHERE idUsuario = ?";
      
        $stmt = $this->conn->prepare($query);
        $this->idUsuario=htmlspecialchars(strip_tags($this->idUsuario));
        $stmt->bindParam(1, $this->idUsuario);
      
        if($stmt->execute()){
            return true;
        }
      
        return false;
    }

 
    function create(){
  
        // query to insert record
        $query = "INSERT INTO usuario
                SET
                nombreUsuario=:nombreUsuario, apellidoUsuario=:apellidoUsuario, email=:email,password=:password, celular=:celular, direccion=:direccion, edad=:edad";
      
        // prepare query
        $stmt = $this->conn->prepare($query);
      
        // sanitize
        $this->nombreUsuario=htmlspecialchars(strip_tags($this->nombreUsuario));
        $this->apellidoUsuario=htmlspecialchars(strip_tags($this->apellidoUsuario));
        $this->email=htmlspecialchars(strip_tags($this->email));
        $this->password=htmlspecialchars(strip_tags($this->password));
        $this->celular=htmlspecialchars(strip_tags($this->celular));
        $this->direccion=htmlspecialchars(strip_tags($this->direccion));
        $this->edad=htmlspecialchars(strip_tags($this->edad));
      
        // bind values
        $stmt->bindParam(":nombreUsuario", $this->nombreUsuario);
        $stmt->bindParam(":apellidoUsuario", $this->apellidoUsuario);
        $stmt->bindParam(":email", $this->email);

        $password_hash = password_hash($this->password, PASSWORD_BCRYPT);
        $stmt->bindParam(":password", $password_hash);
        
        $stmt->bindParam(":celular", $this->celular);
        $stmt->bindParam(":direccion", $this->direccion);
        $stmt->bindParam(":edad", $this->edad);

        // execute query
        if($stmt->execute()){
            return true;
        }
      
        return false;
    }

    function emailExists(){
         $query = "SELECT idUsuario,nombreUsuario, apellidoUsuario,
                    email,celular,direccion,edad,password
                FROM usuario
                WHERE email = ?
                LIMIT 0,1";
     
        $stmt = $this->conn->prepare( $query );
     
        $this->email=htmlspecialchars(strip_tags($this->email));
        $stmt->bindParam(1, $this->email);
     
        $stmt->execute();
     
        $num = $stmt->rowCount();
     
        if($num>0){
            // email existe en db
            $row = $stmt->fetch(PDO::FETCH_ASSOC);
     
            $this->idUsuario = $row['idUsuario'];
            $this->nombreUsuario = $row['nombreUsuario'];
            $this->apellidoUsuario = $row['apellidoUsuario'];
            $this->password = $row['password'];
            $this->celular = $row['celular'];
            $this->direccion = $row['direccion'];
            $this->edad = $row['edad'];
     
            return true;
        }
     
        return false; //No existe el email en db
    }
     

}

?>