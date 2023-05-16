package bluespace.aplicacio;

import bluespace.aplicacio.vista.AplicacioVista;

import javafx.application.Application;
import javafx.stage.Stage;

public class AplicacioStreaming extends Application {        

    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage escenari) throws Exception {
        AplicacioVista apVista = new AplicacioVista();
        
        apVista.inici(escenari);
    }
}
