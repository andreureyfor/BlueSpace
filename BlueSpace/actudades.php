<?php

// Iniciem la sessió
session_start();

// Obtenim el valor de l'usuari de la sessió si existeix, sinó assignem una cadena buida
$usuari = isset($_SESSION['usuari']) ? $_SESSION['usuari'] : "";

// Incluim el fitxer de consulta.php
require 'consulta.php';

// Incluim la vista actudades.view.php
require './views/actudades.view.php';

// Consulta per obtenir les dades del client
$query = "SELECT * FROM clients INNER JOIN compte ON compte.id_client = clients.id_client WHERE usuari = '" . $usuari . "'";
$resultado = mysqli_query($conn, $query);

// Comprovem si hi ha hagut un error en la consulta
if (!$resultado) {
    die('Error en la consulta: ' . mysqli_error($conn));
}

// Comprovem si hi ha registres retornats per la consulta
if (mysqli_num_rows($resultado) > 0) {
    $fila = mysqli_fetch_assoc($resultado);

    // Obtenim les dades del client
    $contrasenya = $fila['contrasenya'];
    $nom = $fila['nom'];
    $email = $fila['email'];
    $telefon = $fila['telefon'];
    $dni = $fila['dni'];
    $adreca = $fila['adreca'];
    $nacionalitat = $fila['nacionalitat'];

    // Mostrem el títol i el formulari per actualitzar les dades
    echo "<h1 class='titol'>Actualitza les teves dades</h1>";
    echo "<form method='POST' class='actu'>";

    echo "<label for='contrasenya'>Contrasenya:</label><br>";
    echo "<input type='password' name='contrasenya' value='$contrasenya'><br>";

    echo "<label for='text'>Nom:</label><br>";
    echo "<input type='text' name='nom' value='$nom'><br>";

    echo "<label for='dni'>DNI:</label><br>";
    echo "<input type='text' name='dni' value='$dni'><br>";

    echo "<label for='adreca'>Adreça:</label><br>";
    echo "<input type='text' name='adreca' value='$adreca'><br>";

    echo "<label for='nacionalitat'>Nacionalitat:</label><br>";
    echo "<input type='text' name='nacionalitat' value='$nacionalitat'><br>";

    echo "<label for='email'>Email:</label><br>";
    echo "<input type='email' name='email' value='$email'><br>";

    echo "<label for='telefon'>Teléfon:</label><br>";
    echo "<input type='tel' name='telefon' value='$telefon'><br>";

    // Menú desplegable per seleccionar el tipus de modalitat
    echo "<label for='telefon'>Modalitat:</label><br>";
    echo "<select name='tipus' class='selecio'>";
    echo "<option value='1' >Gratuïta</option>";
    echo "<option value='2'>Bàsica</option>";
    echo "<option value='3'>Premium</option>";
    echo "</select>";

    echo "<label for='telefon'>Actualitzar:</label><br>";
    echo "<input type='submit' value='Actualizar Dades'>";
    echo "</form>";
    echo "</div>";
} else {
    echo 'No s\'han trobat registres.';
}

// Comprovem si s'ha enviat el formulari mitjançant el mètode POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    // Obtenim les dades enviades pel formulari
    $contrasenya = $_POST['contrasenya'];
    $nom = $_POST['nom'];
    $dni = $_POST['dni'];
    $adreca = $_POST['adreca'];
    $nacionalitat = $_POST['nacionalitat'];
    $email = $_POST['email'];
    $telefon = $_POST['telefon'];
    $id_modalitat = $fila['id_modalitat'];

    // Comprovem si s'ha seleccionat el tipus de modalitat
    if (isset($_POST['tipus'])) {
        $tipus = mysqli_escape_string($conn, $_POST['tipus']);
        if ($tipus == "1") {
            $id_modalitat = 1;
        } else if ($tipus == "2") {
            $id_modalitat = 2;
        } else if ($tipus == "3") {
            $id_modalitat = 3;
        }
    }

    // Actualitzem les dades del client a la base de dades
    $query = "UPDATE clients INNER JOIN compte ON compte.id_client = clients.id_client SET  nom = '$nom', email = '$email', telefon = '$telefon', dni = '$dni', adreca = '$adreca', nacionalitat = '$nacionalitat' WHERE usuari = '" . $usuari . "'";
    $result = mysqli_query($conn, $query);

    // Actualitzem la modalitat i la contrasenya del compte
    $query1 = "UPDATE compte INNER JOIN clients ON clients.id_client = compte.id_client SET id_modalitat = '$id_modalitat', contrasenya = '$contrasenya'   WHERE usuari = '" . $usuari . "'";
    $result1 = mysqli_query($conn, $query1);

    // Consulta per obtenir les dades actualitzades del client
    $sql1 = "SELECT nom, email, telefon, dni, adreca, nacionalitat, tipus FROM clients INNER JOIN compte ON clients.id_client = compte.id_client INNER JOIN modalitat ON modalitat.id_modalitat = compte.id_modalitat WHERE usuari = '" . $usuari . "'";
    $result2 = mysqli_query($conn, $sql1);

    // Comprovem si s'han actualitzat les dades amb èxit
    if ($result && $result1) {

        echo "<h2 class='titolactu'>Dades Actualitzades</h2>";

        // Comprovem si s'han retornat registres per la consulta
        if (mysqli_num_rows($result2) > 0) {

            while ($row = mysqli_fetch_assoc($result2)) {
                echo "<div class=dades>";

                echo "<span><p>Nom: " . $row['nom'] . "</p><span>";
                echo "<span><p>Email: " . $row["email"] . "</p><span>";
                echo "<span><p>Teléfon: " . $row["telefon"] . "</p><span>";
                echo "<span><p>DNI: " . $row["dni"] . "</p><span>";
                echo "<span><p>Adreça: " . $row["adreca"] . "</p><span>";
                echo "<span><p>Nacionalitat: " . $row["nacionalitat"] . "</p><span>";
                echo "<span><p>Tipus: " . $row["tipus"] . "</p><span>";

                echo "</div>";
            }
        } else {
            echo "0 resultats";
        }
    } else {
        echo 'Error en actualitzar les dades: ' . mysqli_error($conn);
    }

}



















































// $nom = $_POST["nom"];
// $cognom = $_POST["cognom"];
// $dni = $_POST["dni"];
// $correu = $_POST["correu"];
// $telefon = $_POST["telefon"];
// $data = $_POST["data"];
// $adreca = $_POST["adreca"];
// $nacionalitat = $_POST["nacionalitat"];
// $targeta = $_POST["targeta"];
// $compte = $_POST["compte"];
// $modalitat = $_POST["modalitat"];
// $usuari = $_POST["usuari"];
// $pwd = $_POST["pwd"];

// $sqlAntiguo = "SELECT email FROM clients WHERE usuari = '" . $usuari . "'";
// $resultadoAntiguo = $conn->query($sqlAntiguo);

// if ($resultadoAntiguo->num_rows > 0) {
//     // Obtener los datos antiguos
//     $fila = $resultadoAntiguo->fetch_assoc();
//     $correu = $fila["email"];
// } else {
//     echo "No se encontraron datos antiguos.";
// }


//  $sql1 = "SELECT usuari ,contrasenya,nom,cognom,email,telefon,dni,data_naixement,adreca,nacionalitat,num_targeta,num_compte_banc FROM clients INNER JOIN compte ON clients.id_client = compte.id_client WHERE usuari = '" . $usuari . "'";
//  $result1 = mysqli_query($conn, $sql1);



// if (mysqli_num_rows($result1) > 0) {

//     while ($row = mysqli_fetch_assoc($result1)) {
//     echo "<div class=dades>";

//     echo "<span><p>Usuari: " . $_POST["usuari"] . "</p><span>";    
//     echo "<span><p>Contrasenya: " . $row["contrasenya"] . "</p><span>";
//     echo "<span><p>Nom: " . $row["nom"] . "</p><span>";
//     echo "<span><p>Cognom: " . $row["cognom"] . "</p><span>";
//     echo "<span><p>Email: " . $row["email"] . "</p><span>";
//     echo "<span><p>Teléfon: " . $row["telefon"] . "</p><span>";
//     echo "<span><p>DNI: " . $row["dni"] . "</p><span>";
//     echo "<span><p>Data_Naixement: " . $row["data_naixement"] . "</p><span>";
//     echo "<span><p>Adreça: " . $row["adreca"] . "</p><span>";
//     echo "<span><p>Nacionalitat: " . $row["nacionalitat"] . "</p><span>";
//     echo "<span><p>Num Targeta: " . $row["num_targeta"] . "</p><span>";
//     echo "<span><p>Num Compte: " . $row["num_compte_banc"] . "</p><span>";

//     echo "</div>";
//     }
// } else {
//    echo "0 results";
// }

mysqli_close($conn);
?>