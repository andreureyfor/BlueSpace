document.addEventListener('DOMContentLoaded', () => {
    // Espera fins que tot el contingut de la pàgina estigui carregat
  
    let cercar = document.getElementById('cercar');
  
    cercar.addEventListener('click', () => {
      // Afegeix un esdeveniment de clic al botó de cerca
  
      peli = document.getElementById('peli').value;
  
      consultar(peli);
    });
  });
  
  async function consultar(peli) {
    // Funció asíncrona per consultar les dades a l'API
  
    let consultarAPI = await fetch(
      'http://www.omdbapi.com/?apikey=625c1541&t=' + peli + '&r=xml'
    );
  
    let dades = await consultarAPI.text();
  
    parser = new DOMParser();
    xmlDoc = parser.parseFromString(dades, 'text/xml');
  
    titol = xmlDoc.getElementsByTagName('movie')[0].getAttribute('title');
    genere = xmlDoc.getElementsByTagName('movie')[0].getAttribute('genre');
    actors = xmlDoc.getElementsByTagName('movie')[0].getAttribute('actors');
    data = xmlDoc.getElementsByTagName('movie')[0].getAttribute('year');
    duracio = xmlDoc.getElementsByTagName('movie')[0].getAttribute('runtime');
    sinopsis = xmlDoc.getElementsByTagName('movie')[0].getAttribute('plot');
    nota = xmlDoc.getElementsByTagName('movie')[0].getAttribute('imdbRating');
    caratula = xmlDoc.getElementsByTagName('movie')[0].getAttribute('poster');
  
    document.getElementById('contingut').innerHTML = `
      <h2>${titol} ${data} </h2>
      <div id='dades'>
          <div id='info'>
          <p><span>Gènere:</span>${genere} - ${duracio}</p>
          <p><span>Actors:</span>${actors}</p>
          <p><span>Sinopsis:</span>${sinopsis}</p>
          <p><span>Nota:</span>${nota}</p>
          </div>
          <img src=${caratula} alt="poster" id="poster">
      </div>`;
  }