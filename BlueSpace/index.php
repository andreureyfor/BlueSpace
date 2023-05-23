<?php

// Requereix el fitxer de connexió a la base de dades
require 'consulta.php';

// Comprova si la sol·licitud és de tipus POST
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $usuari = $_POST["usuari"];
    $passw = $_POST["passw"];

    // Realitza una consulta a la base de dades per obtenir les dades de l'usuari
    $query = mysqli_query($conn, "SELECT usuari, contrasenya FROM compte WHERE usuari = '".$usuari."' AND contrasenya = '".$passw."'");
    $num = mysqli_num_rows($query);

    // Comprova si s'ha trobat una coincidència d'usuari i contrasenya
    if ($num == 1) {
        // Inicia la sessió i emmagatzema el nom d'usuari a la variable de sessió 'usuari'
        session_start();
        $_SESSION['usuari'] = $usuari;

        // Requereix el fitxer de visualització "views/home.view.php" per mostrar la pàgina d'inici
        require 'views/home.view.php';
    } else if ($num == 0) {
        // En cas que no es trobi cap coincidència, redirigeix a la pàgina de connexió
        require 'login.php';
    }
} else {
    // Si no es fa una sol·licitud POST, redirigeix a la pàgina de connexió
    require 'login.php';
}

?>



