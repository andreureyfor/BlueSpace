package bluespace.aplicacio.vista;

import bluespace.aplicacio.basedades.CompteDAO;
import bluespace.aplicacio.model.Compte;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ComptesTarifaVista {
    
    private TableView tblContractes;
    private Label lblModalitat;
    
    public VBox visualitzarContractesTarifa() {
        
        System.out.println("visualitzarContractesTarifa");
        
        VBox vb = new VBox();
        
        Label lblContractes = new Label("VISUALITZACIÓ DE CONTRACTES TARIFA");
        lblContractes.setFont(new Font("ArialBold", 40));
        lblContractes.setTextFill(Color.RED);
        
        MenuItem menuItemGR = new MenuItem("Gratüita");
        MenuItem menuItemBA = new MenuItem("Basica");
        MenuItem menuItemPR = new MenuItem("Premium");
        MenuItem menuItemTO = new MenuItem("Totes");
        
        // Create a MenuButton with Text & Icon & 3 Items
        MenuButton menuButton = new MenuButton("Modalitats", null, menuItemGR, menuItemBA, menuItemPR, menuItemTO);
        
        menuItemGR.setOnAction(event -> visualitzarContractesTarifaDades(1));
        
        menuItemBA.setOnAction(event -> visualitzarContractesTarifaDades(2));
        
        menuItemPR.setOnAction(event -> visualitzarContractesTarifaDades(3));
        
        menuItemTO.setOnAction(event -> visualitzarContractesTarifaDades(0));
        
        lblModalitat = new Label();
        lblModalitat.setFont(new Font("ArialBold", 30));
        lblModalitat.setTextFill(Color.BLUE);
        
        tblContractes = new TableView();
        
        TableColumn<Compte, Integer> colIdCompte = new TableColumn<>("Id Compte");
        colIdCompte.setCellValueFactory(new PropertyValueFactory<>("idCompte"));
        
        TableColumn<Compte, Integer> colIdCli = new TableColumn<>("Id Client");
        colIdCli.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        
        TableColumn<Compte, String> colIdEmail = new TableColumn<>("Email");
        colIdEmail.setMinWidth(100);
        
        TableColumn<Compte, String> colNomCli = new TableColumn<>("Nom");
        colNomCli.setMinWidth(100);
        colNomCli.setCellValueFactory(new PropertyValueFactory<>("nomCli"));
        
        TableColumn<Compte, String> colDataAlta = new TableColumn<>("D.alta");
        colDataAlta.setCellValueFactory(new PropertyValueFactory<>("dataAlta"));
        
        TableColumn<Compte, String> colModalitat = new TableColumn<>("Modalitat");
        colModalitat.setCellValueFactory(new PropertyValueFactory<>("idModalitat"));
        
        tblContractes.getColumns().addAll(colIdCompte, colIdCli, colIdEmail, colNomCli, colDataAlta, colModalitat);
        tblContractes.setMinHeight(100);
        tblContractes.setMinWidth(600);
        
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(30);
        vb.setPadding(new Insets(20, 20, 20, 20));
        
        vb.getChildren().addAll(lblContractes, menuButton, lblModalitat, tblContractes);
        
        return vb;
        
    }
    
    public void visualitzarContractesTarifaDades(int modalitat) {
        
        CompteDAO compteDAO = new CompteDAO();
        
        ArrayList<Compte> comptesTarifa = compteDAO.obtenirComptesModalitatBD(modalitat);
        
        
        switch (modalitat){
            case 0: lblModalitat.setText("COMPTES DE TOTES LES MODALITATS"); break;
            case 1: lblModalitat.setText("COMPTES MODALITAT GRATUÏTA"); break;
            case 2: lblModalitat.setText("COMPTES MODALITAT BÀSICA"); break;
            case 3: lblModalitat.setText("COMPTES MODALITAT PREMIUM"); break;
        }
        
        tblContractes.getItems().clear();
        
        tblContractes.getItems().addAll(comptesTarifa);
        
    }
    
}
