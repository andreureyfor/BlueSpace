<?php

// Iniciem la sessió
session_start();

// Obtenim l'usuari de la sessió, si existeix
$usuari = isset($_SESSION['usuari']) ? $_SESSION['usuari'] : "";

// Requereix el fitxer de visualització "views/pelis.view.php"
require 'views/pelis.view.php';

?>