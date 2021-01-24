<?php
class Usuario{
  
    // database connection and table name
    private $conn;
    private $table_name = "usuario";
  
    // object properties
    public $idUsuario;
    public $nombreUsuario;
    public $apellidoUsuario;
    public $celular;
    public $direccion;
    public $edad;

  
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
                            celular = :celular,
                            direccion = :direccion
                        WHERE
                            idUsuario = :idUsuario";
            
                // prepare query statement
                $stmt = $this->conn->prepare($query);
            
                // sanitize
                $this->nombreUsuario=htmlspecialchars(strip_tags($this->nombreUsuario));
                $this->apellidoUsuario=htmlspecialchars(strip_tags($this->apellidoUsuario));
                $this->celular=htmlspecialchars(strip_tags($this->celular));
                $this->direccion=htmlspecialchars(strip_tags($this->direccion));
                $this->idUsuario=htmlspecialchars(strip_tags($this->idUsuario));
            
                // bind new values
                $stmt->bindParam(':nombreUsuario', $this->nombreUsuario);
                $stmt->bindParam(':apelllidoUsuario', $this->apelllidoUsuario);
                $stmt->bindParam(':celular', $this->celular);
                $stmt->bindParam(':direccion', $this->direccion);
                $stmt->bindParam(':idUsuario', $this->idUsuario);
            
                // execute the query
                if($stmt->execute()){
                    return true;
                }
            
                return false;
     }

}

?>