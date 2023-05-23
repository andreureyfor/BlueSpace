document.addEventListener('DOMContentLoaded', inici);

// Funció que s'executa quan el contingut de la finestra està totalment carregat
function inici() {
    console.log('Crida AJAX arxiu consulta.php');

    // Creem una instància de l'objecte XMLHttpRequest
    const xmlhttp = new XMLHttpRequest();

    // Definim una funció que s'executarà quan la resposta de la crida AJAX s'hagi carregat
    xmlhttp.onload = function() {
        // Assignem el contingut de la resposta al div amb l'ID "pelis"
        document.getElementById("pelis").innerHTML = this.responseText;
    }

    // Obrim una crida GET a l'arxiu "pelisconsulta.php"
    xmlhttp.open("GET", "./pelisconsulta.php");

    // Enviem la crida AJAX
    xmlhttp.send();

    // Afegim un esdeveniment d'escolta a l'element amb l'ID "myInput" per capturar els esdeveniments de teclat
    document.getElementById("myInput").addEventListener('keyup', myFunction);
}

// Funció per filtrar el contingut en funció de l'entrada de l'usuari
function myFunction() {
    var input, filter, pelis, peli, i, titol;

    // Obtenim l'element d'entrada de text amb l'ID "myInput"
    input = document.getElementById("myInput");

    // Obtenim el valor de l'entrada de text i el convertim a majúscules
    filter = input.value.toUpperCase();

    // Obtenim l'element amb l'ID "pelis"
    pelis = document.getElementById("pelis");

    // Obtenim tots els elements amb la classe "peli" dins de l'element "pelis"
    peli = pelis.getElementsByClassName("genere");

    // Recorrem tots els elements amb la classe "peli"
    for (i = 0; i < peli.length; i++) {
        // Obtenim l'element <p> dins de l'element "peli"
        titol = peli[i].getElementsByTagName("p")[0];

        // Obtenim el text de l'element <p>
        txtValue = titol.textContent || titol.innerText;

        // Comprovem si el text coincideix amb el filtre
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            // Mostrem l'element si coincideix amb el filtre
            peli[i].style.display = "";
        } else {
            // Amaguem l'element si no coincideix amb el filtre
            peli[i].style.display = "none";
        }
    }
}