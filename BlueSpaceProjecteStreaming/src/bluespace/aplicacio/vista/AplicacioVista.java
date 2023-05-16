package bluespace.aplicacio.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AplicacioVista {
    
    BorderPane bp = new BorderPane();
    
    public void inici(Stage escenari){
        
        System.out.println("streaming MVC...");
        
        bp.setTop(top());
        bp.setLeft(left());
        
        
        Scene escena = new Scene(bp);

        escenari.setScene(escena);

        escenari.setTitle("Blue Space");
        escenari.setMinHeight(1050);
        escenari.setMinWidth(1800);

        escenari.show();
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
        lblGestio.setTextFill(Color.WHITESMOKE);

        Button btnPelis = new Button("Gestio Pelicules/Series");
        btnPelis.setMinWidth(80);

        btnPelis.setOnAction(e -> {
            GestioProduccionsVista gpv = new GestioProduccionsVista();
            bp.setCenter(gpv.centerGestioProduccio());
            });

        Label lblEstadistiques = new Label("ESTADISTIQUES");

        lblEstadistiques.setFont(new Font("ArialBold", 20));
        lblEstadistiques.setTextFill(Color.WHITESMOKE);

        Button btnClients = new Button("Contactes Clients Tarifa");
        btnClients.setMinWidth(80);
        
        btnClients.setOnAction(e -> {
            ComptesTarifaVista gtv = new ComptesTarifaVista();
            bp.setCenter(gtv.visualitzarContractesTarifa());
            });

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
    
}
