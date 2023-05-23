<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=s, initial-scale=1.0">
    <title>BlueSpace</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="imatges/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="./css/home.css">
    <link rel="stylesheet" href="./css/actudades.css">
</head>

<body>

<div id="all">

        <header id="capcalera">
            <img src="imatges/logo.png" class="logo" alt="">
            <nav id="menu">
                <ul>
                    <li><a href="./home.php">Home</a></li>
                    <li><a href="./pelis.php">Pel·licules</a></li>
                    <li><a href="./series.php">Series</a></li>
                    <li><a href="./busqueda.php">Cercador Web De Pel·licules i Series</a></li>
                    <li><a href="./favorit.php">Favorits</a></li>
                    <li><a href="./tancar.php">Tancar Sessió</a></li>
                </ul>
            </nav>
            <h2 class="nomUsuari">
                <?php echo $usuari ?>
            </h2>
            <a href="./actudades.php" class="perfil"><img src="./imatges/usuari.jpg" alt="foto perfil" class="fotoUsu"></a>

        </header>
</div>

</body>

</html>