<?php

// Dades per connectar a la base de dades
$servername = "localhost:3306";
$username = "root";
$password = "1234";
$dbname = "bluespace";

// Creem una nova connexió a la base de dades
$conn = new mysqli($servername, $username, $password, $dbname);

// Comprovem si hi ha algun error en la connexió
if ($conn->connect_error) {
     die("La connexió ha fallat: " . $conn->connect_error);
}

?>