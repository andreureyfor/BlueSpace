<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="shortcut icon" href="imatges/logo.png" type="image/x-icon">

    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <h1 class="titol"><img src="imatges/logo.png" class="logo" alt="">Blue Space</h1>
    <div id="user">
        <h2>Iniciar sessió</h2>
        <form action="index.php" method="post">
            <div class="perfil">
                <i class="fa fa-user" style="font-size:2.7rem"></i>
                <input type="text" name="usuari" id="usuari" placeholder="Usuari">
            </div>
            <div class="perfil">
                <i class="fa fa-lock" style="font-size:2.7rem"></i>
                <input type="password" name="passw" id="passw" placeholder="Contrasenya">
            </div>
            <input type="submit" id="login" value="Iniciar sessió">
        </form>
        
        <a href="./registre.php"><p>No tens compte? Registrat.</p></a>
        
    </div>

    <script src="js/funcions.js"></script>
</body>
</html>