<?php
   require __DIR__.'/vendor/autoload.php';

   use Kreait\Firebase\Factory;
   use Kreait\Firebase\ServiceAccount;

   $factory = (new Factory)->withServiceAccount(__DIR__ .'/adopcion-mascotas-ecuador-firebase-adminsdk-yrojd-5b84227a84.json')
     ->withDatabaseUri('https://adopcion-mascotas-ecuador-default-rtdb.firebaseio.com');

    $database = $factory->createDatabase();

?>