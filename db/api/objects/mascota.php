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

    function create(){
  
        // query to insert record
        $query = "INSERT INTO mascota
                SET
                    nombre=:nombre, raza=:raza, contacto=:contacto, sexo=:sexo, especie=:especie, foto=:foto";
      
        // prepare query
        $stmt = $this->conn->prepare($query);
      
        // sanitize
        $this->nombre=htmlspecialchars(strip_tags($this->nombre));
        $this->raza=htmlspecialchars(strip_tags($this->raza));
        $this->contacto=htmlspecialchars(strip_tags($this->contacto));
        $this->sexo=htmlspecialchars(strip_tags($this->sexo));
        $this->especie=htmlspecialchars(strip_tags($this->especie));
        $this->foto=htmlspecialchars(strip_tags($this->foto));
      
        // bind values
        $stmt->bindParam(":nombre", $this->nombre);
        $stmt->bindParam(":raza", $this->raza);
        $stmt->bindParam(":contacto", $this->contacto);
        $stmt->bindParam(":sexo", $this->sexo);
        $stmt->bindParam(":especie", $this->especie);
        $stmt->bindParam(":foto", $this->foto);
        
        // execute query
        if($stmt->execute()){
            return true;
        }
      
        return false;
          
    }


    // update the pet
    function update(){
    
        // update query
        $query = "UPDATE
                    mascota
                SET
                    nombre = :nombre,
                    raza = :raza,
                    contacto = :contacto,
                    sexo = :sexo,
                    especie = :especie,
                    foto= :foto
                WHERE
                    id = :id";
    
        // prepare query statement
        $stmt = $this->conn->prepare($query);
    
        // sanitize
        $this->nombre=htmlspecialchars(strip_tags($this->nombre));
        $this->raza=htmlspecialchars(strip_tags($this->raza));
        $this->contacto=htmlspecialchars(strip_tags($this->contacto));
        $this->sexo=htmlspecialchars(strip_tags($this->sexo));
        $this->especie=htmlspecialchars(strip_tags($this->especie));
        $this->foto=htmlspecialchars(strip_tags($this->foto));
    
        // bind new values
        $stmt->bindParam(':nombre', $this->nombre);
        $stmt->bindParam(':raza', $this->raza);
        $stmt->bindParam(':contacto', $this->contacto);
        $stmt->bindParam(':sexo', $this->sexo);
        $stmt->bindParam(':especie', $this->especie);
        $stmt->bindParam(':foto', $this->foto);
        $stmt->bindParam(':id', $this->id);
    
        // execute the query
        if($stmt->execute()){
            return true;
        }
    
        return false;
    }

}

?>