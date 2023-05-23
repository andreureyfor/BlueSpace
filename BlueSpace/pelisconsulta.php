<?php
// Requereix el fitxer "consulta.php", que conté la connexió a la base de dades
require 'consulta.php';
session_start();
$usuari = isset($_SESSION['usuari']) ? $_SESSION['usuari'] : "";
// Consulta SQL per obtenir les dades de les pel·lícules i les seves produccions relacionades


$mesfav = "SELECT * FROM pelis AS p 
            INNER JOIN produccions AS pro ON pro.id_produccio=p.id_produccio 
            ORDER BY favorit DESC LIMIT 5";

$res = $conn->query($mesfav);

// Comprova si hi ha resultats en la consulta
if ($res->num_rows > 0) {
   // Recorre cada fila de resultats
   echo "<section class='prova'>";
   echo "<h2>Mes Preferides</h2>";
   echo "<div class='peli'>";
   while ($mesfav_row = $res->fetch_assoc()) {
            
           
            echo "<div class='genere'>";
            echo "<img src='./imatges/" . $mesfav_row["caratula"] . "' alt='caràtula'>";
            echo "<p>" . $mesfav_row["nom"] . " </p>";
            echo "<p>" . $mesfav_row["duracio"] . " min</p>";


            $eye_sql = "SELECT hc.num_visualitzacio, compte.usuari, pro.id_produccio 
            FROM produccions AS pro 
            INNER JOIN ha_consumit AS hc ON pro.id_produccio = hc.id_produccio 
            INNER JOIN compte ON compte.id_compte = hc.id_compte 
            WHERE compte.usuari = '$usuari' AND pro.id_produccio = hc.id_produccio 
            GROUP BY pro.id_produccio";
            
            $psql = $mesfav_row["id_produccio"];
            $eye_result = $conn->query($eye_sql);

            if ($eye_result->num_rows > 0) {
               while ($eye_row = $eye_result->fetch_assoc()) {
                  $num_visualitzacio = $eye_row['num_visualitzacio'];
                  if ($num_visualitzacio > 0 && $psql == $eye_row["id_produccio"]) {
                        echo '<i class="fa fa-eye" style="font-size:24px; color:white; height: 30px;"></i>';
                  }
               }
            }

            $any = $mesfav_row["any_produccio"];

            $candau_sql = "SELECT modalitat.id_modalitat FROM modalitat 
                           INNER JOIN compte ON compte.id_modalitat=modalitat.id_modalitat 
                           WHERE usuari = '$usuari'";

            $candau_result = $conn->query($candau_sql);

            if($candau_result->num_rows > 0){
               while ($candau_row = $candau_result->fetch_assoc()) {
                  
                  if($any <= 2015 && $candau_row['id_modalitat'] == 1){

                  } else if($any <= 2020 && $candau_row['id_modalitat'] == 2){

                  } else if($candau_row['id_modalitat'] == 3){

                  } else {
                     echo "<i class='fa fa-lock' style='font-size:24px; color:white;'></i>";
                  }
               } 
            }

            echo "</div>";
           
   }
   echo "</div>";
   echo "</section>";
}

$mesvistes = "SELECT p.caratula, pro.nom, p.duracio, pro.any_produccio, pro.id_produccio FROM pelis AS p 
               INNER JOIN produccions AS pro ON pro.id_produccio=p.id_produccio 
               INNER JOIN ha_consumit AS hc ON hc.id_produccio=pro.id_produccio 
               GROUP BY hc.id_produccio ORDER BY num_visualitzacio DESC LIMIT 5";

$res2 = $conn->query($mesvistes);

// Comprova si hi ha resultats en la consulta
if ($res2->num_rows > 0) {
   // Recorre cada fila de resultats
   echo "<section class='prova'>";
   echo "<h2>Mes Vistes</h2>";
   echo "<div class='peli'>";
   while ($mesvis_row = $res2->fetch_assoc()) {
            
           
            echo "<div class='genere'>";
            echo "<img src='./imatges/" . $mesvis_row["caratula"] . "' alt='caràtula'>";
            echo "<p>" . $mesvis_row["nom"] . " </p>";
            echo "<p>" . $mesvis_row["duracio"] . " min</p>";
            //echo '<i class="fa fa-eye" style="font-size:24px; color:white;"></i>';


            $eye_sql = "SELECT hc.num_visualitzacio, compte.usuari, pro.id_produccio 
            FROM produccions AS pro 
            INNER JOIN ha_consumit AS hc ON pro.id_produccio = hc.id_produccio 
            INNER JOIN compte ON compte.id_compte = hc.id_compte 
            WHERE compte.usuari = '$usuari' AND pro.id_produccio = hc.id_produccio 
            GROUP BY pro.id_produccio";
            
            $psql = $mesvis_row["id_produccio"];
            $eye_result = $conn->query($eye_sql);

            if ($eye_result->num_rows > 0) {
               while ($eye_row = $eye_result->fetch_assoc()) {
                  $num_visualitzacio = $eye_row['num_visualitzacio'];
                  if ($num_visualitzacio > 0 && $psql == $eye_row["id_produccio"]) {
                        echo '<i class="fa fa-eye" style="font-size:24px; color:white; height: 30px;"></i>';
                  }
               }
            }

            $any = $mesvis_row["any_produccio"];

            $candau_sql = "SELECT modalitat.id_modalitat FROM modalitat 
            INNER JOIN compte ON compte.id_modalitat=modalitat.id_modalitat 
            WHERE usuari = '$usuari'";

            $candau_result = $conn->query($candau_sql);

            if($candau_result->num_rows > 0){
               while ($candau_row = $candau_result->fetch_assoc()) {
                  
                  if($any <= 2015 && $candau_row['id_modalitat'] == 1){

                  } else if($any <= 2020 && $candau_row['id_modalitat'] == 2){

                  } else if($candau_row['id_modalitat'] == 3){

                  } else {
                     echo "<i class='fa fa-lock' style='font-size:24px; color:white;'></i>";
                  }
               } 
            }

            echo "</div>";
           
   }
   echo "</div>";
   echo "</section>";
}


$sql = "SELECT DISTINCT nom FROM genere";

// Executa la consulta SQL
$result = $conn->query($sql);

// Comprova si hi ha resultats en la consulta
if ($result->num_rows > 0) {
   // Recorre cada fila de resultats
   while ($row = $result->fetch_assoc()) {
      $categoria = $row["nom"];
      echo "<section class='prova'>";
      echo "<h2>$categoria</h2>";
      echo "<div class='peli'>";

      $peli_sql = "SELECT p.caratula, pro.nom, p.duracio, pro.any_produccio, pro.id_produccio  FROM pelis AS p 
      INNER JOIN produccions AS pro ON pro.id_produccio = p.id_produccio 
      INNER JOIN pertany ON pertany.id_produccio = pro.id_produccio 
      INNER JOIN genere AS g ON pertany.id_categoria = g.id_categoria 
      WHERE g.nom = '$categoria'";

      $peli_result = $conn->query($peli_sql);

      if ($peli_result->num_rows > 0) {
         while ($peli_row = $peli_result->fetch_assoc()) {
            echo "<div class='genere'>";
            echo "<img src='./imatges/" . $peli_row["caratula"] . "' alt='caràtula'>";
            echo "<p>" . $peli_row["nom"] . " </p>";
            echo "<p>" . $peli_row["duracio"] . " min</p>";

            $eye_sql = "SELECT hc.num_visualitzacio, compte.usuari, pro.id_produccio 
            FROM produccions AS pro 
            INNER JOIN ha_consumit AS hc ON pro.id_produccio = hc.id_produccio 
            INNER JOIN compte ON compte.id_compte = hc.id_compte 
            WHERE compte.usuari = '$usuari' AND pro.id_produccio = hc.id_produccio 
            GROUP BY pro.id_produccio";
            
            $psql = $peli_row["id_produccio"];
            $eye_result = $conn->query($eye_sql);

            if ($eye_result->num_rows > 0) {
               while ($eye_row = $eye_result->fetch_assoc()) {
                  $num_visualitzacio = $eye_row['num_visualitzacio'];
                  if ($num_visualitzacio > 0 && $psql == $eye_row["id_produccio"]) {
                        echo '<i class="fa fa-eye" style="font-size:24px; color:white; height: 30px;"></i>';
                  }
               }
            }

            $any = $peli_row["any_produccio"];

            $candau_sql = "SELECT modalitat.id_modalitat FROM modalitat 
            INNER JOIN compte ON compte.id_modalitat=modalitat.id_modalitat 
            WHERE usuari = '$usuari'";

            $candau_result = $conn->query($candau_sql);
            
            if($candau_result->num_rows > 0){
               while ($candau_row = $candau_result->fetch_assoc()) {
                  
                  if($any <= 2015 && $candau_row['id_modalitat'] == 1){

                  } else if($any <= 2020 && $candau_row['id_modalitat'] == 2){

                  } else if($candau_row['id_modalitat'] == 3){

                  } else {
                     echo "<i class='fa fa-lock' style='font-size:24px; color:white;'></i>";
                  }
               } 
            }

            echo "</div>";
         }
      } else {
         echo "<p>No hi han pel·licules</p>";
      }
      
      echo "</div>";
      echo "</section>";
   }
} else {
   echo "0 resultats";
}
?>