<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BlueSpace</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="imatges/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="css/home.css">
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

        <div class="slideshow">

            <img src="./imatges/img1.png" class="slide">
            <img src="./imatges/img3.png" class="slide">
            <img src="./imatges/img2.png" class="slide">

        </div>

    </div>

    <footer>

        <nav id="xsocials">

            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-youtube-play"></i></a>
            <a href="#"><i class="fa fa-instagram"></i></a>

        </nav>

        <div id="terms">

            <p><a href="#">Privacy Policy</a> | <a href="#">Terms Of Use</a></p>

        </div>

        <p>© 2022-2023 Streaming / BlueSpace</p>

    </footer>

    <script src="./js/fotos.js"></script>

</body>

</html>