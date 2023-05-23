window.addEventListener('DOMContentLoaded', function() {
  // Seleccionem totes les diapositives
  var slides = document.querySelectorAll('.slide');
  // Inicialitzem la diapositiva actual a la primera
  var currentSlide = 0;

  // Funció per mostrar una diapositiva específica
  function showSlide(slideIndex) {
      // Si l'índex de la diapositiva és menor que 0, mostrem l'última diapositiva
      if (slideIndex < 0) {
          currentSlide = slides.length - 1;
      }
      // Si l'índex de la diapositiva és superior o igual al nombre total de diapositives, mostrem la primera diapositiva
      else if (slideIndex >= slides.length) {
          currentSlide = 0;
      }

      // Amaguem totes les diapositives
      for (var i = 0; i < slides.length; i++) {
          slides[i].style.display = 'none';
      }

      // Mostrem només la diapositiva actual
      slides[currentSlide].style.display = 'block';
  }

  // Funció per passar a la següent diapositiva
  function nextSlide() {
      currentSlide++;
      showSlide(currentSlide);
  }

  // Funció per passar a la diapositiva anterior
  function previousSlide() {
      currentSlide--;
      showSlide(currentSlide);
  }

  // Configurem un interval de temps per canviar automàticament les diapositives cada 10 segons (10000 mil·lisegons)
  setInterval(nextSlide, 10000);

  // Mostrem la primera diapositiva quan la pàgina està carregada
  showSlide(currentSlide);
});