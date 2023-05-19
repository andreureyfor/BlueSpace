package bluespace.aplicacio.vista;

import bluespace.aplicacio.basedades.PelisDAO;
import bluespace.aplicacio.basedades.ProduccionsDAO;
import bluespace.aplicacio.basedades.SeriesDAO;
import bluespace.aplicacio.model.Pelis;
import bluespace.aplicacio.model.Produccions;
import bluespace.aplicacio.model.Series;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GestioProduccionsVista {

    Label lblId;
    TextField txtId;
    Label lblNom;
    TextField txtNom;
    Label lblAny;
    TextField txtAny;
    Label lblNacionalitat;
    TextField txtNacionalitat;
    Label lblCategoria;
    TextField txtCategoria;
    Label lblDirector;
    TextField txtDirector;
    Label lblActor;
    TextField txtActor;
    Label lblFavorit;
    TextField txtFavorit;
    Label lblDurada;
    TextField txtDurada;
    Label lblNumCapitols;
    TextField txtNumCapitols;
    Label lblDuradaTotal;
    TextField txtDuradaTotal;

    RadioButton rb1 = new RadioButton();
    RadioButton rb2 = new RadioButton();

    public VBox centerGestioProduccio() {

        VBox vb = new VBox();

        Label lblPelis = new Label("GESTIÓ PRODUCCIONS");
        lblPelis.setFont(new Font("ArialBold", 30));
        lblPelis.setTextFill(Color.RED);

        VBox vbElem = dadesProduccio();

        HBox hbBotons = botonsGestio();
        hbBotons.setSpacing(10);
        hbBotons.setAlignment(Pos.CENTER);

        vb.getChildren().addAll(lblPelis, vbElem, hbBotons);
        vb.setAlignment(Pos.CENTER);

        vb.setSpacing(10);

        return vb;
    }

    private VBox dadesProduccio() {

        VBox vb = new VBox();

        Label lblProduccions = new Label("GESTIÓ PRODUCCIONS");
        lblProduccions.setFont(new Font("ArialBold", 30));
        lblProduccions.setTextFill(Color.RED);

        lblId = new Label("id");
        txtId = new TextField();

        lblNom = new Label("Nom");
        txtNom = new TextField();

        lblAny = new Label("Anys");
        txtAny = new TextField();

        lblNacionalitat = new Label("Nacionalitat");
        txtNacionalitat = new TextField();

        lblCategoria = new Label("Categoria");
        txtCategoria = new TextField();

        lblDirector = new Label("Director");
        txtDirector = new TextField();

        lblActor = new Label("Actor");
        txtActor = new TextField();

        lblFavorit = new Label("Favorit");
        txtFavorit = new TextField();

        rb1 = new RadioButton("Pel·licula");
        rb2 = new RadioButton("Serie");

        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);

        GridPane gp = new GridPane();

        gp.add(lblId, 0, 0, 1, 1);
        gp.add(txtId, 1, 0, 1, 1);
        gp.add(lblNom, 0, 1, 1, 1);
        gp.add(txtNom, 1, 1, 1, 1);
        gp.add(lblAny, 0, 2, 1, 1);
        gp.add(txtAny, 1, 2, 1, 1);

        gp.add(lblNacionalitat, 0, 3, 1, 1);
        gp.add(txtNacionalitat, 1, 3, 1, 1);

        gp.add(lblCategoria, 0, 4, 1, 1);
        gp.add(txtCategoria, 1, 4, 1, 1);
        gp.add(lblDirector, 0, 5, 1, 1);
        gp.add(txtDirector, 1, 5, 1, 1);
        gp.add(lblActor, 0, 6, 1, 1);
        gp.add(txtActor, 1, 6, 1, 1);
        gp.add(lblFavorit, 0, 7, 1, 1);
        gp.add(txtFavorit, 1, 7, 1, 1);
        gp.add(rb1, 0, 8, 1, 1);
        gp.add(rb2, 1, 8, 1, 1);

        GridPane gpps = new GridPane();

        lblDurada = new Label("Durada");
        lblDurada.setVisible(false);
        txtDurada = new TextField();
        txtDurada.setVisible(false);

        lblNumCapitols = new Label("Numero Capitols");
        lblNumCapitols.setVisible(false);
        txtNumCapitols = new TextField();
        txtNumCapitols.setVisible(false);

        lblDuradaTotal = new Label("Durada Total");
        lblDuradaTotal.setVisible(false);
        txtDuradaTotal = new TextField();
        txtDuradaTotal.setVisible(false);

        gpps.add(lblDurada, 0, 0, 1, 1);
        gpps.add(txtDurada, 1, 0, 1, 1);
        gpps.add(lblNumCapitols, 0, 0, 1, 1);
        gpps.add(txtNumCapitols, 1, 0, 1, 1);
        gpps.add(lblDuradaTotal, 0, 1, 1, 1);
        gpps.add(txtDuradaTotal, 1, 1, 1, 1);

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> x, Toggle anterior, Toggle actual) {

                if (rb1.isSelected()) {
                    lblDurada.setVisible(true);
                    txtDurada.setVisible(true);
                    lblNumCapitols.setVisible(false);
                    txtNumCapitols.setVisible(false);
                    lblDuradaTotal.setVisible(false);
                    txtDuradaTotal.setVisible(false);
                } else {
                    lblNumCapitols.setVisible(true);
                    txtNumCapitols.setVisible(true);
                    lblDuradaTotal.setVisible(true);
                    txtDuradaTotal.setVisible(true);

                    lblDurada.setVisible(false);
                    txtDurada.setVisible(false);
                }
            }

        });

        gp.setAlignment(Pos.CENTER);

        gp.setHgap(10);
        gp.setVgap(10);

        gpps.setAlignment(Pos.CENTER);

        gpps.setHgap(10);
        gpps.setVgap(10);

        vb.setSpacing(20);
        vb.getChildren().addAll(gp, gpps);
        vb.setAlignment(Pos.CENTER);

        return vb;
    }

    private HBox botonsGestio() {

        Button btnConsulta = new Button("Consulta");
        Button btnAlta = new Button("Alta");
        Button btnModificacio = new Button("Modificació");
        Button btnBaixa = new Button("Baixa");
        Button btnInicialitza = new Button("Inicialitza");

        btnConsulta.setOnAction(e -> consultaProduccio());

        btnAlta.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Alta peli...");
                System.out.println("Opció no implementada");
                //altaProduccio();
            }
        });

        btnModificacio.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Opció no implementada");
                System.out.println("Modificant pelicula...");
                //modificaProduccio();
            }
        });
        
        btnInicialitza.setOnAction(e -> inicialitzarCampsPantallaProduccio());
        HBox hbBotons = new HBox(btnConsulta, btnAlta, btnModificacio, btnBaixa, btnInicialitza);
        return hbBotons;
    }
    
    private void consultaProduccio() {

        if (txtId.getText().equals("")) {
            // Per poder realitzar la consulta d'una producció per id, cal que el camp id tingui algun valor
            AlertVista.alertWarning("L'identificador ha de tenir un valor");
        } else {
            // els camps de la pantalla son text, cal convertir els que son numeric
            int id = Integer.parseInt(txtId.getText());

            // Inicialitzaem els camps de la pantalla per si hi ha valors d'anteriors operacions
            inicialitzarCampsPantallaProduccio();
            // creem un objecte ProduccioDAO per accedir a les dades de Producció a la Base de dades
            ProduccionsDAO prodDAO = new ProduccionsDAO();

            Produccions produccio = prodDAO.consultaProduccioBD(id);
            if (produccio == null) {
                AlertVista.alertInformacio("No existeix aquest identificador de produccio");
            } else {
                dadesProduccioAPantalla(produccio);
                // accedim a la taula Pelis de Base de dades per comprovar si es tracta d'una pelicula
                // creem un objecte PeliculaDAO per accedir a la taula Pelicula
                PelisDAO peliDAO = new PelisDAO();
                Pelis peli = peliDAO.consultaPeliculaBD(id);
                // Si retorna un objecte Pelicula, mostrem les dades per pantalla
                if (peli != null) {
                    dadesPeliculaAPantalla(peli);
                } else { //si no es una pelicula, busquem a la taula serie
                    SeriesDAO serieDAO = new SeriesDAO();
                    Series serie = serieDAO.consultaSerieBD(id);
                    if (serie != null) // en el cas que no existeixi les dades en serie no les mostrarà per pantalla
                    {
                        dadesSerieAPantalla(serie);
                    }
                }
            }
        }
    }
    
    void inicialitzarCampsPantallaProduccio() {
        
        txtId.setText("");
        txtNom.setText("");
        txtAny.setText("");
        txtCategoria.setText("");
        txtDirector.setText("");
        txtActor.setText("");
        txtNacionalitat.setText("");
        txtFavorit.setText("");
        
        rb1.setSelected(false);
        rb2.setSelected(false);
        
        lblDurada.setVisible(false);
        txtDurada.setVisible(false);
        
        lblDuradaTotal.setVisible(false);
        txtDuradaTotal.setVisible(false);
        lblNumCapitols.setVisible(false);
        txtNumCapitols.setVisible(false);
        
    }
    
    private void dadesProduccioAPantalla(Produccions p) {
       
        txtId.setText(String.valueOf(p.getId()));
        txtNom.setText(p.getNom());
        txtNacionalitat.setText(p.getNacionalitat());
        txtAny.setText(String.valueOf(p.getAny()));
        txtFavorit.setText(String.valueOf(p.getFavorit()));
    }
    
    private void dadesPeliculaAPantalla(Pelis p) {
        // seleccionem el radio button de serie
        rb1.setSelected(true);

        // mapeig dels atributs de la classe Pelicula als camps de pantalla
        txtDurada.setText(String.valueOf(p.getDurada()));

        // en la consulta de pelicula només visualitzem la primera
        // categoria, director i actor de la película
        txtCategoria.setText(p.getCategories(0));
        txtDirector.setText(p.getDirector(0));
        txtActor.setText(p.getActors(0));

        // Posem visible el camp propi de película
        txtDurada.setVisible(true);
    }

    private void dadesSerieAPantalla(Series s) {
        // seleccionem el radio button de serie
        rb2.setSelected(true);

        // mapeig dels atributs de la classe Pelicula als camps de pantalla
        txtDuradaTotal.setText(String.valueOf(s.getDuradaTotal()));
        txtNumCapitols.setText(String.valueOf(s.getNumCapitols()));

        // en la consulta de serie només visualitzem la primera
        // categoria, director i actor de la serie
        txtCategoria.setText(s.getCategories(0));
        txtDirector.setText(s.getDirector(0));
        txtActor.setText(s.getActors(0));

        // Posem visible el camp propi de película
        txtDuradaTotal.setVisible(true);
        txtNumCapitols.setVisible(true);
    }
}

