<?php
// Iniciem la sessió
session_start();

// Destruïm la sessió
session_destroy();

// Redirigim a la pàgina d'inici
header('Location: index.php');

?>



