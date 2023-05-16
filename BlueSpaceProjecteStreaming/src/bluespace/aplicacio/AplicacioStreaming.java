package bluespace.aplicacio;

import bluespace.aplicacio.basedades.Connexio;
import bluespace.aplicacio.basedades.PelisDAO;
import bluespace.aplicacio.basedades.ProduccionsDAO;
import bluespace.aplicacio.basedades.SeriesDAO;
import bluespace.aplicacio.model.Pelis;
import bluespace.aplicacio.model.Produccions;
import bluespace.aplicacio.model.Series;
import java.sql.Connection;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AplicacioStreaming extends Application {
    
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
    
    BorderPane bp = new BorderPane();
    VBox vb = new VBox();
    RadioButton rb1 = new RadioButton();
    RadioButton rb2 = new RadioButton();
    
        

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage escenari) throws Exception {

        Connection conn = Connexio.getConection();

        escenari.getIcons().add(new Image("Imatges/logo.png"));

        System.out.println("streaming....");

        bp.setTop(top());

        bp.setLeft(left());

        bp.setCenter(centerGestioProduccio());
        // bp.setRight(bp);
        Scene escena = new Scene(bp);

        escenari.setScene(escena);

        escenari.setTitle("Blue Space");
        escenari.setMinHeight(1050);
        escenari.setMinWidth(1800);

        escenari.show();

        //Stage esceneari2 = new Stage();
        //escenari2.show();
    }

    private HBox top() {

        HBox hb = new HBox();

        Label lblAplicacio = new Label("Blue Space Streaming");

        lblAplicacio.setFont(new Font("ArialBold", 40));
        lblAplicacio.setTextFill(Color.WHITE);

        hb.getChildren().add(lblAplicacio);
        hb.setSpacing(30);
        hb.setPadding(new Insets(10, 10, 10, 10));

        hb.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        hb.setMinHeight(200);
        hb.setAlignment(Pos.CENTER);
        return hb;

    }

    private VBox left() {

        VBox vb = new VBox();
        Label lblGestio = new Label("GESTIÓ PRODUCCIONS");

        lblGestio.setFont(new Font("ArialBold", 20));
        lblGestio.setTextFill(Color.WHITE);

        Button btnPelis = new Button("Gestio Pelicules/Series");
        btnPelis.setMinWidth(80);

        btnPelis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //bp.setCenter(centreGestioProduccio());
            }
        });

        Label lblEstadistiques = new Label("ESTADISTIQUES");

        lblEstadistiques.setFont(new Font("ArialBold", 20));
        lblEstadistiques.setTextFill(Color.WHITESMOKE);

        Button btnClients = new Button("Contactes Clients Tarifa");
        btnClients.setMinWidth(80);

        Button btnCliTarifes = new Button("Produccions favorites");
        btnCliTarifes.setMinWidth(80);

        vb.getChildren().addAll(lblGestio, btnPelis, lblEstadistiques, btnClients, btnCliTarifes);

        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(30);
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setMinSize(180, 100);
        vb.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));

        return vb;
    }

    private VBox centerGestioProduccio() {

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
                //altaProduccio();
            }
        });

        btnModificacio.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Modificant pelicula...");
                //modificaProduccio();
            }
        });

        //btnInicialitza.setOnAction((e -> inicialitzarCampsPantallaProduccio()));

        HBox hbBotons = new HBox(btnConsulta, btnAlta, btnModificacio, btnBaixa, btnInicialitza);
        return hbBotons;
    }

    private void consultaProduccio() {

        if (txtId.getText().equals("")) {
            // Per poder realitzar la consulta d'una producció per id, cal que el camp id tingui algun valor
            alertWarning("L'identificador ha de tenir un valor");
        } else {
            // els camps de la pantalla son text, cal convertir els que son numeric
            int id = Integer.parseInt(txtId.getText());

            // Inicialitzaem els camps de la pantalla per si hi ha valors d'anteriors operacions
            //inicalitzarCampsPantallaProduccio();
            // creem un objecte ProduccioDAO per accedir a les dades de Producció a la Base de dades
            ProduccionsDAO prodDAO = new ProduccionsDAO();

            Produccions produccio = prodDAO.consultaProduccioBD(id);
            if (produccio == null) {
                alertInformacio("No existeix aquest identificador de produccio");
            } else {
                //dadesProduccioaAPantalla(produccio);
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

    private void alertWarning(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Warning");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void alertInformacio(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informació");
        alert.setContentText(msg);
        alert.showAndWait();
    }

//    private void mostrarAlertError(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setHeaderText(null);
//        alert.setTitle("Error");
//        alert.setContentText("Error en la aplicacion");
//        alert.showAndWait();
//    }
//    
//    private void mostrarAlertConfirmation(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setHeaderText(null);
//        alert.setTitle("Confirmacion");
//        alert.setContentText("¿Deseas realmente confirmar?");
//        alert.showAndWait();
//    }
}
