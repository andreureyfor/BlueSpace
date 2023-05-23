<?php

// Requereix el fitxer de visualització "views/registre.view.php"
require('views/registre.view.php');

// Inclou el fitxer "consulta.php", que conté la connexió a la base de dades
include("consulta.php");

// Comprova si s'ha enviat el formulari de registre
if (isset($_POST['registrarme'])) {

    // Comprova que els camps obligatoris estiguin omplerts
    if (
        strlen($_POST['usuari']) >= 1 &&
        strlen($_POST['pwd']) >= 1 &&
        strlen($_POST['correu']) >= 1
    ) {

        // Obté les dades enviades pel formulari
        $correu = $_POST["correu"];
        $usuari = $_POST["usuari"];
        $pwd = $_POST["pwd"];
      
        // Comprova si l'usuari ja existeix a la base de dades
        $sql_user = "SELECT usuari FROM compte WHERE usuari = '$usuari'";
        $result_user = mysqli_query($conn, $sql_user);

        // Comprova si l'adreça de correu electrònic ja existeix a la base de dades
        $sql_email = "SELECT email FROM clients WHERE email = '$correu'";
        $result_email = mysqli_query($conn, $sql_email);

        // Si l'usuari o l'adreça de correu electrònic ja existeixen a la base de dades, mostra un missatge d'error
        if (mysqli_num_rows($result_user) > 0 || mysqli_num_rows($result_email) > 0) {
            echo "<h2 class='avis'>L'usuari o l'adreça de correu electrònic ja existeixen a la base de dades.</h2>";
        } else {
            // Si l'usuari i l'adreça de correu electrònic no existeixen a la base de dades, procedeix amb el registre

            // Insereix un nou registre a la taula "clients" amb l'adreça de correu electrònic
            $client = "INSERT INTO clients (email) VALUES ('$correu')";
            mysqli_query($conn, $client);
            $id_client = mysqli_insert_id($conn);

            // Insereix un nou registre a la taula "compte" amb l'usuari, la contrasenya, l'ID del client i l'ID de modalitat (valor predeterminat 1)
            $compte = "INSERT INTO compte (usuari, contrasenya, data_alta, id_client, id_modalitat) 
             VALUES ('$usuari', '$pwd', CURRENT_DATE(),'$id_client', 1)";
            mysqli_query($conn, $compte);

            echo "<h2 class='avis'>L'usuari s'ha registrat correctament</h2>";
        }
    } else {
        // Si els camps obligatoris no estan omplerts, mostra un missatge d'error
            echo "<h2 class='avis'>Completa els camps correctament!</h2>";
    }
}

// Tanca la connexió a la base de dades
mysqli_close($conn);

?>