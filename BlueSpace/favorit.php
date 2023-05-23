<?php

    // Iniciem la sessió
    session_start();

    // Obtenim l'usuari de la sessió, si existeix
    $usuari = isset($_SESSION['usuari']) ? $_SESSION['usuari'] : "";
    
    // Requereix el fitxer de visualització "views/favorit.view.php"
    require 'views/favorit.view.php';

?>