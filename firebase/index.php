<div>
    <div>
        <table>
            <thead>
                <tr>
                    <th>Edad</th>
                    <th>Nombre</th>
                    <th>Raza</th>
                    <th>Contacto</th>
                    <th>Descripcion</th>
                    <th>Sexo</th>
                    <th>Especie</th>
                </tr>
            </thead>
            <tbody>
                <?php
                    include('includes/dbconfig.php');

                    $ref = "mascota/";
                    $fetchdata = $database -> getReference($ref)->getValue();
                    foreach($fetchdata as $key => $row){
                      
                ?>


                <tr>
                    <td> <?php echo $row['edad'] ?> </td>
                    <td> <?php echo $row['nombre'] ?></td>
                    <td> <?php echo $row['raza'] ?> </td>
                    <td> <?php echo $row['contacto'] ?> </td>
                    <td> <?php echo $row['about'] ?> </td>
                    <td> <?php echo $row['sexo'] ?> </td>
                    <td> <?php echo $row['especie'] ?> </td>
                </tr>

                <?php
                    }
                
                ?>
            
            </tbody>
        </table>
        
    </div>


</div>