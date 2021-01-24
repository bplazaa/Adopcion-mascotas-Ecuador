<?php
class Mascota{
  
    // database connection and table name
    private $conn;
    private $table_name = "mascota";
  
    // object properties
    public $id;
    public $nombre;
    public $raza;
    public $contacto;
    public $sexo;
    public $especie;
    public $foto;
  
    // constructor with $db as database connection
    public function __construct($db){
        $this->conn = $db;
    }

    function read(){
        $query = "SELECT
                    nombre, raza,contacto,sexo,especie,foto
                FROM mascota ";
      
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
      
        return $stmt;
    }

    
    function delete(){
  
        $query = "DELETE FROM mascota WHERE id = ?";
      
        $stmt = $this->conn->prepare($query);
        $this->id=htmlspecialchars(strip_tags($this->id));
        $stmt->bindParam(1, $this->id);
      
        if($stmt->execute()){
            return true;
        }
      
        return false;
    }

}
?>