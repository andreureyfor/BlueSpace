<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="imatges/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="./login.view.php">
    <link rel="stylesheet" href="css/registre.css">
    <title>Document</title>
</head>

<body>

    <div id="all">

        <h1 class="titol"><img src="imatges/logo.png" class="logo" alt="">Blue Space</h1>

        <div class="registre">
            <form method="post"  >

                <h2 class="titol2">Registrar-se</h2>

                <input type="text" id="usuari" name="usuari" placeholder="Usuari">

                <input type="password" id="pwd" name="pwd" placeholder="Contrasenya">

                <input type="email" id="correu" name="correu" placeholder="Correu">

                <input type="submit" id="registrarme" name="registrarme" value="Registrar-me">

            </form>

            

        </div>

        <a href="./login.php" class="noseccio"><p>Ja tens compte? Inicia Sessió.</p></a>

    </div>
</body>

</html>