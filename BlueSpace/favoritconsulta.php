<?php
// Requereix el fitxer "consulta.php", que conté la connexió a la base de dades
require 'consulta.php';
session_start();
$usuari = isset($_SESSION['usuari']) ? $_SESSION['usuari'] : "";
// Consulta SQL per obtenir les dades de les pel·lícules i les seves produccions relacionades
$sql = "SELECT p.caratula, pro.nom, p.duracio, hc.favorit, pro.id_produccio FROM produccions AS pro 
        INNER JOIN pelis AS p ON p.id_produccio = pro.id_produccio 
        INNER JOIN ha_consumit AS hc ON hc.id_produccio = pro.id_produccio 
        INNER JOIN compte AS c ON c.id_compte = hc.id_compte WHERE c.usuari = '$usuari' AND hc.favorit = 1;";

$sql2 = "SELECT s.caratula, pro.nom, pro.any_produccio, hc.favorit, pro.id_produccio FROM produccions AS pro 
         INNER JOIN series AS s ON s.id_produccio = pro.id_produccio  
         INNER JOIN ha_consumit AS hc ON hc.id_produccio = pro.id_produccio 
         INNER JOIN compte AS c ON c.id_compte = hc.id_compte WHERE c.usuari = '$usuari' AND hc.favorit = 1;";

// Executa la consulta SQL
$result = $conn->query($sql);
$result2 = $conn->query($sql2);
// Comprova si hi ha resultats en la consulta
if ($result->num_rows > 0) {
   // Recorre cada fila de resultats
   echo "<h2>Pel·licules</h2>";
   while ($row = $result->fetch_assoc()) {
      echo "<div class='peli'>";
      echo "<img src='./imatges/" . $row["caratula"] . "' alt='caràtula'>";
      echo "<p>" . $row["nom"] . " </p>";
      echo "<p>" . $row["duracio"] . " min.</p>";

      $eye_sql = "SELECT hc.num_visualitzacio, compte.usuari, pro.id_produccio 
            FROM produccions AS pro 
            INNER JOIN ha_consumit AS hc ON pro.id_produccio = hc.id_produccio 
            INNER JOIN compte ON compte.id_compte = hc.id_compte 
            WHERE compte.usuari = '$usuari' AND pro.id_produccio = hc.id_produccio 
            GROUP BY pro.id_produccio";
            
      $psql = $row["id_produccio"];
      $eye_result = $conn->query($eye_sql);

      if ($eye_result->num_rows > 0) {
         while ($eye_row = $eye_result->fetch_assoc()) {
            $num_visualitzacio = $eye_row['num_visualitzacio'];
            if ($num_visualitzacio > 0 && $psql == $eye_row["id_produccio"]) {
               echo '<i class="fa fa-eye" style="font-size:24px; color:white; height: 30px;"></i>';
            }
         }
      }
      echo  "</form>";
      echo "</div>";
   }
   } else {
      
   }

if ($result2->num_rows > 0) {
   // Recorre cada fila de resultats
   echo "<h2>Series</h2>";
   while ($row = $result2->fetch_assoc()) {
   echo "<div class='peli'>";
   echo "<img src='./imatges/" . $row["caratula"] . "' alt='caràtula'>";
   echo "<p>" . $row["nom"] . " </p>";
   echo "<p>" . $row["any_produccio"] . " min.</p>";

      $eye_sql = "SELECT hc.num_visualitzacio, compte.usuari, pro.id_produccio 
        FROM produccions AS pro 
        INNER JOIN ha_consumit AS hc ON pro.id_produccio = hc.id_produccio 
        INNER JOIN compte ON compte.id_compte = hc.id_compte 
        WHERE compte.usuari = '$usuari' AND pro.id_produccio = hc.id_produccio 
        GROUP BY pro.id_produccio";
        
      $psql = $row["id_produccio"];
      $eye_result = $conn->query($eye_sql);

      if ($eye_result->num_rows > 0) {
         while ($eye_row = $eye_result->fetch_assoc()) {
            $num_visualitzacio = $eye_row['num_visualitzacio'];
            if ($num_visualitzacio > 0 && $psql == $eye_row["id_produccio"]) {
               echo '<i class="fa fa-eye" style="font-size:24px; color:white; height: 30px;"></i>';
            }
         }
      }
  
  echo "</div>";
      
      echo "</div>";
   }
} else {

}

?>