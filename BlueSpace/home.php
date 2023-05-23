<?php

// Inicia la sessió
session_start();

// Comprova si l'usuari està autenticat i obté el nom d'usuari de la sessió
$usuari = isset($_SESSION['usuari']) ? $_SESSION['usuari'] : "";

// Requereix el fitxer de visualització "views/home.view.php"
require 'views/home.view.php';

?>